package leites.sole.petagram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Mascotas {
    private String nombre;
    private String favorito;
    private int imagen;

    public Mascotas(String nombre, String favorito, int imagen) {
        this.nombre = nombre;
        this.favorito = favorito;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFavorito() {
        return favorito;
    }

    public void setFavorito(String favorito) {
        this.favorito = favorito;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}