package sg.edu.rp.c346.id20039583.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etColour, etIndex;
    Button btnAddItem, btnRemove;
    ListView lvColour;
    String[] alColours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etColour = findViewById(R.id.etTextColour);
        etIndex = findViewById(R.id.etTextIndex);
        btnAddItem = findViewById(R.id.buttonAddItem);
        btnRemove = findViewById(R.id.btnRemoveItem);
        lvColour = findViewById(R.id.listViewColour);

        ArrayList<String> colours;   //two originally stored value in list
        colours = new ArrayList<String>();
        colours.add("red");
        colours.add("orange");

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,
                android.R.layout.simple_list_item_1,
                colours);
        lvColour.setAdapter(adapter);

        btnAddItem.setOnClickListener(new View.OnClickListener() {  //btn onclick for adding new color based on indec position
            @Override
            public void onClick(View view) {
                String newColour = etColour.getText().toString();
                int pos = Integer.parseInt(etIndex.getText().toString());
                //colours.add(newColour);
                colours.add(pos, newColour);
                adapter.notifyDataSetChanged();
            }
        });

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent,View view, int position, long id) {
                Toast.makeText(MainActivity.this, colours.get(position),Toast.LENGTH_SHORT).show();
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newColour = etColour.getText().toString();
                int pos = Integer.parseInt(etIndex.getText().toString());
                colours.remove(pos);
                adapter.notifyDataSetChanged();

            }
        });


    }
}
