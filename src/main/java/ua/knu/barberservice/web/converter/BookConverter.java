package ua.knu.barberservice.web.converter;

import org.springframework.stereotype.Component;
import ua.knu.barberservice.domain.BookModel;
import ua.knu.barberservice.web.model.BookDto;

@Component
public class BookConverter implements Converter<BookDto, BookModel> {

  @Override
  public BookModel toModel(BookDto dto) {
    return BookModel.builder()
        .barberName(dto.getBarberName())
        .userId(dto.getUserId())
        .date(dto.getDate())
        .time(dto.getTime())
        .build();
  }

  @Override
  public BookDto toDto(BookModel model) {
    return BookDto.builder()
        .barberName(model.getBarberName())
        .userId(model.getUserId())
        .date(model.getDate())
        .time(model.getTime())
        .build();
  }
}
