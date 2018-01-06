package com.bdqn.ssm4.controller;

import com.alibaba.fastjson.JSON;
import com.bdqn.ssm4.entity.Grade4;
import com.bdqn.ssm4.service.GradeService4;
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
 * Created by 佳 on 2017/12/9.
 */
@Controller
@RequestMapping("grade")
public class GradeController4 {
    @Resource
    private GradeService4 gradeService4;

    @RequestMapping("toGrade")
    public String toGrade(Integer pageNum, Integer pageSize, Model model) {
        PageInfo<Grade4> pageInfo = gradeService4.queryAll(pageNum, pageSize);
        model.addAttribute("pageInfo", pageInfo);
        return "grade/grade";
    }

    @ResponseBody
    @RequestMapping(value = "queryGradeById",method = RequestMethod.GET,
    produces = {"application/json;charset=UTF-8"})
    public String queryGradeById(Integer gradeId) {
        Grade4 grade4 = gradeService4.queryGradeById(gradeId);
        return JSON.toJSONString(grade4);
    }
    @ResponseBody
    @RequestMapping(value = "deleteGradeById",method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public String deleteGradeById(Integer gradeId) {
        int n = gradeService4.deleteGradeById(gradeId);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
             return JSON.toJSONString(Message.error());
    }
    @ResponseBody
    @RequestMapping(value = "deleteGradeByIds",method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public String deleteGradeByIds(String gradeIds) {
        String[] gradeIdArray = gradeIds.split(",");
        List<Integer> list = new ArrayList<Integer>();
        for (String s : gradeIdArray) {
            list.add(Integer.parseInt(s));
        }
        int n = gradeService4.deleteGradeByIds(list);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }

    @ResponseBody
    @RequestMapping(value = "addGrade",method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public String addGrade(Grade4 grade4) {
        int n = gradeService4.addGrade(grade4);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }

    @ResponseBody
    @RequestMapping(value = "updateGrade",method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public String updateGrade(Grade4 grade4) {
        int n = gradeService4.updateGrade(grade4);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }
}
