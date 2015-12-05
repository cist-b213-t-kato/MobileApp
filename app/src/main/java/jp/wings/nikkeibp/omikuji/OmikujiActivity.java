package jp.wings.nikkeibp.omikuji;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class OmikujiActivity extends Activity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.omikuji);  //ここでxmlのレイアウトを指定する？

        //文字を表示する
        tv = (TextView) findViewById(R.id.hello_view);
        tv.setText("おみくじアプリ");

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setTitle("おみくじ");

//        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }


    public void onButtonClick(View v) throws InterruptedException {

//        String[] strList = { "大吉", "吉", "凶" };

//        Random rnd = new Random();

//        String str = strList[rnd.nextInt(strList.length)];

        //文字を表示する
//        TextView tv = (TextView) findViewById(R.id.hello_view);
//        tv.setText(str+"です");

//        ImageView image = new ImageView(this);
//        image.setImageResource(Result.values()[rnd.nextInt(Result.values().length)].type);
//        setContentView(image);


        OmikujiBox omikujiBox = new OmikujiBox();
        ImageView imageView = (ImageView)findViewById(R.id.imageView);
        omikujiBox.setImageView(imageView);
        omikujiBox.setTextView(tv);
        omikujiBox.shake();
//        setContentView(R.layout.fortune);
//        ImageView imageView2 = (ImageView)findViewById(R.id.imageView2);
//        imageView2.setImageResource(omikujiBox.result);
//        imageView.setImageResource(omikujiBox.result);


    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_omikuji, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
