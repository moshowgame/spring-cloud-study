package com.softdev.system.demo.controller;

import com.alibaba.fastjson.JSON;
import com.softdev.system.demo.entity.Cert;
import com.softdev.system.demo.entity.CertType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
/**
 * EhCache缓存控制器demo
 * @author zhengkai.blog.csdn.net
 * */
@Slf4j
@RestController
public class DemoController {

    @GetMapping("")
    public ResponseEntity<String> index(){
        return ResponseEntity.ok("请求成功");
    }

    @RequestMapping("cert/save")
    @CacheEvict(value = "cache-certList", key = "#cert.certId")
    public Cert save(Cert cert){
        log.info("保存cert到数据库:"+ JSON.toJSONString(cert));
        return cert;
    }
    @Cacheable(value = "cache-certList", key = "#cert.certId")
    @RequestMapping("cert/find")
    public Cert find(Cert cert){
        log.info("从数据库中读取cert:"+ JSON.toJSONString(cert));
        return cert;
    }
    @RequestMapping("type/all")
    @CacheEvict(value = "cache-certType")
    public List<CertType> getType(){
        List<CertType> list = new ArrayList<>();
        list.add(new CertType(1,"个人证书","csdn-person"));
        list.add(new CertType(2,"企业证书","csdn-enterprise"));
        list.add(new CertType(3,"云证书","csdn-cloud"));
        log.info("从数据库中读取typeList:"+ JSON.toJSONString(list));
        return list;
    }
    @CacheEvict(value = "cache-certType" , allEntries=true)
    @RequestMapping("type/clean")
    public List<CertType> clean(){
        log.info("清理所有typeList缓存");
        return null;
    }
}
