package com.company;

import java.sql.SQLOutput;

public class les_twee {

    // 1
    private int fac_non_recursive(int number) {
        int multiplier = number;
        int answer = number;

        for(int i=1; i < number; i++) { // of number-1 en i=0
            multiplier -= 1;
            answer *= multiplier;
        }
        System.out.println(number + " faculteit is " + answer);
        return answer;
    }

    // 1
    private int fac_recursive(int number) {
        if (number == 1) {
            return 1;
        } else
            return fac_non_recursive(number - 1) * number;
    }

    //2
    private int sum_recursive(int number) {
        if (number == 1) {
            return 1;
        } else {
            return sum_recursive(number - 1) + number;
        }
    }

    //2
    private int sum_non_recursive(int number) {
        int add = number;
        int total = number;

        for(int i=0; i < number; i++) {
            add -= 1;
            total += add;
        }
        return total;
    }

    // oefening 23 pagina 339
    public int count_binary_ones(int n) {
        return 1;
    }

    // oefening 49a pagina 343
    // antwoord voor de 4 dingen van recursive use
    // 1 base case: altijd een case die opgelost kan worden zonder recursie te gebruiken
    // 2 make progress: werk naar een case toe die geen recursie gebruikt
    // 3 you gotta believe: neem aan dat the recursive call werk -> niet mee eens
    // 4 compound interest rule: nooit meerdere instancies van het probleem oplossen in verschillende rec. calls
    private String reverse(String str) {
        if (str.isEmpty())
            return str;
        //Calling Function Recursively
        return reverse(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {
        les_twee l2 = new les_twee();
        l2.fac_recursive(4);

        System.out.println("rec: " + l2.fac_non_recursive(8));
        System.out.println("sum non rec: " + l2.sum_non_recursive(3));
        System.out.println("sum rec: " + l2.sum_recursive(8));
        System.out.println("reversed string: " + l2.reverse("aardbei"));
    }


}
