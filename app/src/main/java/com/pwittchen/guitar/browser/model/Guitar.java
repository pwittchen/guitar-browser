package com.pwittchen.guitar.browser.model;

public class Guitar {
  private static final String SPACE = " ";
  public final String name;
  public final GuitarProducer producer;
  public final GuitarType type;
  public final int priceInPln;

  private Guitar(String name, GuitarProducer producer, GuitarType type, int priceInPln) {
    this.name = name;
    this.producer = producer;
    this.type = type;
    this.priceInPln = priceInPln;
  }

  public static Guitar create(String name, GuitarProducer producer, GuitarType type,
      int priceInPln) {
    return new Guitar(name, producer, type, priceInPln);
  }

  @Override public String toString() {
    return new StringBuilder().append(producer)
        .append(SPACE)
        .append(name)
        .append(SPACE)
        .append(type)
        .toString();
  }
}
