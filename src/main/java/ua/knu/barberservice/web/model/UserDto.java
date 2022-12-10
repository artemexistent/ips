package ua.knu.barberservice.web.model;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Value
@Data
@Builder
public class UserDto {
  Long userId;
  String userName;
  String phoneNumber;
}
