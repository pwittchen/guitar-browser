package com.pwittchen.guitar.browser;

import com.pwittchen.guitar.browser.data.GuitarsDataProvider;
import com.pwittchen.guitar.browser.data.GuitarsProvider;
import com.pwittchen.guitar.browser.model.Guitar;
import com.pwittchen.guitar.browser.model.GuitarType;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import rx.functions.Action1;
import rx.observables.BlockingObservable;

import static com.google.common.truth.Truth.assertThat;

public class GuitarsDataProviderTest {

  private GuitarsProvider provider;

  @Before public void setUp() {
    provider = new GuitarsDataProvider();
  }

  @Test public void testShouldReturnLimitedGuitars() {
    // given
    final int limit = 2;
    final GuitarType type = GuitarType.ELECTRIC;
    final List<Guitar> guitars = new ArrayList<>();

    // when
    BlockingObservable<Guitar> observable = provider.observeGuitars(type, limit).toBlocking();
    observable.forEach(new Action1<Guitar>() {
      @Override public void call(Guitar guitar) {
        guitars.add(guitar);
      }
    });

    // then
    assertThat(guitars.size()).isEqualTo(limit);
  }

  @Test public void testShouldReturnGuitarsOfGivenType() {
    // given
    final int limit = 3;
    final GuitarType type = GuitarType.ACOUSTIC;

    // when
    BlockingObservable<Guitar> observable = provider.observeGuitars(type, limit).toBlocking();

    // then
    observable.forEach(new Action1<Guitar>() {
      @Override public void call(Guitar guitar) {
        assertThat(guitar.type).isEqualTo(type);
      }
    });
  }
}
