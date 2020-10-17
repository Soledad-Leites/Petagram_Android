package leites.sole.petagram.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import leites.sole.petagram.pojo.Mascotas;
import leites.sole.petagram.R;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    ArrayList<Mascotas> mascotas;
   //
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascotas> mascotas, Activity activity){ //METODO CONSTRUCTOR
        this.mascotas = mascotas;
        this.activity = activity;
        //this.foto = foto;
    }

    @NonNull
    @Override //INFLA ELLAYOUT Y LO PASARA AL VIEWHOLDER PARA QUE OBTENGA LOS DATOS SOLICITADOS EN EL METODO onBindViewHolder
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listado_mascotas, parent, false);
        return new MascotaViewHolder(v);
    }

   /* */

    @Override //ASOCIA CADA ELEMENTO DE LA LISTA CON CADA VIEW
    public void onBindViewHolder(@NonNull final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascotas mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getImagen());
        mascotaViewHolder.tvHuesoBlanco.setText(mascota.getNombre());
        mascotaViewHolder.tvHuesoAmarillo.setText(mascota.getFavorito());
        mascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a " + mascota.getNombre(),
                        Toast.LENGTH_SHORT).show();

            }
        });
        /*mascotaViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, mascota.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, DetalleMascota.class);
                intent.putExtra("nombre", mascota.getNombre());
                intent.putExtra("imagen", mascota.getImagen());
                intent.putExtra("favorito", mascota.getFavorito());
                activity.startActivity(intent);
            }
        });*/
    }

    @Override
    public int getItemCount() { //CANTIDAD DE ELEMENTOS QUE CONTIENE MI LISTA DE CONTACTOS
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private AppCompatImageView imgFoto;
        private AppCompatTextView tvHuesoBlanco;
        private AppCompatTextView tvHuesoAmarillo;
        private AppCompatImageButton btnLike;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto         = (AppCompatImageView) itemView.findViewById(R.id.imgFoto);
            tvHuesoBlanco      = (AppCompatTextView) itemView.findViewById(R.id.tvHuesoBlanco);
            tvHuesoAmarillo    = (AppCompatTextView) itemView.findViewById(R.id.tvHuesoAmarillo);
            btnLike         = (AppCompatImageButton) itemView.findViewById(R.id.btnLike);

        }
    }

   /* public static class FotoViewHolder extends RecyclerView.ViewHolder{
        private AppCompatTextView tvHuesoBlanco;


        public FotoViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }*/
}
