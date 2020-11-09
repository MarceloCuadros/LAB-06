package com.example.pracasynctaskrv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText mInputLibro;
    private TextView mTextoTitulo;
    private TextView mTextoAutor;

    private TextView txtTituloLibro;
    private TextView txtAutorLibro;
    private TextView txtAnioLibro;
    private TextView txtDescripcionLibro;
    private ImageView ImgLibro;

    public static List<libro> libros;

    private void initializaData() {
        libros = new ArrayList<>();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInputLibro = (EditText)findViewById(R.id.ingresoLibro);


        txtTituloLibro = (TextView)findViewById(R.id.txtTituloLibro);
        txtAutorLibro = (TextView)findViewById(R.id.txtAutorLibro);
        txtAnioLibro = (TextView)findViewById(R.id.txtAnioLibro);
        txtDescripcionLibro = (TextView)findViewById(R.id.txtDescripcionLibro);
        ImgLibro = (ImageView) findViewById(R.id.imgLibro);

        initializaData();

        final RecyclerView rv = (RecyclerView)findViewById(R.id.RvLibros);
        rv.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setStackFromEnd(false);
        rv.setLayoutManager(linearLayoutManager);

        RvAdapter rvAdapter = new RvAdapter(libros, this);

        rvAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), libroDetalle.class);
                intent.putExtra("titulo", libros.get(rv.getChildAdapterPosition(v)).titulo);
                intent.putExtra("autor", libros.get(rv.getChildAdapterPosition(v)).autor);
                intent.putExtra("anio", libros.get(rv.getChildAdapterPosition(v)).anio);
                intent.putExtra("descripcion", libros.get(rv.getChildAdapterPosition(v)).descripcion);
                startActivity(intent);
            }
        });

        rv.setAdapter(rvAdapter);

    }

    public void buscarLibro(View view){
        if(mInputLibro.getText().toString().equals("")){
            libros.clear();
        }
        else {
            String cadenaBusqueda = mInputLibro.getText().toString();
            new conseguirLibro(txtTituloLibro, txtAutorLibro, txtAnioLibro, txtDescripcionLibro).execute(cadenaBusqueda);
            super.onRestart();
        }
    }

}
