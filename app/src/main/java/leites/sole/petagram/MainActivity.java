package leites.sole.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout swiperefresh;
    ListView lstMilista;
    Adapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        agregarFAV();

        swiperefresh = (SwipeRefreshLayout) findViewById(R.id.swiperefresh);
        lstMilista = (ListView) findViewById(R.id.lstMilista);

        String[] planetas = getResources().getStringArray(R.array.planetas);

        lstMilista.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, planetas));

        swiperefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refrescandoContenido();
            }
        });
    }

    public void refrescandoContenido(){
        String[] planetas = getResources().getStringArray(R.array.planetas);
        lstMilista.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, planetas));
        swiperefresh.setRefreshing(false);

    }

    public void agregarFAV() {
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //Toast.makeText(getBaseContext(), getResources().getString(R.string.mensaje), Toast.LENGTH_SHORT).show();
                Snackbar.make(view, getResources().getString(R.string.mensaje), Snackbar.LENGTH_LONG)
                        .setAction(getResources().getString(R.string.texto_accion), new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        })
                        .setActionTextColor(getResources().getColorStateList(R.color.colorPrimary))
                        .setBackgroundTintList(getResources().getColorStateList(R.color.colorAccent))
                        .show();
                }

        });
    }
}
