package com.bdqn.ssm4.service;

import com.bdqn.ssm4.dao.ScoreMapper4;
import com.bdqn.ssm4.entity.Score4;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 佳 on 2018/1/5.
 */
@Service
public class ScoreServiceImpl implements ScoreService {
    @Resource
    private ScoreMapper4 scoreMapper4;
    @Override
    public PageInfo<Score4> queryAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Score4> list = scoreMapper4.queryAll();
        PageInfo<Score4> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<Score4> queryScore(Integer pageNum, Integer pageSize, Integer gradeId, Integer studentId) {
        PageHelper.startPage(pageNum, pageSize);
        List<Score4> list = scoreMapper4.queryScore(gradeId, studentId);
        PageInfo<Score4> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
