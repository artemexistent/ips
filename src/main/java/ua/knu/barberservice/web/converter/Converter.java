package ua.knu.barberservice.web.converter;

public interface Converter<D, M> {
  M toModel(D dto);
  D toDto(M model);
}
