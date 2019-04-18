package com.web.insurance.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.web.insurance.AbstractService;
import com.web.insurance.entity.Program;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class ProgramService extends AbstractService {


    /**
     * 通过产品id查询相关的方案
     * @param program
     * @return
     */
    public PageInfo<Program> findByProductId(Program program) {
        PageHelper.startPage(program.getPageNum(), program.getPageSize());
        List<Program> programs = sqlSession.selectList("program.findByProductId", program.getProductId());
        return new PageInfo<>(programs);
    }

    /**
     * 根据id删除该方案
     * @param id
     * @return
     */
    public int deleteById(int id) {
        return sqlSession.delete("program.deleteById", id);
    }

    /**
     * 更新方案信息
     * @param program
     * @return
     */
    public int updateInfo(Program program) {
        program.setUpdatedUser(getUserInfoService.getUserAccount());
        return sqlSession.update("program.updateInfo", program);
    }

    /**
     * 创建新的方案
     * @param program
     * @return
     */
    public int insertProgram(Program program) {
        program.setCreatedUser(getUserInfoService.getUserAccount());
        return sqlSession.insert("program.insertProgram", program);
    }

    /**
     * 有人投票时，修改票数（在创建投票记录的时候调用）
     */
    @Transactional
    public int updateCount(int id){
        return sqlSession.update("program.updateCount", id);
    }
}
