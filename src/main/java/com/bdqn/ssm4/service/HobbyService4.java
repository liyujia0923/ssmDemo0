package com.bdqn.ssm4.service;

import com.bdqn.ssm4.entity.Hobby4;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by 佳 on 2017/12/28.
 */
public interface HobbyService4 {
    PageInfo<Hobby4> queryAll(Integer pageNum, Integer pageSize);

    Integer addHobby(Hobby4 hobby4);

    Integer deleteHobby(Integer id);

    Integer deleteHobbyList(List<Integer> ids);

    Hobby4 queryHobby(Integer id);

    Integer updateHobby(Hobby4 hobby4);
}
