package pom.tryeventbus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import pom.tryeventbus.Api.ApiMethod;
import pom.tryeventbus.EventBusMessage.LatestForeignExchangeMessage;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btGet)
    Button btGet;
    @BindView(R.id.textView)
    TextView textView;
    private Unbinder unBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unBinder = ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        if (unBinder != null) unBinder.unbind();
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceiveLatestForeignExchange(LatestForeignExchangeMessage message) {
        textView.setText(message.message);

    }

    @OnClick(R.id.btGet)
    public void onClick() {
        ApiMethod.getLatestForeignExchange(this);
    }
}
