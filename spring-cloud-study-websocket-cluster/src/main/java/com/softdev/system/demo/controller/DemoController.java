package com.softdev.system.demo.controller;

import com.softdev.system.demo.config.WebSocketServer;
import com.softdev.system.demo.entity.WsMessage;
import com.softdev.system.demo.entity.WsSite;
import com.softdev.system.demo.repository.WsMessageRepository;
import com.softdev.system.demo.repository.WsSiteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

/**
 * WebSocketController
 * @author zhengkai.blog.csdn.net
 */
@RestController
@Slf4j
public class DemoController {

    @Autowired
    private WsMessageRepository wsMessageRepository;

    @Autowired
    private WsSiteRepository wsSiteRepository;

    @GetMapping("index")
    public ResponseEntity<String> index(){
        return ResponseEntity.ok("请求成功");
    }

    @GetMapping("page")
    public ModelAndView page(){
        return new ModelAndView("websocket");
    }

    @RequestMapping("/push/{toUserId}")
    public ResponseEntity<String> pushToWeb(String message, @PathVariable String toUserId) throws IOException {
        WebSocketServer.sendInfo(message,toUserId);
        return ResponseEntity.ok("MSG SEND SUCCESS");
    }
    @RequestMapping("/push/all")
    public ResponseEntity<String> pushAll() throws IOException {
        scheduledCheck();
        return ResponseEntity.ok("MSG SEND SUCCESS");
    }
    @Scheduled(cron="0/10 * * * * *")
    public void scheduledCheck() {
        log.info("定时群发任务开始执行");
        //遍历当前站点所有用户
        List<WsSite> wsSiteList = wsSiteRepository.findWsSiteUser(WebSocketServer.siteId);
        wsSiteList.forEach(wsSite -> {
            //遍历当前用户的所有信息
            List<WsMessage> wsMessageList = wsMessageRepository.findWsMessages(wsSite.getUserId());
            wsMessageList.forEach(wsMessage -> {
                //发送信息
                try {
                    WebSocketServer.sendInfo(wsMessage.getMessage(),wsMessage.getToUserId());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            //清理发送的信息(更新siteId和状态)
            wsMessageRepository.deleteWsMessages(WebSocketServer.siteId,wsSite.getUserId());
        });
    }
}
