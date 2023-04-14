package com.schmeisky.apikata.application;

import com.schmeisky.apikata.application.converter.WeatherStationResultConverter;
import com.schmeisky.apikata.dto.WeatherStationResult;
import com.schmeisky.apikata.port.IWeatherStationReaderPort;
import com.schmeisky.apikata.port.IWeatherStationWriterPort;

import java.util.HashMap;
import java.util.Map;

public class WeatherStationApplication {

    private IWeatherStationReaderPort reader;
    private IWeatherStationWriterPort writer;

    public WeatherStationApplication(IWeatherStationReaderPort reader, IWeatherStationWriterPort writer){
        this.reader = reader;
        this.writer = writer;
    }

    public void start(){
        WeatherStationResult result = reader.read();

        Map<String, String> options = new HashMap<>();
        options.put("pathname","getWeatherResults.csv");

        writer.write(WeatherStationResultConverter.convert(result), options);
    }
}
