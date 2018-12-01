package kunas.app.expoporto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ProgramacaoActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView imgLogo;
    private ImageView img_banner;
    private Button imgBtn_dia1;
    private Button imgBtn_dia2;
    private Button imgBtn_dia3;

    private Toolbar appToolBarProgramacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programacao);

        imgLogo = findViewById(R.id.imgLogo);
        img_banner = findViewById(R.id.img_banner);
        imgBtn_dia1 = findViewById(R.id.imgBtn_dia1);
        imgBtn_dia2 = findViewById(R.id.imgBtn_dia2);
        imgBtn_dia3 = findViewById(R.id.imgBtn_dia3);

        appToolBarProgramacao = findViewById(R.id.app_toolbar_programacao);
        appToolBarProgramacao.setTitle(R.string.title_activity_programacao);
        setSupportActionBar(appToolBarProgramacao);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public void onClick(View view) {
        Intent in = null;
        String dia;
        switch (view.getId()){
            case R.id.imgBtn_dia1:
                dia = "Dia 15-03";
                in = new Intent(ProgramacaoActivity.this, ListaProgramacaoActivity.class);
                in.putExtra("dia", dia);
                startActivity(in);
                break;
            case R.id.imgBtn_dia2:
                dia = "Dia 16-03";
                in = new Intent(ProgramacaoActivity.this, ListaProgramacaoActivity.class);
                in.putExtra("dia", dia);
                startActivity(in);
                break;
            case R.id.imgBtn_dia3:
                dia = "Dia 17-03";
                in = new Intent(ProgramacaoActivity.this, ListaProgramacaoActivity.class);
                in.putExtra("dia", dia);
                startActivity(in);
                break;
        }
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
                finish();
                return true;
            case R.id.toolbar_programacao_shows:
                in = new Intent(ProgramacaoActivity.this, ShowsActivity.class);
                startActivity(in);
                finish();
                break;
            case R.id.toolbar_programacao_mapa:
                in = new Intent(ProgramacaoActivity.this, MapaActivity.class);
                startActivity(in);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
