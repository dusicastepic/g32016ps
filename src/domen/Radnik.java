/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

/**
 *
 * @author Duca
 */
public class Radnik {

    private int radnikID;
    private String ime;
    private String prezime;
    private String specijalizacija;

    public Radnik() {
    }

    public Radnik(int radnikID, String ime, String prezime, String specijalizacija) {
        this.radnikID = radnikID;
        this.ime = ime;
        this.prezime = prezime;
        this.specijalizacija = specijalizacija;
    }

    public String getSpecijalizacija() {
        return specijalizacija;
    }

    public void setSpecijalizacija(String specijalizacija) {
        this.specijalizacija = specijalizacija;
    }

    public int getRadnikID() {
        return radnikID;
    }

    public void setRadnikID(int radnikID) {
        this.radnikID = radnikID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

}
