package org.example;

import java.util.List;

public class Main {

    private final static DatabaseAPIs db_API = new DatabaseAPIs();
    public static void main(String[] args) {


        System.out.println("Hello world!");

        db_API.insertPerson("Mike","Rouges");

        List<String> first_person = db_API.getIndex(1);

        if(first_person!=null){
            System.out.println("Name of the first person is: "+first_person.get(0));
        }

        System.out.println("Printing all DB:");
        db_API.printAllPersons();



    }
}