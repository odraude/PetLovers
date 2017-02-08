package com.educarod.petlovers;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout sfiMiIndicadorRefresh;
    ListView lvMiLista;
    Adapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        agregarFAB();

        sfiMiIndicadorRefresh = (SwipeRefreshLayout) findViewById(R.id.sflMiIndicadorRefresh);
        lvMiLista = (ListView) findViewById(R.id.lvMiLista);

        String [] pets = getResources().getStringArray(R.array.pets);
        lvMiLista.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, pets));

        sfiMiIndicadorRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refrescandoContenido();
            }
        });

    }

    public void refrescandoContenido() {
        String [] pets = getResources().getStringArray(R.array.pets);
        lvMiLista.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, pets));
        sfiMiIndicadorRefresh.setRefreshing(false);
    }

    public void agregarFAB() {
        FloatingActionButton miFAB = (FloatingActionButton) findViewById(R.id.fabStar);
        miFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, getResources().getString(R.string.mensaje), Toast.LENGTH_SHORT).show();
                Snackbar.make(v, getResources().getString(R.string.mensaje), Snackbar.LENGTH_LONG)
                        .setAction(getResources().getString(R.string.snackbar_accion), new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Log.i("SNACKBAR", "Click en snackbar");
                                    }
                                })
                        .show();
            }
        });
    }
}
