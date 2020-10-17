package leites.sole.petagram;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import leites.sole.petagram.adapter.MascotaAdaptador;
import leites.sole.petagram.adapter.PageAdapter;
import leites.sole.petagram.fragment.PerfilFragment;
import leites.sole.petagram.fragment.RecyclerViewFragment;
import leites.sole.petagram.menues.AcercaDe;
import leites.sole.petagram.menues.contactoForm;
import leites.sole.petagram.pojo.Mascotas;

public class MainActivity extends AppCompatActivity {

    //ArrayList<Mascotas> mascotas;
   // private RecyclerView rvAnimales;

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.ic_huella_negra);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();

        if(toolbar != null){
            setSupportActionBar(toolbar);
        }
        //  COPIADO Y UTILIZADO EN RECYCLERVIEWFRAGMENT
       /* rvAnimales = (RecyclerView) findViewById(R.id.rvAnimales);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvAnimales.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();*/

    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_pet);
    }
            //  COPIADO Y UTILIZADO EN RECYCLERVIEWFRAGMENT
    /*public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
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
    }*/

    // MENU DE OPCIONES ** ESTRELLA EN EL APPBAR
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