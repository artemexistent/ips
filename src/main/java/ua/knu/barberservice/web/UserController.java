package ua.knu.barberservice.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ua.knu.barberservice.service.UserService;
import ua.knu.barberservice.web.converter.UserConverter;
import ua.knu.barberservice.web.model.UserDto;

@RestController
@RequiredArgsConstructor
public class UserController {

  private final UserConverter converter;
  private final UserService service;

  @PostMapping("/user")
  @ResponseStatus(HttpStatus.CREATED)
  void addUser(@RequestBody UserDto userDto) {
    final var userModel = converter.toModel(userDto);
    service.addUser(userModel);
  }

  @GetMapping("/user/{userId}")
  UserDto get(@PathVariable Long userId) {
    return converter.toDto(service.get(userId));
  }

  @PutMapping("/user/{userId}")
  void updateUser(@RequestBody UserDto userDto, @PathVariable Long userId) {
    final var userModel = converter.toModel(userDto);
    service.updateUser(userModel.toBuilder().userId(userId).build());
  }
}
