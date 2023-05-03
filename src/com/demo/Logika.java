package com.demo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Logika{
    private static Scanner scanner;
    private final Bankomat bankomat;
    private final BazaCRUD baza;

    public Logika(Scanner scanner, Bankomat bankomat, BazaCRUD baza) {
        this.scanner = scanner;
        this.bankomat = bankomat;
        this.baza = baza;
    }

    public void postavljanjeJezika() {
        System.out.println("Izaberite jezik sustava:" +
                "1. Hrvatski" +
                "2. Engleski");
        int korisnikovUnos = getKorisnikovUnos();
        //todo sredit promijenu jezika
    }

    public void unosPina() {
        System.out.println("Dobrodosli, unesite pin: \n");
        int korisnikovUnos = getKorisnikovUnos();
    }

    public void ispisiIzbor() {
        System.out.println("""
                Molimo izaberite opciju:
                1. Podizanje novaca
                2. Uplata Novaca
                3. Provjera stanja racuna""");
        int korisnikovUnos = getKorisnikovUnos();
    }

    public static int getKorisnikovUnos() {
        int unos = 0;
        while (unos <= 0) {
            try {
                unos = scanner.nextInt();
            } catch (InputMismatchException exception) {
                System.out.println("""
                        Niste upisali broj!
                        Molimo pokušajte ponovno.
                        """);
                scanner.next();
            }
        }
        return unos;
    }

}