package br.com.pan.usecase.util;

public class StringUtil {

    public static String normalize(String valor) {
        if(valor == null) {
            return null;
        }
        return valor.replaceAll("\\D", "");
    }
}
