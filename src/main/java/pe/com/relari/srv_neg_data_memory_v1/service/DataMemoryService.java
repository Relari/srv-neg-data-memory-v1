package pe.com.relari.srv_neg_data_memory_v1.service;

import pe.com.relari.srv_neg_data_memory_v1.model.domain.DataHeader;

public interface DataMemoryService {

	String findByKey(DataHeader dataHeader);
	void save(DataHeader dataHeader, String data);

	//List<User> findAll();
	void deleteByKey(DataHeader dataHeader);

}
