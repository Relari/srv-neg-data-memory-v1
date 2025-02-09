package pe.com.relari.srv_neg_data_memory_v1.repository.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import pe.com.relari.srv_neg_data_memory_v1.repository.DataMemoryTemporalRepository;

@Repository
public class DataMemoryTemporalRepositoryImpl implements DataMemoryTemporalRepository {

//    private final RedisTemplate<String, String> redisTemplate;
	private final ValueOperations<String, String> ops;

    public DataMemoryTemporalRepositoryImpl(RedisTemplate<String, String> redisTemplate){
//        this.redisTemplate = redisTemplate;
    	ops = redisTemplate.opsForValue();
    }

    @Override
    public void saveWithExpiration(String key, String value, long timeout, TimeUnit unit) {
//        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        ops.set(key, value, timeout, unit);
    }

    @Override
    public String findByKey(String key) {
//        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        return ops.get(key);
    }

}
