package kunas.app.expoporto;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import kunas.app.expoporto.model.Programacao;

class ProgramacaoAdapter extends RecyclerView.Adapter {

    private List<Programacao> programacaoList;
    private Context contexto;

    public ProgramacaoAdapter(List<Programacao> programacaoList, Context contexto) {
        this.programacaoList = programacaoList;
        this.contexto = contexto;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(contexto).inflate(R.layout.schedule_item_list, viewGroup, false);
        ProgramacaoHolder holder = new ProgramacaoHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int pos) {
        final ProgramacaoHolder holder = (ProgramacaoHolder) viewHolder;
        final Programacao programacao = programacaoList.get(pos);
        holder.title.setText(programacao.getTitulo());
        holder.description.setText(programacao.getDescricao());
        holder.hora.setText(programacao.getHora());
        holder.data.setText(Long.toString(programacao.getData()));

//        holder.bookmarkIcon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if ((programacao.getFavorito())==1) {
//                    holder.bookmarkIcon.setImageResource(R.mipmap.icon_favoritar_off);
//                    programacao.setFavorito(0);
//                }else {
//                    holder.bookmarkIcon.setImageResource(R.mipmap.icon_favoritar_on);
//                    programacao.setFavorito(1);
//                }
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return programacaoList.size();
    }
}
