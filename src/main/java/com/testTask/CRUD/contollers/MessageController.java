package com.testTask.CRUD.contollers;

import com.testTask.CRUD.domain.Message;
import com.testTask.CRUD.repository.MessageRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("message")
public class MessageController {

    private final MessageRepo messageRepo;

    @Autowired
    public MessageController(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    @GetMapping
    public List<Message> list() {
        List<Message> all = messageRepo.findAll();
        System.out.println(all);
        return all;
    }


    @PostMapping
    public List<Message> add(@RequestBody List<Message> message) {
        return messageRepo.saveAll(message);
    }
    @PutMapping("{id}")
    Message upadte(@RequestBody Message message,
                               @PathVariable("id") Message messageFromDb){

        BeanUtils.copyProperties(message,messageFromDb);
        return messageRepo.save(messageFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") BigInteger id) {
        messageRepo.deleteById(id);
    }
}

    
    


