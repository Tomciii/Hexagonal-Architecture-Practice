package com.schmeisky.apikata.adapter;

import com.schmeisky.apikata.dto.WeatherStationResultDTO;
import com.schmeisky.apikata.dto.WeatherStationResultListDTO;
import com.schmeisky.apikata.port.IWeatherStationWriterPort;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WeatherStationWriterAdapter implements IWeatherStationWriterPort {

    @Override
    public void write(WeatherStationResultListDTO result, Map<String, String> options) {
        File file = new File(options.get("pathname"));
        try(FileWriter writer = new FileWriter(file)) {
            file.createNewFile();
            writer.write("id,name,date,time,temperature,pressure,wind_direction\n");

            for (WeatherStationResultDTO dto : result.getResultDTOList()){

                String line = String.format("%s,%s,%s,%s,%s,%s,%s",
                        dto.getId(),
                        dto.getName(),
                        dto.getDate(),
                        dto.getTime(),
                        dto.getTemperature(),
                        dto.getPressure(),
                        dto.getWind_direction());

                writer.write(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
