package com.company.project.controller;

import com.company.project.service.RedisBaiseTakes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

/**
 * @PROJECT_NAME: TenghwSSMDemo
 * @PACKAGE_NAME: com.company.project.controller
 * @ClassName: RedisController
 * @User: ZARD
 * @Author:tenghw
 * @Description:
 * @CreateDate:2020/5/29 0029 21:36
 * @Day: 星期五
 */
@Controller
@RequestMapping("/redis")
public class RedisController {
    private static  final Logger logger= LoggerFactory.getLogger(RedisController.class);
    @Resource(name = "seeUserRedisTakes")
    private RedisBaiseTakes redisBaiseTakes;

    @ModelAttribute
    public Jedis setDBindex(@RequestParam(value = "DBindex",defaultValue = "noDBindex",required = false) String DBindex){
        logger.info("@ModelAttribute--key,DBindex===="+DBindex);
        Jedis jedis = redisBaiseTakes.selectDBindex(Integer.parseInt(DBindex));
        return jedis;
    }

    @RequestMapping("/redis1")
    public  String addRedis(@RequestParam(value = "key",defaultValue = "nokey",required = false) String key,
                            @RequestParam(value = "value",defaultValue = "novalue",required = false) String value,
                            Model model){
        System.out.println(key+","+value);
        redisBaiseTakes.add(key, value);
        model.addAttribute("keymodel",key);
        model.addAttribute("valuemodel",value);
      return "redis";
  }


    @RequestMapping("/redis2")
    public  String getKey(@RequestParam(value = "key",defaultValue = "nokey",required = false) String key,
                          Jedis jedis,
                          Model model){
        System.out.println(jedis);
        String value = redisBaiseTakes.get(jedis, key);
        System.out.println(key+"-----"+value);
        model.addAttribute("keyvalue",value);
        return "forward:/index.jsp";
    }










}
