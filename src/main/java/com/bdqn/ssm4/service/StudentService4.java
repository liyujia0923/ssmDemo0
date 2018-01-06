package com.bdqn.ssm4.service;

import com.bdqn.ssm4.entity.Student4;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by 佳 on 2017/12/14.
 */
public interface StudentService4 {
    public PageInfo<Student4> queryAll(Integer pageNum, Integer pageSize);

    public Integer deleteStudentByIds(List<Integer> list);

    public Integer addStudent(Student4 student4);

    public Student4 queryStudentById(Integer id);

    public Integer updateStudent(Student4 student4);

    public List<Student4> queryStudentByGradeId(Integer gradeId);

}
