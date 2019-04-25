package com.example.efficientdietplan;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

    public class DatabaseHelper extends SQLiteOpenHelper {
        public static final String Database_name="dietplan.db";
        public static final String Table_name="female";
        public static final String Table_name2="male";
        public static final String Col_1="Height";
        public static final String Col_2="Weight";
        SQLiteDatabase db;
        public static final String sql_createtable_table1 ="create table "+ Table_name + "("+ Col_1 + " double, "+ Col_2 + " text "+");";
        public static final String sql_createtable_table2 ="create table "+ Table_name2 + "("+ Col_1 + " double, "+ Col_2 + " text "+");";
        public DatabaseHelper(Context context) {
            super(context, Database_name, null, 1);
            SQLiteDatabase db=this.getWritableDatabase();
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(sql_createtable_table1) ;
            db.execSQL(sql_createtable_table2) ;
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+Table_name);
            db.execSQL("DROP TABLE IF EXISTS "+Table_name2);
            onCreate(db);
        }
        public String retrivie(Double h,String gender)
        {
            String w=null;
            if(gender.equals("female"))
            {
                db = this.getReadableDatabase();
                Cursor c = db.rawQuery("SELECT Weight FROM female WHERE Height = '" + h + "'", null);
                c.moveToNext();
                w = c.getString(c.getColumnIndex("Weight"));

            }
            if(gender.equals("male"))
            {
                db = this.getReadableDatabase();
                Cursor c = db.rawQuery("SELECT Weight FROM male WHERE Height = '" + h + "'", null);
                c.moveToNext();
                w = c.getString(c.getColumnIndex("Weight"));

            }
            return w;
        }



}
