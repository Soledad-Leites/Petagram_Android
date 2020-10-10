package leites.sole.petagram;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascotas> mascotas;
    private RecyclerView rvAnimales;
    public MascotaAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvAnimales = (RecyclerView) findViewById(R.id.rvAnimales);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvAnimales.setLayoutManager(llm);
        inicializarListaContactos();
        inicializarAdaptador();

    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        rvAnimales.setAdapter(adaptador);
    }

    public void inicializarListaContactos(){

        mascotas = new ArrayList<Mascotas>();

        mascotas.add(new Mascotas("Lolo", "2", R.drawable.tuki));
        mascotas.add(new Mascotas("Eugenia","9", R.drawable.turtle));
        mascotas.add(new Mascotas("Fernan", "6", R.drawable.cangre));
        mascotas.add(new Mascotas("Georgia","1", R.drawable.pez));
        mascotas.add(new Mascotas("Helgua", "7", R.drawable.polarpolls));
        mascotas.add(new Mascotas("Pipi", "12", R.drawable.pajaro));
        mascotas.add(new Mascotas("Moyo", "14", R.drawable.oveja));
    }

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
        }
        return super.onOptionsItemSelected(item);
    }
}