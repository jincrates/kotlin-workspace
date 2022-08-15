package me.jincrates.concurrencyproblems.repository

import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Component
import java.time.Duration

@Component
class RedisLockRepository(
    private val redisTemplate: RedisTemplate<String, String>
) {

    /**
     * Redis에서 Lock을 획득합니다.
     */
    fun lock(key: Long): Boolean? = redisTemplate.opsForValue().setIfAbsent(generateKey(key), "lock", Duration.ofMillis(3_000))

    /**
     * Redis에서 Lock을 해제합니다.
     */
    fun unlock(key: Long): Boolean = redisTemplate.delete(generateKey(key))

    fun generateKey(key: Long) = key.toString()

}