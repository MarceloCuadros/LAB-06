package com.example.pracasynctaskrv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class libroDetalle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libro_detalle);

        String titulo ="";
        String autor ="";
        String anio ="";
        String descripcion ="";

        Bundle extras = getIntent().getExtras();
        if (extras !=null){
            titulo = extras.getString("titulo");
            autor = extras.getString("autor");
            anio = extras.getString("anio");
            descripcion = extras.getString("descripcion");
        }

        TextView txttitulo = (TextView)findViewById(R.id.txttitulo);
        TextView txtautor= (TextView)findViewById(R.id.txtautor);
        TextView txtanio = (TextView)findViewById(R.id.txtanio);
        TextView txtdescripcion = (TextView)findViewById(R.id.txtdescripcion);

        txttitulo.setText("Titulo: "+titulo);
        txtautor.setText("Autor: "+autor);
        txtanio.setText("Fecha: "+anio);
        txtdescripcion.setText(descripcion);

    }
}
