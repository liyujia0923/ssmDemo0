package com.bdqn.ssm4.controller;

import com.alibaba.fastjson.JSON;
import com.bdqn.ssm4.entity.Score4;
import com.bdqn.ssm4.service.ScoreService;
import com.bdqn.ssm4.util.PageUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by 佳 on 2017/12/26.
 */
@Controller
@RequestMapping("score")
public class ScoreController4 {
    @Resource
    private ScoreService scoreService;
    @RequestMapping(value = "toScore")
    public String toScore() {
        return "score/score";
    }

    @ResponseBody
    @RequestMapping(value = "queryAll",method = RequestMethod.GET,
    produces = {"application/json;charset=UTF-8"})
    public String queryAll(Integer page,Integer rows,Integer gradeId,Integer studentId){
     /*   PageInfo<Score4> pageInfo = scoreService.queryAll(page, rows);
        PageUtil<Score4> pageUtil = new PageUtil<>(pageInfo);
        return JSON.toJSONString(pageUtil);*/
        if (null != gradeId && gradeId == -1) {
            gradeId = null;
        }
        if (null != studentId && studentId == -1) {
            studentId = null;
        }
        PageInfo<Score4> pageInfo = scoreService.queryScore(page, rows, gradeId, studentId);
        PageUtil<Score4> pageUtil = new PageUtil<>(pageInfo);
        return JSON.toJSONString(pageUtil);
    }
}
