package com.mhkhoa.webserviceontap.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.mhkhoa.webserviceontap.R;
import com.mhkhoa.webserviceontap.adapter.AdapterNhanVien;
import com.mhkhoa.webserviceontap.model.NhanVien;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<NhanVien> nhanVienArrayList;
    String url = "http://192.168.1.4/minhkhoa/danhsachnhanvien.php";
    AdapterNhanVien adapter;
    ListView lstNhanVien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        init();
        getData();

    }

    private void getData() {
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for(int i = 0 ; i < response.length() ; i++){
                            try {
                                JSONObject object = response.getJSONObject(i);
                                NhanVien a = new NhanVien();
                                a.setMa(object.getString("MA"));
                                a.setTen(object.getString("TEN"));
                                a.setHsluong(object.getString("HSLUONG"));
                                nhanVienArrayList.add(a);
                                adapter.notifyDataSetChanged();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);
    }

    private void init() {
        nhanVienArrayList = new ArrayList<>();
        adapter = new AdapterNhanVien(MainActivity.this,nhanVienArrayList);
        lstNhanVien.setAdapter(adapter);
    }

    private void addControls(){
        lstNhanVien = findViewById(R.id.listview);
    }
}
