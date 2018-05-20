package br.com.wolfes.appconcursos.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import br.com.wolfes.appconcursos.R;
import br.com.wolfes.appconcursos.modelo.Estado;
import br.com.wolfes.appconcursos.util.EstadoUtil;

public class ListaEstadosActivity extends AppCompatActivity {

    ListView listaEstados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_estados);

        listaEstados = findViewById(R.id.lista);

        ArrayAdapter<Estado> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, EstadoUtil.listarEstados());

        listaEstados.setAdapter(adapter);

        listaEstados.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> lista, View item, int position, long id) {
                Estado estado = (Estado) listaEstados.getItemAtPosition(position);

                //Toast.makeText(ListaEstadosActivity.this, estado.toString(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ListaEstadosActivity.this, ListaConcursosActivity.class);
                intent.putExtra("estado", estado);
                startActivity(intent);
            }
        });
    }
}
