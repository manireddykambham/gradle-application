package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // Create an endpoint that accepts POST requests
    @PostMapping("/api/data")
    public CustomResponse handlePostRequest(@RequestBody CustomRequest customRequest) {
        // Create a simple response
        return new CustomResponse("Received your data: " + customRequest.getData());
    }

    // Static inner class to hold incoming request data
    public static class CustomRequest {
        private String data;

        // Getters and Setters
        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
    }

    // Static inner class to hold response data
    public static class CustomResponse {
        private String message;

        public CustomResponse(String message) {
            this.message = message;
        }

        // Getters and Setters
        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
