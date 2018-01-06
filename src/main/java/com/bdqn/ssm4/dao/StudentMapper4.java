package com.bdqn.ssm4.dao;

import com.bdqn.ssm4.entity.Student4;

import java.util.List;

/**
 * Created by 佳 on 2017/12/14.
 */
public interface StudentMapper4 {
    public List<Student4> queryAll();

    public Integer deleteStudentByIds(List<Integer> list);

    public Integer addStudent(Student4 student4);

    public Student4 queryStudentById(Integer id);

    public Integer updateStudent(Student4 student4);

    public List<Student4> queryStudentByGradeId(Integer gradeId);
}
