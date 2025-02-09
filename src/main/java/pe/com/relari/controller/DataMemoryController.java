package pe.com.relari.controller;

import lombok.AllArgsConstructor;
import pe.com.relari.srv_neg_data_memory_v1.model.api.DataMemoryRequest;
import pe.com.relari.srv_neg_data_memory_v1.model.api.DataMemoryResponse;
import pe.com.relari.srv_neg_data_memory_v1.model.domain.DataHeader;
import pe.com.relari.srv_neg_data_memory_v1.service.DataMemoryService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "${application.api.path}")
@AllArgsConstructor
public class DataMemoryController {

    private final DataMemoryService dataMemoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(
    		@RequestHeader(name = "user-code") String userCode,
    		@RequestHeader(name = "Request-ID") String requestId,
            @RequestBody DataMemoryRequest dataMemoryRequest) {
        dataMemoryService.save(
        		new DataHeader(dataMemoryRequest.getTransacctionKey(), requestId, userCode),
        		dataMemoryRequest.getData()
        );
    }

//    private User mapUser(DataMemoryRequest dataMemoryRequest) {
//        return new User(
//                dataMemoryRequest.getId(), dataMemoryRequest.getName(), dataMemoryRequest.getSalary()
//        );
//    }

    @GetMapping(path = "/{transacctionKey}")
    public DataMemoryResponse findById(
    		@RequestHeader(name = "user-code") String userCode,
    		@RequestHeader(name = "Request-ID") String requestId,
    		@PathVariable("transacctionKey") String transacctionKey){
        var data = dataMemoryService.findByKey(
        		new DataHeader(transacctionKey, requestId, userCode)
		);
        return new DataMemoryResponse(null, data);
    }

//    @DeleteMapping(path = "/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteById(@PathVariable("id") Integer id){
//        dataMemoryService.deleteById(id);
//    }
//
//    @GetMapping
//    public List<UserResponse> findAll(){
//        return dataMemoryService.findAll()
//                .stream()
//                .map(this::mapUserResponse)
//                .collect(Collectors.toList());
//    }
//
//    private UserResponse mapUserResponse(User user) {
//        return new UserResponse(
//                user.getName(), user.getSalary()
//        );
//    }
}
