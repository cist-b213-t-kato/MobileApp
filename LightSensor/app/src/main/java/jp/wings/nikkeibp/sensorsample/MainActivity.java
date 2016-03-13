package jp.wings.nikkeibp.sensorsample;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    private TextView values;
    private SensorManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        
        values = (TextView)findViewById(R.id.view);
        manager = (SensorManager)getSystemService(SENSOR_SERVICE);
        
    }

    @Override
    protected void onResume() {
        super.onResume();
        List<Sensor> sensors = manager.getSensorList(Sensor.TYPE_LIGHT);
        if(sensors.size() > 0) {
            Sensor s = sensors.get(0);
            manager.registerListener(this, s, SensorManager.SENSOR_DELAY_UI);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        String str = "照度:" + event.values[0];
        values.setText(str);

        //同Windowのときだけ画面の輝度を設定する
        //他のタスク？に切り替えると元に戻っちゃう
//        WindowManager.LayoutParams lp = getWindow().getAttributes();
//        lp.screenBrightness = 1.0f;
//        getWindow().setAttributes(lp);


        float sensorValue = Float.valueOf(event.values[0]);
        int value = 0;    // 0〜255の値を設定

        if(sensorValue > 500.0){
            //どんな明るくても200くらいあれば良さそう？
            value = 200;
        }else if(sensorValue > 300.0){
            value = 150;
        }

        //システム設定の画面の輝度を設定する
        Settings.System.putInt(getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, value);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
