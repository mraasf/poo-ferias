package poo.collections;

import java.util.*;

public class Factory {
    public static Collection create(String str) {
        if (isNumeric(str)) {
            Double valor = Double.valueOf(str);
            if (valor%3==0) return new Stack();
            else if (valor%2==0) return new LinkedList();
            else return new TreeSet();
        }
        else return new ArrayList();
    }

    private static boolean isNumeric(String valor){
        try {
            Double.valueOf(valor);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
}
