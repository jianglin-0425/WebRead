package com.jl.repository;

import com.jl.bean.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

/**
 * @program: demo
 * @description:
 * @author: LIN
 * @create: 2021~05~13 14:17
 */

@SpringBootTest
public class BookDaoTest {
    @Autowired
    IBookDAO dao;
    @Test
    public void findAll(){

        Book book=new Book();
        book.setBid(1);
        Book list=dao.findOne(book);
        System.out.println(list);
        Assert.notNull(list);
    }
    @Test
    public void findTWO(){

    }
}
