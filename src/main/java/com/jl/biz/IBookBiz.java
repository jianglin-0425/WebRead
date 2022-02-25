package com.jl.biz;

import com.jl.bean.Book;

import java.util.List;

/**
 * @program: demo
 * @description:
 * @author: LIN
 * @create: 2021~05~14 16:44
 */
public interface IBookBiz {
    public Book findOne(Book book) throws Exception;
    public List<Book> findByCondition( Book book, int count);

    public int getLength(Book info)throws Exception;

    public List<Book> findByPage(Book b,Integer pageNum,Integer pageSize) throws Exception;


}
