package com.bdqn.ssm4.service;

import com.bdqn.ssm4.entity.Tuser4;
import com.github.pagehelper.PageInfo;

/**
 * Created by 佳 on 2017/12/7.
 */
public interface TuserService4 {
    public Tuser4 login(Tuser4 tuser4);

    public PageInfo<Tuser4> queryAll(Integer pageNum, Integer pageSize);
}
