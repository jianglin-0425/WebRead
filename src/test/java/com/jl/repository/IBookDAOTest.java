package com.jl.repository;

import com.jl.bean.Book;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
class IBookDAOTest {

    @Autowired
    IBookDAO dao;
    @Test
    void findByCondition() {
        Book book=new Book();
        book.setBtype("言情小说、都市小说");
        List<Book> list=dao.findByCondition(book,13);
        for (Book b:list) {
            System.out.println(b);
        }
    }
}