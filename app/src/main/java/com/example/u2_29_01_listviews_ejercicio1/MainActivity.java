package com.example.u2_29_01_listviews_ejercicio1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Declarar los elementos o vistas con los que voy a trabajar
    ListView lvCiudades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Identificando vistas
        lvCiudades=(ListView)findViewById(R.id.ListaCiudades);

        //Datos a mostrar en el ListView
        String[] ciudades = {"Cádiz","Málaga","Sevilla","Almería","Jaen","Córdoba","Granada",
                               "Huesca", "Badalona", "Pernambuco", "Sebastopol", "Hospitaled de Llobregat",
                                "Theed", "Coruscant"};

        //Creamos el ADAPTADOR

        ArrayAdapter<String> adaptador=new ArrayAdapter<String>(this,
        android.R.layout.simple_list_item_1,ciudades);

        //Añadir el adaptardor al ListView
        lvCiudades.setAdapter(adaptador);

        //Añadir el evento
        lvCiudades.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(),"Has pulsado un item", Toast.LENGTH_LONG).show();

                String ciudad_seleccionada = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),"Has pulsado "+ciudad_seleccionada, Toast.LENGTH_LONG).show();

            }
        });

        //Añadir el evento click largo
        lvCiudades.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return true;
            }
        });

        lvCiudades.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                String ciudad_seleccionada = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),"Pulsaste Largo "+ciudad_seleccionada, Toast.LENGTH_LONG).show();

                return true;
            }
        });


    }//FIN OnCreate


}//Fin Activity
