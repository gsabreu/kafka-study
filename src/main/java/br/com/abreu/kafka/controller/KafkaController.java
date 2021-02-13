package br.com.abreu.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.abreu.kafka.service.SendMessageService;

@RestController
@RequestMapping(path = "/kafka")
public class KafkaController {

    @Autowired
    private SendMessageService sendMessageService;

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody String msg) {
	sendMessageService.sendMessage(msg);
	return ResponseEntity.ok("OK");
    }

}
