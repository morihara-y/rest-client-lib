package rest.client.lib;

import java.util.Locale;
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
        String prefix = getMsaUrlPrefix(serviceCode);

        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        sb.append(endPoint.getEndPoint());
        return sb.toString();
    }
    
    private String getMsaUrlPrefix(String serviceCode) {
    	// Get URL prefix from vm argument
    	serviceCode = serviceCode.trim().toUpperCase(Locale.ROOT).replace('-', '_');
        final String systemPropertyKey = "MSA_" + serviceCode;
        return System.getProperty(systemPropertyKey);
    }


}
