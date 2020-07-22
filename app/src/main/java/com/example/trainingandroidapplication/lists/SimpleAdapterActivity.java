package com.example.trainingandroidapplication.lists;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trainingandroidapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleAdapterActivity extends AppCompatActivity {

    private int counter = 0;
    private Map<String, Object> tempMap;
    private List<Map<String, Object>> mapList = new ArrayList<>();
    private SimpleAdapter simpleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter);

        String[] from = new String[]{"value", "img"};
        int[] to = new int[]{R.id.textViewSimpleAdapter, R.id.imageViewSimpleAdapter};


        simpleAdapter = new MySimpleAdapter(this, mapList, R.layout.item_simple_adapter, from, to);
        ListView listView = findViewById(R.id.listViewSimpleAdapter);
        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = view.findViewById(R.id.textViewSimpleAdapter);
                String message = "Click on " + textView.getText().toString();
                Toast.makeText(SimpleAdapterActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonAddItemToLV: {
                tempMap = new HashMap<>();
                tempMap.put("value", String.valueOf(counter));
                tempMap.put("img", counter);
                mapList.add(tempMap);
                simpleAdapter.notifyDataSetChanged();
                counter++;
                break;
            }
            case R.id.buttonRemoveItemToLV: {
                if (counter != 0) {
                    mapList.remove(counter - 1);
                    simpleAdapter.notifyDataSetChanged();
                    counter--;
                }
                break;
            }
        }
    }


    class MySimpleAdapter extends android.widget.SimpleAdapter {

        /**
         * Constructor
         *
         * @param context  The context where the View associated with this SimpleAdapter is running
         * @param data     A List of Maps. Each entry in the List corresponds to one row in the list. The
         *                 Maps contain the data for each row, and should include all the entries specified in
         *                 "from"
         * @param resource Resource identifier of a view layout that defines the views for this list
         *                 item. The layout file should include at least those named views defined in "to"
         * @param from     A list of column names that will be added to the Map associated with each
         *                 item.
         * @param to       The views that should display column in the "from" parameter. These should all be
         *                 TextViews. The first N views in this list are given the values of the first N columns
         */
        public MySimpleAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
            super(context, data, resource, from, to);
        }

        @Override
        public void setViewImage(ImageView v, int value) {
            if (value % 2 == 0) {
                v.setImageResource(R.drawable.smollet);
            }else {
                v.setImageResource(R.drawable.smollet2);
            }
        }

        @Override
        public void setViewText(TextView v, String text) {
            if (v.getId() == R.id.textViewSimpleAdapter) {
                v.setText("Item_" + text);
            }
        }


    }
}
