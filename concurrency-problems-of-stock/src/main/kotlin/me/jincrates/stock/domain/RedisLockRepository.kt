package me.jincrates.stock.domain

import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Component
import java.time.Duration

@Component
class RedisLockRepository(
    private val redisTemplate: RedisTemplate<String, String>
) {

    fun lock(key: Long): Boolean? = redisTemplate.opsForValue().setIfAbsent(generateKey(key), "lock", Duration.ofMillis(3_000))

    fun unlock(key: Long): Boolean = redisTemplate.delete(generateKey(key))

    fun generateKey(key: Long) = key.toString()
}