package com.web.insurance.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.web.insurance.AbstractService;
import com.web.insurance.entity.Comment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CommentService extends AbstractService {

    /**
     * 根据产品id查询该产品的评论
     * @param comment
     * @return
     */
    public PageInfo<Comment> findByProductId(Comment comment) {
        PageHelper.startPage(comment.getPageNum(), comment.getPageSize());
        List<Comment> comments = sqlSession.selectList("comment.findByProductId", comment.getProductId());
        return new PageInfo<>(comments);
    }

    /**
     * 删除自己的评论
     * @param id
     * @return
     */
    public int deleteInfo(int id) {
        return sqlSession.delete("comment.deleteInfo", id);
    }

    /**
     * 增加评论
     * @param comment
     * @return
     */
    public int addInfo(Comment comment) {
        comment.setAccount(getUserInfoService.getUserAccount());
        return sqlSession.insert("comment.addInfo", comment);
    }
}
