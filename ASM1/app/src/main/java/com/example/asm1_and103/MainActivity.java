package com.example.asm1_and103;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ListView lstMain;
    List<MobileModel> list;

    MobileAdapter mobileAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lstMain = findViewById(R.id.listviewMain);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.DOMAIN)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<MobileModel>> call = apiService.getMobiles();
        call.enqueue(new Callback<List<MobileModel>>() {
            @Override
            public void onResponse(Call<List<MobileModel>> call, Response<List<MobileModel>> response) {
                if (response.isSuccessful()){
                    list =response.body();
                    mobileAdapter = new MobileAdapter(getApplicationContext(), list);
                    lstMain.setAdapter(mobileAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<MobileModel>> call, Throwable t) {
                Log.e("Main", t.getMessage());
            }
        });
    }
}
