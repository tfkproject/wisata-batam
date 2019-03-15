package app.tfkproject.objekwisatabatam;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import app.tfkproject.objekwisatabatam.model.ItemObjekWisata;

public class ObjekDetailActivity extends AppCompatActivity implements OnMapReadyCallback {

    private MapView mapView;
    private ImageView imageView;
    private TextView txtNama, txtLokasi, txtDesk;
    private Button tombolPeta;

    private static final String MAP_VIEW_BUNDLE_KEY = "MapViewBundleKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objek_detail);

        //String id_wisata = getIntent().getStringExtra("key_id");
        final String nama = getIntent().getStringExtra("key_nama");
        String gambar = getIntent().getStringExtra("key_gambar");
        final String lokasi = getIntent().getStringExtra("key_lokasi");
        String deskripsi = getIntent().getStringExtra("key_deskripsi");

        getSupportActionBar().setTitle(nama);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mapView = (MapView) findViewById(R.id.mapview);

        Bundle mapViewBundle = null;
        if (savedInstanceState != null) {
            mapViewBundle = savedInstanceState.getBundle(MAP_VIEW_BUNDLE_KEY);
        }

        mapView = findViewById(R.id.mapview);
        mapView.onCreate(mapViewBundle);
        mapView.getMapAsync(this);

        imageView = (ImageView) findViewById(R.id.img);
        txtNama = (TextView) findViewById(R.id.txt_nama);

        txtLokasi = (TextView) findViewById(R.id.txt_lokasi);
        txtDesk = (TextView) findViewById(R.id.txt_desk);

        txtNama.setText(nama);
        txtLokasi.setText(lokasi);
        txtDesk.setText(deskripsi);
        Glide.with(ObjekDetailActivity.this).load(gambar).into(imageView);

        final String latitude = getIntent().getStringExtra("key_lat");
        final String longitude = getIntent().getStringExtra("key_long");

        tombolPeta = (Button) findViewById(R.id.btn_direction);
        tombolPeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ObjekDetailActivity.this, MapsActivity.class);
                intent.putExtra("key_nama_tujuan", nama);
                intent.putExtra("key_lokasi_tujuan", lokasi);
                intent.putExtra("key_lat_tujuan", latitude);
                intent.putExtra("key_long_tujuan", longitude);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap map) {

        String latitude = getIntent().getStringExtra("key_lat");
        String longitude = getIntent().getStringExtra("key_long");

        double lat = Double.valueOf(latitude);
        double lng = Double.valueOf(longitude);

        map.addMarker(new MarkerOptions().position(new LatLng(lat, lng)));

        LatLng coords = new LatLng(lat, lng);
        map.addMarker(new MarkerOptions().position(coords));
        map.setMinZoomPreference(16);
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(coords, 10f);
        map.moveCamera(cameraUpdate);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Bundle mapViewBundle = outState.getBundle(MAP_VIEW_BUNDLE_KEY);
        if (mapViewBundle == null) {
            mapViewBundle = new Bundle();
            outState.putBundle(MAP_VIEW_BUNDLE_KEY, mapViewBundle);
        }

        mapView.onSaveInstanceState(mapViewBundle);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }
    @Override
    protected void onPause() {
        mapView.onPause();
        super.onPause();
    }
    @Override
    protected void onDestroy() {
        mapView.onDestroy();
        super.onDestroy();
    }
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
}
