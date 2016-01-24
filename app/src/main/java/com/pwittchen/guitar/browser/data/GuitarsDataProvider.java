package com.pwittchen.guitar.browser.data;

import com.pwittchen.guitar.browser.model.Guitar;
import com.pwittchen.guitar.browser.model.GuitarProducer;
import com.pwittchen.guitar.browser.model.GuitarType;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class GuitarsDataProvider implements GuitarsProvider {
  @Override public List<Guitar> getGuitars() {
    return new ArrayList<Guitar>() {{
      add(Guitar.create("55 F CE Thinbody", GuitarProducer.CORDOBA, GuitarType.CLASSIC, 5199));
      add(Guitar.create("C 10 SP", GuitarProducer.CORDOBA, GuitarType.CLASSIC, 4499));
      add(Guitar.create("ESC 105", GuitarProducer.FENDER, GuitarType.CLASSIC, 465));
      add(Guitar.create("T9C", GuitarProducer.CHATEAU, GuitarType.CLASSIC, 449));
      add(Guitar.create("Sara", GuitarProducer.ADMIRA, GuitarType.CLASSIC, 375));
      add(Guitar.create("C 30 M II", GuitarProducer.YAMAHA, GuitarType.CLASSIC, 415));
      add(Guitar.create("Acero D10", GuitarProducer.CORDOBA, GuitarType.ACOUSTIC, 2999));
      add(Guitar.create("TW 15 H", GuitarProducer.TANGLEWOOD, GuitarType.ACOUSTIC, 2249));
      add(Guitar.create("Passport D200 SB", GuitarProducer.BREEDLOVE, GuitarType.ACOUSTIC, 1799));
      add(Guitar.create("Passport Plus D200 SB", GuitarProducer.YAMAHA, GuitarType.ACOUSTIC, 699));
      add(Guitar.create("CD 60", GuitarProducer.FENDER, GuitarType.ACOUSTIC, 589));
      add(Guitar.create("OG 1 N 3/4", GuitarProducer.WASHBURN, GuitarType.ACOUSTIC, 399));
      add(Guitar.create("PRO 1 EB", GuitarProducer.EPIPHONE, GuitarType.ACOUSTIC, 389));
      add(Guitar.create("CF 60", GuitarProducer.FENDER, GuitarType.ACOUSTIC, 589));
      add(Guitar.create("T66 A", GuitarProducer.LAG, GuitarType.ACOUSTIC, 589));
      add(Guitar.create("Mark II Synergy", GuitarProducer.BREEDLOVE, GuitarType.ELECTRIC, 12999));
      add(Guitar.create("JEM 7 V WH", GuitarProducer.IBANEZ, GuitarType.ELECTRIC, 11306));
      add(Guitar.create("TC 2", GuitarProducer.CHATEAU, GuitarType.ELECTRIC, 569));
      add(Guitar.create("ST 1", GuitarProducer.CHATEAU, GuitarType.ELECTRIC, 329));
      add(Guitar.create("0A CE FN", GuitarProducer.WASHBURN, GuitarType.ELECTRO_ACOUSTIC, 535));
    }};
  }

  @Override public Observable<List<Guitar>> observeGuitars() {
    return Observable.just(getGuitars());
    // return Observable.error(new RuntimeException("Ooops!"));
    // uncomment line above, and comment first line to simulate error in Observable
  }

  @Override public Observable<Guitar> observeGuitars(final GuitarType type, final int limit) {
    return observeGuitars().flatMap(new Func1<List<Guitar>, Observable<Guitar>>() {
      @Override public Observable<Guitar> call(List<Guitar> guitars) {
        return Observable.from(guitars);
      }
    }).filter(new Func1<Guitar, Boolean>() {
      @Override public Boolean call(Guitar guitar) {
        return guitar.type == type;
      }
    }).limit(limit);
  }
}
