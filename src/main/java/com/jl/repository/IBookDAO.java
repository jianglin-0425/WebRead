package com.jl.repository;


import com.jl.bean.Book;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookDAO{

    public int add(Book book) ;

    public Book findOne(Book book);

    public List<Book> findAll(Book book) ;

    public List<Book> findByCondition(@Param( value = "book")Book book, @Param( value = "count") Integer count);

    public List<Book> findNewBook(Book book)  ;

    //TODO:
    public List<Book> findNewList(@Param(value = "book") Book book,@Param(value = "count") Integer count) ;

    public List<String> findType() ;

    public int updateHot(Book book) ;


    public List<Book> findHot(Book b,Integer count) throws Exception ;

    public int getLength(Book info) throws Exception;

    public List<Book> findByPage(@Param("book") Book book, @Param("pageSize") Integer pageSize, @Param("pageIndex") Integer pageIndex) throws Exception ;

    public List<Book> findByKeys(@Param( value = "book")Book book, @Param( value = "count") Integer count);

}
