package ua.knu.barberservice.web.converter;

import org.springframework.stereotype.Component;
import ua.knu.barberservice.domain.PlaceModel;
import ua.knu.barberservice.domain.UserModel;
import ua.knu.barberservice.web.model.PlaceDto;
import ua.knu.barberservice.web.model.UserDto;

@Component
public class PlaceConverter implements Converter<PlaceDto, PlaceModel> {

  @Override
  public PlaceModel toModel(PlaceDto dto) {
    return PlaceModel.builder()
        .address(dto.getAddress())
        .build();
  }

  @Override
  public PlaceDto toDto(PlaceModel model) {
    return PlaceDto.builder()
        .address(model.getAddress())
        .build();
  }
}
