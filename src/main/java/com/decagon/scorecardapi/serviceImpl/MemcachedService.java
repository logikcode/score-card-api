package com.decagon.scorecardapi.serviceImpl;

import lombok.AllArgsConstructor;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeoutException;

@Service
@AllArgsConstructor
public class MemcachedService {

    private final MemcachedClient memcachedClient;

    public void save(String key, String value) {
        try {
            memcachedClient.set(key, 0, value);
        } catch (TimeoutException | InterruptedException | MemcachedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public String getValueByKey(String key) {
        try {
            return memcachedClient.get(key);
        } catch (Exception e) {
            return null;
        }
    }


    public void clear(String key) {

        try {
            memcachedClient.delete(key);
        } catch (TimeoutException | InterruptedException | MemcachedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
