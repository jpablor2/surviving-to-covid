package com.example.survivingtocovid.service;

import com.example.survivingtocovid.dao.AdviceDao;
import com.example.survivingtocovid.model.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AdviceService {

    private final AdviceDao adviceDao;

    @Autowired
    public AdviceService(@Qualifier("fakeDao") AdviceDao adviceDao) {
        this.adviceDao = adviceDao;
    }

    public int addAdvice(Advice advice) {
        return adviceDao.insertAdvice(advice);
    }

    public List<Advice> getAllAdvices() {
        return adviceDao.getAllAdvices();
    }

    public Optional<Advice> getAdvicePerId(UUID id) {
        return adviceDao.getAdvicePerId(id);
    }

    public int deleteAdvicePerId(UUID id){
        return adviceDao.deleteAdvicePerId(id);
    }

    public int updateAdvicePerId(UUID id, Advice advice){
        return adviceDao.updateAdvicePerId(id, advice);
    }
}
