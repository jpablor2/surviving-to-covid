package com.example.survivingtocovid.api;

import com.example.survivingtocovid.model.Advice;
import com.example.survivingtocovid.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/advice")
public class AdviceController {

    private final AdviceService adviceService;

    @Autowired
    public AdviceController(AdviceService adviceService) {
        this.adviceService = adviceService;
    }

    @PostMapping
    public void addAdvice(@RequestBody Advice advice) {
        adviceService.addAdvice(advice);
    }

    @GetMapping
    public List<Advice> getAllAdvices(){
        return adviceService.getAllAdvices();
    }

    @GetMapping(path = "{id}")
    public Optional<Advice> getAdvicePerId(@PathVariable("id") UUID id) {
        return adviceService.getAdvicePerId(id);
    }

    @DeleteMapping(path = "{id}")
    public int deleteAdvicePerId(@PathVariable("id") UUID id) {
        return adviceService.deleteAdvicePerId(id);
    }

    @PutMapping(path = "{id}")
    public int updateAdvicePerId(@PathVariable("id")UUID id, @RequestBody Advice advice){
        return adviceService.updateAdvicePerId(id, advice);
    }
}
