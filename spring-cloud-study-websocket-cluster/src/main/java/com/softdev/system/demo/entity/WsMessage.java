package com.softdev.system.demo.entity;

import lombok.Data;
import java.util.Date;
import java.util.List;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;

/**
*  ws_message
* @author 大狼狗 2020-01-14
*/
@Entity
@Data
@Table(name="ws_message")
public class WsMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @Id
    private String id;

    /**
    * from_user_id
    */
    private String fromUserId;

    /**
    * to_user_id
    */
    private String toUserId;

    /**
    * create_time
    */
    private Date createTime;
    /**
     * create_time
     */
    private Date readTime;
    /**
    * message
    */
    private String message;

    /**
    * status
    */
    private boolean status;

    /**
    * site_id
    */
    private String siteId;
    public WsMessage() {
    }

}
