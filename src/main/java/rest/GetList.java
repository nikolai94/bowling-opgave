package rest;

import DTO.DTOGet;
import Interfaces.GetRequests;
import Interfaces.IMyLogger;
import com.google.gson.Gson;
import entities.Frame;
import entities.Game;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class GetList implements GetRequests {
    private OkHttpClient httpClient;
    private Gson gson;
    private IMyLogger myLogger;

    public GetList(IMyLogger myLogger) {
        this.httpClient = new OkHttpClient();
        this.gson = new Gson();
        this.myLogger = myLogger;
    }

    public GetList(OkHttpClient httpClient, Gson gson, IMyLogger myLogger) {
        this.httpClient = httpClient;
        this.gson = gson;
        this.myLogger = myLogger;
    }

    public Game GetBowlingPointsList(String urlStr) {
        Request request = new Request.Builder()
                .url(urlStr)
                .build();
        try{
            Response response = httpClient.newCall(request).execute();
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            String json = response.body().string();
            myLogger.writeToLogFile("GET: " + json);

            return convertFromJson(json);

        }catch (Exception e){
            e.printStackTrace();
        }
        //TODO
        return null;
    }


    private Game convertFromJson(String json){
        DTOGet dtoGet = gson.fromJson(json, DTOGet.class);

        String token = dtoGet.getToken();
        Frame[] frames;

        int[][] arr = dtoGet.getPoints();
        frames = new Frame[arr.length];

        for(int i = 0; i < arr.length; i++){
            frames[i] = new Frame(arr[i][0], arr[i][1]);
        }

        return new Game(token, frames);

    }
}
