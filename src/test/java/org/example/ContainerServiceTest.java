package org.example;

import junit.framework.Assert;
import org.example.DI.ContainerService;
import org.example.DI.ContainerServiceRepository;
import org.testng.annotations.Test;

import static junit.framework.Assert.assertNotNull;

public class ContainerServiceTest {


    @Test
    public void getObject_BookRepository() {
        BookRepository bookRepository = ContainerService.getObject(BookRepository.class);
        assertNotNull(bookRepository);
        //  BookRepository bookRepository = ContainerService.getObject(BookRepository.class);
        //        assertNotNull(bookRepository); 아무것도 Object에 구현을 하지 않았기 때문에 Error
    }

        @Test
        public void getObject_BookService() {
            BookService bookService = ContainerService.getObject(BookService.class);
            assertNotNull(bookService);
            assertNotNull(bookService.bookRepository);
//BookService bookService = ContainerService.getObject(BookService.class);
//            assertNotNull(bookService);
//            assertNotNull(bookService.bookRepository); => 이상태에서는 Null 왜냐면 bookRepository에 아무것도 x
        }

    }
