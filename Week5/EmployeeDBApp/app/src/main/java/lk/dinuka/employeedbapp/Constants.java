package lk.dinuka.employeedbapp;

import android.provider.BaseColumns;

public interface Constants extends BaseColumns {
    public static final String TABLE_NAME = "EmployeeDetails" ;

    // Columns in the Employees database
    public static final String ID = "id" ;
    public static final String NAME = "name" ;
    public static final String ADDRESS = "address" ;
    public static final String AGE = "age" ;
    public static final String POSITION = "position" ;

}
