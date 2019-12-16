package com.testTask.CRUD.repository;

import com.testTask.CRUD.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface MessageRepo  extends JpaRepository<Message, BigInteger> {

}
