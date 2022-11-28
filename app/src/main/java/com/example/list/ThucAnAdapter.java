package com.example.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ThucAnAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<ThucAn> thucAnList;

    public ThucAnAdapter(Context context, int layout, List<ThucAn> thucAnList) {
        this.context = context;
        this.layout = layout;
        this.thucAnList = thucAnList;
    }

    @Override
    public int getCount() {
        return thucAnList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        ImageView imgHinh;
        TextView txtTen, txtMoTa;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;

        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(layout, null);
            holder = new ViewHolder();
            // ánh xạ view
            holder.txtTen = (TextView) view.findViewById(R.id.textviewTen);
            holder.txtMoTa = (TextView) view.findViewById(R.id.textviewMoTa);
            holder.imgHinh = (ImageView) view.findViewById(R.id.imageviewHinh);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }


        // gán giá trị
        ThucAn thucAn = thucAnList.get(i);

        holder.txtTen.setText(thucAn.getTen());
        holder.txtMoTa.setText(thucAn.getMoTa());
        holder.imgHinh.setImageResource(thucAn.getHinh());

        return view;
    }
}
