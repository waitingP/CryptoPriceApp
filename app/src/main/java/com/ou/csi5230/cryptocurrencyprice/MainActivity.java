package com.ou.csi5230.cryptocurrencyprice;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ou.csi5230.cryptocurrencyprice.tableview.data.CryptoPriceDataProvider;

// An crypto price app based on sortable table: https://github.com/evrencoskun/TableView
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(
                    R.id.activity_container,
                    new MainFragment(new CryptoPriceDataProvider()),
                    MainFragment.class.getSimpleName()
            ).commit();
        }
    }
}
