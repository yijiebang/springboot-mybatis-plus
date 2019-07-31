//package com.www.jjy.beifen;
//
//import com.www.jjy.bean.User;
//import com.www.jjy.mapper.UserDao;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.CachePut;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.stereotype.Service;
///**
// * 用户操作 service 层
// * 一般情况下，我们在Sercive层进行对缓存的操作。
// * 先介绍 Ehcache 在 Spring 中的注解：在支持 Spring Cache 的环境下，
// * * @Cacheable : Spring在每次执行前都会检查Cache中是否存在相同key的
// * 缓存元素，如果存在就不再执行该方法，而是直接从缓存中获取结果进行返回，
// * 否则才会执行并将返回结果存入指定的缓存中。
// * * @CacheEvict : 清除缓存。
// * * @CachePut : @CachePut也可以声明一个方法支持缓存功能。
// * 使用@CachePut标注的方法在执行前不会去检查缓存中是否存在之前执行过的结果，
// * 而是每次都会执行该方法，并将执行结果以键值对的形式存入指定的缓存中。
// * * 这三个方法中都有两个主要的属性：value 指的是 ehcache.xml
// * 中的缓存策略空间；key 指的是缓存的标识，同时可以用 # 来引用参数。
// */
//
///**
// * @author: Jerry Yi
// * @date: 2019/7/21 13:20
// * @description:
// */
//@Service
//public class UserService    {
//    @Autowired
//    UserDao userDao;
//
//    //这里的单引号不能少，否则会报错，被识别是一个对象
//    private static final String CACHE_KEY = "'user'";
//    private static final String DEMO_CACHE_NAME = "users";
//
//    //删除用户数据
//    @CacheEvict(value = DEMO_CACHE_NAME,key = "'user_'+#id")//这是清除缓存
//    public void delete(String id) {
//        System.out.println("删除数据："+id);
//        userDao.delete(id);
//    }
//
//    //更新用户数据
//    @CachePut(value = DEMO_CACHE_NAME,key = "'user_'+#user.getId()")
//    public User update(User user) {
//        System.out.println("修改数据："+user.getId());
//        return userDao.update(user);
//    }
//
//    //查找用户数据
//    @Cacheable(value=DEMO_CACHE_NAME,key="'user_'+#id")
//    public User findById(String id) {
//        System.out.println("查询数据库："+id);
//        return userDao.findById(id);
//    }
//
//    //保存用户数据
//    @CacheEvict(value=DEMO_CACHE_NAME,key=CACHE_KEY)
//    public int save(User user) {
//        System.out.println("新增数据到数据库："+user.getId());
//        return userDao.save(user);
//    }
//}
