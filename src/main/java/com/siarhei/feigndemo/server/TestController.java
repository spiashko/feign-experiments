package com.siarhei.feigndemo.server;

import com.siarhei.feigndemo.client.SimpleClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    private final SimpleClient simpleClient;

    public TestController(SimpleClient simpleClient) {
        this.simpleClient = simpleClient;
    }

    @GetMapping("/test-bad-request")
    public ResponseEntity<String> getBadRequest() {
        ResponseEntity<String> response = null;

        try {
            response = simpleClient.getBadRequest();
        } catch (Exception ex) {
            System.out.println(ex);
            throw ex;
        }

        return response;
    }

    @GetMapping("/test-internal-error")
    public ResponseEntity<String> getInternalError() {
        ResponseEntity<String> response = null;

        try {
            response = simpleClient.getInternalError();
        } catch (Exception ex) {
            System.out.println(ex);
            throw ex;
        }

        return response;
    }

    @GetMapping("/test-result-not-found")
    public ResponseEntity<String> getResultNotFound() {
        ResponseEntity<String> response = null;

        try {
            response = simpleClient.getResultNotFound();
        } catch (Exception ex) {
            System.out.println(ex);
            throw ex;
        }

        return response;
    }

    @GetMapping("/test-timeout")
    public ResponseEntity<String> getTimeout() {
        ResponseEntity<String> response = null;

        try {
            response = simpleClient.getTimeout();
        } catch (Exception ex) {
            System.out.println(ex);
            throw ex;
        }

        return response;
    }
}
