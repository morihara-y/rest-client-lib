package rest.client.lib;

import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;

import rest.client.lib.spec.EndPoint;

public interface RestClient {

    public <T> ResponseEntity<T> get(String serviceCode, EndPoint endPoint, ParameterizedTypeReference<T> responseType,
            Map<String, String> queryParams);

    public <T> ResponseEntity<T> post(String serviceCode, EndPoint endPoint, Object requestBody,
            ParameterizedTypeReference<T> responseType, Map<String, String> queryParams);

    public <T> ResponseEntity<T> put(String serviceCode, EndPoint endPoint, Object requestBody,
            ParameterizedTypeReference<T> responseType, Map<String, String> queryParams);

    public <T> ResponseEntity<T> delete(String serviceCode, EndPoint endPoint, Object requestBody,
            ParameterizedTypeReference<T> responseType, Map<String, String> queryParams);
}
