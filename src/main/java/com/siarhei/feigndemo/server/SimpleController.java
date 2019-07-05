package com.siarhei.feigndemo.server;

import com.siarhei.feigndemo.server.exception.BadRequestException;
import com.siarhei.feigndemo.server.exception.InternalException;
import com.siarhei.feigndemo.server.exception.ResultNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleController {

    private RuntimeException rootException = new RuntimeException("rootException exception");

    @GetMapping("/bad-request")
    public ResponseEntity<String> getBadRequest() {
        throw new BadRequestException("my bad request message", rootException);
    }

    @GetMapping("/internal-error")
    public ResponseEntity<String> getInternalError() {
        throw new InternalException("my internal error message", rootException);
    }

    @GetMapping("/result-not-found")
    public ResponseEntity<String> getResultNotFound() {
        throw new ResultNotFoundException("my result not found message", rootException);
    }

    @GetMapping("/timeout")
    public ResponseEntity<String> getTimeout() throws InterruptedException {

        Thread.sleep(1000000000);

        return ResponseEntity.ok("my result not found message");
    }
}
