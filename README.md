Guitar Browser
==============

### This branch has empty implementation of 2 methods

- `MainActivity.createGuitarsSubscription(guitarType, guitarLimit)`
- `GuitarsDataProvider.observeGuitars(guitarType, guitarLimit)`

Simple Android app prepared as an examplary usage of RxJava and RxAndroid for "Reactive Live Coding" presentation shown during [GDG DevFest](http://devfest.pl) 2015 in Warsaw, Poland.

The most interesting part of the code can be found in [MainActivity](https://github.com/pwittchen/guitar-browser/blob/master/app/src/main/java/com/pwittchen/guitar/browser/ui/MainActivity.java) class.

**Slides from the presentation** are available at: https://speakerdeck.com/pwittchen/reactive-live-coding

Building and running the project
--------------------------------

You can open, build and run the project in Android Studio/IntelliJ IDEA or with Gradle Wrapper from command line:

```
./gradlew build run
```

Tests
-----

You can execute unit tests with the following command:

```
./gradlew test
```
