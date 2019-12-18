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



}