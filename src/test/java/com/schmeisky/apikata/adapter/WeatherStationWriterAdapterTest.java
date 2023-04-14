package com.schmeisky.apikata.adapter;

import com.schmeisky.apikata.dto.WeatherStationResultDTO;
import com.schmeisky.apikata.dto.WeatherStationResultListDTO;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.function.BooleanSupplier;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class WeatherStationWriterAdapterTest {

    private WeatherStationWriterAdapter adapter;
    private String testPath = "\\testCSV.csv";

    @Test
    void assertFileWasWritten(@TempDir Path tempDir) {
        adapter = new WeatherStationWriterAdapter();
        WeatherStationResultListDTO givenDTO = getGivenResultListDTO();
        Map<String, String> options = new HashMap<>();
        options.put("pathname",tempDir.toString().concat(testPath));

        adapter.write(givenDTO, options);

        File file = new File(tempDir.toString().concat(testPath));
        boolean expected = file.exists();

        Assertions.assertTrue(expected);
    }

    @Test
    void assertHashCode(@TempDir Path tempDir) {
        try {
        adapter = new WeatherStationWriterAdapter();
        WeatherStationResultListDTO givenDTO = getGivenResultListDTO();
        Map<String, String> options = new HashMap<>();
        options.put("pathname",tempDir.toString().concat(testPath));

        adapter.write(givenDTO, options);

        File actualFile = new File(tempDir.toString().concat(testPath));
        URL resource = getClass().getClassLoader().getResource("testCSV.csv");
        File expectedFile = null;

            expectedFile = new File(resource.toURI());

            Assertions.assertEquals(FileUtils.readFileToString(actualFile, StandardCharsets.UTF_8), FileUtils.readFileToString(expectedFile, StandardCharsets.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private WeatherStationResultListDTO getGivenResultListDTO(){
        WeatherStationResultListDTO result = new WeatherStationResultListDTO();

        WeatherStationResultDTO dto = new WeatherStationResultDTO();
        dto.setId("1");
        dto.setWind_direction("testWindDirection");
        dto.setDate("testDate");
        dto.setTemperature("testTemp");
        dto.setName("testName");
        dto.setTime("testTime");
        dto.setPressure("testPressure");

        List<WeatherStationResultDTO> dtoList = new ArrayList<>();
        dtoList.add(dto);

        result.setResultDTOList(dtoList);

        return result;
    }
}