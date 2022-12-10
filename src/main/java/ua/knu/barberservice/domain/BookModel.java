package ua.knu.barberservice.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.util.Date;

@Value
@Data
@Builder(toBuilder = true)
public class BookModel {

  Long userId;
  String barberName;
  Date date;
  Integer time;
}
