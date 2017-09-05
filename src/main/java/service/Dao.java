package service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.ProizvodjacDocument;
import model.Sertifikati;
import org.springframework.stereotype.Service;

@Service
public class Dao {

    Connection con;

    public Dao() {
        con = DbConnection.getInstance();
    }

    public int addSertifikati(Sertifikati sertifikati) {

        try {
            PreparedStatement preparedStatement
                    = con.prepareStatement("insert into sertifikati (proizvodjac, adresa, mesto, zemlja) "
                            + "values (?, ?, ?, ? )", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, sertifikati.getProizvodjac());
            preparedStatement.setString(2, sertifikati.getAdresa());
            preparedStatement.setString(3, sertifikati.getMesto());
            preparedStatement.setString(4, sertifikati.getZemlja());

            int affectedRows = preparedStatement.executeUpdate();

            try (ResultSet rs = preparedStatement.getGeneratedKeys()) {
                if (rs.next()) {
                    System.out.println(rs.getInt(1));
                    return rs.getInt(1);
                }
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public void deleteSertifikati(int Id) {
        try {
            PreparedStatement preparedStatement = con.prepareStatement("update sertifikati set aktivan = 0 where Id=?");
            preparedStatement.setInt(1, Id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateSertifikati(Sertifikati sertifikati) {
        try {
            PreparedStatement preparedStatement = con
                    .prepareStatement("update sertifikati set proizvodjac=?, adresa=?, mesto=?, zemlja=?, aktivan=?"
                            + " where id=?");
            Boolean cc = sertifikati.getAktivan();
            int mAktivan = 0;
            if (cc == true) {
                mAktivan = 1;
            }
            System.out.println(cc);
            preparedStatement.setString(1, sertifikati.getProizvodjac());
            preparedStatement.setString(2, sertifikati.getAdresa());
            // preparedStatement.setDate(3, new java.sql.Date(user.getDob().getTime()));
            preparedStatement.setString(3, sertifikati.getMesto());
            preparedStatement.setString(4, sertifikati.getZemlja());
            preparedStatement.setInt(5, mAktivan);
            preparedStatement.setInt(6, sertifikati.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Sertifikati> getAllSertifikati(String whereUslov) {
        List<Sertifikati> sertifikatiList = new ArrayList<Sertifikati>();
        String sql = "";
        try {
            Statement statement = con.createStatement();
            sql = "select * from sertifikati " + whereUslov + " order by id";
            System.out.println(sql);
            ResultSet rs = statement.executeQuery("select * from sertifikati " + whereUslov + " order by id");
            while (rs.next()) {
                Sertifikati sertifikati = new Sertifikati();
                sertifikati.setId(rs.getInt("id"));
                sertifikati.setProizvodjacId(rs.getInt("proizvodjac_id"));
                sertifikati.setProizvodjac(rs.getString("proizvodjac"));
                sertifikati.setAdresa(rs.getString("adresa"));
                sertifikati.setMesto(rs.getString("mesto"));
                sertifikati.setZemlja(rs.getString("zemlja"));
                sertifikati.setAktivan(rs.getBoolean("aktivan"));
                sertifikatiList.add(sertifikati);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return sertifikatiList;
    }

    public Sertifikati getSertifikatiById(int sertifikatiId) {
        Sertifikati sertifikati = new Sertifikati();
        try {
            PreparedStatement preparedStatement = con.
                    prepareStatement("select * from sertifikati where id=?");
            preparedStatement.setInt(1, sertifikatiId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                sertifikati.setId(rs.getInt("Id"));
                sertifikati.setProizvodjac(rs.getString("proizvodjac"));
                sertifikati.setAdresa(rs.getString("adresa"));
                sertifikati.setMesto(rs.getString("mesto"));
                sertifikati.setZemlja(rs.getString("zemlja"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return sertifikati;
    }

    public List<ProizvodjacDocument> findAllByProizvodjacId(int userId) {
        List<ProizvodjacDocument> proizvodjacDocumentList = new ArrayList<ProizvodjacDocument>();
        try {
            Statement statement = con.createStatement();
            String Query = "select * from proizvodjac_document where proizvodjac_id = "
                    + userId + " ";
            ResultSet rs = statement.executeQuery(Query);
            System.out.println(Query);
            while (rs.next()) {
                ProizvodjacDocument proizvodjacDocument = new ProizvodjacDocument();
                proizvodjacDocument.setAsortiman(rs.getString("asortiman"));
                proizvodjacDocument.setAsortimanSifra(rs.getString("asortiman_sifra"));
                proizvodjacDocument.setBrojSertifikata(rs.getString("broj_sertifikata"));
                proizvodjacDocument.setContent(rs.getBytes("content"));
                proizvodjacDocument.setDatumIzdavanja(rs.getDate("datum_izdavanja"));
                proizvodjacDocument.setDatumKontrole(rs.getDate("datum_kontrole"));
                proizvodjacDocument.setDatumVreme(rs.getTime("datum_vreme"));
                proizvodjacDocument.setDescription(rs.getString("description"));
                proizvodjacDocument.setName(rs.getString("name"));
                proizvodjacDocument.setType(rs.getString("type"));
                proizvodjacDocument.setId(rs.getLong("id"));
                proizvodjacDocument.setKojeupisao(rs.getString("kojeupisao"));
                proizvodjacDocument.setMestoIzdavanja(rs.getString("mesto_izdavanja"));
//                        proizvodjacDocument.getName()
                proizvodjacDocument.setNazivVrstaProizvodnje(rs.getString("naziv_vrsta_proizvodnje"));
                proizvodjacDocument.setRezerva1(rs.getString("rezerva1"));
                proizvodjacDocument.setRezerva2(rs.getString("rezerva2"));
                proizvodjacDocument.setRezerva3(rs.getString("rezerva3"));
                proizvodjacDocument.setSifraVrstaProizvodnje(rs.getString("sifra_vrsta_proizvodnje"));
                proizvodjacDocument.setTipSertifikata(rs.getString("tip_sertifikata"));
                proizvodjacDocument.setTipSertifikataSifra(rs.getString("tip_sertifikata_sifra"));
                proizvodjacDocument.setUserId(rs.getLong("user_id"));
                proizvodjacDocument.setVaziDo(rs.getDate("vazi_do"));

                proizvodjacDocument.setProizvodjacId(rs.getInt("proizvodjac_id"));
                proizvodjacDocument.setProizvodjac(rs.getString("proizvodjac"));

                proizvodjacDocumentList.add(proizvodjacDocument);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return proizvodjacDocumentList;
    }

    public String addDocument(ProizvodjacDocument proizvodjacdocument) {

        try {

            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("set names utf8");
            preparedStatement.execute();
            preparedStatement = con.prepareStatement("set character set utf8");
            preparedStatement.execute();

            preparedStatement = con.prepareStatement(
                    "INSERT INTO proizvodjac_document (`user_id`,`name`,`description`,`type`,`content`, "
                    + "`broj_sertifikata`, `proizvodjac_id`,`proizvodjac`,`sifra_vrsta_proizvodnje`,`naziv_vrsta_proizvodnje`,"
                    + "`datum_kontrole`, `mesto_izdavanja`,`datum_izdavanja`,`vazi_do`,`asortiman_sifra`,`asortiman`,"
                    + "`tip_sertifikata_sifra`, `tip_sertifikata`,`rezerva1`,`rezerva2`,`rezerva3`,`aktivan` "
                    + ") VALUES (?, ?, ?, ?,?, ?, ?, ?,?, ?, ?, ?,?, ?, ?, ?,?, ?, ?, ?, ?, ?)");

            preparedStatement.setString(1, proizvodjacdocument.getProizvodjac());
            preparedStatement.setString(2, proizvodjacdocument.getName());
            preparedStatement.setString(3, proizvodjacdocument.getDescription());
            preparedStatement.setString(4, proizvodjacdocument.getType());
            preparedStatement.setBytes(5, proizvodjacdocument.getContent());
            preparedStatement.setString(6, proizvodjacdocument.getBrojSertifikata());
            preparedStatement.setInt(7, proizvodjacdocument.getProizvodjacId());
            preparedStatement.setString(8, proizvodjacdocument.getProizvodjac());
            preparedStatement.setString(9, proizvodjacdocument.getSifraVrstaProizvodnje());
            preparedStatement.setString(10, proizvodjacdocument.getNazivVrstaProizvodnje());
//            preparedStatement.setDate(11, new Date());
            java.util.Date today = new java.util.Date();
            Date cc = new java.sql.Date(today.getTime());
//            preparedStatement.setDate(11, cc);
            java.sql.Date tt = new java.sql.Date(proizvodjacdocument.getDatumKontrole().getTime());
            preparedStatement.setDate(11, tt);
            preparedStatement.setString(12, proizvodjacdocument.getMestoIzdavanja());

            java.sql.Date tt1 = new java.sql.Date(proizvodjacdocument.getDatumIzdavanja().getTime());
            java.sql.Date tt2 = new java.sql.Date(proizvodjacdocument.getVaziDo().getTime());
            preparedStatement.setDate(13, tt1);
            preparedStatement.setDate(14, tt2);
//            preparedStatement.setDate(13, (Date) proizvodjacdocument.getDatumIzdavanja());
//            preparedStatement.setDate(14, (Date) proizvodjacdocument.getVaziDo());
            preparedStatement.setString(15, proizvodjacdocument.getAsortimanSifra());
            preparedStatement.setString(16, proizvodjacdocument.getAsortiman());
            preparedStatement.setString(17, proizvodjacdocument.getTipSertifikataSifra());
            preparedStatement.setString(18, proizvodjacdocument.getTipSertifikata());
            preparedStatement.setString(19, proizvodjacdocument.getRezerva1());
            preparedStatement.setString(20, proizvodjacdocument.getRezerva2());
            preparedStatement.setString(21, proizvodjacdocument.getRezerva3());
            preparedStatement.setInt(22, 1);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return "Greska " + e.getMessage();
        }
        return "Dokument za proizvođača " + proizvodjacdocument.getProizvodjacId() + " " + proizvodjacdocument.getProizvodjac()
                + " je uspešno upisan.";
    }

    public void deleteProizvodjacDocument(int Id) {
        try {
            PreparedStatement preparedStatement = con.prepareStatement("delete from proizvodjac_document where Id=?");
            preparedStatement.setInt(1, Id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ProizvodjacDocument nadjiProizvodjacDocumentPoId(int userId) {

        ProizvodjacDocument proizvodjacDocument = new ProizvodjacDocument();
        try {
            Statement statement = con.createStatement();
            String Query = "select * from proizvodjac_document where id = "
                    + userId + " ";
            ResultSet rs = statement.executeQuery(Query);
            System.out.println(Query);
            while (rs.next()) {
//                ProizvodjacDocument proizvodjacDocument = new ProizvodjacDocument();
                proizvodjacDocument.setAsortiman(rs.getString("asortiman"));
                proizvodjacDocument.setAsortimanSifra(rs.getString("asortiman_sifra"));
                proizvodjacDocument.setBrojSertifikata(rs.getString("broj_sertifikata"));
                proizvodjacDocument.setContent(rs.getBytes("content"));
                proizvodjacDocument.setDatumIzdavanja(rs.getDate("datum_izdavanja"));
                proizvodjacDocument.setDatumKontrole(rs.getDate("datum_kontrole"));
                proizvodjacDocument.setDatumVreme(rs.getTime("datum_vreme"));
                proizvodjacDocument.setDescription(rs.getString("description"));
                proizvodjacDocument.setName(rs.getString("name"));
                proizvodjacDocument.setType(rs.getString("type"));
                proizvodjacDocument.setId(rs.getLong("id"));
                proizvodjacDocument.setKojeupisao(rs.getString("kojeupisao"));
                proizvodjacDocument.setMestoIzdavanja(rs.getString("mesto_izdavanja"));
                proizvodjacDocument.setNazivVrstaProizvodnje(rs.getString("naziv_vrsta_proizvodnje"));
                proizvodjacDocument.setRezerva1(rs.getString("rezerva1"));
                proizvodjacDocument.setRezerva2(rs.getString("rezerva2"));
                proizvodjacDocument.setRezerva3(rs.getString("rezerva3"));
                proizvodjacDocument.setSifraVrstaProizvodnje(rs.getString("sifra_vrsta_proizvodnje"));
                proizvodjacDocument.setTipSertifikata(rs.getString("tip_sertifikata"));
                proizvodjacDocument.setTipSertifikataSifra(rs.getString("tip_sertifikata_sifra"));
                proizvodjacDocument.setUserId(rs.getLong("user_id"));
                proizvodjacDocument.setVaziDo(rs.getDate("vazi_do"));
                proizvodjacDocument.setProizvodjacId(rs.getInt("proizvodjac_id"));
                proizvodjacDocument.setProizvodjac(rs.getString("proizvodjac"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return proizvodjacDocument;
    }

}
