package com.jl.biz.impl;

import com.jl.bean.Book;
import com.jl.biz.IBookBiz;
import com.jl.repository.IBookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: demo
 * @description:
 * @author: LIN
 * @create: 2021~05~13 14:09
 */

@Service
public class BookBizImpl implements IBookBiz {

    @Autowired
    IBookDAO bookDao;

    @Override
    public Book findOne(Book book) {
        return bookDao.findOne(book);
    }

    @Override
    public List<Book> findByCondition(Book book,int count) {

        return bookDao.findByCondition(book,count);
    }



    @Override
    public int getLength(Book info) throws Exception {
        return bookDao.getLength(info);
    }

    @Override
    public List<Book> findByPage(Book b, Integer pageNum, Integer pageSize) throws Exception {
       return bookDao.findByPage(b,pageSize,pageNum);
    }
}
