package com.example.chmarax.logregform;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private ImageView logo, ivSignIn, btnTwitter;
    private AutoCompleteTextView email, password;
    private TextView forgotPass, signUp;
    private Button btnSignIn;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser user;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initializeGUI();

        user = firebaseAuth.getCurrentUser();

        if(user != null) {
            finish();
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
        }

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String inEmail = email.getText().toString();
                String inPassword = password.getText().toString();

                if(validateInput(inEmail, inPassword)){
                    checkUser(inEmail, inPassword);
                }

            }
        });



    }



    public void checkUser(String email, String password){

        progressDialog.setMessage("Verificating...");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    progressDialog.dismiss();
                    Toast.makeText(LoginActivity.this,"Login Successful",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
                }
                else{
                    progressDialog.dismiss();
                    Toast.makeText(LoginActivity.this,"Invalid email or password",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    private void initializeGUI(){

        logo = findViewById(R.id.ivLogLogo);
        ivSignIn = findViewById(R.id.ivSignIn);
        btnTwitter = findViewById(R.id.ivFacebook);
        email = findViewById(R.id.atvEmailLog);
        password = findViewById(R.id.atvPasswordLog);
        forgotPass = findViewById(R.id.tvForgotPass);
        signUp = findViewById(R.id.tvSignIn);
        btnSignIn = findViewById(R.id.btnSignIn);
        progressDialog = new ProgressDialog(this);

        firebaseAuth = FirebaseAuth.getInstance();

    }


    public boolean validateInput(String email, String password){

        if(email.isEmpty() || password.isEmpty()){
            Toast.makeText(LoginActivity.this,"Fill all the details.",Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

}
