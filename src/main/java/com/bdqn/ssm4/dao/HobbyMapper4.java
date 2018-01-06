package com.bdqn.ssm4.dao;

import com.bdqn.ssm4.entity.Hobby4;

import java.util.List;

/**
 * Created by 佳 on 2017/12/28.
 */
public interface HobbyMapper4 {
    List<Hobby4> queryAll();

    Integer addHobby(Hobby4 hobby4);

    Integer deleteHobby(Integer id);

    Integer deleteHobbyList(List<Integer> ids);

    Hobby4 queryHobby(Integer id);

    Integer updateHobby(Hobby4 hobby4);
}
