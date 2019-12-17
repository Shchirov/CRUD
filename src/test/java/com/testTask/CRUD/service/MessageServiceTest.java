package com.testTask.CRUD.service;

import com.testTask.CRUD.domain.Message;
import com.testTask.CRUD.repository.MessageRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

class MessageServiceTest {

    @Mock
    private MessageRepository messageRepository;

    private MessageService messageService =
            new MessageServiceImplementation(messageRepository);
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
        final BigInteger id = BigInteger.valueOf(1L);
        final Message message = new Message(id, "test");
        final List<Message> expectedMessages = Collections.singletonList(message);
        Mockito.when(messageRepository.findAll()).thenReturn(expectedMessages);
        final List<Message> resultMessages = messageService.findAll();
        Assertions.assertEquals(expectedMessages, resultMessages);
    }

    @Test
    void saveAll() {
        final BigInteger id = BigInteger.valueOf(1L);
        final Message message = new Message(id, "test");
        final List<Message> expectedMessages = Collections.singletonList(message);
        Mockito.verify(messageRepository).saveAll(expectedMessages);
        messageService.saveAll(expectedMessages);
    }

    @Test
    void deleteById() {
        final BigInteger id = BigInteger.valueOf(1L);
        Mockito.verify(messageRepository).deleteById(id);
        messageService.deleteById(id);
    }

    @Test
    void updateMessages()
    {
        final BigInteger id = BigInteger.valueOf(1L);
        final Message message = new Message(id, "test");
        final List<Message> expectedMessages = Collections.singletonList(message);
        Mockito.when(messageRepository.findAll()).thenReturn(expectedMessages);
        final List<Message> resultMessages = messageService.findAll();
        Assertions.assertEquals(expectedMessages, resultMessages);
    }*/

}