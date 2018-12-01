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
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import kunas.app.expoporto.model.Programacao;

public class ListaProgramacaoActivity extends AppCompatActivity{

    private Toolbar appToolBarProgramacao;
    private ImageView banner;
    private RecyclerView recyclerListaProgramacao;
    private ProgramacaoAdapter adapter;

    private List<Programacao> listaProgramacao = new ArrayList<Programacao>();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = MainActivity.getFirebase();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_programacao);


        appToolBarProgramacao = findViewById(R.id.app_toolbar_programacao);
        appToolBarProgramacao.setTitle(R.string.title_activity_programacao);
        setSupportActionBar(appToolBarProgramacao);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        banner = findViewById(R.id.img_banner_programacao);

        // Configurando o gerenciador de layout para ser uma lista.
        recyclerListaProgramacao = (RecyclerView) findViewById(R.id.recyclerListaProgramacao);
        adapter = new ProgramacaoAdapter(listaProgramacao,this);
        recyclerListaProgramacao.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerListaProgramacao.setLayoutManager(layoutManager);
        recyclerListaProgramacao.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        Intent intent = getIntent();
        final String dia = intent.getStringExtra("dia");
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listaProgramacao.clear();
                for (DataSnapshot data : dataSnapshot.child(dia).getChildren()){
//                    Programacao programacao = data.getValue(Programacao.class);
                    Long dt = (Long) data.child("data").getValue();
                    String h = (String) data.child("hora").getValue();
                    String t = (String) data.child("titulo").getValue();
                    String d = (String) data.child("descricao").getValue();
                    Programacao programacao = new Programacao(t,d,h,dt);
                    listaProgramacao.add(programacao);
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
        inflater.inflate(R.menu.menu_programacao, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent in = null;
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.toolbar_programacao_shows:
                in = new Intent(ListaProgramacaoActivity.this, ShowsActivity.class);
                in.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(in);
                finish();
                break;
            case R.id.toolbar_programacao_mapa:
                in = new Intent(ListaProgramacaoActivity.this, MapaActivity.class);
                in.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(in);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
