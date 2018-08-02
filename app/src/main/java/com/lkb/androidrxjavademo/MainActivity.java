package com.lkb.androidrxjavademo;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView msgView = findViewById(R.id.msgView);
        Button myButton = findViewById(R.id.buttonView);
        MainActivityViewModel viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        //viewModel.getMessage().observe(this,msg-> msgView.setText(msg));
        viewModel.init();
        viewModel.getMessageLocal().observe(this,msg-> msgView.setText(msg));

        myButton.setOnClickListener(v -> viewModel.changeLiveDataValue());

    }

}
