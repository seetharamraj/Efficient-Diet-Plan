package com.example.efficientdietplan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class first extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }
    public void clickone(View view)
    {
        Intent ii=new Intent(this,Signup.class);
        startActivity(ii);
    }
    public void clicktwo(View view)
    {
        Intent iit=new Intent(this,Signin.class);
        startActivity(iit);
    }
}
