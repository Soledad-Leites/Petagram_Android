package leites.sole.petagram;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class DetalleMascota extends AppCompatActivity {


    private TextView tvHuesoBlanco;
    private TextView tvHuesoAmarillo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_mascota);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miToolbar);
        setSupportActionBar(miActionBar);

        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString(getResources().getString(R.string.pnombre));
       // int imagen = parametros.getInt(getResources().getDrawable(R.string.ptelefono));
        String favorito = parametros.getString(getResources().getString(R.string.pfavorito));


        tvHuesoBlanco = (TextView) findViewById(R.id.tvHuesoBlanco);
        tvHuesoAmarillo = (TextView) findViewById(R.id.tvHuesoAmarillo);


        tvHuesoBlanco.setText(nombre);
        tvHuesoAmarillo.setText(favorito);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(DetalleMascota.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }
}
