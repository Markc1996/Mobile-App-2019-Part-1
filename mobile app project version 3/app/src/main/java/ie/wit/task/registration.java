package ie.wit.task;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class registration extends AppCompatActivity {

    private EditText userName, userPassword, userEmail;
    private Button regButton;
    private TextView userLogin;
    private FirebaseAuth firebaseAuth;
    private int counter = 5;
    private TextView userRegistration;
    private TextView Info;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        setupUIViews();

        firebaseAuth = firebaseAuth.getInstance();

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate()){
                    //upload data to database
                    String user_email = userEmail.getText().toString().trim();
                    String user_password = userPassword.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {
                                Toast.makeText(registration.this, "Registration Successfull",Toast.LENGTH_SHORT ).show();
                                startActivity(new Intent(registration.this, MainActivity.class));
                            }else{
                                Toast.makeText(registration.this, "Registration Failed",Toast.LENGTH_SHORT ).show();
                            }

                        }
                    });
                }
            }
        });

        userLogin.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                startActivity(new Intent(registration.this, MainActivity.class));
            }
        });
    }

    private void setupUIViews(){
        userName = (EditText) findViewById(R.id.etUserName);
        userPassword = (EditText) findViewById(R.id.etUserPassword);
        userEmail = (EditText) findViewById(R.id.etUserEmail);
        regButton = (Button) findViewById(R.id.btnRegister);
        userLogin = (TextView) findViewById(R.id.tvUserLogin);
        userRegistration = (TextView)findViewById(R.id.btnRegister);

        Info.setText("No of attempts remaining: 5");
    }

    private Boolean validate(){
        Boolean result = false;

        String name = userName.getText().toString();
        String password = userPassword.getText().toString();
        String email = userEmail.getText().toString();

        if(name.isEmpty() && password.isEmpty() && email.isEmpty()){
            Toast.makeText(this, "Please enter all the details", Toast.LENGTH_SHORT).show();
        }else {
            result = true;
        }

        return result;
    }

}
