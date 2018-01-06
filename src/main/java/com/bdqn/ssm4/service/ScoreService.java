package com.bdqn.ssm4.service;

import com.bdqn.ssm4.entity.Score4;
import com.github.pagehelper.PageInfo;

/**
 * Created by 佳 on 2018/1/5.
 */
public interface ScoreService {
    PageInfo<Score4> queryAll(Integer pageNum, Integer pageSize);

    PageInfo<Score4> queryScore(Integer pageNum, Integer pageSize,
                                Integer gradeId,Integer studentId);
}
