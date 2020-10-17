package leites.sole.petagram.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import leites.sole.petagram.R;
import leites.sole.petagram.adapter.FotoAdaptador;
import leites.sole.petagram.adapter.MascotaAdaptador;
import leites.sole.petagram.pojo.Fotos;
import leites.sole.petagram.pojo.Mascotas;


public class PerfilFragment extends Fragment {
    ArrayList<Mascotas> mascotas;
    private RecyclerView rvPerfilAnimal;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable  Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container,  false);

        rvPerfilAnimal  = (RecyclerView) v.findViewById(R.id.rvPerfilAnimal);
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);
        glm.setOrientation(GridLayoutManager.VERTICAL);
        rvPerfilAnimal.setLayoutManager(glm);
        initAdaptador();
        initListaFotos();
        return v;
    }


    public void initAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        rvPerfilAnimal.setAdapter(adaptador);}



    public void initListaFotos() {
        mascotas = new ArrayList<Mascotas>();

        mascotas.add(new Mascotas("10", R.drawable.oveja));
        mascotas.add(new Mascotas("16", R.drawable.oveja2));
        mascotas.add(new Mascotas("6", R.drawable.oveja3));
        mascotas.add(new Mascotas("21", R.drawable.oveja4));
        mascotas.add(new Mascotas("3", R.drawable.oveja5));

    }

}