package com.example.groupproject5;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;

public class ChuckNorrisDataHandler {
    private HttpClient dataGrabber;

    public ChuckNorrisDataHandler(){

    }
    public String loadJoke(String jokeCategory){

        var site =  "https://api.chucknorris.io/jokes/random?category="+jokeCategory;
        var builder = HttpRequest.newBuilder();
        var jokeURI = URI.create(site);
        var jokeRequest = builder.uri(jokeURI).build();
        HttpResponse<String> response = null;
        try {
            response = dataGrabber.send(jokeRequest,HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            System.out.println("Did not gain connection to the site");
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println("Connection to the site timed out");
            e.printStackTrace();
        }
        if (response  == null){
            System.out.println("joke data not retrieved");
            System.exit(-1);
        }
        var responseBody = response.body();
        var jsonReader = new Gson();
        var jokeData = jsonReader.fromJson(responseBody,jokeDataType[].class);
        return Arrays.toString(jokeData);


    }
    class jokeDataType{
        ArrayList<String> categories;
        String created_at;
        String icon_url;
        String id;
        String url;
        String value;

        @Override
        public String toString(){
            return value;
        }
    }

}
