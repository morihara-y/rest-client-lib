package rest.client.lib;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import rest.client.lib.spec.EndPoint;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RestClientImpl implements RestClient {
    private RestExecutor executor;

    private final RestTemplate rt;

    private RestExecutor getRestExecuter() {
        synchronized (this) {
            if (this.executor == null) {
                this.executor = new RestExecutor(this.rt);
            }
        }
        return this.executor;
    }

    @Override
    public <T> ResponseEntity<T> get(String serviceCode, EndPoint endPoint, ParameterizedTypeReference<T> responseType,
            Map<String, String> queryParams) {
        return getRestExecuter().execute(serviceCode, endPoint, (Object) null, responseType, queryParams,
                HttpMethod.GET);
    }

    @Override
    public <T> ResponseEntity<T> post(String serviceCode, EndPoint endPoint, Object requestBody,
            ParameterizedTypeReference<T> responseType, Map<String, String> queryParams) {
        return getRestExecuter().execute(serviceCode, endPoint, requestBody, responseType, queryParams,
                HttpMethod.POST);
    }

    @Override
    public <T> ResponseEntity<T> put(String serviceCode, EndPoint endPoint, Object requestBody,
            ParameterizedTypeReference<T> responseType, Map<String, String> queryParams) {
        return getRestExecuter().execute(serviceCode, endPoint, requestBody, responseType, queryParams, HttpMethod.PUT);
    }

    @Override
    public <T> ResponseEntity<T> delete(String serviceCode, EndPoint endPoint, Object requestBody,
            ParameterizedTypeReference<T> responseType, Map<String, String> queryParams) {
        return getRestExecuter().execute(serviceCode, endPoint, requestBody, responseType, queryParams,
                HttpMethod.DELETE);
    }

}
