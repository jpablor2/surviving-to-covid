package com.example.survivingtocovid.dao;

import com.example.survivingtocovid.model.Advice;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AdviceDao {

    int insertAdvice(UUID id, Advice advice);

    default int insertAdvice(Advice advice) {
        UUID id = UUID.randomUUID();
        return insertAdvice(id, advice);
    }

    List<Advice> getAllAdvices();

    Optional<Advice> getAdvicePerId(UUID id);

    int deleteAdvicePerId(UUID id);

    int updateAdvicePerId(UUID id, Advice advice);
}
