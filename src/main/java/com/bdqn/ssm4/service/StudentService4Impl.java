package com.bdqn.ssm4.service;

import com.bdqn.ssm4.dao.StudentMapper4;
import com.bdqn.ssm4.dao.StudentNumMapper;
import com.bdqn.ssm4.entity.Student4;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 佳 on 2017/12/14.
 */
@Service
public class StudentService4Impl implements StudentService4 {
    @Resource
    private StudentMapper4 studentMapper4;
    @Resource
    private StudentNumMapper studentNumMapper;
    @Override
    public PageInfo<Student4> queryAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Student4> list = studentMapper4.queryAll();
        PageInfo<Student4> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Integer deleteStudentByIds(List<Integer> list) {
        return studentMapper4.deleteStudentByIds(list);
    }

    @Override
    public Integer addStudent(Student4 student4) {
        Integer gradeId = student4.getGrade4().getId();
        studentNumMapper.updateMaxNumByGradeId(gradeId);
        Integer maxNum = studentNumMapper.queryMaxNumByGradeId(gradeId);
        String gradeName = student4.getGrade4().getGradeName();
        String studentNum = gradeName + maxNum;
        int n = 15 - studentNum.length();
        if (n > 0) {
            for (int i = 0; i<n;i++) {
                gradeName += 0;
            }
        }
        studentNum = gradeName + maxNum;
        student4.setStudentNum(studentNum);

        return studentMapper4.addStudent(student4);
    }

    @Override
    public Student4 queryStudentById(Integer id) {
        return studentMapper4.queryStudentById(id);
    }

    @Override
    public Integer updateStudent(Student4 student4) {
        return studentMapper4.updateStudent(student4);
    }

    @Override
    public List<Student4> queryStudentByGradeId(Integer gradeId) {
        return studentMapper4.queryStudentByGradeId(gradeId);
    }

}
