package tn.esprit.ms_event.Util;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WeatherResponse {
    private List<WeatherInfo> weather;
    private MainInfo main;
}
