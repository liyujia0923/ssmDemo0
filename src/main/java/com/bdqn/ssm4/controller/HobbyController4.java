package com.bdqn.ssm4.controller;

import com.alibaba.fastjson.JSON;
import com.bdqn.ssm4.entity.Hobby4;
import com.bdqn.ssm4.service.HobbyService4;
import com.bdqn.ssm4.util.Message;
import com.bdqn.ssm4.util.PageUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 佳 on 2017/12/26.
 */
@Controller
@RequestMapping("hobby")
public class HobbyController4 {
    @Resource
    private HobbyService4 hobbyService4;
    @RequestMapping(value = "toHobby")
    public String toHobby() {
        return "hobby/hobby";
    }

    @ResponseBody
    @RequestMapping(value = "queryAll",method = RequestMethod.GET,
    produces = {"application/json;charset=UTF-8"})
    public String queryAll(Integer page, Integer rows) {
        PageInfo<Hobby4> pageInfo = hobbyService4.queryAll(page, rows);
      /*  Map<String, Object> map = new HashMap<>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());*/
        PageUtil<Hobby4> pageUtil = new PageUtil<>(pageInfo);
        return JSON.toJSONString(pageUtil);
    }

    @ResponseBody
    @RequestMapping(value = "addHobby",method = RequestMethod.POST,
    produces = {"application/json;charset=UTF-8"})
    public String addHobby(Hobby4 hobby4) {
        int n = hobbyService4.addHobby(hobby4);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }
    @ResponseBody
    @RequestMapping(value = "deleteHobby",method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public String deleteHobby(Integer id) {
        int n = hobbyService4.deleteHobby(id);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }
    @ResponseBody
    @RequestMapping(value = "deleteHobbyList",method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public String deleteHobbyList(String ids) {
        String[] idArray = ids.split(",");
        List<Integer> list = new ArrayList<>();
        if (idArray != null || idArray.length > 0) {
            for (String s : idArray) {
                list.add(Integer.parseInt(s));
            }
        }
        int n = hobbyService4.deleteHobbyList(list);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }
    @ResponseBody
    @RequestMapping(value = "queryHobby",method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    public String queryHobby(Integer id) {
        Hobby4 hobby4 = hobbyService4.queryHobby(id);
        return JSON.toJSONString(hobby4);
    }
    @ResponseBody
    @RequestMapping(value = "updateHobby",method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public String updateHobby(Hobby4 hobby4) {
        int n = hobbyService4.updateHobby(hobby4);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }
}
