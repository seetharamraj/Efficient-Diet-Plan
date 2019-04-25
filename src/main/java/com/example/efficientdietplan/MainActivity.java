package com.example.efficientdietplan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2,e3;
    Button b;
    DatabaseHelper Mydb;
    Spinner s;
    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent iiit= getIntent();
        String email = iiit.getStringExtra("message");
        //e1 = (EditText) findViewById(R.id.editText);
        e2 = (EditText) findViewById(R.id.editText2);
        e3 = (EditText) findViewById(R.id.editText3);
        s=(Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> myAdapter = new ArrayAdapter <String> (MainActivity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.names));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(myAdapter);
        System.out.print("Project Start");
        Mydb=new DatabaseHelper(this);
        System.out.print("Project next step");
    }
    public void clickone(View view)
    {
        //String value1 = e1.getText().toString();
        String value1=s.getSelectedItem().toString();
        String value2 = e2.getText().toString();
        String value3 = e3.getText().toString();
        System.out.println("aaaaaaaaaaaaaaaa"+value1);
        if(value1!=null && value2!=null && value3!=null) {
            if(value1.equals("female")||value1.equals("male")) {
                        Intent i = new Intent(this, Display.class);
                        i.putExtra("message", value1);
                        i.putExtra("message2", value2);
                        i.putExtra("message3", value3);
                        i.putExtra("message4",email);
                        startActivity(i);


            }
            else
            {
                Toast.makeText(MainActivity.this, "Wrong Details",
                        Toast.LENGTH_LONG).show();
            }
        }
    }

}
