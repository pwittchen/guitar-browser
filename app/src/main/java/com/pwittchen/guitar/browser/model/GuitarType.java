package com.pwittchen.guitar.browser.model;

public enum GuitarType {
  CLASSIC("classic"),
  ACOUSTIC("acoustic"),
  ELECTRIC("electric"),
  ELECTRO_ACOUSTIC("electro-acoustic"),
  BASS("bass"),
  BASS_ELECTRO_ACOUSTIC("bass electro-acoustic");

  private final String name;

  GuitarType(String name) {
    this.name = name;
  }

  @Override public String toString() {
    return name;
  }
}
