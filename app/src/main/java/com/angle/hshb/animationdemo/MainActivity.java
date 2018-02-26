package com.angle.hshb.animationdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.btn_main_base_animitor)
    Button btnBaseAnimator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.btn_main_base_animitor})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_main_base_animitor:
                startActivity(new Intent(this,BaseAnimatorActivity.class));
                break;
        }
    }
}
