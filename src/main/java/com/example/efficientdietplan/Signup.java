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
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Signup extends AppCompatActivity {
    int a=0;
    EditText e1,e2;
    Button b;
    String email,password;
    Intent iii= getIntent();
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        e1 = (EditText) findViewById(R.id.editText4);
        e2 = (EditText) findViewById(R.id.editText5);
        b=(Button) findViewById(R.id.button4);

        FirebaseApp.initializeApp(this);
        mAuth = FirebaseAuth.getInstance();
    }
    public void click(View view)
    {
        createAccount();

    }
    public void createAccount()
    {
        email=e1.getText().toString();
        password=e2.getText().toString();
        System.out.println("heloooo"+email);
        System.out.println("hiiiii"+password);

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("TAG", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();

                            Intent iiit = new Intent(Signup.this, MainActivity.class);
                            iiit.putExtra("message", email);
                            startActivity(iiit);
//                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("TAG", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(Signup.this, "Authentication failed." + task.getException().getMessage(),
                                    Toast.LENGTH_LONG).show();

                            //                          updateUI(null);
                        }

                        // ...
                    }
                });

    }
}
