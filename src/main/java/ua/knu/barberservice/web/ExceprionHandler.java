package ua.knu.barberservice.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

@ControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class ExceprionHandler {

  @ExceptionHandler(value = NoSuchElementException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public void handle1(NoSuchElementException e){
  }

}
