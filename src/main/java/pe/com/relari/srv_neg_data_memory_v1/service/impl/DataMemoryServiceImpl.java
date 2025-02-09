package pe.com.relari.srv_neg_data_memory_v1.service.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import pe.com.relari.srv_neg_data_memory_v1.model.domain.DataHeader;
import pe.com.relari.srv_neg_data_memory_v1.repository.DataMemoryPermanentRepository;
import pe.com.relari.srv_neg_data_memory_v1.repository.DataMemoryTemporalRepository;
import pe.com.relari.srv_neg_data_memory_v1.service.DataMemoryService;

@Service
@AllArgsConstructor
public class DataMemoryServiceImpl implements DataMemoryService {

    private final DataMemoryTemporalRepository dataMemoryTemporalRepository;
    private final DataMemoryPermanentRepository dataMemoryPermanentRepository;

	@Override
	public String findByKey(DataHeader dataHeader) {
		// TODO Auto-generated method stub
//		return dataMemoryPermanentRepository.findByKey(dataHeader.getKey(), dataHeader.getTransacctionKey());
		return dataMemoryTemporalRepository.findByKey(dataHeader.getKey());
	}

	@Override
	public void save(DataHeader dataHeader, String data) {
		// TODO Auto-generated method stub
//		dataMemoryPermanentRepository.save(dataHeader.getKey(), dataHeader.getTransacctionKey(), data);
		dataMemoryTemporalRepository.saveWithExpiration(dataHeader.getKey(), data, 120, TimeUnit.SECONDS);
	}


//    @Override
//    public List<User> findAll() {
//        return dataMemoryTemporalRepository.findAll()
//                .values()
//                .stream()
//                .map(this::mapUser)
//                .collect(Collectors.toList());
//    }
//
//    private User mapUser(UserEntity userEntity) {
//        return new User(
//                userEntity.getId(), userEntity.getName(), userEntity.getSalary()
//        );
//    }
//
//    @Override
//    public User findById(Integer id) {
//        var userEntity = dataMemoryTemporalRepository.findById(id);
//        return mapUser(userEntity);
//    }
//
//    @Override
//    public void save(User user) throws InterruptedException {
//        var userEntity = mapUserEntity(user);
//        dataMemoryTemporalRepository.save(userEntity);
//    }
//
    @Override
    public void deleteByKey(DataHeader dataHeader) {
        dataMemoryPermanentRepository.deleteByKey(dataHeader.getKey(), dataHeader.getTransacctionKey());
    }
//
//    private UserEntity mapUserEntity(User user) {
//        return new UserEntity(
//                user.getId(), user.getName(), user.getSalary()
//        );
//    }
}