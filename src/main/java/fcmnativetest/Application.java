package fcmnativetest;

import com.google.firebase.FirebaseApp;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;

public class Application {

    private static final String DEVICETOKEN = System.getenv("FCM_DEVICETOKEN");

    public static void main(String[] args) throws FirebaseMessagingException {
        System.out.println("Initializing FirebaseApp");
        FirebaseApp app = FirebaseApp.initializeApp();
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
