package kunas.app.expoporto.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ProgramaDAO {
    private final String TABLE_PROGRAMA = "Programa";
    private DB_Gateway gw;

    /*public ProgramaDAO(Context ctx){
        gw = DB_Gateway.getInstance(ctx);
    }


    // retorna o ID da inserção
    public long salvarItem(Programacao programacao){
        ContentValues cv = new ContentValues();
        cv.put("Titulo", programacao.getTitulo());
        cv.put("Descricao", programacao.getDescricao());
        cv.put("Data", programacao.getData());
        cv.put("Favorito", programacao.getFavorito());
        Log.d("Success", "Salvou no bd");
        return gw.getDatabase().insert(TABLE_PROGRAMA, null, cv);
    }

    // retorna a quantidade de linhas afetadas
    public int excluirItem(long id){
        return gw.getDatabase().delete(TABLE_PROGRAMA, "ID=?", new String[]{ id + "" });
    }

    public void updateItem(Programacao programacao, long id) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Titulo", programacao.getTitulo());
        contentValues.put("Descricao", programacao.getDescricao());
        contentValues.put("Data", programacao.getData());
        contentValues.put("Favorito", programacao.getFavorito());
        //String clausuaWhere = Pessoa._ID+"=?";
        //String _id = String.valueOf(id);
        //String [] argswhere = new String []  { _id };
        //bancoDados.update("pessoas", contentValues, clausuaWhere,argswhere);
        //ou assim
        String clausuaWhere = "ID="+id;
        gw.getDatabase().update("Programa", contentValues, clausuaWhere,null);
    }

    public List<Programacao> retornarTodos(){
        List<Programacao> programacao = new ArrayList<>();
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM Programa", null);
        while(cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("ID"));
            int f = cursor.getInt(cursor.getColumnIndex("Favorito"));
            String Data = cursor.getString(cursor.getColumnIndex("Data"));
            String Titulo = cursor.getString(cursor.getColumnIndex("Titulo"));
            String Descricao = cursor.getString(cursor.getColumnIndex("Descricao"));
            programacao.add(new Programacao(id,f, Titulo, Descricao, Data));
        }
        cursor.close();
        return programacao;
    }

    public void recriarTabela(){
        gw.getDatabase().execSQL("DROP TABLE Programa");
        gw.getDatabase().execSQL("CREATE TABLE Programa (ID INTEGER PRIMARY KEY AUTOINCREMENT, Favorito INTEGER, Titulo TEXT NOT NULL, Descricao TEXT, Data TEXT)");
    }*/

}