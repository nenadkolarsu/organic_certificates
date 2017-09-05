package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.ProizvodjacDocument;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-04T12:17:59")
@StaticMetamodel(Sertifikati.class)
public class Sertifikati_ { 

    public static volatile SingularAttribute<Sertifikati, String> proizvodjacSifra;
    public static volatile SingularAttribute<Sertifikati, Date> datumKontrole;
    public static volatile SingularAttribute<Sertifikati, Boolean> aktivan;
    public static volatile SingularAttribute<Sertifikati, Date> datumVreme;
    public static volatile SingularAttribute<Sertifikati, String> brojSertifikata;
    public static volatile SingularAttribute<Sertifikati, String> zemljaSifra;
    public static volatile SingularAttribute<Sertifikati, String> proizvodjacSkraceno;
    public static volatile SingularAttribute<Sertifikati, String> tipSertifikata;
    public static volatile SingularAttribute<Sertifikati, String> sifraVrstaProizvodnje;
    public static volatile SingularAttribute<Sertifikati, String> pttBroj;
    public static volatile SingularAttribute<Sertifikati, String> asortiman;
    public static volatile SingularAttribute<Sertifikati, String> proizvodjac;
    public static volatile SingularAttribute<Sertifikati, String> adresa;
    public static volatile SingularAttribute<Sertifikati, String> sertifikaticol1;
    public static volatile SingularAttribute<Sertifikati, Integer> idVrstaProizvodnje;
    public static volatile SingularAttribute<Sertifikati, Integer> id;
    public static volatile SingularAttribute<Sertifikati, String> rezerva3;
    public static volatile SingularAttribute<Sertifikati, String> rezerva2;
    public static volatile SingularAttribute<Sertifikati, String> rezerva1;
    public static volatile SingularAttribute<Sertifikati, String> sertifikaticol;
    public static volatile SingularAttribute<Sertifikati, Integer> proizvodjacId;
    public static volatile SingularAttribute<Sertifikati, String> tipSertifikataSifra;
    public static volatile SingularAttribute<Sertifikati, String> mestoIzdavanja;
    public static volatile SingularAttribute<Sertifikati, Date> vaziDo;
    public static volatile SingularAttribute<Sertifikati, String> zemlja;
    public static volatile SingularAttribute<Sertifikati, String> nazivVrstaProizvodnje;
    public static volatile CollectionAttribute<Sertifikati, ProizvodjacDocument> proizvodjacDocumentCollection;
    public static volatile SingularAttribute<Sertifikati, String> mesto;
    public static volatile SingularAttribute<Sertifikati, Date> datumIzdavanja;
    public static volatile SingularAttribute<Sertifikati, String> asortimanSifra;

}