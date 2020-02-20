package lk.dinuka.dogproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView v1 = findViewById(R.id.im_view);

        String resource = "brittany_02625";

        int resource_id = getResources().getIdentifier(resource,"drawable","lk.dinuka.dogproject");
        // have the project name properly in defPackage(= package). Won't work otherwise.

        v1.setImageResource(resource_id);

    }
}
