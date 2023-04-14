package com.schmeisky.apikata.application.converter;

import com.schmeisky.apikata.dto.WeatherStationResult;
import com.schmeisky.apikata.dto.WeatherStationResultDTO;
import com.schmeisky.apikata.dto.WeatherStationResultListDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WeatherStationResultConverter {

    public static WeatherStationResultListDTO convert(WeatherStationResult result){

        WeatherStationResultListDTO dto = new WeatherStationResultListDTO();

        List<WeatherStationResultDTO> list = new ArrayList<>();

        for(Map<String, Object> map : result.getResults()){
            WeatherStationResultDTO dto1 = new WeatherStationResultDTO();

            dto1.setId(map.get("id").toString());
            dto1.setName(map.get("name").toString());
            dto1.setTemperature(map.get("T").toString());
            dto1.setPressure(map.get("P").toString());
            dto1.setWind_direction(map.get("D").toString());
            dto1.setDate(map.get("time").toString().split(" ")[0]);
            dto1.setTime(map.get("time").toString().split(" ")[1]);

            list.add(dto1);
        }

        dto.setResultDTOList(list);

        return dto;
    }

}
