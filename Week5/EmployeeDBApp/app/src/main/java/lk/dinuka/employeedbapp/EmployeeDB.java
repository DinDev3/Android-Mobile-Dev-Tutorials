package lk.dinuka.employeedbapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.provider.BaseColumns._ID;
import static lk.dinuka.employeedbapp.Constants.ADDRESS;
import static lk.dinuka.employeedbapp.Constants.AGE;
import static lk.dinuka.employeedbapp.Constants.ID;
import static lk.dinuka.employeedbapp.Constants.NAME;
import static lk.dinuka.employeedbapp.Constants.POSITION;
import static lk.dinuka.employeedbapp.Constants.TABLE_NAME;

public class EmployeeDB extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "employees.db";
    private static final int DATABASE_VERSION = 1;

    /* Create a helper object for the Employees database */
    public EmployeeDB(Context ctx) {
        super(ctx, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                ID + " TEXT ," +
                NAME + " TEXT NOT NULL," +
                ADDRESS + " TEXT ," +
                AGE + " TEXT ," +
                POSITION + " TEXT);"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME); onCreate(sqLiteDatabase);
    }
}
