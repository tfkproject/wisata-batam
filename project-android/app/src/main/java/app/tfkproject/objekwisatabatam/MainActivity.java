package app.tfkproject.objekwisatabatam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout lyPariwisata, lyTentang, lyProfil, lyEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lyPariwisata = (LinearLayout) findViewById(R.id.pariwisata);
        lyPariwisata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ObjekWisataActivity.class);
                startActivity(intent);
            }
        });

        lyEvent = (LinearLayout) findViewById(R.id.event);
        lyEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EventActivity.class);
                startActivity(intent);
            }
        });

        lyProfil = (LinearLayout) findViewById(R.id.profil);
        lyProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ProfilActivity.class);
                startActivity(intent);
            }
        });

        lyTentang = (LinearLayout) findViewById(R.id.tentang);
        lyTentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TentangActivity.class);
                startActivity(intent);
            }
        });
    }
}
