package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
private EditText edtEmail , edtUserName, edtPassword;
private Button  btnSignUp,btnSignIn ,login;
private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
login=findViewById(R.id.button);
        edtEmail=findViewById(R.id.email);
        edtPassword=findViewById(R.id.pass);
        edtUserName=findViewById(R.id.uname3);
        btnSignIn=findViewById(R.id.signin);
        btnSignUp=findViewById(R.id.signup);

        mAuth = FirebaseAuth.getInstance();

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUP();
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this,"on click executes",Toast.LENGTH_SHORT).show();
                signinn();
            }
        });
login.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent =new Intent(MainActivity.this,Login.class);
        startActivity(intent);
    }
});
    }

    private void signUP()
    {
        mAuth.createUserWithEmailAndPassword(edtEmail.getText().toString(),edtPassword.getTextColors().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful())
                {//Tranition to next activity
                    Toast.makeText(MainActivity.this,"Sign Up Succesful",Toast.LENGTH_SHORT).show();

                }
                else {Toast.makeText(MainActivity.this,"Sign Up Failed",Toast.LENGTH_SHORT).show();}
            }
        });

    }

//    private void signIN()
//    {
//        mAuth.signInWithEmailAndPassword(edtEmail.getText().toString(),edtPassword.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                if(task.isSuccessful())
//                {Toast.makeText(MainActivity.this,"Sign IN Succesful",Toast.LENGTH_SHORT).show();}
//                else
//                {Toast.makeText(MainActivity.this,"Sign IN Failed",Toast.LENGTH_SHORT).show();}
//            }
//
//        });
//
//    }

    private void signinn()
    {mAuth.signInWithEmailAndPassword(edtEmail.getText().toString(),edtPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {

            if(task.isSuccessful())
            {
                Toast.makeText(MainActivity.this,"Signin Succesful",Toast.LENGTH_SHORT).show();
            }
            else { Toast.makeText(MainActivity.this,"Signin Failed",Toast.LENGTH_SHORT).show();}

        }
    });


    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
//        updateUI(currentUser);
        if(currentUser!=null)
         {
            //        Transition to next Activity
             }

    }


}
