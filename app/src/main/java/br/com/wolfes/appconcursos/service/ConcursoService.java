package br.com.wolfes.appconcursos.service;

import java.util.List;

import br.com.wolfes.appconcursos.modelo.Concurso;
import br.com.wolfes.appconcursos.modelo.DetalheConcurso;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ConcursoService {

    @GET("concursos/{sigla_estado}/listar")
    Call<List<Concurso>> listarConcursos(@Path("sigla_estado") String sigla_estado);

    @GET("concursos/{sigla_estado}/detalhar/{url_concurso}")
    Call<DetalheConcurso> detalharConcursos(@Path("sigla_estado") String sigla_estado, @Path("url_concurso") String url_concurso);
}
