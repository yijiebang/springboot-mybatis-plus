//package com.www.jjy.beifen;
//
//import com.www.jjy.bean.User;
//import com.www.jjy.service111.UserService;
//import org.apache.ibatis.cache.CacheException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.UUID;
//
///**
// * @author: Jerry Yi
// * @date: 2019/7/21 13:24
// * @description:
// */
//@RestController
//public class EhcacheController {
//    private static final Logger logger = LoggerFactory.getLogger(EhcacheController.class);
//
//
//    @Autowired
//    UserService userService;
//
//
//    @RequestMapping("/encache")
//    public String EhcacheTest(){
//        logger.debug("进行Encache缓存测试");
//        System.out.println("====生成第一个用户====");
//        User user1 = new User();
//        //生成第一个用户的唯一标识符 UUID
//        String u1_uuid = UUID.randomUUID().toString();
//        //去掉 UUID 的 - 符号
//        String uuid1 = u1_uuid.substring(0,8)+u1_uuid.substring(9,13)+u1_uuid.substring(14,18)+u1_uuid.substring(19,23)+u1_uuid.substring(24);
//        user1.setUsername("张三");
//        user1.setAge(18);
//        user1.setId(uuid1);
//        user1.setPwd("123456");
//        if (userService.save(user1) == 0){
//          //  throw new JdbcException("用户对象插入数据库失败");
//        }
//
//        //第一次查询
//        System.out.println(userService.findById(user1.getId()));
//        //通过缓存查询
//        System.out.println(userService.findById(user1.getId()));
//
//        System.out.println("====修改数据====");
//        User user2 = new User();
//        user2.setUsername("李四-update");
//        user2.setAge(22);
//        user2.setId(user1.getId());
//        user2.setPwd("123457");
//         try {
//           // System.out.println(userService.update(user2));
//        } catch (CacheException e){
//            e.printStackTrace();
//        }
//
//        System.out.println(userService.findById(user2.getId()));
//        return "success";
//    }
//
//}
