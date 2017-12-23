package com.mhkhoa.webserviceontap.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mhkhoa.webserviceontap.R;
import com.mhkhoa.webserviceontap.model.NhanVien;

import java.util.ArrayList;

/**
 * Created by thaim on 23/12/2017.
 */

public class AdapterNhanVien extends BaseAdapter {

    Context context;
    ArrayList<NhanVien> nhanVienArrayList;
    LayoutInflater inflater;

    public AdapterNhanVien(Context context, ArrayList<NhanVien> nhanVienArrayList) {
        this.context = context;
        this.nhanVienArrayList = nhanVienArrayList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return nhanVienArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return nhanVienArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.item_nv,null);
        //addcontrols
        TextView txtMaSo = view.findViewById(R.id.textviewmaso);
        TextView txtHoTen = view.findViewById(R.id.textviewten);
        TextView txtHSLuong = view.findViewById(R.id.textviewhsluong);
        //settext
        txtMaSo.setText(nhanVienArrayList.get(i).getMa());
        txtHoTen.setText(nhanVienArrayList.get(i).getTen());
        txtHSLuong.setText(nhanVienArrayList.get(i).getHsluong());
        return view;
    }
}
