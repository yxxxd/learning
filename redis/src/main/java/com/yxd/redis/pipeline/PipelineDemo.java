package com.yxd.redis.pipeline;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yuxudong
 * @date 2019/12/14 16:58
 */
@RestController
@RequestMapping("pipeline")
public class PipelineDemo {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    private int index = 0;

    private int size = 100;


    /**
     * <p>
     *     普通方式循环set
     * </p>
     * 计时：2420ms
     */
    @RequestMapping("normalSet")
    public long normalSet(){
        int s = index;
        long start = System.currentTimeMillis();
        for (int i = s; i < s+size ; i++) {
            stringRedisTemplate.opsForValue().set("key"+i, "value"+i);
        }
        index+=size;
        return System.currentTimeMillis()-start;
    }

    /**
     * <p>
     *     multi方式set
     * </p>
     * 计时：
     *      37
     *      37
     *      60
     *      34
     *      35
     */
    @RequestMapping("multiSet")
    public long multiSet(){
        Map<String, String> map = new HashMap<>(16);
        int s = index;
        long start = System.currentTimeMillis();
        for (int i=s;i<s+size;i++) {
            map.put("key"+i, "value"+i);
        }
        stringRedisTemplate.opsForValue().multiSet(map);
        index +=size;
        return System.currentTimeMillis()-start;
    }

    /**
     * <p>
     *     管道方式set
     * </p>
     * 计时：
     *      1333
     *      50
     *      57
     *      56
     *      49
     */
    @RequestMapping("pipelineSet")
    public long pipelineSet(){
        int s = index;
        long start = System.currentTimeMillis();
        List<Object> res = stringRedisTemplate.executePipelined(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                for (int i = s; i < s+size ; i++) {
                    redisConnection.set(("key"+i).getBytes(), ("value"+i).getBytes());
                }
                return null;
            }
        });
        index+=size;
        return System.currentTimeMillis()-start;
    }
}
