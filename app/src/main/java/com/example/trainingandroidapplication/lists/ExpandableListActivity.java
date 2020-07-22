package com.example.trainingandroidapplication.lists;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.Toast;

import com.example.trainingandroidapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ExpandableListActivity extends AppCompatActivity {

    private String[] groups = new String[]{"Words", "Items", "Books"};
    private String[] words = new String[]{"word1", "word2"};
    private String[] items = new String[]{"item1", "item2", "item3", "item4"};
    private String[] books = new String[]{"book1", "book", "book3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list);

        setTitle("ExpandableList");

        Map<String, String> map;
        final ArrayList<Map<String, String>> groupsMapArrayList = new ArrayList<>();
        ArrayList<Map<String, String>> tempMapArrayList = new ArrayList<>();
        final ArrayList<ArrayList<Map<String, String>>> allItemsAndGroupsMapArrayList = new ArrayList<>();

        String groupFrom[] = new String[]{"groupName"};
        int groupTo[] = new int[]{android.R.id.text1};
        String childFrom[] = new String[]{"itemName"};
        int childTo[] = new int[]{android.R.id.text1};

        for (String s : groups) {
            map = new HashMap<>();
            map.put("groupName", s);
            groupsMapArrayList.add(map);
        }

        for (String s : words) {
            map = new HashMap<>();
            map.put("itemName", s);
            tempMapArrayList.add(map);
        }
        allItemsAndGroupsMapArrayList.add(tempMapArrayList);

        tempMapArrayList = new ArrayList<>();
        for (String s : items) {
            map = new HashMap<>();
            map.put("itemName", s);
            tempMapArrayList.add(map);
        }
        allItemsAndGroupsMapArrayList.add(tempMapArrayList);

        tempMapArrayList = new ArrayList<>();
        for (String s : books) {
            map = new HashMap<>();
            map.put("itemName", s);
            tempMapArrayList.add(map);
        }
        allItemsAndGroupsMapArrayList.add(tempMapArrayList);

        SimpleExpandableListAdapter simpleExpandableListAdapter = new SimpleExpandableListAdapter(
                this, groupsMapArrayList,
                android.R.layout.simple_expandable_list_item_1,
                groupFrom, groupTo,
                allItemsAndGroupsMapArrayList,
                android.R.layout.simple_list_item_1,
                childFrom, childTo
        );
        ExpandableListView expandableListView = findViewById(R.id.expandableListView);
        expandableListView.setAdapter(simpleExpandableListAdapter);

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                Toast.makeText(ExpandableListActivity.this, groups[groupPosition], Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                String g = groupsMapArrayList.get(groupPosition).get("groupName");
                String i = allItemsAndGroupsMapArrayList.get(groupPosition).get(childPosition).get("itemName");
                Toast.makeText(ExpandableListActivity.this, g + " " + i, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}
