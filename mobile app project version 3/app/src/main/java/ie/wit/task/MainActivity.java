package ie.wit.task;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){



        switch (item.getItemId())
        {

            case R.id.list:startActivity(new Intent(this, list.class));
                Toast.makeText(this,"Tables selected", Toast.LENGTH_SHORT).show();
                break;

            case R.id.table:startActivity(new Intent(this, tables.class));
                Toast.makeText(this,"Tables selected", Toast.LENGTH_SHORT).show();
                break;


            case R.id.main_menu:startActivity(new Intent(this, MainActivity.class));
                Toast.makeText(this,"Back to main menu", Toast.LENGTH_SHORT).show();
                break;

          /*  case R.id.register:startActivity(new Intent(this, registration.class));
                Toast.makeText(this,"Register selected", Toast.LENGTH_SHORT).show();
                break;

            case R.id.login:startActivity(new Intent(this, login.class));
                Toast.makeText(this,"Login selected", Toast.LENGTH_SHORT).show();
                break;
          */
        }

        return super.onOptionsItemSelected(item);
    }
}
