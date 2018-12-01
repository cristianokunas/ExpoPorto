package kunas.app.expoporto;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapaActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Toolbar appToolbarMapa;
    private Button botaoRota;
//    private String urlPavilhao = "https://www.google.com.br/maps/place/Centro+Municipal+De+Esporte+E+Lazer/@-27.7314045,-54.9012115,333m/data=!3m1!1e3!4m12!1m6!3m5!1s0x0:0xa89cba1f2179e0da!2sCentro+Municipal+De+Esporte+E+Lazer!8m2!3d-27.731517!4d-54.9003942!3m4!1s0x0:0xa89cba1f2179e0da!8m2!3d-27.731517!4d-54.9003942";
    private String urlPavilhao = "geo:0,0?q=-27.7316709,-54.9002709(Centro Municipal de Esportes e Lazer)";
//    private String urlPavilhao = "https://plus.codes/739X+9R Porto Vera Cruz, RS";
//    private String urlPavilhao = "google.streetview:cbll=-27.7315186,-54.9003915";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        botaoRota = findViewById(R.id.tracaRota);
        appToolbarMapa = findViewById(R.id.app_toolbar_mapa);
        appToolbarMapa.setTitle(R.string.title_activity_mapa);
        setSupportActionBar(appToolbarMapa);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        botaoRota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Display a label at the location of Google's Sydney office
                Uri gmmIntentUri = Uri.parse(urlPavilhao);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_mapa, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        Intent in = new Intent(MapaActivity.this, MainActivity.class);
        in.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(in);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent in = null;
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                finish();
                return true;
            case R.id.toolbar_mapa_shows:
                in = new Intent(MapaActivity.this, ShowsActivity.class);
                in.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(in);
                finish();
                break;
            case R.id.toolbar_mapa_programacao:
                in = new Intent(MapaActivity.this, ProgramacaoActivity.class);
                in.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(in);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        LatLng pavilhaofeira = new LatLng(-27.7315186, -54.9003915);
        Marker marker = mMap.addMarker(
                new MarkerOptions().position(pavilhaofeira).
                        title("Centro Municipal de Esportes e Lazer").
                        snippet("R. Humaitá, 335"));

        marker.showInfoWindow();
        mMap.moveCamera(CameraUpdateFactory.newLatLng(pavilhaofeira));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(17.0f));

    }
}
