package model;

import java.util.Date;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;
//import java.time.LocalDate;

public class FileBucket {
    

        
	MultipartFile file;	
	String description;      
        String name;  
        String type;  
        Long id;
        Integer proizvodjacId;

        String brojSertifikata;
        String nazivVrstaProizvodnje;
//        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        @DateTimeFormat(pattern="dd/MM/yyyy")
        Date datumKontrole;

        Date datumIzdavanja;
        Date vaziDo;
        String tipSertifikata;
        String rezerva1;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
        
            public String getBrojSertifikata() {
        return brojSertifikata;
    }

    public void setBrojSertifikata(String brojSertifikata) {
        this.brojSertifikata = brojSertifikata;
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

    public Integer getProizvodjacId() {
        return proizvodjacId;
    }

    public void setProizvodjacId(Integer proizvodjacId) {
        this.proizvodjacId = proizvodjacId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    




}