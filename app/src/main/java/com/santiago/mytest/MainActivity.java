package com.santiago.mytest;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText ed_name;
    private TextInputEditText ed_pass;
    private Button button;
    private TextView text_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed_name = findViewById(R.id.ed_name);
        ed_pass = findViewById(R.id.ed_pass);
        button = findViewById(R.id.button);
        text_view = findViewById(R.id.text_view);

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Manager.Request request = new Manager.Request(ed_name.getText().toString(),ed_pass.getText().toString());
                login(request);
            }
        });
    }

    private void login( Manager.Request request){
        Manager.login( request, new Callback<Manager>() {
            @Override
            public void onResponse(Call<Manager> call, Response<Manager> response) {
                Log.d("tag",response.body().getMsg());
                text_view.setText(response.body().getMsg());
            }

            @Override
            public void onFailure(Call<Manager> call, Throwable t) {
//               text_view.setText( t.getCause().getMessage());
                Log.d("tag",t.getMessage());
            }
        });
    }

}
