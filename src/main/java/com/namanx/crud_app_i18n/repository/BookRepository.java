package com.namanx.crud_app_i18n.repository;

import com.namanx.crud_app_i18n.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
