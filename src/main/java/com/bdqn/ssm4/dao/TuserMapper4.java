package com.bdqn.ssm4.dao;

import com.bdqn.ssm4.entity.Tuser4;

import java.util.List;

/**
 * Created by 佳 on 2017/12/7.
 */
public interface TuserMapper4 {
    public Tuser4 login(Tuser4 tuser4);

    public List<Tuser4> queryAll();
}
