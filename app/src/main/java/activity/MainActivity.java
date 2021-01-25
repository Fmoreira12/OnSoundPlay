package activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


import com.example.onsoundplay.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                AbrirclasseTrack();
            }
        }, 5000);

    }

    private void AbrirclasseTrack() {
        Intent i  = new Intent(MainActivity.this, Track.class);
        startActivity(i);
        finish();
    }


}