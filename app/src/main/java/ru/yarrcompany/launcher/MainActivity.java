package ru.yarrcompany.launcher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView dateview = findViewById(R.id.date);
        long date = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MMMyyy");
        String dateString = sdf.format(date);
        dateview.setText(dateString);
        this.registerReceiver(this.mBatInfoReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        ImageView imageButton30 = findViewById(R.id.imageView3);
        TextView batteryTxt = findViewById(R.id.batteryTxt1);

    }
    private BroadcastReceiver mBatInfoReceiver = new BroadcastReceiver(){

        @Override
        public void onReceive(Context ctxt, Intent intent) {
            ImageView imageButton30 = findViewById(R.id.imageView3);
            TextView batteryTxt = findViewById(R.id.batteryTxt1);
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
            batteryTxt.setText(String.valueOf(level) + "%");
            if(level > 90)
                imageButton30.setImageResource(R.drawable.ic_heart_fill);
            else if (level > 80)
                imageButton30.setImageResource(R.drawable.ic_heart_fill);
            else if(level > 70)
                imageButton30.setImageResource(R.drawable.ic_heart_fill);
            else if(level > 60)
                imageButton30.setImageResource(R.drawable.ic_heart_half);
            else if(level > 50)
                imageButton30.setImageResource(R.drawable.ic_heart_half);
            else if(level > 35)
                imageButton30.setImageResource(R.drawable.ic_heart_half);
            else if(level > 20)
                imageButton30.setImageResource(R.drawable.ic_heart_half);
            else if(level > 5)
                imageButton30.setImageResource(R.drawable.ic_heart_empty);
            else if(level > 2)
                imageButton30.setImageResource(R.drawable.ic_heart_empty);
            else
                imageButton30.setImageResource(R.drawable.ic_heart_empty);
        }
    };
    public void all(View view){
        Intent intent = new Intent(this, AppsListActivity.class);
        startActivity(intent);
    }
    public void settings(View view){
        Intent LaunchIntent =getPackageManager().getLaunchIntentForPackage("com.android.settings");
        startActivity(LaunchIntent);
    }
    public void phone(View view){
        Intent LaunchIntent =getPackageManager().getLaunchIntentForPackage("com.google.android.dialer");
        startActivity(LaunchIntent);
    }
    public void contacts(View view){
        Intent LaunchIntent =getPackageManager().getLaunchIntentForPackage("com.google.android.contacts");
        startActivity(LaunchIntent);
    }
    public void telega(View view){
        Intent LaunchIntent =getPackageManager().getLaunchIntentForPackage("org.telegram.messenger");
        startActivity(LaunchIntent);
    }
    public void chrome(View view){
        Intent LaunchIntent =getPackageManager().getLaunchIntentForPackage("com.android.chrome");
        startActivity(LaunchIntent);
    }
    public void camera(View view){
        Intent LaunchIntent =getPackageManager().getLaunchIntentForPackage("com.google.android.apps.cameralite");
        startActivity(LaunchIntent);
    }
    public void gallery(View view){
        Intent LaunchIntent =getPackageManager().getLaunchIntentForPackage("com.google.android.apps.photosgo");
        startActivity(LaunchIntent);
    }
    public void sms (View view){
        Intent LaunchIntent =getPackageManager().getLaunchIntentForPackage("com.google.android.apps.messaging");
        startActivity(LaunchIntent);
    }
    public void clock(View view){
        Intent LaunchIntent =getPackageManager().getLaunchIntentForPackage("com.google.android.deskclock");
        startActivity(LaunchIntent);
    }



    @Override
    protected void onDestroy() {
        this.unregisterReceiver(this.mBatInfoReceiver);
        super.onDestroy();
    }

}
