package com.softdev.system.demo.repository;

import com.softdev.system.demo.entity.WsMessage;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
*  ws_message
* @author 大狼狗 2020-01-14
*/
@Repository
public interface WsMessageRepository extends JpaRepository<WsMessage,String> {

    @Query(value = "select * from ws_message t left join ws_site x on x.user_id=t.user_id where t.site_id=:siteId and t.user_id=:userId",nativeQuery = true)
    public List<WsMessage> findWsMessages(String userId);


}
