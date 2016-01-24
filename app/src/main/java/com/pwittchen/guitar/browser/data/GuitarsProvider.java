package com.pwittchen.guitar.browser.data;

import com.pwittchen.guitar.browser.model.Guitar;
import com.pwittchen.guitar.browser.model.GuitarType;
import java.util.List;
import rx.Observable;
import rx.Subscription;

public interface GuitarsProvider {
  List<Guitar> getGuitars();

  Observable<List<Guitar>> observeGuitars();

  Observable<Guitar> observeGuitars(final GuitarType guitarType, final int guitarLimit);
}
