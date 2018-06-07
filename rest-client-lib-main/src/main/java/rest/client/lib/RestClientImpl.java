package rest.client.lib;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import rest.client.lib.spec.EndPoint;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RestClientImpl implements RestClient {
    private final RestTemplate rt;

    private final boolean isCircuitBreacker = false;

    private RestExecutor getRestExecuter() {
        return new RestExecutor(this.rt);
    }

    @Override
    public <T> ResponseEntity<T> get(String serviceCode, EndPoint endPoint, ParameterizedTypeReference<T> responseType,
            Map<String, String> queryParams) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> ResponseEntity<T> post(String serviceCode, EndPoint endPoint, Object requestBody,
            ParameterizedTypeReference<T> responseType, Map<String, String> queryParams) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> ResponseEntity<T> put(String serviceCode, EndPoint endPoint, Object requestBody,
            ParameterizedTypeReference<T> responseType, Map<String, String> queryParams) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> ResponseEntity<T> delete(String serviceCode, EndPoint endPoint, Object requestBody,
            ParameterizedTypeReference<T> responseType, Map<String, String> queryParams) {
        // TODO Auto-generated method stub
        return null;
    }

}
