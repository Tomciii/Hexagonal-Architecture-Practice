package com.schmeisky.apikata;


import com.schmeisky.apikata.adapter.WeatherStationReaderAdapter;
import com.schmeisky.apikata.adapter.WeatherStationWriterAdapter;
import com.schmeisky.apikata.application.WeatherStationApplication;

public class APIAccess {

    public static void main(final String[] args) {
        WeatherStationApplication application = new WeatherStationApplication(
                new WeatherStationReaderAdapter(),
                new WeatherStationWriterAdapter());

    application.start();
    }



}
