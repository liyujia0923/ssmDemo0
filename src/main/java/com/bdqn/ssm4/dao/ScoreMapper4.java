package com.bdqn.ssm4.dao;

import com.bdqn.ssm4.entity.Score4;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 佳 on 2018/1/5.
 */
public interface ScoreMapper4 {
    public List<Score4> queryAll();

    public List<Score4> queryScore(@Param("gradeId") Integer gradeId,
                                   @Param("studentId") Integer studentId);

    public Integer deleteScoreById(Integer id);

    public Integer deleteScoreByIds(List<Integer> list);

    public Score4 queryScoreById(Integer id);
}
