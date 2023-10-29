package com.nisheeth.ibmmq.resources;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nisheeth.ibmmq.models.MessageRequest;
import com.nisheeth.ibmmq.models.MessageResponse;
import com.nisheeth.ibmmq.service.MessageService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/message")
public class MessageResources {

    private final MessageService messageService;

    @PostMapping(path = "send", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> sendMessage(@RequestBody MessageRequest messageRequest) {
        messageService.sendMessage(messageRequest.message());
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "recv", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MessageResponse> receiveMessage() {
        return ResponseEntity.ok(messageService.receiveMessage());
    }
}
