package pom.tryeventbus;

import android.app.Application;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Roy.Leung on 10/1/17.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        EventBus.builder().addIndex(new MyEventBusIndex()).installDefaultEventBus();
    }
}
