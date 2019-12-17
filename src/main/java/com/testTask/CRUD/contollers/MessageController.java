package com.testTask.CRUD.contollers;

import com.testTask.CRUD.domain.Message;
import com.testTask.CRUD.service.MessageServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("message")
public class MessageController {


   private final MessageServiceImplementation serviceImplementation;

   @Autowired
    public MessageController(final MessageServiceImplementation serviceImplementation) {
        this.serviceImplementation = serviceImplementation;
    }

    @GetMapping
    public List<Message> list() {
        List<Message> all = serviceImplementation.findAll();
        System.out.println(all);
        return all;
    }


    @PostMapping
    public void add(@RequestBody List<Message> message) {
        System.out.println("post");
        serviceImplementation.saveAll(message);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") BigInteger id) {
        System.out.println("delete");
        serviceImplementation.deleteById(id);
    }

    @PutMapping
    public void updateMessages(@RequestBody List<Message> messages)
    {
        serviceImplementation.updateMessages(messages);

    }

}

    
    


