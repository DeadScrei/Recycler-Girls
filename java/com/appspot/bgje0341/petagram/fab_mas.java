package com.appspot.bgje0341.petagram;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class fab_mas extends AppCompatActivity {

    Toolbar bar;
    RecyclerView recyclerView;
    ArrayList<Mascota> mascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fab_mas);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) // Habilitar up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);


        Bundle bundle = getIntent().getExtras();
        ArrayList<Mascota> count = new ArrayList<Mascota>();

        for (int c=0;c<5;c++){
            //initListaFab(new Mascota(Adapter.seleccion.get(c).getImagen(),Adapter.seleccion.get(c).getHuesoB(),Adapter.seleccion.get(c).getHuesoA(),Adapter.seleccion.get(c).getNombre(),Adapter.seleccion.get(c).getLike()));
            count.add(new Mascota(bundle.getInt("Imagen" + c),
                    bundle.getInt("Estrella" + c),
                    bundle.getInt("Corazon"+c),
                    bundle.getString("Nombre"+c),
                    bundle.getInt("Like"+c)));
        }
        initListaFab(count);
        initAdapter();
        //Snackbar.make(recyclerView, "Favoritas", Snackbar.LENGTH_SHORT).show();
        Snackbar.make(recyclerView,"Tus primeras "+Adapter.seleccion.size()+" Favoritas",Snackbar.LENGTH_SHORT).show();

    }

    public void initAdapter(){
        Adapter adapter = new Adapter(mascotas);
        recyclerView.setAdapter(adapter);
    }

    public void initListaFab(ArrayList<Mascota> mascota){
        mascotas = new ArrayList<Mascota>();
        for(int c=0;c<mascota.size();c++){
            mascotas.add(mascota.get(c));
        }
        //mascotas.add(new Mascota(R.drawable.girl4, R.drawable.corazones, R.drawable.estrella, "Scarlet", 0));
    }

}
