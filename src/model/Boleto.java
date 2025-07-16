/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Eme
 */
public class Boleto {
    private int idBoleto;
    private String tipoBoleto;

    public Boleto() {}

    public Boleto(int idBoleto, String tipoBoleto) {
        this.idBoleto = idBoleto;
        this.tipoBoleto = tipoBoleto;
    }

    public int getIdBoleto() {
        return idBoleto;
    }

    public void setIdBoleto(int idBoleto) {
        this.idBoleto = idBoleto;
    }

    public String getTipoBoleto() {
        return tipoBoleto;
    }

    public void setTipoBoleto(String tipoBoleto) {
        this.tipoBoleto = tipoBoleto;
    }

    @Override
    public String toString() {
        return idBoleto + " - " + tipoBoleto;
    }
}
