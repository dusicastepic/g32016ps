/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

/**
 *
 * @author User
 */
public class VrstaPosla {

    private int vrstaPoslaID;
    private String naziv;

    public VrstaPosla() {
    }

    public VrstaPosla(int vrstaPoslaID, String naziv) {
        this.vrstaPoslaID = vrstaPoslaID;
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getVrstaPoslaID() {
        return vrstaPoslaID;
    }

    public void setVrstaPoslaID(int vrstaPoslaID) {
        this.vrstaPoslaID = vrstaPoslaID;
    }

    @Override
    public String toString() {
        return naziv;
    }

}
