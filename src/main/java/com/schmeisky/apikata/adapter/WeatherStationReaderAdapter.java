package com.schmeisky.apikata.adapter;

import com.google.gson.Gson;
import com.schmeisky.apikata.dto.WeatherStationResult;
import com.schmeisky.apikata.port.IWeatherStationReaderPort;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

public class WeatherStationReaderAdapter implements IWeatherStationReaderPort {
    @Override
    public WeatherStationResult read() {

        final WeatherStationResult result;
        try {
            final URL url = new URL("https://apis.is/weather/observations/en?stations=1");
            try(InputStream inputStream = url.openStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            ) {
                final Gson gson = new Gson();
                String fetchedJson = getJsonString(inputStreamReader);
                result = gson.fromJson(fetchedJson, WeatherStationResult.class);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("unable to parse URL", e);
        } catch (IOException e) {
            throw new RuntimeException("unable to readData", e);
        }

        return result;
    }

    private static String getJsonString(InputStreamReader reader) throws IOException {
        StringBuilder fetchedJson = new StringBuilder();

        int c = 0;
        while ((c = reader.read()) != -1 ){
            fetchedJson.append((char) c);
        }

        String json = fetchedJson.toString();
        return json;
    }
}
