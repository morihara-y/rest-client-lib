package rest.client.lib;

import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import rest.client.lib.spec.EndPoint;


class RestExecutor {
    private final RestTemplate rt;

    private boolean isCircuitBreacker = false;

    RestExecutor(RestTemplate rt) {
        this.rt = rt;
    }

    public <T> ResponseEntity<T> execute(String serviceCode, EndPoint endPoint, Object requestBody,
            ParameterizedTypeReference<T> responseType, Map<String, String> queryParams, HttpMethod method) {
        if (isCircuitBreacker) {
            // TODO It is implemented tentatively. It will be added Circuit
            // Breaker.
        } else {

        }
        return null;
    }

    private <T> ResponseEntity<T> doExecute(String serviceCode, EndPoint endPoint, Object requestBody, ParameterizedTypeReference<T> responseType, Map<String, String> queryParams,
            HttpMethod method) {
        String url = makeUrl(serviceCode, endPoint);
        // TODO Replace HttpEntity from requestBody which has data of JSON.
        HttpEntity<T> requestEntity = (HttpEntity<T>) requestBody;
        return rt.exchange(url, method, requestEntity, responseType, queryParams);
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
