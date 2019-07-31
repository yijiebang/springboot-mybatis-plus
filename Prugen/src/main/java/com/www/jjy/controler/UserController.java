package com.www.jjy.controler;


import com.www.jjy.entity.User;
import com.www.jjy.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Jerry
 * @since 2019-07-21
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    IUserService service;

    @RequestMapping("/test")
    @ResponseBody
    public List<User> findAll(){

        return service.selectList(null);
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        logger.debug("进行接口测试");
        //insert
        User user = new User();
        user.setUsername("yijiebang");
        user.setPwd("123456");
        //生成第一个用户的唯一标识符 UUID
        String u1_uuid = UUID.randomUUID().toString();
        //去掉 UUID 的 - 符号
        String uuid1 = u1_uuid.substring(0,8)+u1_uuid.substring(9,13)+u1_uuid.substring(14,18)+u1_uuid.substring(19,23)+u1_uuid.substring(24);

        user.setId(uuid1);
        user.setAge(23);
        boolean res = service.insert(user);
        if (res){
             logger.error("用户对象插入数据库失败");
        }
        return res ? "success" : "fail";
    }

    //Increase one record
    @RequestMapping(value = "/addRecord", method = RequestMethod.POST)
    public String addRecord(User ur){
        //生成第一个用户的唯一标识符 UUID
        String u1_uuid = UUID.randomUUID().toString();
        //去掉 UUID 的 - 符号
        String uuid1 = u1_uuid.substring(0,8)+u1_uuid.substring(9,13)+u1_uuid.substring(14,18)+u1_uuid.substring(19,23)+u1_uuid.substring(24);

        ur.setId(uuid1);
        boolean res =  service.insert(ur);
        return res ? "success" : "fail";
    }
    //Delete
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String deleteById(@RequestParam("id") String id){

        boolean res =    service.deleteById(id);
        if (res){
            logger.error("用户对象插入数据库失败");
        }
        return res ? "success" : "fail";

     }
    //updateByid
    @RequestMapping(value = "/update", method=RequestMethod.PUT)
    public boolean updateById(User ur){
        return service.updateById(ur);
    }
    //selectList:Query All
    @RequestMapping("/select")
    @ResponseBody
    public List selectAll(){
        //
        List<User> user = service.selectList(null);

        System.out.println(user);
        return user;
    } 
}
