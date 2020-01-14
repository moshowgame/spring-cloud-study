package com.softdev.system.demo.entity;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;

/**
*  ws_site
* @author 大狼狗 2020-01-14
*/
@Entity
@Data
@Table(name="ws_site")
public class WsSite implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * site_id
    */
    private String siteId;

    /**
    * user_id
    */
    @Id
    private String userId;

    /**
    * create_time
    */
    private Date createTime;

    public WsSite() {
    }

}
