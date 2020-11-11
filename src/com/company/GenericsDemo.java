package com.company;

import java.util.ArrayList;
import java.util.List;

// Elke class kan het stukje tussen de < > vervangen
// Generics werken alleen met classes, niet met dataTypes.
// int werkt dus niet Integer wel

// als T extends Number, kunnen er alleen classes T worden die Number extenden
// Float, Integer, Double kunnen dus, String en andere classes die niet Number extenden NIET
class Container<T extends Number> { // conventions -> use CAPITOL lettters E - element T - Type
    T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void show() {
        System.out.println(value.getClass().getName());
    }

    // T extends number dus nu wordt er afgevangen dat er alleen nummers in de arraylist komen te staan
    // ipv extends kan ook SUPER gebruikt worden, dan kunnen er superclasses in van T, die Integer is idg, dus de super
    // classes van T kunnen er dan in, Number als Object kan er in dat geval in dan
    public void printArrayListWithNumber(ArrayList<? extends T> list) {
        for (T number: list) {
            System.out.println("nummer in lijst: " + number);
        }
    }
}

public class GenericsDemo {
    public static void main(String[] args) {
        int value = 5;

        List values = new ArrayList();

        values.add(7);
        values.add("Niels");


        // omdat de List geen "restricties" heeft kan er integers en Strings worden toegevoegd
        // hierdoor kunnen RunTime errors ontstaan door bijvoorbeeld met de String value integer acties te doen
        // Generics kunnen dus met de < > worden gespecificeerd
        // dit handelt de fouten in compile time al af i.p.v. Runtime
        List<Integer> betterValues = new ArrayList<Integer>(); // is dus beter, nu vangen we af dat er alleen int inkomen
        betterValues.add(7);
        // betterValues.add("Niels"); dit mag dus niet meer omdat de list nu "restricties" heeft


        for(int i=0; i < values.size(); i++) {
            System.out.println(values.get(i));
        }

        Container<?> obj = new Container(); // nu Raw type
        Container<Integer> l = new Container<>();
        l.value = 9;
        l.show(); // print integer omdat we de value naar integer hebben gezet door hem mee te geven in de < >

        // werkt niet want in de class is afgevangen dat er alleen nummers in mogen
        //l.printArrayListWithNumber(new ArrayList<String>());

        // mag wel want INTEGER
        l.printArrayListWithNumber(new ArrayList<Integer>());
    }
}


