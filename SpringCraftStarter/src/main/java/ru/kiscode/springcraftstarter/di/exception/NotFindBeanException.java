package ru.kiscode.springcraftstarter.di.exception;

public class NotFindBeanException extends RuntimeException {
  public NotFindBeanException(String message) {
    super(message);
  }
}
