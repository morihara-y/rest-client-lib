package rest.client.lib;

import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import rest.client.lib.spec.EndPoint;


class RestExecutor {
    private final RestTemplate rt;

    RestExecutor(RestTemplate rt) {
        this.rt = rt;
    }

    <T> ResponseEntity<T> execute(String serviceCode, EndPoint endPoint, Object requestBody,
            ParameterizedTypeReference<T> responseType, Map<String, String> queryParams, HttpMethod method) {
        // TODO Implement CircuitBreaker architecture.
        return doExchange(serviceCode, endPoint, requestBody, responseType, queryParams, method);
    }

    private <T> ResponseEntity<T> doExchange(String serviceCode, EndPoint endPoint, Object requestBody,
            ParameterizedTypeReference<T> responseType, Map<String, String> queryParams, HttpMethod method) {
        String url = makeUrl(serviceCode, endPoint);
        HttpEntity<?> requestEntity = getEntity(requestBody);
        return rt.exchange(url, method, requestEntity, responseType);
    }

    private HttpEntity<?> getEntity(Object body) {
        return new HttpEntity<Object>(body, makeHeader());
    }

    private HttpHeaders makeHeader() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("User-Agent", "Chrome");
        // TODO Add session token
        return httpHeaders;
    }

    private String makeUrl(String serviceCode, EndPoint endPoint) {
        // TODO Get URL prefix and context root by serviceCode
        String prefix = "http://test.com/test";

        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        sb.append(endPoint.getEndPoint());
        return sb.toString();
    }


}
