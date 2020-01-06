package rest;

import DTO.DTOPost;
import Interfaces.IMyLogger;
import Interfaces.PostRequests;
import com.google.gson.Gson;
import okhttp3.*;

import java.io.IOException;

public class PostList implements PostRequests {
    private OkHttpClient httpClient;
    private Gson gson;
    private IMyLogger myLogger;

    public PostList(IMyLogger myLogger) {
        this.httpClient = new OkHttpClient();
        this.gson = new Gson();
        this.myLogger = myLogger;
    }

    public PostList(OkHttpClient httpClient, Gson gson, IMyLogger myLogger) {
        this.httpClient = httpClient;
        this.gson = gson;
        this.myLogger = myLogger;
    }


    public boolean validateBowlingSum(String token, int[] result, String urlStr) {
        RequestBody formBody = new FormBody.Builder()
                .add("token", token)
                .add("points", convertToJson(result))
                .build();


        Request request = new Request.Builder()
                .url(urlStr)
                .addHeader("User-Agent", "OkHttp Bot")
                .post(formBody)
                .build();

        try {
            Response response = httpClient.newCall(request).execute();
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            String json = response.body().string();
            myLogger.writeToLogFile("POST: " + json);

            DTOPost dtoPost = convertFromJson(json);
            return dtoPost.getSuccess();

        }catch (Exception e){
            e.printStackTrace();
        }
        //TODO
        return false;
    }

    private DTOPost convertFromJson(String json){
        return gson.fromJson(json, DTOPost.class);
    }

    private String convertToJson(int[] result){
        return gson.toJson(result);
    }


}
