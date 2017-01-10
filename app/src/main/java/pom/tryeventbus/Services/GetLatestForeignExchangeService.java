package pom.tryeventbus.Services;

import android.app.IntentService;
import android.content.Intent;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;

import pom.tryeventbus.Api.ApiManager;
import pom.tryeventbus.EventBusMessage.LatestForeignExchangeMessage;


public class GetLatestForeignExchangeService extends IntentService {

    public GetLatestForeignExchangeService() {
        super("GetLatestForeignExchangeService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        try {
            String returnJsonString = ApiManager.getLatestForeignExchange();
            EventBus.getDefault().post(new LatestForeignExchangeMessage(returnJsonString));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
