package com.pwittchen.guitar.browser.ui;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.pwittchen.guitar.browser.R;
import com.pwittchen.guitar.browser.data.GuitarsDataProvider;
import com.pwittchen.guitar.browser.data.GuitarsProvider;
import com.pwittchen.guitar.browser.model.Guitar;
import com.pwittchen.guitar.browser.model.GuitarType;
import java.util.ArrayList;
import java.util.List;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
  private static final GuitarType GUITAR_TYPE = GuitarType.ACOUSTIC;
  private static final int GUITAR_LIMIT = 3;

  private List<String> listOfGuitars = new ArrayList<>();
  private GuitarsProvider guitarsProvider;
  private Subscription guitarsSubscription;

  @InjectView(R.id.container) public RelativeLayout relativeLayoutContainer;
  @InjectView(R.id.toolbar) public Toolbar toolbar;
  @InjectView(R.id.list_view_guitars) public ListView listViewGuitars;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.inject(this);
    setSupportActionBar(toolbar);

    guitarsProvider = new GuitarsDataProvider();
  }

  @Override protected void onResume() {
    super.onResume();
    listOfGuitars.clear();
    guitarsSubscription = createGuitarsSubscription(GUITAR_TYPE, GUITAR_LIMIT);
  }

  private Subscription createGuitarsSubscription(final GuitarType guitarType, int guitarLimit) {
    return null; //TODO: implement
  }

  private void loadStringsToListView(List<String> list) {
    int itemResourceId = android.R.layout.simple_list_item_1;
    listViewGuitars.setAdapter(new ArrayAdapter<>(this, itemResourceId, list));
  }

  @Override protected void onPause() {
    super.onPause();
    safelyUnsubscribe(guitarsSubscription);
  }

  private void safelyUnsubscribe(Subscription subscription) {
    if (subscription != null && !subscription.isUnsubscribed()) {
      guitarsSubscription.unsubscribe();
    }
  }
}
