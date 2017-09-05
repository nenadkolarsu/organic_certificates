/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.validator.constraints.*;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author ms
 */
@Entity
@Table(name = "proizvodjac_document")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProizvodjacDocument.findAll", query = "SELECT p FROM ProizvodjacDocument p"),
    @NamedQuery(name = "ProizvodjacDocument.findById", query = "SELECT p FROM ProizvodjacDocument p WHERE p.id = :id"),
    @NamedQuery(name = "ProizvodjacDocument.findByUserId", query = "SELECT p FROM ProizvodjacDocument p WHERE p.userId = :userId"),
    @NamedQuery(name = "ProizvodjacDocument.findByName", query = "SELECT p FROM ProizvodjacDocument p WHERE p.name = :name"),
    @NamedQuery(name = "ProizvodjacDocument.findByDescription", query = "SELECT p FROM ProizvodjacDocument p WHERE p.description = :description"),
    @NamedQuery(name = "ProizvodjacDocument.findByType", query = "SELECT p FROM ProizvodjacDocument p WHERE p.type = :type"),
    @NamedQuery(name = "ProizvodjacDocument.findByBrojSertifikata", query = "SELECT p FROM ProizvodjacDocument p WHERE p.brojSertifikata = :brojSertifikata"),
    @NamedQuery(name = "ProizvodjacDocument.findByProizvodjacId", query = "SELECT p FROM ProizvodjacDocument p WHERE p.proizvodjacId = :proizvodjacId"),
    @NamedQuery(name = "ProizvodjacDocument.findByProizvodjac", query = "SELECT p FROM ProizvodjacDocument p WHERE p.proizvodjac = :proizvodjac"),
    @NamedQuery(name = "ProizvodjacDocument.findBySifraVrstaProizvodnje", query = "SELECT p FROM ProizvodjacDocument p WHERE p.sifraVrstaProizvodnje = :sifraVrstaProizvodnje"),
    @NamedQuery(name = "ProizvodjacDocument.findByNazivVrstaProizvodnje", query = "SELECT p FROM ProizvodjacDocument p WHERE p.nazivVrstaProizvodnje = :nazivVrstaProizvodnje"),
    @NamedQuery(name = "ProizvodjacDocument.findByDatumKontrole", query = "SELECT p FROM ProizvodjacDocument p WHERE p.datumKontrole = :datumKontrole"),
    @NamedQuery(name = "ProizvodjacDocument.findByMestoIzdavanja", query = "SELECT p FROM ProizvodjacDocument p WHERE p.mestoIzdavanja = :mestoIzdavanja"),
    @NamedQuery(name = "ProizvodjacDocument.findByDatumIzdavanja", query = "SELECT p FROM ProizvodjacDocument p WHERE p.datumIzdavanja = :datumIzdavanja"),
    @NamedQuery(name = "ProizvodjacDocument.findByVaziDo", query = "SELECT p FROM ProizvodjacDocument p WHERE p.vaziDo = :vaziDo"),
    @NamedQuery(name = "ProizvodjacDocument.findByAsortimanSifra", query = "SELECT p FROM ProizvodjacDocument p WHERE p.asortimanSifra = :asortimanSifra"),
    @NamedQuery(name = "ProizvodjacDocument.findByAsortiman", query = "SELECT p FROM ProizvodjacDocument p WHERE p.asortiman = :asortiman"),
    @NamedQuery(name = "ProizvodjacDocument.findByTipSertifikataSifra", query = "SELECT p FROM ProizvodjacDocument p WHERE p.tipSertifikataSifra = :tipSertifikataSifra"),
    @NamedQuery(name = "ProizvodjacDocument.findByTipSertifikata", query = "SELECT p FROM ProizvodjacDocument p WHERE p.tipSertifikata = :tipSertifikata"),
    @NamedQuery(name = "ProizvodjacDocument.findByRezerva1", query = "SELECT p FROM ProizvodjacDocument p WHERE p.rezerva1 = :rezerva1"),
    @NamedQuery(name = "ProizvodjacDocument.findByRezerva2", query = "SELECT p FROM ProizvodjacDocument p WHERE p.rezerva2 = :rezerva2"),
    @NamedQuery(name = "ProizvodjacDocument.findByRezerva3", query = "SELECT p FROM ProizvodjacDocument p WHERE p.rezerva3 = :rezerva3"),
    @NamedQuery(name = "ProizvodjacDocument.findByAktivan", query = "SELECT p FROM ProizvodjacDocument p WHERE p.aktivan = :aktivan"),
    @NamedQuery(name = "ProizvodjacDocument.findByDatumVreme", query = "SELECT p FROM ProizvodjacDocument p WHERE p.datumVreme = :datumVreme"),
    @NamedQuery(name = "ProizvodjacDocument.findByKojeupisao", query = "SELECT p FROM ProizvodjacDocument p WHERE p.kojeupisao = :kojeupisao")})
public class ProizvodjacDocument implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "user_id")
    private long userId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @Lob
    @Column(name = "content")
    private byte[] content;
    @Column(name = "broj_sertifikata")
    private String brojSertifikata;
    @Column(name = "proizvodjac_id")
    @NotEmpty
    private Integer proizvodjacId;
    @Column(name = "proizvodjac")
    private String proizvodjac;
    @Column(name = "sifra_vrsta_proizvodnje")
    private String sifraVrstaProizvodnje;
    @Column(name = "naziv_vrsta_proizvodnje")
    private String nazivVrstaProizvodnje;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "datum_kontrole")
    @NotEmpty
    @Temporal(TemporalType.DATE)
    private Date datumKontrole;
    @Column(name = "mesto_izdavanja")
    private String mestoIzdavanja;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "datum_izdavanja")
    @Temporal(TemporalType.DATE)
    @NotEmpty
    private Date datumIzdavanja;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "vazi_do")
    @Temporal(TemporalType.DATE)
    @NotEmpty
    private Date vaziDo;
    @Column(name = "asortiman_sifra")
    private String asortimanSifra;
    @Column(name = "asortiman")
    private String asortiman;
    @Column(name = "tip_sertifikata_sifra")
    private String tipSertifikataSifra;
    @Column(name = "tip_sertifikata")
    private String tipSertifikata;
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
    @Column(name = "kojeupisao")
    private String kojeupisao;

    public ProizvodjacDocument() {
    }

    public ProizvodjacDocument(Long id) {
        this.id = id;
    }

    public ProizvodjacDocument(Long id, long userId, String name, String type, byte[] content) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.type = type;
        this.content = content;
    }

    public ProizvodjacDocument(Long id, long userId, String name, String description, String type, byte[] content, String brojSertifikata, Integer proizvodjacId, String proizvodjac, String sifraVrstaProizvodnje, String nazivVrstaProizvodnje, Date datumKontrole, String mestoIzdavanja, Date datumIzdavanja, Date vaziDo, String asortimanSifra, String asortiman, String tipSertifikataSifra, String tipSertifikata, String rezerva1, String rezerva2, String rezerva3, Boolean aktivan, Date datumVreme, String kojeupisao) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.type = type;
        this.content = content;
        this.brojSertifikata = brojSertifikata;
        this.proizvodjacId = proizvodjacId;
        this.proizvodjac = proizvodjac;
        this.sifraVrstaProizvodnje = sifraVrstaProizvodnje;
        this.nazivVrstaProizvodnje = nazivVrstaProizvodnje;
        this.datumKontrole = datumKontrole;
        this.mestoIzdavanja = mestoIzdavanja;
        this.datumIzdavanja = datumIzdavanja;
        this.vaziDo = vaziDo;
        this.asortimanSifra = asortimanSifra;
        this.asortiman = asortiman;
        this.tipSertifikataSifra = tipSertifikataSifra;
        this.tipSertifikata = tipSertifikata;
        this.rezerva1 = rezerva1;
        this.rezerva2 = rezerva2;
        this.rezerva3 = rezerva3;
        this.aktivan = aktivan;
        this.datumVreme = datumVreme;
        this.kojeupisao = kojeupisao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
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

    public String getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(String proizvodjac) {
        this.proizvodjac = proizvodjac;
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

    public String getAsortimanSifra() {
        return asortimanSifra;
    }

    public void setAsortimanSifra(String asortimanSifra) {
        this.asortimanSifra = asortimanSifra;
    }

    public String getAsortiman() {
        return asortiman;
    }

    public void setAsortiman(String asortiman) {
        this.asortiman = asortiman;
    }

    public String getTipSertifikataSifra() {
        return tipSertifikataSifra;
    }

    public void setTipSertifikataSifra(String tipSertifikataSifra) {
        this.tipSertifikataSifra = tipSertifikataSifra;
    }

    public String getTipSertifikata() {
        return tipSertifikata;
    }

    public void setTipSertifikata(String tipSertifikata) {
        this.tipSertifikata = tipSertifikata;
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

    public String getKojeupisao() {
        return kojeupisao;
    }

    public void setKojeupisao(String kojeupisao) {
        this.kojeupisao = kojeupisao;
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
        if (!(object instanceof ProizvodjacDocument)) {
            return false;
        }
        ProizvodjacDocument other = (ProizvodjacDocument) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ProizvodjacDocument[ id=" + id + " ]";
    }
    
}
