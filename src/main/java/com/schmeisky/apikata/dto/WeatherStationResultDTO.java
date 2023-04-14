package com.schmeisky.apikata.dto;

public class WeatherStationResultDTO {

   private String id;
   private String name;
   private String date;
   private String time;
   private String temperature;
   private String pressure;

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getDate() {
      return date;
   }

   public void setDate(String date) {
      this.date = date;
   }

   public String getTime() {
      return time;
   }

   public void setTime(String time) {
      this.time = time;
   }

   public String getTemperature() {
      return temperature;
   }

   public void setTemperature(String temperature) {
      this.temperature = temperature;
   }

   public String getPressure() {
      return pressure;
   }

   public void setPressure(String pressure) {
      this.pressure = pressure;
   }

   public String getWind_direction() {
      return wind_direction;
   }

   public void setWind_direction(String wind_direction) {
      this.wind_direction = wind_direction;
   }

   private String wind_direction;
}
