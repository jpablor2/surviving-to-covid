package com.example.survivingtocovid.api;

import com.example.survivingtocovid.dao.AdviceDao;
import com.example.survivingtocovid.model.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/advice")
public class AdviceController {

    @Autowired
    private AdviceDao adviceDao;

    //Adding new Advice
    @PostMapping
    public ResponseEntity<Advice> addNewAdvice(@RequestBody Advice advice) {
        try {
            advice.setId(UUID.randomUUID());
            Advice _advice = adviceDao.save(advice);
            return new ResponseEntity<>(_advice, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    //Getting all the advices
    @GetMapping
    public List <Advice> getAllDevices(){
        return adviceDao.findAll();
    }

    //Getting a advice per ID
    @GetMapping(path = "{id}")
    public ResponseEntity <Advice> getAdvicePerId(@PathVariable("id") UUID id){
        Optional <Advice> advice = adviceDao.findById(id);
        if(advice.isPresent()){
            return new ResponseEntity<>(advice.get(), HttpStatus.OK);
        } else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Update a device per ID
    @PutMapping(path = "{id}")
    public ResponseEntity <Advice> updateAdvicePerId(@PathVariable("id") UUID id, @RequestBody Advice advice) {
        Optional<Advice> _advice = adviceDao.findById(id);
        if(_advice.isPresent()) {
            Advice updatedAdvice = _advice.get();
            updatedAdvice.setActivityName(advice.getActivityName());
            updatedAdvice.setCategory(advice.getCategory());
            updatedAdvice.setInstructions(advice.getInstructions());
            updatedAdvice.setOnlineAcademyUrl(advice.getOnlineAcademyUrl());
            return new ResponseEntity<>(adviceDao.save(updatedAdvice), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Deleting advice per Id
    @DeleteMapping(path = "{id}")
    public ResponseEntity<Advice> deleteAdvicePerId(@PathVariable("id") UUID id) {
        try {
            adviceDao.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e ) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

}
