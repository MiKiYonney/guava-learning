package com.cache

import com.google.common.cache.CacheBuilder
import com.google.common.cache.CacheLoader
import com.google.common.cache.LoadingCache
import com.sun.corba.se.impl.orbutil.graph.Graph

import java.security.Key
import java.util.concurrent.TimeUnit

/**
 * Created by yonney.yang on 2015/5/29.
 */
//Guava Cache：本地缓存实现，支持多种缓存过期策略 PK ConcurrentMap
LoadingCache<Key, Graph> graphs = CacheBuilder.newBuilder()
        .maximumSize(1000)
        .expireAfterWrite(10, TimeUnit.MINUTES)
        .removalListener(MY_LISTENER)
        .build(
        new CacheLoader<Key, Graph>() {
            public Graph load(Key key) throws Exception {
                return createExpensiveGraph(key);
            }
        });


public static void main(String[] args) {

}