package com.namanx.crud_app_i18n.controller;

import com.namanx.crud_app_i18n.model.Book;
import com.namanx.crud_app_i18n.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController("/")
@RequiredArgsConstructor
@Slf4j
public class BookController {


    private final BookService bookService;
    private final MessageSource messageSource;

    @PostMapping("/new-book")
    public ResponseEntity<Book> addBook(@RequestBody Book book, Locale locale) {
        try {
            bookService.addBook(book);
            String successMessage = messageSource.getMessage("success.book.added", null, locale);
            log.info(successMessage);
            return ResponseEntity.ok().body(book);
        } catch (Exception e) {
            String errorMessage = messageSource.getMessage("error.message", null, locale);
            log.error(errorMessage, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}

