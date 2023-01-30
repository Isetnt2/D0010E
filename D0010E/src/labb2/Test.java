package labb2;

import labb2.MyArrayList;

import java.util.ArrayList;

public class Test {
    private static MyArrayList<String> lista = new MyArrayList<>();
    private static void skriv(int id) {
        System.out.println(id + ": " + lista);
    }
    public static void main(String[] args) {
        skriv(0);
// En illustration av hur den interna arrayen påverkas finns i bildspelet
// från föreläsning 4.
        lista.add("A");
        lista.add("B");
        lista.add("C");
        lista.add("D");
        lista.add("E");
        lista.add("F");
        lista.add("G");
        skriv(1);
        lista.add("X");
        skriv(2);
        lista.remove(2);
        skriv(3);
        System.out.println(lista.get(4));
        System.out.println(lista.isEmpty());
        System.out.println(lista.contains("B"));
        lista.remove(1);
        skriv(5);
        System.out.println(lista.contains("B"));
        lista.clear();
        skriv(6);
// Avkommentera nästa rad och kör, så kastas ett undantag
// lista.add(2, "Y"); // Fel! Finns ingen plats med index 2!
    }
}

