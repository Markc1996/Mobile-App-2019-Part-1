package ie.wit.task;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class login extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter =5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Name = (EditText)findViewById(R.id.etName);
        Password = (EditText)findViewById(R.id.etPassword);
        Info = (TextView)findViewById(R.id.tvInfo);
        Login = (Button)findViewById(R.id.btnLogin);

        Info.setText("No of Attempts remaining: 5");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });

    }

    private void validate(String toString, String toString1) {
    }

    private void Validate(String userName, String userPassword){
        if((userName == "Admin" && userPassword == "1234")){
           Intent intent = new Intent(login.this, SecondActivity.class);
           startActivity(intent);
        }else{
            counter--;

            Info.setText("No of attempts remaining:" + String.valueOf(counter));
            
            if (counter == 0){
                Login.setEnabled(false);
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.table:
                startActivity(new Intent(this, tables.class));
                Toast.makeText(this, "Tables Selected", Toast.LENGTH_SHORT).show();
                break;

            case R.id.main_menu:
                startActivity(new Intent(this, MainActivity.class));
                Toast.makeText(this, "Back to main menu", Toast.LENGTH_SHORT).show();
                break;

            case R.id.list:
                startActivity(new Intent(this, List.class));
                Toast.makeText(this, "Login Selected", Toast.LENGTH_SHORT).show();
                break;


           /* case R.id.menuStats:
                startActivity(new Intent(this, Stats.class));
                Toast.makeText(this, "Stats Selected", Toast.LENGTH_SHORT).show();
                break;

                */

        }

        return super.onOptionsItemSelected(item);
    }

}
