/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Nenad
 */
public class Kupac {

    private Integer id;
    private String name;    
    private String maticni_broj;
    private String pib;
    private String pdv_potvrda;
    private String adresa;
    private String mesto;
    private String racun;   

    public Kupac() {
    }

    public Kupac(Integer id, String name, String maticni_broj, String pib, String pdv_potvrda, String adresa, String mesto, String racun) {
        this.id = id;
        this.name = name;
        this.maticni_broj = maticni_broj;
        this.pib = pib;
        this.pdv_potvrda = pdv_potvrda;
        this.adresa = adresa;
        this.mesto = mesto;
        this.racun = racun;
    }
    
        public Kupac(Integer id) {
        this.id = id;
        
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaticni_broj() {
        return maticni_broj;
    }

    public void setMaticni_broj(String maticni_broj) {
        this.maticni_broj = maticni_broj;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public String getPdv_potvrda() {
        return pdv_potvrda;
    }

    public void setPdv_potvrda(String pdv_potvrda) {
        this.pdv_potvrda = pdv_potvrda;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public String getRacun() {
        return racun;
    }

    public void setRacun(String racun) {
        this.racun = racun;
    }


}
