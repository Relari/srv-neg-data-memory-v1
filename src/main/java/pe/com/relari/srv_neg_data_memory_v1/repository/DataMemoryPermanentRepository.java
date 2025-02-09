package pe.com.relari.srv_neg_data_memory_v1.repository;

import java.util.Map;

public interface DataMemoryPermanentRepository {

    void save(String key, String hashKey, String value);

    Map<String, String> findAll();

    String findByKey(String key, String hashKey);

    void deleteByKey(String key, String hashKey);
}
