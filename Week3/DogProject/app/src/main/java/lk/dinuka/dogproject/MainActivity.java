package lk.dinuka.dogproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String resource = "brittany_02625";

        int resource_id = getResources().getIdentifier(resource, "drawable", "lk.dinuka.dogproject");
        // have the project name properly in defPackage(= package). Won't work otherwise.

        ImageView v1 = findViewById(R.id.im_view);
        v1.setImageResource(resource_id);

    }


    public void changeImage(View view) {          // call this method onClick of Button

        ImageView v1 = findViewById(R.id.im_view);
        v1.setTag(1);       //used to identify which image is in the ImageView
        //------------Every time the button is clicked, Tag is set to 1-----------------////////////////??

        System.out.println(v1.getTag().toString().equals("1"));

        if (v1.getTag().toString().equals("1")) {
            String resource = "welsh_springer_spaniel_08203";
            int resource_id = getResources().getIdentifier(resource, "drawable", "lk.dinuka.dogproject");
            // have the project name properly in defPackage(= package). Won't work otherwise.

            v1.setImageResource(resource_id);
            v1.setTag(2);

        } else {
            String resource = "brittany_02625";
            int resource_id = getResources().getIdentifier(resource, "drawable", "lk.dinuka.dogproject");
            // have the project name properly in defPackage(= package). Won't work otherwise.

            v1.setImageResource(resource_id);
            v1.setTag(1);
        }

    }

}


/*
References:
https://stackoverflow.com/questions/32420565/android-changing-imageview-between-two-images-on-button-click-and-reclick
 */