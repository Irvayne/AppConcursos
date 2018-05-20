package br.com.wolfes.appconcursos.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.com.wolfes.appconcursos.R;
import br.com.wolfes.appconcursos.config.RetrofitConfig;
import br.com.wolfes.appconcursos.modelo.Concurso;
import br.com.wolfes.appconcursos.modelo.DetalheConcurso;
import br.com.wolfes.appconcursos.modelo.Estado;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetalheConcursoActivity extends AppCompatActivity {

    Concurso concurso;
    DetalheConcurso detalheConcurso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_concurso);

        Intent intent = getIntent();
        concurso = (Concurso) intent.getSerializableExtra("concurso");



        Call<DetalheConcurso> call = new RetrofitConfig().getConcursoService().detalharConcursos(concurso.getSigla_estado(), concurso.getUrl_detalhe());
        call.enqueue(new Callback<DetalheConcurso>() {
            @Override
            public void onResponse(Call<DetalheConcurso> call, Response<DetalheConcurso> response) {
                detalheConcurso = response.body();

                if(detalheConcurso!=null) {
                    if (detalheConcurso.getTitulo() != null) {
                        TextView titulo = findViewById(R.id.text_titulo);
                        titulo.setText(detalheConcurso.getTitulo());
                    }

                    if (detalheConcurso.getSubtitulo() != null) {
                        TextView subtitulo = findViewById(R.id.text_subtitulo);
                        subtitulo.setText(detalheConcurso.getSubtitulo());
                    }

                    if (detalheConcurso.getConteudo() != null) {
                        TextView conteudo = findViewById(R.id.text_conteudo);
                        conteudo.setText(detalheConcurso.getConteudo());
                    }
                }else{
                    Toast.makeText(DetalheConcursoActivity.this,"Problema no carregamento das informações do concurso selecionado", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DetalheConcurso> call, Throwable t) {
                Toast.makeText(DetalheConcursoActivity.this, "Problema na conexão com a internet!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
