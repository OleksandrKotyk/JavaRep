package com.company;

//1. Wyświetli napis wraz ze znakiem nowej linii.
//2. Do-while najpierw wykona potem sprawdza, a while najpierw sprawdza warunek.
//3. boolean b = sc.nextBoolean();

import java.util.Scanner;


public class Main {
    static String getData(Scanner sc, String s, boolean numCheck) {
        String data;
        while (true) {
            System.out.print(s);
            data = sc.nextLine();
            if (data.isEmpty()) continue;
            if (data.equals("q")) return null;
            if (numCheck) {
                try {
                    Double.parseDouble(data);
                } catch (NumberFormatException nfe) {
                    continue;
                }
            }
            break;
        }
        return data;
    }

    public static void main(String[] args) {
        //2
        Scanner sc = new Scanner(System.in);
        System.out.println("#2");
        System.out.println(sc.nextByte());
        System.out.println(sc.nextShort());
        System.out.println(sc.nextInt());
        System.out.println(sc.nextLong());
        System.out.println(sc.nextFloat());
        System.out.println(sc.nextDouble());
        System.out.println(sc.next().charAt(0));
        System.out.println(sc.nextBoolean());
        //3
        System.out.println("#3");
        String imie = sc.next();
        String nazwisko = sc.next();
        String plec = sc.next("(man)|(woman)");
        int wiek = sc.nextInt();

        System.out.println("Imię: " + imie);
        System.out.println("Nazwisko: " + nazwisko);
        System.out.println("Płęć: " + plec);
        System.out.println("Wiek: " + wiek);
        //4
        System.out.println("#4");
        for (int i = -1000; i <1002; i+=3) {
            System.out.println(i);
        }
        //5
        System.out.println("#5");
        System.out.print("i1: ");
        int i1 = sc.nextInt();
        System.out.print("i2: ");
        int i2 = sc.nextInt();
        System.out.print("i3: ");
        int i3 = sc.nextInt();
        System.out.println("Max: " + Math.max(Math.max(i1,i2), i3));

        //6
        System.out.println("#6");
        while (true) {
            String data = getData(sc, "First number: ", true);
            if (data == null) break;
            Double d1 = Double.parseDouble(data);

            data = getData(sc, "Second number: ", true);
            if (data == null) break;
            Double d2 = Double.parseDouble(data);
            loop:
            while (true) {
                String operator = getData(sc, "Operator: ", false);
                if (operator == null) break;
                switch (operator) {
                    case "+":
                        System.out.println("Wynik: " + (d1 + d2));
                        break loop;
                    case "-":
                        System.out.println("Wynik: " + (d1 - d2));
                        break loop;
                    case "*":
                        System.out.println("Wynik: " + (d1 * d2));
                        break loop;
                    case "/":
                        System.out.println("Wynik: " + (d1 / d2));
                        break loop;
                }
            }
            System.out.println();
        }


        //7
        System.out.println("#7");
        System.out.print("First number: ");
        int d1 = sc.nextInt();
        System.out.print("First number: ");
        int d2 = sc.nextInt();

        int num;
        while (true) {
            num = d1 % d2;
            if (num == 0) {
                System.out.println("Wynik: " + d2);
                break;
            } else {
                d1 = d2;
                d2 = num;
            }
        }

        //8
        System.out.println("#8");
        System.out.print("Szukany: ");
        int szukany = sc.nextInt();
        int[][] tab = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        for (int i = 0; i < tab.length; i++)
            for (int j = 0; j < tab[i].length; j++)
                if (tab[i][j] == szukany) {
                    System.out.println(szukany + " at " + (i + 1) + ":" + (j + 1));
                    break;
                }
        System.out.println("Nie ma takiego elementu w tablicy!!!");
    }
}
