package ua.knu.barberservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.knu.barberservice.domain.PlaceModel;
import ua.knu.barberservice.domain.UserEntity;
import ua.knu.barberservice.domain.UserModel;
import ua.knu.barberservice.repository.PlaceRepository;
import ua.knu.barberservice.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaceService {

  private final PlaceRepository repository;

  public List<PlaceModel> getAllPlaces() {
    return repository.findAll()
        .stream()
        .map(entity -> PlaceModel.builder()
            .address(entity.getAddress())
            .build())
        .toList();
  }
}
