package lk.dinuka.ibmtexttospeech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import com.ibm.cloud.sdk.core.http.HttpMediaType;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.developer_cloud.android.library.audio.StreamPlayer;
import com.ibm.watson.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.text_to_speech.v1.model.SynthesizeOptions;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {
    private StreamPlayer player = new StreamPlayer();
    private TextToSpeech textService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textService = initTextToSpeechService();
    }

    public void buttonClick(View view) {
        Calendar cal = new GregorianCalendar();
        int hours = cal.get(Calendar.HOUR_OF_DAY);
        int minutes = cal.get(Calendar.MINUTE);

        String prefix = "";

        if (minutes < 9 && minutes >= 1) {
            prefix = " O ";
        }

        String suffix = " am ";
        if (hours > 12) {
            hours = hours - 12;
            suffix = " pm ";
        }

        new SynthesisTask().execute("Hello world. Good morning my friend. " +
                "How is the weather today? The time is " + +hours + " " + prefix + minutes + suffix);
    }


    private TextToSpeech initTextToSpeechService() {
        Authenticator authenticator = new IamAuthenticator("fV_5OUIol2WXx_pXQ2oG9-PWJFsbBr2I6tiDKOrWUB7k");
        TextToSpeech service = new TextToSpeech(authenticator);
        service.setServiceUrl("https://api.us-south.text-to-speech.watson.cloud.ibm.com/instances/2aa0807f-fff7-4ea6-a9aa-5828fa2f2020");
        return service;
    }


    private class SynthesisTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            SynthesizeOptions synthesizeOptions = new SynthesizeOptions.Builder()
                    .text(params[0])
                    .voice(SynthesizeOptions.Voice.EN_US_LISAVOICE)
                    .accept(HttpMediaType.AUDIO_WAV)
                    .build();
            player.playStream(textService.synthesize(synthesizeOptions).execute().getResult());

            return "Did synthesize";
        }
    }
}
