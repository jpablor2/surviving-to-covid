package com.example.survivingtocovid.dao;

import com.example.survivingtocovid.model.Advice;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakeAdviceDataAccessService implements AdviceDao{

    private static List<Advice> DB = new ArrayList<>();

    @Override
    public int insertAdvice(UUID id, Advice advice) {
        DB.add(new Advice(id, advice.getInstructions(), advice.getOnlineAcademyUrl(), advice.getCategory(), advice.getActivityName()));
        return 1;
    }

    @Override
    public List<Advice> getAllAdvices() {
        return DB;
    }

    @Override
    public Optional<Advice> getAdvicePerId(UUID id) {
        return DB.stream()
                .filter(advice -> advice.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteAdvicePerId(UUID id) {
        Optional<Advice> advice = getAdvicePerId(id);
        if(!advice.isPresent()){
            return 0;
        }
        DB.remove(advice.get());
        return 1;
    }

    @Override
    public int updateAdvicePerId(UUID id, Advice newAdvice) {
        return getAdvicePerId(id).map(advice -> {
            int indexOfOldAdvice = DB.indexOf(advice);
            if(indexOfOldAdvice >= 0){
                DB.set(indexOfOldAdvice, newAdvice);
                return 1;
            }
            return 0;
        }).orElse(0);
    }


}
