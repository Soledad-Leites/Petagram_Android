package leites.sole.petagram;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import leites.sole.petagram.adapter.MascotaAdaptador;
import leites.sole.petagram.menues.AcercaDe;
import leites.sole.petagram.menues.contactoForm;
import leites.sole.petagram.pojo.Mascotas;

public class cincoFavoritos extends AppCompatActivity {
    ArrayList<Mascotas> mascotas;
    private RecyclerView rvFavoritos;
    public MascotaAdaptador adaptador;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cinco_favoritos);

        rvFavoritos = (RecyclerView) findViewById(R.id.rvFavoritos);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvFavoritos.setLayoutManager(llm);
        inicializarListaContactos();
        inicializarAdaptador();

    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        rvFavoritos.setAdapter(adaptador);
    }

    public void inicializarListaContactos(){

        mascotas = new ArrayList<Mascotas>();

        mascotas.add(new Mascotas("Moyo", "14", R.drawable.oveja));
        mascotas.add(new Mascotas("Pipi", "12", R.drawable.pajaro));
        mascotas.add(new Mascotas("Eugenia","9", R.drawable.turtle));
        mascotas.add(new Mascotas("Helgua", "7", R.drawable.polarpolls));
        mascotas.add(new Mascotas("Fernan", "6", R.drawable.cangre));

    }

    // MENU DE OPCIONES ** ESTRELLA EN EL APPBAR ** contacto y about
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.estrellita:
                Intent intent = new Intent(this, cincoFavoritos.class);
                startActivity(intent);
                break;
            case R.id.contacto:
                Intent j = new Intent(this, contactoForm.class);
                startActivity(j);
                break;
            case R.id.acercaDe:
                Intent k = new Intent(this, AcercaDe.class);
                startActivity(k);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

