package com.testTask.CRUD.service;

import com.testTask.CRUD.domain.Message;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface MessageService {

    Optional<Message> findById(BigInteger id);
    List<Message> findAll();
    void saveAll(List<Message> messages);
    void deleteById(BigInteger id);
}
