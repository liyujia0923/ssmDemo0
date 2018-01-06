package com.bdqn.ssm4.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.bdqn.ssm4.entity.Grade4;
import com.bdqn.ssm4.entity.Student4;
import com.bdqn.ssm4.service.GradeService4;
import com.bdqn.ssm4.service.StudentService4;
import com.bdqn.ssm4.util.Message;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 佳 on 2017/12/14.
 */
@Controller
@RequestMapping("student")
public class StudentController4 {
    @Resource
    private StudentService4 studentService4;
    @Resource
    private GradeService4 gradeService4;

    @RequestMapping(value = "queryAll")
    public String queryAll(Integer pageNum, Integer pageSize, Model model) {
        PageInfo<Student4> pageInfo = studentService4.queryAll(pageNum, pageSize);
        model.addAttribute("pageInfo", pageInfo);
        return "student/student";
    }

    @ResponseBody
    @RequestMapping(value = "deleteStudentByIds",method = RequestMethod.POST,
    produces = {"application/json;charset=UTF-8"})
    public String deleteStudentByIds(String studentId) {
        String[] studentArray = studentId.split(",");
        List<Integer> list = new ArrayList<>();
        for (String s : studentArray) {
            list.add(Integer.parseInt(s));
        }
        int n = studentService4.deleteStudentByIds(list);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }
    @ResponseBody
    @RequestMapping(value = "queryGrade",method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    public String queryGrade() {
        List<Grade4> list = gradeService4.queryAll();
        return JSONArray.toJSONString(list);
    }
    @ResponseBody
    @RequestMapping(value = "addStudent",method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public String addStudent(Student4 student4) {
        int n = studentService4.addStudent(student4);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }
    @ResponseBody
    @RequestMapping(value = "queryStudentById",method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    public String queryStudentById(Integer id) {
        Student4 student4  = studentService4.queryStudentById(id);
        return JSON.toJSONString(student4);
    }
    @ResponseBody
    @RequestMapping(value = "updateStudent",method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public String updateStudent(Student4 student4) {
        int n = studentService4.updateStudent(student4);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }
    @ResponseBody
    @RequestMapping(value = "queryStudentByGradeId",method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    public String queryStudentByGradeId(Integer gradeId) {
        List<Student4> list = studentService4.queryStudentByGradeId(gradeId);
        return JSON.toJSONString(list);
    }

}
