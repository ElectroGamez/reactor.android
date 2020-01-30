package nl.hedium.reactor;

import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MessagingService extends FirebaseMessagingService {

    private static final String TAG = "MessageService";

    @Override
    public void onNewToken(String token) {
        Log.d(TAG, "Refreshed token: " + token);

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        Log.e(TAG, token);
    }

    @Override
    public void onMessageReceived(RemoteMessage message) {
        Log.e(TAG, message.toString());
    }

    public void logToken() {

    FirebaseInstanceId.getInstance().getInstanceId()
            .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                @Override
                public void onComplete(@NonNull Task<InstanceIdResult> task) {
                    if (!task.isSuccessful()) {
                        return;
                    }

                    // Get new Instance ID token
                    String token = task.getResult().getToken();
                    //return the result to an other tread? or call it from there.
                    TextView myAwesomeTextView = MainActivity.app.findViewById(R.id.idField);
                    myAwesomeTextView.setText(token);
                }
            });
    }
}
