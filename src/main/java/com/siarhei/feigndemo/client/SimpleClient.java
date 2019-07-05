package com.siarhei.feigndemo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "simpleclient", url = "http://localhost:8080")
public interface SimpleClient {

    @GetMapping("/bad-request")
    ResponseEntity<String> getBadRequest();

    @GetMapping("/internal-error")
    ResponseEntity<String> getInternalError();

    @GetMapping("/result-not-found")
    ResponseEntity<String> getResultNotFound();

    @GetMapping("/timeout")
    ResponseEntity<String> getTimeout();
}
