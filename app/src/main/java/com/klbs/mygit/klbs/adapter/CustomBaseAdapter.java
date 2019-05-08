package com.example.klbs.apnarestaurants.klbs.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.klbs.apnarestaurants.R;
import com.example.klbs.apnarestaurants.model.RowItem;

import java.util.List;

/**
 * Created by KLBS on 4/14/2017.
 */

public class CustomBaseAdapter extends BaseAdapter {
    Context context;
    List<RowItem> rowItems;

    public CustomBaseAdapter(Context context, List<RowItem> items) {
        this.context = context;
        this.rowItems = items;
    }

    /*private view holder class*/
    private class ViewHolder {
        ImageView imageView;
        TextView txtTitle;
        TextView txtDesc;
        TextView txtpluse;
        TextView txtminus;
        TextView txttotal;
        TextView value;
        TextView txtall;
        Button btadd;

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        LayoutInflater mInflater = (LayoutInflater)
                context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            holder.txtDesc = (TextView) convertView.findViewById(R.id.desc);
            holder.txtTitle = (TextView) convertView.findViewById(R.id.title);
            holder.imageView = (ImageView) convertView.findViewById(R.id.icon);
            holder.txtpluse=(TextView)convertView.findViewById(R.id.tv_pluse);
            holder.txtminus=(TextView)convertView.findViewById(R.id.tv_minus);
            holder.txttotal=(TextView)convertView.findViewById(R.id.tv_total);
            holder.value=(TextView)convertView.findViewById(R.id.value);
            holder.txtall=(TextView)convertView.findViewById(R.id.tv_all);
            holder.btadd=(Button)convertView.findViewById(R.id.bt_add);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

      final   RowItem rowItem = (RowItem) getItem(position);

        holder.txtDesc.setText(rowItem.getDesc());
        holder.txtTitle.setText(rowItem.getTitle());
        holder.imageView.setImageResource(rowItem.getImageId());
        holder.value.setText(String.valueOf(rowItem.getTotal()));
        holder.txttotal.setText(String.valueOf(rowItem.getCountitem()));
        holder.txtall.setText(String.valueOf(rowItem.getAllitem()));

        holder.txtpluse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int increase_count =rowItem.getCountitem();
                rowItem.setCountitem(++increase_count);
                int go=++increase_count;

               /* int increase_count1 =rowItem.getTotal();

                rowItem.setTotal(increase_count1+increase_count1);*/
                notifyDataSetChanged();
            }
        });
        holder.txtminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int decrease_count =rowItem.getCountitem();
                int to=--decrease_count;
                rowItem.setCountitem(--decrease_count );

              /*  int decrease_count1 =rowItem.getTotal();
                rowItem.setTotal(decrease_count1*to );*/

                notifyDataSetChanged();
            }
        });

        holder.btadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int decrease_count1 =rowItem.getTotal();
                int decrease_countall =rowItem.getCountitem();
              rowItem.setAllitem(decrease_count1*decrease_countall);
                Toast.makeText(context,"ckick",Toast.LENGTH_LONG).show();

                notifyDataSetChanged();

            }
        });





        return convertView;
    }

    @Override
    public int getCount() {
        return rowItems.size();
    }

    @Override
    public Object getItem(int position) {
        return rowItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return rowItems.indexOf(getItem(position));
    }
}