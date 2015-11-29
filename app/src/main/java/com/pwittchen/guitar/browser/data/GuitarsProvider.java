package com.pwittchen.guitar.browser.data;

import com.pwittchen.guitar.browser.model.Guitar;
import java.util.List;
import rx.Observable;

public interface GuitarsProvider {
  List<Guitar> getGuitars();

  Observable<List<Guitar>> observeGuitars();
}
