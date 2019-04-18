package com.web.insurance.controller;

import com.web.insurance.entity.Program;
import com.web.insurance.service.ProgramService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/api/program")
public class ProgramController {

    @Resource
    private ProgramService programService;

    @PostMapping("/findByProductId")
    public Object findByProductId(@RequestBody Program program) {
        return programService.findByProductId(program);
    }

    @GetMapping("/deleteById")
    public int deleteById(@RequestParam int id){
        return programService.deleteById(id);
    }

    @PostMapping("/updateInfo")
    public int updateInfo(@RequestBody Program program) {
        return programService.updateInfo(program);
    }

    @PostMapping("/insertProgram")
    public int insertProgram(@RequestBody Program program){
        return programService.insertProgram(program);
    }

}
