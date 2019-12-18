package com.testTask.CRUD.service;

import com.testTask.CRUD.domain.Message;
import com.testTask.CRUD.repository.MessageRepository;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceImplementation implements MessageService {

    private MessageRepository messageRepository;

    @Autowired
    public MessageServiceImplementation(final MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Optional<Message> findById(final BigInteger id) {
        return messageRepository.findById(id);
    }

    @Override
    public List<Message> findAll() {
        List<Message> all = messageRepository.findAllByOrderByPositionDesc();
        return all;
    }

    @Override
    public void saveAll(final List<Message> messages) {

        messageRepository.saveAll(messages);
    }

    @Override
    public void deleteById(final BigInteger id) {

        messageRepository.deleteById(id);
    }
}
