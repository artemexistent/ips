package ua.knu.barberservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.knu.barberservice.domain.UserEntity;
import ua.knu.barberservice.domain.UserModel;
import ua.knu.barberservice.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository repository;

  public UserModel get(Long userId) {
    final var userEntity = repository.findByUserId(userId);
    return UserModel.builder()
        .userName(userEntity.getUserName())
        .phoneNumber(userEntity.getPhoneNumber())
        .userId(userEntity.getId())
        .build();
  }

  public void addUser(UserModel userModel) {
    repository.save(UserEntity.builder()
        .userId(userModel.getUserId())
        .userName(userModel.getUserName())
        .phoneNumber(userModel.getPhoneNumber())
        .build());
  }

  public void updateUser(UserModel userModel) {
    final var userEntity = repository.findByUserId(userModel.getUserId());
    userEntity.setPhoneNumber(userEntity.getPhoneNumber());
    repository.save(userEntity);
  }
}
