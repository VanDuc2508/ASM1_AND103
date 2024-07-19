package com.example.asm1_and103;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MobileAdapter extends BaseAdapter {
    List<MobileModel> listMobileModel;
    Context context;
    public MobileAdapter(Context context, List<MobileModel> listMobileModel){
        this.listMobileModel = listMobileModel;
        this.context = context;
    }
    @Override
    public int getCount() {
        return listMobileModel.size();
    }

    @Override
    public Object getItem(int position) {
        return listMobileModel.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.item_mobile, parent, false);
        }

        MobileModel mobile = listMobileModel.get(position);

        TextView tvID = convertView.findViewById(R.id.idTextView);
        ImageView imgAvatar = convertView.findViewById(R.id.imageView);
        TextView tvName = convertView.findViewById(R.id.nameTextView);
        TextView tvBorn = convertView.findViewById(R.id.bornTextView);
        TextView tvBrand = convertView.findViewById(R.id.brandTextView);
        TextView tvPrice = convertView.findViewById(R.id.priceTextView);

        tvName.setText("Tên: "+ mobile.getName());
        tvBorn.setText("Năm sản xuất: "+String.valueOf(mobile.getBorn()));
        tvBrand.setText("Hãng: "+mobile.getBrand());
        String formattedPrice = String.format("%.0f", mobile.getPrice());
        tvPrice.setText("Giá: " + formattedPrice);

        // Sử dụng Picasso để tải ảnh từ server
        String imageUrl = ApiService.DOMAIN + "/uploads/" + mobile.getImage();
        Picasso.get().load(imageUrl).placeholder(R.drawable.placeholder).into(imgAvatar);

        return convertView;
    }



}
