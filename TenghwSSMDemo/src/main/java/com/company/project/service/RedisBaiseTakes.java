package com.company.project.service;

import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @PROJECT_NAME: TenghwSSMDemo
 * @PACKAGE_NAME: cn.itrip.common
 * @ClassName: RedisAPI
 * @User: ZARD
 * @Author:tenghw
 * @Description:
 * @CreateDate:2020/5/29 0029 19:35
 * @Day: 星期五
 */
@SuppressWarnings({"rawtypes","unchecked","all"})
public interface RedisBaiseTakes<H,K,V> {
    //选择查询的redis数据库
    public Jedis selectDBindex(int DBindex);
    //增
    public void add(K key,String value);
    public void addObj(H objectKey,K key,V object);
    //删
    public void delete(K key);
    public void delete(List<K> listKeys);
    public void deletObj(H objecyKey,K key);
    //改
    public void update(K key,String value);
    public void updateObj(H objectKey,K key,V object);
    //查
    public String get(Jedis jedis,K key);
    public V getObj(H objectKey,K key);





}
