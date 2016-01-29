package org.mhacks.myschedule;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    ListView todo;
    List<String> list = new ArrayList<String>();
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todo = (ListView) findViewById(R.id.list);

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, list);
        todo.setAdapter(adapter);

        todo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemPosition = position;
                String itemValue = (String) todo.getItemAtPosition(position);

                Toast.makeText(getApplicationContext(), "Position :" + itemPosition + "List Item: " + itemValue,
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // Add items to the list on button click
    public void add(View view)
    {
        EditText editText = (EditText) findViewById(R.id.newItem);
        String message = editText.getText().toString();
        editText.setText("");
        list.add(message);
        adapter.notifyDataSetChanged();
    }
}
