package lk.dinuka.droidcafeinput;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Tag for the intent extra.
    public static final String EXTRA_MESSAGE = "com.example.android.droidcafe.extra.MESSAGE";
//    public static final List EXTRA_MESSAGE = "com.example.android.droidcafe.extra.MESSAGE";
    // initializing the final variable that can pass into the OrderActivity?

    // The order message, displayed in the Toast and sent to the new Activity
    private String mOrderMessage;
    private String mAllMessages;
    private ArrayList<String> mAllOrderMessages = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
//                intent.putExtra(EXTRA_MESSAGE,mOrderMessage);       // to pass one message to the Order Activity
                intent.putExtra(EXTRA_MESSAGE, mAllMessages);       // to pass one message to the Order Activity

                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void showDonutOrder(View view) {      // Show a message that the donut image was clicked
        mOrderMessage = getString(R.string.donut_order_message);
        mAllOrderMessages.add(mOrderMessage);
        displayToast(getString(R.string.donut_order_message));

        addAllOrdersToOneMessage();
    }

    public void showIceCreamOrder(View view) {      // Show a message that the ice cream sandwich image was clicked
        mOrderMessage = getString(R.string.ice_cream_order_message);
        mAllOrderMessages.add(mOrderMessage);
        displayToast(getString(R.string.ice_cream_order_message));

        addAllOrdersToOneMessage();
    }

    public void showFroyoOrder(View view) {      // Show a message that the froyo image was clicked
        mOrderMessage = getString(R.string.froyo_order_message);
        mAllOrderMessages.add(mOrderMessage);
        displayToast(getString(R.string.froyo_order_message));

        addAllOrdersToOneMessage();
    }


    public void addAllOrdersToOneMessage() {

        if (mAllOrderMessages.size() != 1) {        // to make sure that the first item isn't 'null'
            mAllMessages = mAllMessages + "\n" + mAllOrderMessages.get(mAllOrderMessages.size() - 1);      //concatenating the last order message
        } else{
            mAllMessages = "\n" + mAllOrderMessages.get(mAllOrderMessages.size() - 1);      //concatenating the last order message
        }
    }

}


/*
Reference:
https://codelabs.developers.google.com/codelabs/android-training-clickable-images/index.html?index=../../android-training#2

https://codelabs.developers.google.com/codelabs/android-training-input-controls/index.html?index=../..android-training#6
 */
