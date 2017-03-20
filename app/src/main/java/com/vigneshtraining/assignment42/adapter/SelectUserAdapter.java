package com.vigneshtraining.assignment42.adapter;

import android.content.Context;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.vigneshtraining.assignment42.R;
import com.vigneshtraining.assignment42.model.SelectUser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vimadhavan on 3/19/2017.
 */

public class SelectUserAdapter extends BaseAdapter {
    private ArrayList<SelectUser> _data;

    private Context _c;


    public SelectUserAdapter(ArrayList<SelectUser> selectUsers, Context context) {
        _data = selectUsers;
        _c = context;

    }


    @Override
    public int getCount() {
        return  _data.size();
    }

    @Override
    public Object getItem(int position) {
        return  _data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view == null) {
            LayoutInflater li = (LayoutInflater) _c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = li.inflate(R.layout.custom_list, parent,false);
            Log.e("Inside", "here--------------------------- In view1");
            holder = new ViewHolder();

            holder.name = (TextView) view.findViewById(R.id.name);

            holder.phone = (TextView) view.findViewById(R.id.no);

            view.setTag(holder);
       } else {
           holder = (ViewHolder) view.getTag();
           Log.e("Inside", "here--------------------------- In view2");
        }



        SelectUser data = (SelectUser) _data.get(position);
        holder.name.setText(data.getName());
       //holder.check.setChecked(data.getCheckedBox());
        holder.phone.setText(data.getPhone());

        // Set image if exists



        return view;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView name, phone;

    }
}
