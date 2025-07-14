package com.zenzy.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GoogleMapsService {
    private static final String GOOGLE_MAPS_API_KEY = "YOUR_API_KEY";

    public String getCoordinates(String address) {
        String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + address + "&key=" + GOOGLE_MAPS_API_KEY;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }
}
