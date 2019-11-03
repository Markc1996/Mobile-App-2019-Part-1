package ie.wit.task;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class tables extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables);
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
              startActivity(new Intent(this, list.class));
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
