package com.lfy.mapper;

import com.lfy.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookDaoTests {

    @Autowired
    private BookDao bookDao;

    @Test
    void testFindById(){
        Book book = bookDao.selectById(1);
        System.out.println(book);
    }

    @Test
    void testSave(){
        Book book = new Book();
        book.setName("大学英语");
        book.setType("教材");
        book.setDescription("这是一门毫无意义上课摸鱼的课");
        bookDao.insert(book);
    }

}
