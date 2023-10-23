package tn.esprit.ms_event.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tn.esprit.ms_event.Entities.Weather;
import tn.esprit.ms_event.Util.WeatherResponse;

@Service
public class WeatherService {
    private final RestTemplate restTemplate;

    @Value("${openweathermap.api.key}")
    private String apiKey;

    @Autowired
    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Weather getWeatherByCityName(String cityName) {
        String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=" + apiKey;

        ResponseEntity<WeatherResponse> response = restTemplate.getForEntity(apiUrl, WeatherResponse.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            WeatherResponse weatherResponse = response.getBody();
            Weather weather = new Weather();
            weather.setCityName(cityName);
            weather.setDescription(weatherResponse.getWeather().get(0).getDescription());
            weather.setTemperature(weatherResponse.getMain().getTemp());
            return weather;
        }

        return null;
    }
}


