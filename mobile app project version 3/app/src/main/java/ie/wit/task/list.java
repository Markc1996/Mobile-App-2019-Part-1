package ie.wit.task;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class list extends AppCompatActivity {


    ArrayList<String> itemList;

    ArrayAdapter<String> adapter;

    EditText itemText;

    Button addButton;

    ListView lv;
    private AbsListView v;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        lv = (ListView) findViewById(R.id.listView);
        itemText = (EditText) findViewById(R.id.addtext);
        addButton = (Button) findViewById(R.id.addbutton);

        itemList = new ArrayList<>();

        adapter = new ArrayAdapter<String>(list.this, android.R.layout.simple_list_item_multiple_choice, itemList);

        View.OnClickListener addlistener = new View.OnClickListener() {

            public void onClick(View v) {

                itemList.add(itemText.getText().toString());
                itemText.setText("");
                adapter.notifyDataSetChanged();


            }
        };

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {


                SparseBooleanArray positionchecker = lv.getCheckedItemPositions();

                int count = lv.getCount();

                for (int item = count - 1; item >= 0; item--) {

                    if (positionchecker.get(item)) {

                        adapter.remove(itemList.get(item));

                        Toast.makeText(list.this, "items deleted successfully", Toast.LENGTH_SHORT).show();
                    }
                }

                positionchecker.clear();

                adapter.notifyDataSetChanged();


                return false;


            }
        });

        addButton.setOnClickListener(addlistener);

        lv.setAdapter(adapter);


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
