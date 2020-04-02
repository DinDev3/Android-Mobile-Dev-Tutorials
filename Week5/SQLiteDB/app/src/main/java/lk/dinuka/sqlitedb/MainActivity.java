package lk.dinuka.sqlitedb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import static android.provider.BaseColumns._ID;
import static lk.dinuka.sqlitedb.Constants.TABLE_NAME;
import static lk.dinuka.sqlitedb.Constants.TIME;
import static lk.dinuka.sqlitedb.Constants.TITLE;


public class MainActivity extends AppCompatActivity {
    private static String[] FROM = {_ID, TIME, TITLE};
    private static String ORDER_BY = TIME + " DESC";
    private EventsData events;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        events = new EventsData(this);

        try {
            addEvent("Hello, Android!");
            Cursor cursor = getEvents();
            showEvents(cursor);         // display the db content
        } finally {
            events.close();
        }
    }

    public void addEvent(String string){
        // Insert a new record into the Events data source.

        SQLiteDatabase db = events.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TIME, System.currentTimeMillis());
        values.put(TITLE, string);
        db.insertOrThrow(TABLE_NAME, null, values);


    }

    public Cursor getEvents(){
        // Performs a managed query.
        // will handle closing & re-querying the cursor when needed.

        SQLiteDatabase db = events.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, FROM, null,null,
                null,null,ORDER_BY);

        return cursor;
    }

    private void showEvents(Cursor cursor){
        StringBuilder builder = new StringBuilder("Saved events:\n");

        while (cursor.moveToNext()){
            long id = cursor.getLong(0);
            long time = cursor.getLong(1);
            String title = cursor.getString(2);
            builder.append(id).append(": ");
            builder.append(time).append(": ");
            builder.append(title).append("\n");
        }
        cursor.close();

        TextView text = (TextView) findViewById(R.id.text);

        text.setText(builder);
    }
}
