package kunas.app.expoporto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import kunas.app.expoporto.model.Programacao;

public class ShowsActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar appToolBarAgenda;
    private RecyclerView recyclerShow;
    private ProgramacaoAdapter adapter;

    private List<Programacao> listaShows = new ArrayList<Programacao>();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = MainActivity.getFirebase();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shows);

        appToolBarAgenda = findViewById(R.id.app_toolbar_agenda);
        appToolBarAgenda.setTitle(R.string.title_activity_shows);
        setSupportActionBar(appToolBarAgenda);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerShow = findViewById(R.id.recyclerShows);
        adapter = new ProgramacaoAdapter(listaShows,this);
        recyclerShow.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerShow.setLayoutManager(layoutManager);
        recyclerShow.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));


        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listaShows.clear();
                for (DataSnapshot data : dataSnapshot.child("Shows").getChildren()){
//                    Programacao programacao = data.getValue(Programacao.class);
                    Long dt = (Long) data.child("data").getValue();
                    String h = (String) data.child("hora").getValue();
                    String t = (String) data.child("banda").getValue();
                    String d = (String) data.child("descricao").getValue();
                    Programacao programacao = new Programacao(t,d,h,dt);
                    listaShows.add(programacao);
                }
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Error", "Failed to read value.", error.toException());
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_shows, menu);
        return true;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onBackPressed() {
        Intent in = new Intent(ShowsActivity.this, MainActivity.class);
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
            case R.id.toolbar_shows_programacao:
                in = new Intent(ShowsActivity.this, ProgramacaoActivity.class);
                in.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(in);
                finish();
                break;
            case R.id.toolbar_shows_mapa:
                in = new Intent(ShowsActivity.this, MapaActivity.class);
                in.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(in);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
