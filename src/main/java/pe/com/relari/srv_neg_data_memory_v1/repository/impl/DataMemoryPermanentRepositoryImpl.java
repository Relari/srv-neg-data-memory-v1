package pe.com.relari.srv_neg_data_memory_v1.repository.impl;

import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import pe.com.relari.srv_neg_data_memory_v1.repository.DataMemoryPermanentRepository;

public class DataMemoryPermanentRepositoryImpl implements DataMemoryPermanentRepository {

	private static final String KEY_MAP_USER = "USER";

//    private final RedisTemplate<String, String> redisTemplate;

//    private final HashOperations hashOperations;


	private HashOperations<String, String, String> hashOperations;

    public DataMemoryPermanentRepositoryImpl(RedisTemplate<String, String> redisTemplate) {
        this.hashOperations = redisTemplate.opsForHash();
    }
	
    @Override
    public void save(String key, String hashKey, String data) {
        hashOperations.put(key, hashKey, data);
    }

    @Override
    public Map<String, String> findAll() {
        return hashOperations.entries(KEY_MAP_USER);
    }

    @Override
    public String findByKey(String key, String hashKey) {
        return hashOperations.get(key, hashKey);
    }

    @Override
    public void deleteByKey(String key, String hashKey) {
        hashOperations.delete(key, hashKey);
    }
}
