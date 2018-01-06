package com.bdqn.ssm4.service;

import com.bdqn.ssm4.dao.TuserMapper4;
import com.bdqn.ssm4.entity.Tuser4;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 佳 on 2017/12/7.
 */
@Service("tuserService")
public class TuserService4Impl implements TuserService4 {
    @Resource
    private TuserMapper4 tuserMapper4;
    @Override
    public Tuser4 login(Tuser4 tuser4) {
        return tuserMapper4.login(tuser4);
    }

    @Override
    public PageInfo<Tuser4> queryAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Tuser4> list = tuserMapper4.queryAll();
        PageInfo<Tuser4> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
