package com.example.mamorky.prueba25.utils;

import com.example.mamorky.prueba25.data.pojo.Contacto;

import java.util.Comparator;

/**
 * Created by mamorky on 12/12/17.
 */

public class Comparators {
    public static class CompareByTLF implements Comparator<Contacto>{

        @Override
        public int compare(Contacto o1, Contacto o2) {
            return o1.getTlf().compareTo(o2.getTlf());
        }
    }

    public static class CompareById implements Comparator<Contacto>{

        @Override
        public int compare(Contacto o1, Contacto o2) {
            if(o1.getId() < o2.getId())
                return -1;
            else if(o1.getId() > o2.getId())
                return 1;
            else
                return 0;
        }
    }
}
