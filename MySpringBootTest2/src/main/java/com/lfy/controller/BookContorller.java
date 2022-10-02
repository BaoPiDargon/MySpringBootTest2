package com.lfy.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lfy.domain.Book;
import com.lfy.service.BookService;
import com.lfy.utils.Code;
import com.lfy.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookContorller {

    @Autowired
    private BookService bookService;

    @PostMapping
    public R save(@RequestBody Book book){
        return bookService.save(book)? new R(Code.SAVE_OK,"添加成功"): new R(Code.SAVE_ERR,"添加失败");
    }

    @DeleteMapping("{id}")
    public R deleteById(@PathVariable Integer id){
        return bookService.removeById(id)? new R(Code.DELETE_OK,"删除成功"): new R(Code.DELETE_ERR,"删除失败");
    }

    @PutMapping
    public R updateById(@RequestBody Book book){
        return bookService.updateById(book)? new R(Code.UPDATE_OK,"修改成功"): new R(Code.UPDATE_ERR,"修改失败");
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(Code.GET_OK,bookService.getById(id));
    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable Integer currentPage,@PathVariable Integer pageSize){
        Page<Book> bookPage = new Page<>(currentPage,pageSize);
        IPage<Book> bookIPage = bookService.page(bookPage);
        if(bookIPage.getPages()<currentPage){
            bookPage.setCurrent(bookIPage.getPages());
            bookIPage = bookService.page(bookPage);
        }
        return new R(Code.GET_OK,bookIPage);
    }

//    @GetMapping("{currentPage}/{pageSize}")
//    public R getPage(@PathVariable Integer currentPage,@PathVariable Integer pageSize,@RequestBody Book book){
//
//        LambdaQueryWrapper<Book> bookLambdaQueryWrapper = Wrappers.lambdaQuery();
//        if(book.getType()!=null)bookLambdaQueryWrapper.like(Book::getType,book.getType());
//        if(book.getName()!=null)bookLambdaQueryWrapper.like(Book::getName,book.getName());
//        if(book.getDescription()!=null)bookLambdaQueryWrapper.like(Book::getDescription,book.getDescription());
//
//        Page<Book> bookPage = new Page<>(currentPage,pageSize);
//        IPage<Book> bookIPage = bookService.page(bookPage,bookLambdaQueryWrapper);
//        if(bookIPage.getPages()<currentPage){
//            bookPage.setCurrent(bookIPage.getPages());
//            bookIPage = bookService.page(bookPage,bookLambdaQueryWrapper);
//        }
//        return new R(Code.GET_OK,bookIPage);
//    }

}
