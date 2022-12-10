package ua.knu.barberservice.web;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.knu.barberservice.service.BarberService;
import ua.knu.barberservice.web.converter.BarberConverter;
import ua.knu.barberservice.web.model.BarberDto;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BarberController {

  private final BarberConverter converter;
  private final BarberService service;

  @GetMapping("/barber/find")
  List<BarberDto> getByPlace(@RequestParam String address) {
    return service.getByPlace(address)
        .stream()
        .map(converter::toDto)
        .toList();
  }

  @GetMapping("/barber")
  List<BarberDto> getAvailable(@RequestParam(defaultValue = "0") Integer startTime,
                               @RequestParam(defaultValue = "23") Integer endTime,
                               @RequestParam
                               @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
    return service.getAvailable(startTime, endTime, date)
        .stream()
        .map(converter::toDto)
        .toList();
  }

  @GetMapping("/barber/{barberName}")
  List<Integer> getAvailableTime(@PathVariable String barberName,
                                 @RequestParam
                                 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
    return service.getAvailableTime(barberName, date);
  }
}
