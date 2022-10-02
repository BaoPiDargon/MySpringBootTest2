package com.lfy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lfy.domain.Book;
import com.lfy.mapper.BookDao;
import com.lfy.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl extends ServiceImpl<BookDao,Book> implements BookService {
//
//    @Autowired
//    private BookDao bookDao;
//
//    @Override
//    public boolean save(Book book) {
//        return bookDao.insert(book) > 0;
//    }
//
//    @Override
//    public boolean delete(Book book) {
//        return bookDao.deleteById(book) > 0;
//    }
//
//    @Override
//    public boolean update(Book book) {
//        return bookDao.updateById(book) > 0;
//    }
//
//    @Override
//    public Book getById(int id) {
//        return bookDao.selectById(id);
//    }
//
//    @Override
//    public List<Book> getAll() {
//        return bookDao.selectList(null);
//    }
}
