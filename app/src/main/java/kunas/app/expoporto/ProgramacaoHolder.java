package kunas.app.expoporto;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ProgramacaoHolder extends RecyclerView.ViewHolder{

    final TextView title;
    final TextView description;
    final TextView hora;
    final TextView data;


    public ProgramacaoHolder(@NonNull View view) {
        super(view);
        title = view.findViewById(R.id.title_textview);
        description = view.findViewById(R.id.description_textview);
        hora = view.findViewById(R.id.text_horaAdapter);
        data = view.findViewById(R.id.text_data);
    }
}
