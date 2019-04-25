package com.example.efficientdietplan;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Signin extends AppCompatActivity {
    EditText e1,e2;
    Button b;
    String email,password;
    Intent iit= getIntent();
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        e1 = (EditText) findViewById(R.id.editText6);
        e2 = (EditText) findViewById(R.id.editText7);
        b=(Button) findViewById(R.id.button5);
        mAuth = FirebaseAuth.getInstance();

    }
    public void click(View view)
    {
        sigininAccount();

    }
    public void sigininAccount()
    {
        email=e1.getText().toString();
        password=e2.getText().toString();
        System.out.println("heloooo"+email);
        System.out.println("hiiiii"+password);

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("TAG", "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent iitt = new Intent(Signin.this, MainActivity.class);
                            startActivity(iitt);
                            //updateUI(user);
                        }else {
                            // If sign in fails, display a message to the user.
                            Log.w("TAG", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(Signin.this, "Authentication failed."+task.getException().getMessage(),
                                    Toast.LENGTH_LONG).show();

                            //updateUI(null);
                        }

                        // ...
                    }
                });
    }

}
