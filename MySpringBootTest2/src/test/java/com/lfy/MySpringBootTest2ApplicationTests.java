package com.lfy;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lfy.domain.Book;
import com.lfy.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MySpringBootTest2ApplicationTests {

    @Autowired
    private BookService bookService;

    @Test
    void contextLoads() {
        Page<Book> page = new Page<>(1,5);
        IPage<Book> iPage = bookService.page(page);
        System.out.println(iPage.getRecords());
    }
}
