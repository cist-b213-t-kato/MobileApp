package jp.wings.nikkeibp.omikuji;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class OmikujiActivity extends Activity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.omikuji);  //ここでlayoutディレクトリのxmlを指定する？

        //文字を表示する
        tv = (TextView) findViewById(R.id.hello_view);
        tv.setText("おみくじアプリ");

    }

    OmikujiBox omikujiBox = new OmikujiBox();

    public void onButtonClick(View v) throws InterruptedException {


        ImageView imageView = (ImageView)findViewById(R.id.imageView);
        omikujiBox.setImageView(imageView);
        omikujiBox.setTextView(tv);
        omikujiBox.shake();
//        setContentView(R.layout.fortune);
//        ImageView imageView2 = (ImageView)findViewById(R.id.imageView2);
//        imageView2.setImageResource(omikujiBox.result);
//        imageView.setImageResource(omikujiBox.result);


    }

}
