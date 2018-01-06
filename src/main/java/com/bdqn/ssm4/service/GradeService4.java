package com.bdqn.ssm4.service;

import com.bdqn.ssm4.entity.Grade4;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by 佳 on 2017/12/9.
 */
public interface GradeService4 {
    public PageInfo<Grade4> queryAll(Integer pageNum, Integer pageSize);

    public Grade4 queryGradeById(Integer id);

    public Integer deleteGradeById(Integer id);

    public Integer deleteGradeByIds(List<Integer> list);

    public Integer addGrade(Grade4 grade4);

    public List<Grade4> queryAll();

    public Integer updateGrade(Grade4 grade4);
}
