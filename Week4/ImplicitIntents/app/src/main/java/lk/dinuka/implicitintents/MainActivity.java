package lk.dinuka.implicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mWebsiteEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebsiteEditText = findViewById(R.id.website_edittext);
    }

    public void openWebsite(View view) {
        String url = mWebsiteEditText.getText().toString();

        Uri webpage = Uri.parse(url);           // parsing the string into a Uri object
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        if (intent.resolveActivity(getPackageManager()) != null){       // asking the Android Package Manager to find an Activity that can handle the implicit Intent
            startActivity(intent);
        } else{
            Log.d("ImplicitIntents", "Can't handle this!");
        }
    }

    public void openLocation(View view) {
    }

    public void shareText(View view) {
    }
}
