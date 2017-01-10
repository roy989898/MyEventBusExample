package pom.tryeventbus.Api;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Roy.Leung on 10/1/17.
 */

public class ApiManager {

    public static String getLatestForeignExchange() throws IOException {

        OkHttpClient client = new OkHttpClient();

        String url = "http://api.fixer.io/latest";
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();

        return response.body().string();


    }
}
