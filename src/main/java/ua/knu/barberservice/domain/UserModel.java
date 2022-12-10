package ua.knu.barberservice.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Value
@Data
@Builder(toBuilder = true)
public class UserModel {
  Long userId;
  String userName;
  String phoneNumber;
}
