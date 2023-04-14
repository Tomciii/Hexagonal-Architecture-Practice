package com.schmeisky.apikata.dto;

import java.util.List;
import java.util.Map;

public class WeatherStationResult {

        List<Map<String, Object>> results;

        public WeatherStationResult(final List<Map<String, Object>> results) {
            this.results = results;
        }

        public List<Map<String, Object>> getResults() {
            return results;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "results=" + results +
                    '}';
        }

}
