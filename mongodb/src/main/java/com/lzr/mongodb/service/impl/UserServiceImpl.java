package com.lzr.mongodb.service.impl;

import com.lzr.mongodb.bean.User;
import com.lzr.mongodb.service.UserService;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author linzerong
 * @create 2019-06-03 16:15
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     *注入MongoTemplate
     */
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void saveUser(User user) {
        //使用名称为user的文档保存用户信息
        mongoTemplate.save(user,"user");
        //直接使用类名小写保存
        //mongoTemplate.save(user);
    }

    @Override
    public DeleteResult deleteUser(Long id) {
        //构建id相等的条件
        Criteria criteria = Criteria.where("id").is(id);
        //查询对象
        Query queryId = Query.query(criteria);
        //删除用户
        DeleteResult deleteResult = mongoTemplate.remove(queryId,User.class);
        return deleteResult;
    }

    @Override
    public List<User> findUser(String userName, String note, int skip, int limit) {
        //设置用户名和备注模糊查询
        Criteria criteria = Criteria.where("userName").regex(userName).and("note").regex(note);
        //构建查询条件，设置分页跳过skip个，至多返回limit个
        Query query = Query.query(criteria).limit(limit).skip(skip);
        //查询
        List<User> userList = mongoTemplate.find(query,User.class);
        return userList;
    }

    @Override
    public UpdateResult updateUser(Long id, String userName, String note) {
        //确定更新的对象
        Criteria criteriaId = Criteria.where("id").is(id);
        Query query = Query.query(criteriaId);
        //定义更新对象，要更新的属性
        Update update = Update.update("userName", userName);
        update.set("note", note);
        //第一个文档
        UpdateResult result = mongoTemplate.updateFirst(query, update, User.class);
        //多个文档
        //  UpdateResult result = mongoTemplate.updateMulti(query, update, User.class);
        return result;
    }

    @Override
    public User getUser(Long id) {
        /*这是另外一种方法
        Criteria criteriaId = Criteria.where("id").is(id);
        Query queryId = Query.query(criteriaId);
        return mongoTemplate.findOne(queryId, User.class);
        */
        return mongoTemplate.findById(id, User.class);
    }
}
