package com.bdqn.ssm4.dao;

import com.bdqn.ssm4.entity.Grade4;

import java.util.List;

/**
 * Created by 佳 on 2017/12/9.
 */
public interface GradeMapper4 {
    public List<Grade4> queryAll();

    public Grade4 queryGradeById(Integer id);

    public Integer deleteGradeById(Integer id);

    public Integer deleteGradeByIds(List<Integer> list);

    public Integer addGrade(Grade4 grade4);

    public Integer updateGrade(Grade4 grade4);


}
