package pe.com.relari.srv_neg_data_memory_v1.model.domain;

import java.util.StringJoiner;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DataHeader {

	private String transacctionKey;
    private String requestId;
    private String userCode;
    
    public String getKey() {
    	return new StringJoiner("-")
    			.add(transacctionKey)
    			.add(requestId)
    			.add(userCode)
    			.toString();
    }

}
