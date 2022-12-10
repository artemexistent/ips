package ua.knu.barberservice.web.converter;

import org.springframework.stereotype.Component;
import ua.knu.barberservice.domain.UserModel;
import ua.knu.barberservice.web.model.UserDto;

@Component
public class UserConverter implements Converter<UserDto, UserModel> {

  @Override
  public UserModel toModel(UserDto dto) {
    return UserModel.builder()
        .userId(dto.getUserId())
        .userName(dto.getUserName())
        .phoneNumber(dto.getPhoneNumber())
        .build();
  }

  @Override
  public UserDto toDto(UserModel model) {
    return UserDto.builder()
        .userId(model.getUserId())
        .userName(model.getUserName())
        .phoneNumber(model.getPhoneNumber())
        .build();
  }
}
