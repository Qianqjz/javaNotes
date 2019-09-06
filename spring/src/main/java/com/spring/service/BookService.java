package com.spring.service;

import com.spring.dao.BookDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BookService {

//    @Qualifier("bookDao")
//    @Autowired(required = false)
    @Resource(name="bookDao2")
//    @Inject
    private BookDao bookDao;


    public void print(){
        System.out.println(bookDao);
    }

    @Override
    public String toString() {
        return "BookService{" +
                "bookDao=" + bookDao +
                '}';
    }
}
