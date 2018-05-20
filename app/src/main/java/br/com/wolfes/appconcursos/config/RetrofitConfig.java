package br.com.wolfes.appconcursos.config;


import br.com.wolfes.appconcursos.service.ConcursoService;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {

    private final Retrofit retrofit;

    public RetrofitConfig() {
       retrofit =  new Retrofit.Builder().baseUrl("http://50.30.43.161:8080/ConcursosWS/")
        .addConverterFactory(JacksonConverterFactory.create())
        .build();

    }

    public ConcursoService getConcursoService(){
        return this.retrofit.create(ConcursoService.class);
    }

}
