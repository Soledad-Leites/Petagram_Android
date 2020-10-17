package leites.sole.petagram.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import leites.sole.petagram.R;
import leites.sole.petagram.pojo.Mascotas;

public class FotoAdaptador extends RecyclerView.Adapter<FotoAdaptador.FotoViewHolder> {

    ArrayList<Mascotas> foto;
    Activity activity;

    public FotoAdaptador(ArrayList<Mascotas> foto, Activity activity){
        this.foto = foto;
        this.activity = activity;
    }

    @NonNull
    @Override
    public FotoAdaptador.FotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listado_mascotas, parent, false);
        return new FotoAdaptador.FotoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FotoAdaptador.FotoViewHolder holder, int position) {
        Mascotas mascotas = foto.get(position);
        holder.imgFoto.setImageResource(mascotas.getImagen());
        holder.tvHuesoAmarillo.setText(mascotas.getFavorito());
    }


    @Override
    public int getItemCount() {
        return foto.size();
    }

    public static class FotoViewHolder extends RecyclerView.ViewHolder{

        private AppCompatImageView imgFoto;
        private AppCompatTextView tvHuesoAmarillo;

        public FotoViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto         = (AppCompatImageView) itemView.findViewById(R.id.imgFoto);
            tvHuesoAmarillo    = (AppCompatTextView) itemView.findViewById(R.id.tvHuesoAmarillo);
        }
    }
}
