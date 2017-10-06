package com.example.honorehercule.essaie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ArrayList<String> items;
    ArrayAdapter<String> itemsAdapter;
    ListView lvitems;
    EditText etNewitem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvitems=(ListView)findViewById(R.id.lvItems);
        items=new ArrayList<>();
        itemsAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,items);
        lvitems.setAdapter(itemsAdapter);
        items.add("Honore");
        items.add("Hercule");
        setListViewListener();
    }

    public void onAddItem(View v) {
        etNewitem = (EditText) findViewById(R.id.etNewItem);
        String itemText=etNewitem.getText().toString();
        itemsAdapter.add(itemText);
        etNewitem.setText("");
        //writeItems();
    }



    private void setListViewListener(){
        Log.i("mainActivity" , "Setting up Listener add ");
        lvitems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                items.remove(i);
                Toast.makeText(getApplicationContext(), items.get(i), Toast.LENGTH_SHORT).show();
                itemsAdapter.notifyDataSetChanged();

                return false;
            }
        });
    }

}
