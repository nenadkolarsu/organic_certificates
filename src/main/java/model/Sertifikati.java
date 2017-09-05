/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Pionir SU
 */
@Entity
@Table(name = "sertifikati")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sertifikati.findAll", query = "SELECT s FROM Sertifikati s"),
    @NamedQuery(name = "Sertifikati.findById", query = "SELECT s FROM Sertifikati s WHERE s.id = :id"),
    @NamedQuery(name = "Sertifikati.findByBrojSertifikata", query = "SELECT s FROM Sertifikati s WHERE s.brojSertifikata = :brojSertifikata"),
    @NamedQuery(name = "Sertifikati.findByProizvodjacId", query = "SELECT s FROM Sertifikati s WHERE s.proizvodjacId = :proizvodjacId"),
    @NamedQuery(name = "Sertifikati.findByProizvodjacSifra", query = "SELECT s FROM Sertifikati s WHERE s.proizvodjacSifra = :proizvodjacSifra"),
    @NamedQuery(name = "Sertifikati.findByProizvodjac", query = "SELECT s FROM Sertifikati s WHERE s.proizvodjac = :proizvodjac"),
    @NamedQuery(name = "Sertifikati.findByProizvodjacSkraceno", query = "SELECT s FROM Sertifikati s WHERE s.proizvodjacSkraceno = :proizvodjacSkraceno"),
    @NamedQuery(name = "Sertifikati.findByAdresa", query = "SELECT s FROM Sertifikati s WHERE s.adresa = :adresa"),
    @NamedQuery(name = "Sertifikati.findByPttBroj", query = "SELECT s FROM Sertifikati s WHERE s.pttBroj = :pttBroj"),
    @NamedQuery(name = "Sertifikati.findByMesto", query = "SELECT s FROM Sertifikati s WHERE s.mesto = :mesto"),
    @NamedQuery(name = "Sertifikati.findByZemljaSifra", query = "SELECT s FROM Sertifikati s WHERE s.zemljaSifra = :zemljaSifra"),
    @NamedQuery(name = "Sertifikati.findByZemlja", query = "SELECT s FROM Sertifikati s WHERE s.zemlja = :zemlja"),
    @NamedQuery(name = "Sertifikati.findByIdVrstaProizvodnje", query = "SELECT s FROM Sertifikati s WHERE s.idVrstaProizvodnje = :idVrstaProizvodnje"),
    @NamedQuery(name = "Sertifikati.findBySifraVrstaProizvodnje", query = "SELECT s FROM Sertifikati s WHERE s.sifraVrstaProizvodnje = :sifraVrstaProizvodnje"),
    @NamedQuery(name = "Sertifikati.findByNazivVrstaProizvodnje", query = "SELECT s FROM Sertifikati s WHERE s.nazivVrstaProizvodnje = :nazivVrstaProizvodnje"),
    @NamedQuery(name = "Sertifikati.findByDatumKontrole", query = "SELECT s FROM Sertifikati s WHERE s.datumKontrole = :datumKontrole"),
    @NamedQuery(name = "Sertifikati.findByMestoIzdavanja", query = "SELECT s FROM Sertifikati s WHERE s.mestoIzdavanja = :mestoIzdavanja"),
    @NamedQuery(name = "Sertifikati.findByDatumIzdavanja", query = "SELECT s FROM Sertifikati s WHERE s.datumIzdavanja = :datumIzdavanja"),
    @NamedQuery(name = "Sertifikati.findByVaziDo", query = "SELECT s FROM Sertifikati s WHERE s.vaziDo = :vaziDo"),
    @NamedQuery(name = "Sertifikati.findByAsortiman", query = "SELECT s FROM Sertifikati s WHERE s.asortiman = :asortiman"),
    @NamedQuery(name = "Sertifikati.findByAsortimanSifra", query = "SELECT s FROM Sertifikati s WHERE s.asortimanSifra = :asortimanSifra"),
    @NamedQuery(name = "Sertifikati.findByTipSertifikata", query = "SELECT s FROM Sertifikati s WHERE s.tipSertifikata = :tipSertifikata"),
    @NamedQuery(name = "Sertifikati.findByTipSertifikataSifra", query = "SELECT s FROM Sertifikati s WHERE s.tipSertifikataSifra = :tipSertifikataSifra"),
    @NamedQuery(name = "Sertifikati.findByRezerva1", query = "SELECT s FROM Sertifikati s WHERE s.rezerva1 = :rezerva1"),
    @NamedQuery(name = "Sertifikati.findByRezerva2", query = "SELECT s FROM Sertifikati s WHERE s.rezerva2 = :rezerva2"),
    @NamedQuery(name = "Sertifikati.findByRezerva3", query = "SELECT s FROM Sertifikati s WHERE s.rezerva3 = :rezerva3"),
    @NamedQuery(name = "Sertifikati.findByAktivan", query = "SELECT s FROM Sertifikati s WHERE s.aktivan = :aktivan"),
    @NamedQuery(name = "Sertifikati.findByDatumVreme", query = "SELECT s FROM Sertifikati s WHERE s.datumVreme = :datumVreme"),
    @NamedQuery(name = "Sertifikati.findBySertifikaticol", query = "SELECT s FROM Sertifikati s WHERE s.sertifikaticol = :sertifikaticol")})
public class Sertifikati implements Serializable {
    @Column(name = "sertifikaticol1")
    private String sertifikaticol1;
    @OneToMany(mappedBy = "proizvodjacId")
    private Collection<ProizvodjacDocument> proizvodjacDocumentCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "broj_sertifikata")
    private String brojSertifikata;
    @Column(name = "proizvodjac_id")
    private Integer proizvodjacId;
    @Column(name = "proizvodjac_sifra")
    private String proizvodjacSifra;    
    @Column(name = "proizvodjac")
    @NotEmpty(message = "Proizvodjac can not be left empty")
    private String proizvodjac;
    @Column(name = "proizvodjac_skraceno")
    private String proizvodjacSkraceno;
    @Column(name = "adresa")
    @NotEmpty(message = "Adresa can not be left empty")
    private String adresa;
    @Column(name = "ptt_broj")
    private String pttBroj;
    @Column(name = "mesto")
    @NotEmpty(message = "Mesto can not be left empty")
    private String mesto;
    @Column(name = "zemlja_sifra")
    private String zemljaSifra;
    @Column(name = "zemlja")
    @NotEmpty(message = "Zemlja can not be left empty")
    private String zemlja;
    @Column(name = "id_vrsta_proizvodnje")
    private Integer idVrstaProizvodnje;
    @Column(name = "sifra_vrsta_proizvodnje")
    private String sifraVrstaProizvodnje;
    @Column(name = "naziv_vrsta_proizvodnje")
    private String nazivVrstaProizvodnje;
    @Column(name = "datum_kontrole")
    @Temporal(TemporalType.DATE)
    private Date datumKontrole;
    @Column(name = "mesto_izdavanja")
    private String mestoIzdavanja;
    @Column(name = "datum_izdavanja")
    @Temporal(TemporalType.DATE)
    private Date datumIzdavanja;
    @Column(name = "vazi_do")
    @Temporal(TemporalType.DATE)
    private Date vaziDo;
    @Column(name = "asortiman")
    private String asortiman;
    @Column(name = "asortiman_sifra")
    private String asortimanSifra;
    @Column(name = "tip_sertifikata")
    private String tipSertifikata;
    @Column(name = "tip_sertifikata_sifra")
    private String tipSertifikataSifra;
    @Column(name = "rezerva1")
    private String rezerva1;
    @Column(name = "rezerva2")
    private String rezerva2;
    @Column(name = "rezerva3")
    private String rezerva3;
    @Column(name = "aktivan")
    private Boolean aktivan;
    @Column(name = "datum_vreme")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datumVreme;
    @Column(name = "sertifikaticol")
    private String sertifikaticol;

    public Sertifikati(Integer id, String brojSertifikata, Integer proizvodjacId, String proizvodjacSifra, String proizvodjac, String proizvodjacSkraceno, String adresa, String pttBroj, String mesto, String zemljaSifra, String zemlja, Integer idVrstaProizvodnje, String sifraVrstaProizvodnje, String nazivVrstaProizvodnje, Date datumKontrole, String mestoIzdavanja, Date datumIzdavanja, Date vaziDo, String asortiman, String asortimanSifra, String tipSertifikata, String tipSertifikataSifra, String rezerva1, String rezerva2, String rezerva3, Boolean aktivan, Date datumVreme, String sertifikaticol) {
        this.id = id;
        this.brojSertifikata = brojSertifikata;
        this.proizvodjacId = proizvodjacId;
        this.proizvodjacSifra = proizvodjacSifra;
        this.proizvodjac = proizvodjac;
        this.proizvodjacSkraceno = proizvodjacSkraceno;
        this.adresa = adresa;
        this.pttBroj = pttBroj;
        this.mesto = mesto;
        this.zemljaSifra = zemljaSifra;
        this.zemlja = zemlja;
        this.idVrstaProizvodnje = idVrstaProizvodnje;
        this.sifraVrstaProizvodnje = sifraVrstaProizvodnje;
        this.nazivVrstaProizvodnje = nazivVrstaProizvodnje;
        this.datumKontrole = datumKontrole;
        this.mestoIzdavanja = mestoIzdavanja;
        this.datumIzdavanja = datumIzdavanja;
        this.vaziDo = vaziDo;
        this.asortiman = asortiman;
        this.asortimanSifra = asortimanSifra;
        this.tipSertifikata = tipSertifikata;
        this.tipSertifikataSifra = tipSertifikataSifra;
        this.rezerva1 = rezerva1;
        this.rezerva2 = rezerva2;
        this.rezerva3 = rezerva3;
        this.aktivan = aktivan;
        this.datumVreme = datumVreme;
        this.sertifikaticol = sertifikaticol;
    }

    
    public Sertifikati() {
    }

    public Sertifikati(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrojSertifikata() {
        return brojSertifikata;
    }

    public void setBrojSertifikata(String brojSertifikata) {
        this.brojSertifikata = brojSertifikata;
    }

    public Integer getProizvodjacId() {
        return proizvodjacId;
    }

    public void setProizvodjacId(Integer proizvodjacId) {
        this.proizvodjacId = proizvodjacId;
    }

    public String getProizvodjacSifra() {
        return proizvodjacSifra;
    }

    public void setProizvodjacSifra(String proizvodjacSifra) {
        this.proizvodjacSifra = proizvodjacSifra;
    }

    public String getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(String proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    public String getProizvodjacSkraceno() {
        return proizvodjacSkraceno;
    }

    public void setProizvodjacSkraceno(String proizvodjacSkraceno) {
        this.proizvodjacSkraceno = proizvodjacSkraceno;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getPttBroj() {
        return pttBroj;
    }

    public void setPttBroj(String pttBroj) {
        this.pttBroj = pttBroj;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public String getZemljaSifra() {
        return zemljaSifra;
    }

    public void setZemljaSifra(String zemljaSifra) {
        this.zemljaSifra = zemljaSifra;
    }

    public String getZemlja() {
        return zemlja;
    }

    public void setZemlja(String zemlja) {
        this.zemlja = zemlja;
    }

    public Integer getIdVrstaProizvodnje() {
        return idVrstaProizvodnje;
    }

    public void setIdVrstaProizvodnje(Integer idVrstaProizvodnje) {
        this.idVrstaProizvodnje = idVrstaProizvodnje;
    }

    public String getSifraVrstaProizvodnje() {
        return sifraVrstaProizvodnje;
    }

    public void setSifraVrstaProizvodnje(String sifraVrstaProizvodnje) {
        this.sifraVrstaProizvodnje = sifraVrstaProizvodnje;
    }

    public String getNazivVrstaProizvodnje() {
        return nazivVrstaProizvodnje;
    }

    public void setNazivVrstaProizvodnje(String nazivVrstaProizvodnje) {
        this.nazivVrstaProizvodnje = nazivVrstaProizvodnje;
    }

    public Date getDatumKontrole() {
        return datumKontrole;
    }

    public void setDatumKontrole(Date datumKontrole) {
        this.datumKontrole = datumKontrole;
    }

    public String getMestoIzdavanja() {
        return mestoIzdavanja;
    }

    public void setMestoIzdavanja(String mestoIzdavanja) {
        this.mestoIzdavanja = mestoIzdavanja;
    }

    public Date getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja(Date datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    public Date getVaziDo() {
        return vaziDo;
    }

    public void setVaziDo(Date vaziDo) {
        this.vaziDo = vaziDo;
    }

    public String getAsortiman() {
        return asortiman;
    }

    public void setAsortiman(String asortiman) {
        this.asortiman = asortiman;
    }

    public String getAsortimanSifra() {
        return asortimanSifra;
    }

    public void setAsortimanSifra(String asortimanSifra) {
        this.asortimanSifra = asortimanSifra;
    }

    public String getTipSertifikata() {
        return tipSertifikata;
    }

    public void setTipSertifikata(String tipSertifikata) {
        this.tipSertifikata = tipSertifikata;
    }

    public String getTipSertifikataSifra() {
        return tipSertifikataSifra;
    }

    public void setTipSertifikataSifra(String tipSertifikataSifra) {
        this.tipSertifikataSifra = tipSertifikataSifra;
    }

    public String getRezerva1() {
        return rezerva1;
    }

    public void setRezerva1(String rezerva1) {
        this.rezerva1 = rezerva1;
    }

    public String getRezerva2() {
        return rezerva2;
    }

    public void setRezerva2(String rezerva2) {
        this.rezerva2 = rezerva2;
    }

    public String getRezerva3() {
        return rezerva3;
    }

    public void setRezerva3(String rezerva3) {
        this.rezerva3 = rezerva3;
    }

    public Boolean getAktivan() {
        return aktivan;
    }

    public void setAktivan(Boolean aktivan) {
        this.aktivan = aktivan;
    }

    public Date getDatumVreme() {
        return datumVreme;
    }

    public void setDatumVreme(Date datumVreme) {
        this.datumVreme = datumVreme;
    }

    public String getSertifikaticol() {
        return sertifikaticol;
    }

    public void setSertifikaticol(String sertifikaticol) {
        this.sertifikaticol = sertifikaticol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sertifikati)) {
            return false;
        }
        Sertifikati other = (Sertifikati) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.javahonk.controller.Sertifikati[ id=" + id + " ]";
    }

    public String getSertifikaticol1() {
        return sertifikaticol1;
    }

    public void setSertifikaticol1(String sertifikaticol1) {
        this.sertifikaticol1 = sertifikaticol1;
    }

    @XmlTransient
    public Collection<ProizvodjacDocument> getProizvodjacDocumentCollection() {
        return proizvodjacDocumentCollection;
    }

    public void setProizvodjacDocumentCollection(Collection<ProizvodjacDocument> proizvodjacDocumentCollection) {
        this.proizvodjacDocumentCollection = proizvodjacDocumentCollection;
    }
    
}
