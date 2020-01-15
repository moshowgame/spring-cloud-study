package com.softdev.system.demo.repository;

import com.softdev.system.demo.entity.WsMessage;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
*  ws_message
* @author 大狼狗 2020-01-14
*/
@Repository
public interface WsMessageRepository extends JpaRepository<WsMessage,String> {

    @Query(value = "select * from ws_message t where t.status=0 and t.to_user_id=?1",nativeQuery = true)
    public List<WsMessage> findWsMessages(String userId);

    @Modifying
    @Transactional
    @Query(value = "update ws_message t set t.site_id=?1,t.read_time=now(),status=1 where t.to_user_id=?2 and status=0",nativeQuery = true)
    public int deleteWsMessages(String siteId, String userId);
}
