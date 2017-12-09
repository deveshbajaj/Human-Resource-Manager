package com.example.devesh.humanresourcemanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class choose extends AppCompatActivity {
    Button bt_buy,bt_sell;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        bt_buy = (Button)findViewById(R.id.buy_but);
        bt_sell = (Button)findViewById(R.id.sell_but);
        bt_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent in = new Intent(getApplicationContext(),buyActivity.class);
                startActivity(in);
            }
        });
        bt_sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent in = new Intent(getApplicationContext(),sellActivity.class);
                startActivity(in);
            }
        });
    }
}
