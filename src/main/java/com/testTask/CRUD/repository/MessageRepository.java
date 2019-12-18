package com.testTask.CRUD.repository;

import com.testTask.CRUD.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, BigInteger> {

   List<Message> findAllByOrderByPositionDesc();
}
