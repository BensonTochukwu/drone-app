//package com.drone.app.services;
//
//import com.drone.app.models.LocationDto;
//import com.drone.app.repo.LocationRepo;
//import lombok.RequiredArgsConstructor;
//
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//@RequiredArgsConstructor
//public class TrackingService {
//
//    private LocationRepo locationRepo;
//
//    public static void sendLocation(LocationDto locationDto) throws Exception {
//        URL url = new URL("http//:droneTrackingLocation/api/v1");
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        conn.setRequestMethod("POST");
//        conn.setRequestMethod("Content-Type");
//        conn.setDoOutput(true);
//
//
//    }
//}
