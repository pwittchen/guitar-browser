package com.pwittchen.guitar.browser.model;

public enum GuitarProducer {
  ADMIRA("Admira"),
  FENDER("Fender"),
  TANGLEWOOD("Tanglewood"),
  BREEDLOVE("Breedlove"),
  FRAMUS("Framus"),
  CORDOBA("Cordoba"),
  YAMAHA("Yamaha"),
  LAG("LAG"),
  IBANEZ("Ibanez"),
  WASHBURN("Washburn"),
  EPIPHONE("Epiphone"),
  CHATEAU("Chateau"),
  GIBSON("Gibson");

  private final String name;

  GuitarProducer(String name) {
    this.name = name;
  }

  @Override public String toString() {
    return name;
  }
}
