package com.example.klbs.apnarestaurants.klbs.adapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.klbs.apnarestaurants.R;
import com.example.klbs.apnarestaurants.model.RowItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KLBS on 4/14/2017.
 */


    public class VegFoodActivity extends Activity implements
        AdapterView.OnItemClickListener {

        public static final String[] titles = new String[] { " thali",
            " thali", " thali", "sabji" };
    public static final int[] countitemall = new int[] { 1,
            1, 1, 1 };

    public static final int[] countitem = new int[] { 0,
            0, 0, 0 };
    public static final int[] total = new int[] { 200,
            305, 250, 250 };

        public static final String[] descriptions = new String[] {
                "Oriya thali",
                "Andhra thali", "Rajasthani thali",
                "tawa sabji" };

        public static final Integer[] images = { R.drawable.veg1,
                R.drawable.veg2, R.drawable.veg3, R.drawable.veg4 };

        ListView listView;
        List<RowItem> rowItems;

        /** Called when the activity is first created. */
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.veg_food_activity);

            rowItems = new ArrayList<RowItem>();
            for (int i = 0; i < titles.length; i++) {
                RowItem item = new RowItem(images[i], titles[i], descriptions[i],total[i],countitem[i],countitemall[i]);
                rowItems.add(item);
            }

            listView = (ListView) findViewById(R.id.list);
            CustomBaseAdapter adapter = new CustomBaseAdapter(this, rowItems);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(this);
        }

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Item " + (position + 1) + ": " + rowItems.get(position),
                    Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();
        }
    }

