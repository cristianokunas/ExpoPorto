package kunas.app.expoporto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import kunas.app.expoporto.model.Programacao;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button imgBtn_programacao;
    private Button imgBtn_agenda;
    private Button imgBtn_mapa;
    private static DatabaseReference myRef;
    private List<Programacao> listaProgramacao = new ArrayList<Programacao>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getFirebase();
        myRef.keepSynced(true);

        imgBtn_programacao = findViewById(R.id.imgBtn_programacao);
        imgBtn_agenda = findViewById(R.id.imgBtn_agenda);
        imgBtn_mapa = findViewById(R.id.imgBtn_mapa);

//
//        ProgramaDAO dao = new ProgramaDAO(this);
//
//        dao.salvarItem(criaP(0,0,"aqui1","bbb", "15/03"));
//        dao.salvarItem(criaP(1,0,"mudou2","bbb", "15/03"));
//        dao.salvarItem(criaP(2,0,"aaa","bbb", "15/03"));
//        dao.salvarItem(criaP(3,0,"aaa","bbb", "16/03"));
//        dao.salvarItem(criaP(4,0,"aaa","bbb", "16/03"));
//        dao.salvarItem(criaP(5,0,"aaa","bbb", "16/03"));
//        dao.salvarItem(criaP(6,0,"aaa","bbb", "17/03"));
//        dao.salvarItem(criaP(7,0,"aaa","bbb", "17/03"));
//        dao.salvarItem(criaP(8,0,"aaa","bbb", "17/03"));
//


    }

   /* private void writeNewUser(int userId,int f, String titulo, String descricao, String data) {
        Programacao p = new Programacao(userId,f, titulo, descricao, data);

        myRef.child("users").child(String.valueOf(userId)).setValue(p);
    }*/

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imgBtn_programacao:
                Intent intentProgramacao = new Intent(MainActivity.this, ProgramacaoActivity.class);
                startActivity(intentProgramacao);
                break;
            case R.id.imgBtn_agenda:
                Intent intentAgenda = new Intent(MainActivity.this, ShowsActivity.class);
                startActivity(intentAgenda);
                break;
            case R.id.imgBtn_mapa:
                Intent intentMapa = new Intent(MainActivity.this, MapaActivity.class);
                startActivity(intentMapa);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    public static DatabaseReference getFirebase(){
        if( myRef == null ){
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
            Log.d("success", "abilitou offline");
            myRef = FirebaseDatabase.getInstance().getReference("Programacao");
        }
        return( myRef );
    }


   /* public Programacao criaP(int i,int f, String t, String d, String data){
        Programacao p = new Programacao(i,f, t, d, data);
        myRef.child("users").child(String.valueOf(i)).setValue(p);

        return p;
    }*/
}
