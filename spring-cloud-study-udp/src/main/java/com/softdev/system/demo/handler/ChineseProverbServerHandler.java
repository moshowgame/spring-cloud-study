package com.softdev.system.demo.handler;


import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.ThreadLocalRandom;


public class ChineseProverbServerHandler extends
        SimpleChannelInboundHandler<DatagramPacket> {
    //谚语列表
    private static final String[] DICTIONARY = { "只要功夫深，铁棒磨成针。",
            "旧时王谢堂前燕,飞入寻常百姓家。", "洛阳亲友如相问，一片冰心在玉壶。", "一寸光阴一寸金，寸金难买寸光阴。",
            "老骥伏枥，志在千里，烈士暮年，壮心不已" };
    private String nextQuote(){
        //返回0-DICTIONARY.length中的一个整数。
        int quoteId = ThreadLocalRandom.current().nextInt(DICTIONARY.length);
        return DICTIONARY[quoteId];//将谚语列表中对应的谚语返回
    }
    /**
     * 在这个方法中，形参packet客户端发过来的DatagramPacket对象
     * DatagramPacket 类解释
     * 1.官网是这么说的：
     * The message container that is used for {@link DatagramChannel} to communicate with the remote peer.
     * 翻译：DatagramPacket 是消息容器，这个消息容器被 DatagramChannel使用，作用是用来和远程设备交流
     * 2.看它的源码我们发现DatagramPacket是final类不能被继承，只能被使用。我们还发现DatagramChannel最终实现了AddressedEnvelope接口，接下来我们看一下AddressedEnvelope接口。
     * AddressedEnvelope接口官网解释如下：
     * A message that wraps another message with a sender address and a recipient address.
     * 翻译：这是一个消息,这个消息包含发送者和接受者消息
     * 3.那我们知道了DatagramPacket它包含了发送者和接受者的消息，
     * 通过content()来获取消息内容
     * 通过sender();来获取发送者的消息
     * 通过recipient();来获取接收者的消息。
     *
     * 4.public DatagramPacket(ByteBuf data, InetSocketAddress recipient) {}
     *  这个DatagramPacket其中的一个构造方法，data 是发送内容;是发送都信息。
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket packet)
            throws Exception {

        String req = packet.content().toString(CharsetUtil.UTF_8);//上面说了，通过content()来获取消息内容
        System.out.println(req);
        /**
         * 重新 new 一个DatagramPacket对象，我们通过packet.sender()来获取发送者的消息。
         * 重新发达出去！
         */
        ctx.writeAndFlush(new DatagramPacket(Unpooled.copiedBuffer(nextQuote(),CharsetUtil.UTF_8), packet.sender()));
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        ctx.close();
        cause.printStackTrace();
    }

}