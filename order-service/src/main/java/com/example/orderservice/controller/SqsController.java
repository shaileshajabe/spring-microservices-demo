
package com.example.orderservice.controller;

import com.example.orderservice.service.SqsProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/sqs")
public class SqsController {

    private final SqsProducerService sqsProducerService;

    public SqsController(SqsProducerService sqsProducerService) {
        this.sqsProducerService = sqsProducerService;
    }

    @PostMapping("/send")
    public ResponseEntity<Map<String, String>> sendMessage(
            @RequestBody Map<String, Object> message) {

        String messageBody = new com.fasterxml.jackson.databind.ObjectMapper()
                .valueToTree(message)
                .toString();

        String messageId = sqsProducerService.sendMessage(messageBody);

        return ResponseEntity.ok(Map.of(
                "status", "Message sent successfully",
                "messageId", messageId
        ));
    }
}

