package com.demo;

public class Klijent {
   private String ime;
   private String prezime;
    private int pinBroj;
    private int oib;
    private int stanjeRacuna;

    public Klijent(String ime, String prezime, int pinBroj, int oib, int stanjeRacuna) {
        this.ime = ime;
        this.prezime = prezime;
        this.pinBroj = pinBroj;
        this.oib = oib;
        this.stanjeRacuna = stanjeRacuna;
    }



    public String getIme() {
        return ime;
    }
    public String getPrezime() {
        return prezime;
    }

    public int getPinBroj() {
        return pinBroj;
    }

    public int getOib() {
        return oib;
    }

    public int getStanjeRacuna() {
        return stanjeRacuna;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPinBroj(int pinBroj) {
        this.pinBroj = pinBroj;
    }

    public void setOib(int oib) {
        this.oib = oib;
    }
    public void setStanjeRacuna(int stanjeRacuna) {
        this.stanjeRacuna = stanjeRacuna;
    }
}
