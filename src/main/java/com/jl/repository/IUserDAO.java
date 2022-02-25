package com.jl.repository;

import com.jl.bean.User;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: demo
 * @description:
 * @author: LIN
 * @create: 2021~05~13 15:19
 */

@Repository
public interface IUserDAO {

    public int add(User user);

    public User findOne(User user);

    public int updateUser(User user);

    public List<User> findMany(@Param("curIndex") String curIndex ,@Param("pageSize") String pageSize);

    public List<User> findCondition(@Param("user") User user,@Param("pageIndex") Integer pageIndex ,@Param("pageSize") Integer pageSize);

    public int getEmailCount(User user);

}
