package ua.knu.barberservice.web.converter;

import org.springframework.stereotype.Component;
import ua.knu.barberservice.domain.BarberModel;
import ua.knu.barberservice.domain.UserModel;
import ua.knu.barberservice.web.model.BarberDto;
import ua.knu.barberservice.web.model.UserDto;

@Component
public class BarberConverter implements Converter<BarberDto, BarberModel> {

  @Override
  public BarberModel toModel(BarberDto dto) {
    return BarberModel.builder()
        .name(dto.getName())
        .rating(dto.getRating())
        .cost(dto.getCost())
        .build();
  }

  @Override
  public BarberDto toDto(BarberModel model) {
    return BarberDto.builder()
        .name(model.getName())
        .rating(model.getRating())
        .cost(model.getCost())
        .build();
  }
}
