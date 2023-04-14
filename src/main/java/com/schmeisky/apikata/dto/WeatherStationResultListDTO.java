package com.schmeisky.apikata.dto;

import java.util.List;

public class WeatherStationResultListDTO {

    private List<WeatherStationResultDTO> resultDTOList;

    public List<WeatherStationResultDTO> getResultDTOList() {
        return resultDTOList;
    }

    public void setResultDTOList(List<WeatherStationResultDTO> resultDTOList) {
        this.resultDTOList = resultDTOList;
    }
}
