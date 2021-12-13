package com.example.groupproject5;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GameOfThronesDataHandler {
    private HttpClient dataGrabber;
    private String webLocation;

    public GameOfThronesDataHandler(String siteToSearch){
        dataGrabber = HttpClient.newHttpClient();
        webLocation = siteToSearch;
    }

    public BookDataType[] getData(){
        var requestBuilder = HttpRequest.newBuilder();
        var dataRequest = requestBuilder.uri(URI.create(webLocation)).build();
        HttpResponse<String> response = null;
        try{
            response = dataGrabber.send(dataRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            System.out.println("Error Connecting to Network or Site");
        } catch (InterruptedException exception) {
            System.out.println("Lost Connection to Network or Site");
        }
        if (response == null){
            System.out.println("Unable to get Data From Network....Giving Up");
            System.exit(-1);
        }
        var responseBody = response.body();
        var jsonParser = new Gson();
        var BookData = jsonParser.fromJson(responseBody, BookDataType[].class);
        return BookData;
    }

    class BookDataType{
        String name;
        String isbn;
        Integer numberOfPages;

        @Override
        public String toString(){
            return name;
        }
    }
}
