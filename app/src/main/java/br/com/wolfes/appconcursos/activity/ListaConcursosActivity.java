package br.com.wolfes.appconcursos.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.wolfes.appconcursos.R;
import br.com.wolfes.appconcursos.config.RetrofitConfig;
import br.com.wolfes.appconcursos.modelo.Concurso;
import br.com.wolfes.appconcursos.modelo.Estado;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaConcursosActivity extends AppCompatActivity {

    List<Concurso> concursos = new ArrayList<>();
    ListView listaConcursos;
    Estado estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_concursos);

        Intent intent = getIntent();
        estado = (Estado) intent.getSerializableExtra("estado");
        //Log.e("Estado", estado.toString());
        Call<List<Concurso>> call = new RetrofitConfig().getConcursoService().listarConcursos(estado.getSigla());
        call.enqueue(new Callback<List<Concurso>>() {
            @Override
            public void onResponse(Call<List<Concurso>> call, Response<List<Concurso>> response) {
                concursos = response.body();
                listaConcursos = findViewById(R.id.lista_concursos);
                ArrayAdapter<Concurso> adapter = new ArrayAdapter<>(ListaConcursosActivity.this, android.R.layout.simple_list_item_1, concursos);
                listaConcursos.setAdapter(adapter);

                listaConcursos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> lista, View item, int position, long id) {
                        Concurso concurso = (Concurso) listaConcursos.getItemAtPosition(position);

                        Intent intent = new Intent(ListaConcursosActivity.this, DetalheConcursoActivity.class);
                        intent.putExtra("concurso", concurso);
                        startActivity(intent);
                    }
                });

            }

            @Override
            public void onFailure(Call<List<Concurso>> call, Throwable t) {
                Toast.makeText(ListaConcursosActivity.this, "Problema na conexão com a internet!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
