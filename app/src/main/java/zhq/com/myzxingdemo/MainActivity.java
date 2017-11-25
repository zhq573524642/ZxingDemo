package zhq.com.myzxingdemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.WriterException;
import com.google.zxing.activity.CaptureActivity;
import com.google.zxing.common.BitmapUtils;

public class MainActivity extends AppCompatActivity {
    private static final int REQCODE_SCAN = 100;
    private Button btnNewZXing;
    private Button btnUseZXing;
    private EditText etContent;
    private ImageView ivCode;
    private Bitmap dCode;
    private TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etContent = findViewById(R.id.et_content);
        ivCode = findViewById(R.id.iv_code);
        tvResult = findViewById(R.id.tv_result);

        btnNewZXing = findViewById(R.id.btn_new_zxing);
        btnUseZXing = findViewById(R.id.btn_use_zxing);
        init();
    }

    private void init() {
        //生成二维码
        btnNewZXing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                genCode();
            }
        });
        //扫描二维码
        btnUseZXing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                codeResult();
            }
        });
    }
    //生成二维码
    public void genCode(){
        String content = etContent.getText().toString().trim();
        try {
            dCode = BitmapUtils.create2DCode(content);
            ivCode.setImageBitmap(dCode);

        } catch (WriterException e) {
            e.printStackTrace();
        }
    }

    public void codeResult(){
        Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
        startActivityForResult(intent,REQCODE_SCAN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /*String result = data.getStringExtra("qrcode_result");
        Toast.makeText(this, "结果"+result, Toast.LENGTH_SHORT).show();*/
        if(requestCode == REQCODE_SCAN){
            //获取二维码扫描的结果
            String result = data.getStringExtra("qrcode_result");
            tvResult.setText("扫描结果"+result);
            Toast.makeText(this, "" + result, Toast.LENGTH_LONG).show();
            //如果二维码内容是以“http://”开头的就调起浏览器打开
            if(result.contains("http://")){
                //网站：浏览器打开，隐式意图打开
        /*      <intent-filter>
            <action android:name="android.intent.action.VIEW" />
            <category android:name="android.intent.category.DEFAULT" />
            <category android:name="android.intent.category.BROWSABLE" />
            <data android:scheme="http" />
            <data android:scheme="https" />
            <data android:scheme="about" />
            <data android:scheme="javascript" />
        </intent-filter>*/

                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.setData(Uri.parse("http:" + result));
                startActivity(intent);

            }
        }
    }
}
