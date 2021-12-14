package com.example.groupproject5;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class MakeupDataHandler {

    public static class DataHandler {
        private HttpClient dataGrabber;
        private String webLocation;

        public DataHandler(String siteToSearch){
            dataGrabber = HttpClient.newHttpClient();
            webLocation = siteToSearch;
        }

        public MakeupDataType[] getData(){
            var requestBuilder = HttpRequest.newBuilder();
            var ourURI = URI.create(webLocation);
            var dataRequest = requestBuilder.uri(ourURI).build();
            HttpResponse<String> response = null;
            try {
                response = dataGrabber.send(dataRequest, HttpResponse.BodyHandlers.ofString());
            }catch (IOException e){
                System.out.println("Error with connecting to Server");
            }
            catch (InterruptedException exception){
                System.out.println("Lost connection to server");
            }
            if(response == null){
                System.out.println("Unable to get data from network ... giving up");
                System.exit(-1);
            }
            var responseBody = response.body();
            var jsonParser = new Gson();
            var UnivData = jsonParser.fromJson(responseBody, MakeupDataType[].class);
            return UnivData;
        }

        class MakeupDataType{
            String alpha_two_code;
            ArrayList<String> web_pages;
            String name;
            String brand;
            String description;
            ArrayList<String> price;

            @Override
            public String toString(){
                return name;
            }
        }
    }
}
