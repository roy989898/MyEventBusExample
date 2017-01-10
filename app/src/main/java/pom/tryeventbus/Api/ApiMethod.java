package pom.tryeventbus.Api;

import android.content.Context;
import android.content.Intent;

import pom.tryeventbus.Services.GetLatestForeignExchangeService;

/**
 * Created by Roy.Leung on 10/1/17.
 */

public class ApiMethod {
    static public void getLatestForeignExchange(Context mContext) {
        Intent intent = new Intent(mContext, GetLatestForeignExchangeService.class);
        mContext.startService(intent);
    }
}
