package rest.client.lib;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import rest.client.lib.spec.EndPoint;

public class RestClientImpl implements RestClient {

    @Override
    public <T> ResponseEntity<T> get(String contextRoot, EndPoint endPoint, Map<String, String> queryParams) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> ResponseEntity<T> post(String contextRoot, EndPoint endPoint, Object requestBody,
            Map<String, String> queryParams) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> ResponseEntity<T> put(String contextRoot, EndPoint endPoint, Object requestBody,
            Map<String, String> queryParams) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> ResponseEntity<T> delete(String contextRoot, EndPoint endPoint, Object requestBody,
            Map<String, String> queryParams) {
        // TODO Auto-generated method stub
        return null;
    }
}
