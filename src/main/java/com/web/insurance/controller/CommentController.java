package com.web.insurance.controller;

import com.web.insurance.entity.Comment;
import com.web.insurance.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/api/comment")
public class CommentController {

    @Resource
    private CommentService commentService;

    @PostMapping("/findByProductId")
    public Object findByProductId(@RequestBody Comment comment){
        return commentService.findByProductId(comment);
    }

    @GetMapping("/deleteInfo")
    public int deleteInfo(@RequestParam int id){
        return commentService.deleteInfo(id);
    }
    @PostMapping("/addInfo")
    public int addInfo(@RequestBody Comment comment){
        return commentService.addInfo(comment);
    }
}
