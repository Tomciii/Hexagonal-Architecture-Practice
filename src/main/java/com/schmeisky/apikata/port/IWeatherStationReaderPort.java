package com.schmeisky.apikata.port;

import com.schmeisky.apikata.dto.WeatherStationResult;

public interface IWeatherStationReaderPort {
    WeatherStationResult read();
}
