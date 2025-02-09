package pe.com.relari.srv_neg_data_memory_v1.repository;

import java.util.concurrent.TimeUnit;

public interface DataMemoryTemporalRepository {

    void saveWithExpiration(String key, String value, long timeout, TimeUnit unit);
    String findByKey(String key);

}
