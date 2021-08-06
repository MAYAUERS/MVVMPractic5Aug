package com.example.mvvmpractic5aug.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mvvmpractic5aug.R;
import com.example.mvvmpractic5aug.model.APIResponse;
import com.example.mvvmpractic5aug.viewModel.EmployeeViewModel;

public class MainActivity extends AppCompatActivity {


    Button button;
    TextView textView;
    EmployeeViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.txt_11);
        button=findViewById(R.id.btn11);

        viewModel=new ViewModelProvider(this).get(EmployeeViewModel.class);
        viewModel.init();
        viewModel.getAllLiveData().observe(this, new Observer<APIResponse>() {
            @Override
            public void onChanged(APIResponse apiResponse) {
                textView.setText(apiResponse.getSuccessFlag().toString());
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            viewModel.getResponse();
            }
        });
    }


}
