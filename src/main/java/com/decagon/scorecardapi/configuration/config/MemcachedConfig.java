package com.decagon.scorecardapi.configuration.config;

import com.google.code.ssm.Cache;
import com.google.code.ssm.CacheFactory;
import com.google.code.ssm.config.AbstractSSMConfiguration;
import com.google.code.ssm.config.DefaultAddressProvider;
import com.google.code.ssm.providers.spymemcached.SpymemcachedConfiguration;
import com.google.code.ssm.providers.xmemcached.MemcacheClientFactoryImpl;
import com.google.code.ssm.providers.xmemcached.XMemcachedConfiguration;
import com.google.code.ssm.spring.ExtendedSSMCacheManager;
import com.google.code.ssm.spring.SSMCache;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.XMemcachedClient;
import net.spy.memcached.auth.AuthDescriptor;
import net.spy.memcached.auth.PlainCallbackHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Arrays;

//@RefreshScope
@Configuration
@EnableCaching
public class MemcachedConfig extends AbstractSSMConfiguration {

    private String memcachedHost = "localhost";
    private int memcachedPort = 11211;
    Logger logger = LoggerFactory.getLogger(MemcachedConfig.class);

    @Bean
    public MemcachedClient memcachedClient() {

        MemcachedClient client = null;
        try {

            client = new XMemcachedClient(memcachedHost, memcachedPort);
        } catch (NumberFormatException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            logger.info("Memcached encountered an error : {}", e.getMessage());
        }

        return client;
    }

    @Bean
    @Override
    public CacheFactory defaultMemcachedClient() {
//        String serverString = memcachedHost + ":" + memcachedPort;
//        AuthDescriptor ad = new AuthDescriptor(new String[] { "PLAIN" },
//                new PlainCallbackHandler(System.getenv("MEMCACHIER_USERNAME"),
//                        System.getenv("MEMCACHIER_PASSWORD")));
//
//        final SpymemcachedConfiguration conf = new SpymemcachedConfiguration();
//        conf.setUseBinaryProtocol(true);
//        conf.setAuthDescriptor(ad);
//
//        final CacheFactory cf = new CacheFactory();
//        cf.setCacheClientFactory(new MemcacheClientFactoryImpl());
//        cf.setAddressProvider(new DefaultAddressProvider(serverString));
//        cf.setConfiguration(conf);
//        return cf;
        String serverString = memcachedHost + ":" + memcachedPort;
        final XMemcachedConfiguration conf = new XMemcachedConfiguration();
        conf.setUseBinaryProtocol(true);
        final CacheFactory cf = new CacheFactory();
        cf.setCacheClientFactory(new MemcacheClientFactoryImpl());
        cf.setAddressProvider(new DefaultAddressProvider(serverString));
        cf.setConfiguration(conf);
        return cf;
    }

    @Bean
    public CacheManager cacheManager() throws Exception {
        // Use SSMCacheManager instead of ExtendedSSMCacheManager if you do not
        // need to set per key expiration
        ExtendedSSMCacheManager cacheManager = new ExtendedSSMCacheManager();
        Cache cache = this.defaultMemcachedClient().getObject();
        // SSMCache(cache, 0, false) creates a cache with default key expiration
        // of 0 (no expiration) and flushing disabled (allowClear = false)
        cacheManager.setCaches(Arrays.asList(new SSMCache(cache, 0, false)));
        return cacheManager;
    }

}
