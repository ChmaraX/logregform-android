
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrationActivity extends AppCompatActivity {

    private ImageView logo, joinus;
    private AutoCompleteTextView username, email, password;
    private Button signup;
    private TextView signin;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        initializeGUI();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    registerUser();
            }
        });


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }


    private void initializeGUI(){

        logo = findViewById(R.id.ivRegLogo);
        joinus = findViewById(R.id.ivJoinUs);
        username = findViewById(R.id.atvUsernameReg);
        email =  findViewById(R.id.atvEmailReg);
        password = findViewById(R.id.atvPasswordReg);
        signin = findViewById(R.id.tvSignIn);
        signup = findViewById(R.id.btnSignUp);
        progressDialog = new ProgressDialog(this);

        firebaseAuth = FirebaseAuth.getInstance();
    }

    private void registerUser() {

        progressDialog.setMessage("Verificating...");
        progressDialog.show();

        final String inputName = username.getText().toString().trim();
        final String inputPw = password.getText().toString().trim();
        final String inputEmail = email.getText().toString().trim();


        if(inputName.isEmpty() || inputPw.isEmpty() || inputEmail.isEmpty()){
            Toast.makeText(RegistrationActivity.this,"Please fill all the details.",Toast.LENGTH_SHORT).show();
            progressDialog.dismiss();
        }
        else{
            firebaseAuth.createUserWithEmailAndPassword(inputEmail,inputPw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        progressDialog.dismiss();
                        sendUserData(inputName);
                        Toast.makeText(RegistrationActivity.this,"You've been registered successfully.",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegistrationActivity.this,MainActivity.class));
                    }
                    else{
                        progressDialog.dismiss();
                        Toast.makeText(RegistrationActivity.this,"Email already exists.",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }


    private void sendUserData(String username){

        firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = firebaseDatabase.getReference(firebaseAuth.getUid());
        UserProfile userProfile = new UserProfile(username);
        myRef.setValue(userProfile);

    }


}
