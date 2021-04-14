package fcmnativetest;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import java.io.IOException;

public class Application {

    private static final String DEVICETOKEN = System.getenv("FCM_DEVICETOKEN");

    public static void main(String[] args) throws FirebaseMessagingException, IOException {
        FirebaseOptions opts = FirebaseOptions.builder()
            .setProjectId("my-kubernetes-codelab-217414")
            .setCredentials(GoogleCredentials.getApplicationDefault())
            .build();

        System.out.println("Initializing FirebaseApp");
        FirebaseApp app = FirebaseApp.initializeApp(opts);
        System.out.println("FirebaseApp initialized");

        Message message = Message.builder()
                .setToken(DEVICETOKEN)
                .putData("body", "This is a test message")
                .build();

        System.out.println("Sending message");
        FirebaseMessaging.getInstance(app).send(message);
        System.out.println("Message sent");
    }
}
