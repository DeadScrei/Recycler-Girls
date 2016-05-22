package com.appspot.bgje0341.petagram;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar bar;
    RecyclerView recyclerView;
    ArrayList<Mascota> mascotas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(bar);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        initLista();
        initAdapter();

        ArrayList<String> nombresMascotas = new ArrayList<>();
        for (Mascota mascota: mascotas){
            nombresMascotas.add(mascota.getNombre());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.iconodeBar:

                Intent intent = new Intent(this,fab_mas.class);
                for (int c=0;c<Adapter.seleccion.size();c++){
                    intent.putExtra("Imagen"+c,Adapter.seleccion.get(c).getImagen());//Imagen
                    intent.putExtra("Estrella"+c,Adapter.seleccion.get(c).getHuesoB());//Estrella
                    intent.putExtra("Corazon"+c,Adapter.seleccion.get(c).getHuesoA());//Corazon
                    intent.putExtra("Nombre"+c,Adapter.seleccion.get(c).getNombre());//Nombre
                    intent.putExtra("Like"+c,Adapter.seleccion.get(c).getLike());//Like
                }

                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void initAdapter(){
        Adapter adapter = new Adapter(mascotas);
        recyclerView.setAdapter(adapter);
    }

    public void initLista(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.girl1, R.drawable.corazones, R.drawable.estrella, "Carla", 0));
        mascotas.add(new Mascota(R.drawable.girl2, R.drawable.corazones, R.drawable.estrella, "Andrea", 0));
        mascotas.add(new Mascota(R.drawable.girl3,R.drawable.corazones, R.drawable.estrella,"Paola",0));
        mascotas.add(new Mascota(R.drawable.girl4, R.drawable.corazones, R.drawable.estrella, "Scarlet",0));
        mascotas.add(new Mascota(R.drawable.girl5, R.drawable.corazones, R.drawable.estrella, "Wendy", 0));
        mascotas.add(new Mascota(R.drawable.girl6,R.drawable.corazones, R.drawable.estrella,"Jannete",0));
        mascotas.add(new Mascota(R.drawable.girl7,R.drawable.corazones, R.drawable.estrella,"Honey",0));
        mascotas.add(new Mascota(R.drawable.girl8,R.drawable.corazones, R.drawable.estrella,"Alejandra",0));
    }

}
