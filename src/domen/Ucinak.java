/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.util.Date;

/**
 *
 * @author User
 */
public class Ucinak {

    private int ucinakID;
    private int brojSati;
    private Date datum;
    private VrstaPosla vrstaposla;
    private Radnik radnik;

    public Ucinak() {
    }

    public Ucinak(int ucinakID, int brojSati, Date datum, VrstaPosla vrstaposla, Radnik radnik) {
        this.ucinakID = ucinakID;
        this.brojSati = brojSati;
        this.datum = datum;
        this.vrstaposla = vrstaposla;
        this.radnik = radnik;
    }

    public Radnik getRadnik() {
        return radnik;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }

    public int getUcinakID() {
        return ucinakID;
    }

    public void setUcinakID(int ucinakID) {
        this.ucinakID = ucinakID;
    }

    public int getBrojSati() {
        return brojSati;
    }

    public void setBrojSati(int brojSati) {
        this.brojSati = brojSati;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public VrstaPosla getVrstaposla() {
        return vrstaposla;
    }

    public void setVrstaposla(VrstaPosla vrstaposla) {
        this.vrstaposla = vrstaposla;
    }
    
}
