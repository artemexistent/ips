package ua.knu.barberservice.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.knu.barberservice.domain.BookModel;
import ua.knu.barberservice.service.BarberService;
import ua.knu.barberservice.service.BookService;
import ua.knu.barberservice.web.converter.BarberConverter;
import ua.knu.barberservice.web.converter.BookConverter;
import ua.knu.barberservice.web.model.BarberDto;
import ua.knu.barberservice.web.model.BookDto;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {

  private final BookConverter converter;
  private final BookService service;

  @PostMapping("/book")
  void createBook(@RequestBody BookDto bookDto) {
    final var bookModel = converter.toModel(bookDto);
    service.createBook(bookModel);
  }
}
