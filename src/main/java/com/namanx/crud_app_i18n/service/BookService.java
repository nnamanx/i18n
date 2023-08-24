package com.namanx.crud_app_i18n.service;

import com.namanx.crud_app_i18n.model.Book;
import com.namanx.crud_app_i18n.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    

    public ResponseEntity<Book> addBook(Book book) {
        try {
            Book bookObject = bookRepository.save(book);
            return new ResponseEntity<>(bookObject, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
