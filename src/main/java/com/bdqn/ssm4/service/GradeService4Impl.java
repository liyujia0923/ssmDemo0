package com.bdqn.ssm4.service;

import com.bdqn.ssm4.dao.GradeMapper4;
import com.bdqn.ssm4.dao.StudentNumMapper;
import com.bdqn.ssm4.entity.Grade4;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 佳 on 2017/12/9.
 */
@Service
public class GradeService4Impl implements GradeService4 {
    @Resource
    private GradeMapper4 gradeMapper4;
    @Resource
    private StudentNumMapper studentNumMapper;
    @Override
    public PageInfo<Grade4> queryAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Grade4> list = gradeMapper4.queryAll();
        PageInfo<Grade4> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Grade4 queryGradeById(Integer id) {
        return gradeMapper4.queryGradeById(id);
    }

    @Override
    public Integer deleteGradeById(Integer id) {
        return gradeMapper4.deleteGradeById(id);
    }

    @Override
    public Integer deleteGradeByIds(List<Integer> list) {
        return gradeMapper4.deleteGradeByIds(list);
    }

    @Override
    public Integer addGrade(Grade4 grade4) {
        gradeMapper4.addGrade(grade4);
        Integer gradeId = grade4.getId();
        return studentNumMapper.addStudentNum(gradeId);
    }

    @Override
    public List<Grade4> queryAll() {
        return gradeMapper4.queryAll();
    }

    @Override
    public Integer updateGrade(Grade4 grade4) {
        return gradeMapper4.updateGrade(grade4);
    }
}
