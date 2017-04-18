/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbb;

import domen.Radnik;
import domen.Ucinak;
import domen.VrstaPosla;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.print.PSPrinterJob;

/**
 *
 * @author User
 */
public class DBBroker {

    Connection konekcija;
    ArrayList<Ucinak> listeUcinaka = new ArrayList<>();

    public void ucitajDrajver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void otvoriKonekciju() {
        String url = "jdbc:mysql://localhost:3306/prosoftg3";
        String user = "root";
        String pass = "";

        try {
            konekcija = DriverManager.getConnection(url, user, pass);
            konekcija.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void zatvoriKonekciju() {
        try {
            konekcija.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void commit() {
        try {
            konekcija.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void rollback() {
        try {
            konekcija.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<VrstaPosla> vratiListeVP() {
        ArrayList<VrstaPosla> listeVrstiPosla = new ArrayList<>();
        String upit = "SELECT * from VrstaPosla order by naziv desc";
        try {
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(upit);
            while (rs.next()) {
                int VrstaPoslaID = rs.getInt("VrstaPoslaID");
                String Naziv = rs.getString("Naziv");
                VrstaPosla vp = new VrstaPosla(VrstaPoslaID, Naziv);
                listeVrstiPosla.add(vp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeVrstiPosla;
    }

    public ArrayList<Radnik> vratiListuRadnika() {
        ArrayList<Radnik> listaRdnika = new ArrayList<>();
        String upit = "select * from Radnik order by Prezime asc";
        try {
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(upit);;
            while (rs.next()) {
                int radnikID = rs.getInt("RadnikID");
                String ime = rs.getString("Ime");
                String prezime = rs.getString("Prezime");
                String specijalizacija = rs.getString("Specijalizacija");
                Radnik r = new Radnik(radnikID, ime, prezime, specijalizacija);
                listaRdnika.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaRdnika;
    }

    public void unesiListuUcinaka(Ucinak u, int indeks) throws SQLException {
        String upit = "Insert into Ucinak values (?,?,?,?,?)";
        PreparedStatement ps = konekcija.prepareStatement(upit);
        ps.setInt(1, indeks);
        ps.setInt(2, u.getBrojSati());
        ps.setDate(3, new Date(u.getDatum().getTime()));
        ps.setInt(4, u.getVrstaposla().getVrstaPoslaID());
        ps.setInt(5, u.getRadnik().getRadnikID());
        ps.executeUpdate();

    }

    public int vratiIndeks() {
        String upit = "SELECT max(UcinakID) as maks from Ucinak";
        int indeks = 0;
        try {
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(upit);
            while (rs.next()) {
                indeks = rs.getInt("maks");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return indeks+1;

    }
}
