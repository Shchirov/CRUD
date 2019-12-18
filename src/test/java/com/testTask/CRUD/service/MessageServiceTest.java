package com.testTask.CRUD.service;

import com.testTask.CRUD.domain.Message;
import com.testTask.CRUD.repository.MessageRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@SpringBootTest
class MessageServiceTest {

    @MockBean
    private MessageRepository messageRepository;

    @Autowired
    private MessageService messageService;
/*
    @Test
    void findById() {
        final BigInteger id = BigInteger.valueOf(1L);
        final Message message = new Message(id, "test");
        Mockito.when(messageRepository.findById(id)).thenReturn(Optional.of(message));
        final Optional<Message> messageOptional = messageService.findById(id);
        Assertions.assertEquals(message, messageOptional.orElse(null));
    }

    @Test
    void findAll() {
        final List<Message> expectedMessages = new ArrayList<>();
        Mockito.when(messageRepository.findAll()).thenReturn(expectedMessages);
        final List<Message> resultMessages = messageService.findAll();
        Assertions.assertEquals(expectedMessages, resultMessages);
    }*/




}