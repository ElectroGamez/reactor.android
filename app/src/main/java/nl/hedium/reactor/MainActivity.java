package nl.hedium.reactor;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static AppCompatActivity app;

    String TAG = "MainActive";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        app = this;

        MessagingService messagingService = new MessagingService();
        messagingService.logToken();
    }
}
