package rest.client.lib;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import rest.client.lib.spec.EndPoint;

/**
 * TODO Make javadoc
 *
 * @author morihara-y
 */
public interface RestClient {
    /**
     * TODO Make javadoc
     *
     * @param contextRoot
     * @param endPoint
     * @param queryParams
     * @return
     */
    public <T> ResponseEntity<T> get(String contextRoot, EndPoint endPoint, Map<String, String> queryParams);

    /**
     * TODO Make javadoc
     *
     * @param contextRoot
     * @param endPoint
     * @param requestBody
     * @param queryParams
     * @return
     */
    public <T> ResponseEntity<T> post(String contextRoot, EndPoint endPoint, Object requestBody,
            Map<String, String> queryParams);

    /**
     * TODO Make javadoc
     *
     * @param contextRoot
     * @param endPoint
     * @param requestBody
     * @param queryParams
     * @return
     */
    public <T> ResponseEntity<T> put(String contextRoot, EndPoint endPoint, Object requestBody,
            Map<String, String> queryParams);

    /**
     * TODO Make javadoc
     *
     * @param contextRoot
     * @param endPoint
     * @param requestBody
     * @param queryParams
     * @return
     */
    public <T> ResponseEntity<T> delete(String contextRoot, EndPoint endPoint, Object requestBody,
            Map<String, String> queryParams);
}
