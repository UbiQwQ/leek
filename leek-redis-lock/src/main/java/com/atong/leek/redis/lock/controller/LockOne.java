package com.atong.leek.redis.lock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @program: leek
 * @description:
 * 一步一步实现redis分布式锁
 * 第一步业务逻辑实现,不考虑任何并发
 * @author: atong
 * @create: 2021-03-11 22:53
 */
@RestController
public class LockOne {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 扣减库存
     * @return end
     */
    @RequestMapping("/deduct_stock_one")
    public String deductStock () {
        //jedis.get("stock");
        int stock = Integer.parseInt(Objects.requireNonNull(stringRedisTemplate.opsForValue().get("stock")));
        if (stock > 0) {
            int realStock = stock - 1;
            // jedis.set(key, value)
            stringRedisTemplate.opsForValue().set("stock", realStock + "");
            System.out. println("扣减成功,剩余库存:" + realStock);
        }else {
            System.out.println("扣减失败,库存不足");
        }
        return "end";
    }
}
