package leites.sole.petagram.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import leites.sole.petagram.R;
import leites.sole.petagram.adapter.MascotaAdaptador;
import leites.sole.petagram.pojo.Mascotas;

public class RecyclerViewFragment extends Fragment {
    ArrayList<Mascotas> mascotas;
    private RecyclerView rvAnimales;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
       // return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_rv, container, false);

        rvAnimales = (RecyclerView) v.findViewById(R.id.rvAnimales);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvAnimales.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();

        return v;
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        rvAnimales.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){

        mascotas = new ArrayList<Mascotas>();

        mascotas.add(new Mascotas("Lolo", "2", R.drawable.tuki));
        mascotas.add(new Mascotas("Eugenia","9", R.drawable.turtle));
        mascotas.add(new Mascotas("Fernan", "6", R.drawable.cangre));
        mascotas.add(new Mascotas("Georgia","1", R.drawable.pez));
        mascotas.add(new Mascotas("Helgua", "7", R.drawable.polarpolls));
        mascotas.add(new Mascotas("Pipi", "12", R.drawable.pajaro));
        mascotas.add(new Mascotas("Moyo", "14", R.drawable.oveja));
    }
}
