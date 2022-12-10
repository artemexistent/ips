package ua.knu.barberservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.knu.barberservice.domain.BookEntity;
import ua.knu.barberservice.domain.BookModel;
import ua.knu.barberservice.repository.BarberRepository;
import ua.knu.barberservice.repository.BookRepository;
import ua.knu.barberservice.repository.DayRepository;
import ua.knu.barberservice.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class BookService {

  private final BookRepository repository;
  private final BarberRepository barberRepository;
  private final DayRepository dayRepository;
  private final UserRepository userRepository;

  public void createBook(BookModel bookModel) {
    final var barberEntity = barberRepository.findAllByBarberName(bookModel.getBarberName()).stream().findFirst().orElseThrow();
    final var date = dayRepository.findByDate(bookModel.getDate());
    final var userEntity = userRepository.findByUserId(bookModel.getUserId());

    final var bookEntity = BookEntity.builder()
        .barberId(barberEntity.getId())
        .dayId(date.getId())
        .userId(userEntity.getId())
        .timeId(bookModel.getTime())
        .build();

    repository.save(bookEntity);
  }
}
