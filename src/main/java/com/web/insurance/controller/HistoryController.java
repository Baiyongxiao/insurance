package com.web.insurance.controller;

import com.web.insurance.entity.History;
import com.web.insurance.service.HistoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/api/history")
public class HistoryController {

    @Resource
    private HistoryService historyService;


    @PostMapping("/findAllHistory")
    public Object findAllHistory(@RequestBody History history){
        return historyService.findAllHistory(history);
    }

    @PostMapping("/voted")
    public int voted(@RequestBody History history){
        return historyService.voted(history);
    }

    @GetMapping("/deleteHistory")
    public int deleteHistory(@RequestParam int id){
        return historyService.deleteHistory(id);
    }

    @PostMapping("/selectVotedUser")
    public Object selectVotedUser(@RequestBody History history){
        return historyService.selectVotedUser(history);
    }
}
