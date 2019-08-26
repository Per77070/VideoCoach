package com.example.videocoach;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText userEmail, userPassword;
       private ProgressDialog ProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    mAuth = FirebaseAuth.getInstance();
    }


    EditText email =  (EditText) findViewById(R.id.email);

    EditText password =  (EditText) findViewById(R.id.password);


    private void CreateNewAccount(){


        String email = userEmail.getText().toString();
        String password = userPassword.getText().toString();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Type your email adress.", Toast.LENGTH_SHORT).show();
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "Type your password.", Toast.LENGTH_SHORT).show();
        }
else
        {
    mAuth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
if(task.isSuccessful()){

    Toast.makeText(LoginActivity.this, "Account created succesfully", Toast.LENGTH_SHORT).show();
    
}
         else
{
        String message = task.getException().toString();
    Toast.makeText(LoginActivity.this, "Error" +message, Toast.LENGTH_SHORT).show();


}

                }
            });
    }




}

}
