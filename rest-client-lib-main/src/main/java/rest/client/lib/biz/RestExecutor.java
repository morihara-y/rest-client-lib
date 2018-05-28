package rest.client.lib.biz;

import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import rest.client.lib.spec.EndPoint;

public class RestExecutor {
    private RestTemplate rt;

    private boolean isCircuitBreacker = false;

    public RestExecutor() {
        this.rt = new RestTemplate();
    }

    public void execute(String contextRoot, EndPoint endPoint, Object requestBody, Map<String, String> queryParams,
            HttpMethod method) {
        // TODO It is implemented tentatively. It will be added Circuit Breaker.
    }
}
