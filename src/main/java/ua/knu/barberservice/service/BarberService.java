package ua.knu.barberservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.stereotype.Service;
import ua.knu.barberservice.domain.BarberModel;
import ua.knu.barberservice.domain.BookEntity;
import ua.knu.barberservice.repository.BarberRepository;
import ua.knu.barberservice.repository.BookRepository;
import ua.knu.barberservice.repository.DayRepository;
import ua.knu.barberservice.repository.PlaceRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BarberService {

  private final BarberRepository repository;
  private final DayRepository dayRepository;
  private final BookRepository bookRepository;
  private final PlaceRepository placeRepository;

  public List<BarberModel> getByPlace(String address) {
    final var place = placeRepository.findByAddress(address);
    return repository.findAllByPlaceId(place.getId())
        .stream()
        .map(barberEntity ->
            BarberModel.builder()
                .name(barberEntity.getBarberName())
                .cost(barberEntity.getCost())
                .rating(barberEntity.getRating())
                .build())
        .toList();
  }


  public List<BarberModel> getAvailable(Integer startTime, Integer endTime, Date date) {
    final var day = dayRepository.findByDate(date);
    return repository.findAll()
        .stream()
        .filter(barberEntity -> barberEntity.getDays()
            .stream()
            .anyMatch(dayEntity -> DateUtils.isSameDay(dayEntity.getDate(), date))
        )
        .filter(barberEntity -> {
          final var times = new ArrayList<Integer>();
          for (int i = startTime; i <= endTime; i++) {
            times.add(i);
          }
          final var bookTimes = bookRepository.findAllByBarberId(barberEntity.getId())
              .stream()
              .filter(bookEntity -> bookEntity.getDayId().equals(day.getId()))
              .map(BookEntity::getTimeId)
              .toList();

          times.removeAll(bookTimes);
          return !times.isEmpty();
        })
        .map(barberEntity ->
            BarberModel.builder()
                .name(barberEntity.getBarberName())
                .cost(barberEntity.getCost())
                .rating(barberEntity.getRating())
                .build())
        .toList();
  }

  public List<Integer> getAvailableTime(String barberName, Date date) {
    final var day = dayRepository.findByDate(date);

    final var barber = repository.findAllByBarberName(barberName).stream()
        .filter(barberEntity -> barberEntity.getDays()
            .stream()
            .anyMatch(dayEntity -> DateUtils.isSameDay(dayEntity.getDate(), date))
        ).findFirst().orElseThrow();

    final var times = new ArrayList<Integer>();
    for (int i = 0; i <= 23; i++) {
      times.add(i);
    }

    final var bookTimes = bookRepository.findAllByBarberId(barber.getId())
        .stream()
        .filter(bookEntity -> bookEntity.getDayId().equals(day.getId()))
        .map(BookEntity::getTimeId)
        .toList();

    times.removeAll(bookTimes);
    return times;
  }
}
