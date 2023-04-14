package com.schmeisky.apikata.port;

import com.schmeisky.apikata.dto.WeatherStationResultListDTO;

import java.util.Map;

public interface IWeatherStationWriterPort {
    void write(WeatherStationResultListDTO result, Map<String, String> options);

}
