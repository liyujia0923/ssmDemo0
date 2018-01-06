package com.bdqn.ssm4.service;

import com.bdqn.ssm4.dao.HobbyMapper4;
import com.bdqn.ssm4.entity.Hobby4;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 佳 on 2017/12/28.
 */
@Service
public class HobbyService4Impl implements HobbyService4 {
    @Resource
    private HobbyMapper4 hobbyMapper4;
    @Override
    public PageInfo<Hobby4> queryAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Hobby4> list = hobbyMapper4.queryAll();
        PageInfo<Hobby4> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Integer addHobby(Hobby4 hobby4) {
        return hobbyMapper4.addHobby(hobby4);
    }

    @Override
    public Integer deleteHobby(Integer id) {
        return hobbyMapper4.deleteHobby(id);
    }

    @Override
    public Integer deleteHobbyList(List<Integer> ids) {
        return hobbyMapper4.deleteHobbyList(ids);
    }

    @Override
    public Hobby4 queryHobby(Integer id) {
        return hobbyMapper4.queryHobby(id);
    }

    @Override
    public Integer updateHobby(Hobby4 hobby4) {
        return hobbyMapper4.updateHobby(hobby4);
    }
}
