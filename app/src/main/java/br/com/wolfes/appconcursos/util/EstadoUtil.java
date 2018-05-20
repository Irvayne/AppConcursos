package br.com.wolfes.appconcursos.util;

import java.util.Arrays;
import java.util.List;

import br.com.wolfes.appconcursos.modelo.Estado;

public class EstadoUtil {

    public static List<Estado> listarEstados(){
        return Arrays.asList(new Estado("pi", "Piauí"),
                new Estado("ma", "Maranhão"),
                new Estado("ce", "Ceará"),
                new Estado("sp", "São Paulo"),
                new Estado("rj", "Rio de Janeiro"),
                new Estado("rs", "Rio Grande do Sul"),
                new Estado("mg", "Minas Gerais"),
                new Estado("ba", "Bahia"),
                new Estado("am", "Amazonas")
        );
    }
}
