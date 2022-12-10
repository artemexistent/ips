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
import ua.knu.barberservice.service.PlaceService;
import ua.knu.barberservice.service.UserService;
import ua.knu.barberservice.web.converter.PlaceConverter;
import ua.knu.barberservice.web.converter.UserConverter;
import ua.knu.barberservice.web.model.PlaceDto;
import ua.knu.barberservice.web.model.UserDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PlaceController {

  private final PlaceConverter converter;
  private final PlaceService service;

  @GetMapping("/space")
  List<PlaceDto> getPlaces() {
    return service.getAllPlaces()
        .stream().map(converter::toDto).toList();
  }
}
