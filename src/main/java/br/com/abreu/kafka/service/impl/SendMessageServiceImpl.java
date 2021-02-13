package br.com.abreu.kafka.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import br.com.abreu.kafka.service.SendMessageService;

@Service
public class SendMessageServiceImpl implements SendMessageService {

    private final static String topicName = "baeldung";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String msg) {
	ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topicName, msg);

	future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

	    @Override
	    public void onSuccess(SendResult<String, String> result) {
		System.out.println(
			"Sent message[" + msg + "] with offset = [" + result.getRecordMetadata().offset() + "]");

	    }

	    @Override
	    public void onFailure(Throwable ex) {

	    }
	});
    }

}
