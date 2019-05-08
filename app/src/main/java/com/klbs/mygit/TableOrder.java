package com.example.klbs.apnarestaurants;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.klbs.apnarestaurants.klbs.adapter.VegFoodActivity;

/**
 * Created by KLBS on 4/12/2017.
 */

public class TableOrder extends Activity {
    LinearLayout ll_veg,ll_nonveg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table_order);
        ll_veg=(LinearLayout)findViewById(R.id.ll_veg);
        ll_nonveg=(LinearLayout)findViewById(R.id.ll_nonveg);

        ll_veg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in =new Intent(TableOrder.this, VegFoodActivity.class);
                startActivity(in);
            }
        });
    }

}
