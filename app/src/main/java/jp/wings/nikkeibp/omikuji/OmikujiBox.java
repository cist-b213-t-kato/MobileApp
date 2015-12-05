package jp.wings.nikkeibp.omikuji;

import android.media.Image;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by Etude on 2015/12/05.
 */
public class OmikujiBox {

    private ImageView imageView;
    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    private TextView textView;
    public void setTextView(TextView textView) {
        this.textView = textView;
    }

    Result result;


    Animation.AnimationListener aListener = new Animation.AnimationListener(){
        @Override
        public void onAnimationStart(Animation animation) {
        }
        @Override
        public void onAnimationEnd(Animation animation) {
            imageView.setImageResource(R.drawable.omikuji2);
            Result[] rs = Result.values();
            Random rnd = new Random();
            result = rs[rnd.nextInt(rs.length)];
            textView.setText(result.label);
        }
        @Override
        public void onAnimationRepeat(Animation animation) {
        }
    };

    public void shake(){

//        ImageView imageView = (ImageView)findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.omikuji);

        TranslateAnimation translate = new TranslateAnimation(0, 0, 0, -100);
        translate.setRepeatMode(Animation.REVERSE);
        translate.setRepeatCount(5);
        translate.setDuration(100);

        RotateAnimation rotate = new RotateAnimation(0, -36,
                imageView.getWidth()/2, imageView.getHeight()/2);
        rotate.setDuration(200);

        AnimationSet set = new AnimationSet(true);
        set.addAnimation(rotate);
        set.addAnimation(translate);

        set.setAnimationListener(aListener);

        imageView.startAnimation(set);


    }
}
