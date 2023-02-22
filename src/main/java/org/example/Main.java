package org.example;

import java.awt.image.DataBuffer;
import java.util.List;

public class Main {

    private final static DatabaseAPIs db_API = new DatabaseAPIs();
    public static void main(String[] args) {


        System.out.println("Hello world!");

        List<String> prima_persona = db_API.getIndex(1);

        if(prima_persona!=null){
            System.out.println("Il nome della prima persona è: "+prima_persona.get(0));
        }

        System.out.println("Stampo tutto il DB:");
        db_API.printAllPersons();



    }
}