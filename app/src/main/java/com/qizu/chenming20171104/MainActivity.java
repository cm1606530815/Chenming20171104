package com.qizu.chenming20171104;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.xys.libzxing.zxing.activity.CaptureActivity;

public class MainActivity extends AppCompatActivity {
    private Button saomiao;
    TextView mTv_Ruslet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        saomiao = (Button) findViewById(R.id.saomiao);
        mTv_Ruslet = (TextView) findViewById(R.id.tv_ruselt);
    }
    public void haha(View view){
        startActivityForResult(new Intent(MainActivity.this, JuxingActivity.class), 0);
    }

    public void scan(View view){
        startActivityForResult(new Intent(MainActivity.this, CaptureActivity.class), 0);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            Bundle bundle=data.getExtras();
            String result=bundle.getString("result");
            mTv_Ruslet.setText(result);
        }else if(resultCode==RESULT_CANCELED){

        }
    }
}
