package com.example.survivingtocovid.dao;

import com.example.survivingtocovid.model.Advice;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface AdviceDao extends MongoRepository<Advice, UUID> {

    public List<Advice> findAll();
    public Advice save(Advice advice);
    public Advice findById(Advice advice);
    public Advice deleteById(Advice advice);

}
