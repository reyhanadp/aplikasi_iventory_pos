/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.daoimpl;

import id.ac.pos.gudang.dao.PengembalianDAO;
import id.ac.pos.gudang.daoimpl.admin.RegionalDAOImpl;
import id.ac.pos.gudang.entity.Pengembalian;
import id.ac.pos.gudang.entity.Produk;
import id.ac.pos.gudang.entity.Regional;
import id.ac.pos.gudang.utility.DatabaseConnectivity;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Operator
 */
public class PengembalianDAOImpl implements PengembalianDAO {

    private Connection conn;

    public PengembalianDAOImpl() {
        conn = DatabaseConnectivity.getConnection();
    }

    @Override
    public String getIdPengembalian() {
        String id_pengembalian = null;
        String SELECT = "select * from tb_trans_pengembalian";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
            if (result != null) {

                //selama result memiliki data
                //return lebih dari 1 data
                while (result.next()) {

                    //mengambil 1 data
                    id_pengembalian = result.getString("id_pengembalian");
                }
            }
        } catch (SQLException ex) {

            Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return id_pengembalian;
    }

    @Override
    public ArrayList<Produk> getProduk(Object pilihan, String jenis_produk) {
        ArrayList<Produk> arrayProdukPrangko = null;
        String SELECT = "";
        if (jenis_produk.compareTo("MS") == 0) {
            SELECT = "SELECT * FROM tb_produk "
                    + "WHERE nama_produk='" + pilihan + "' && "
                    + "id_jenis_produk in (SELECT id_jenis_produk FROM"
                    + " tb_produk WHERE id_jenis_produk = 'SS'"
                    + " || id_jenis_produk = 'MS')";
        } else if (jenis_produk.compareTo("SHP") == 0) {
            SELECT = "SELECT * FROM tb_produk "
                    + "WHERE nama_produk='" + pilihan + "' && "
                    + "id_jenis_produk in (SELECT id_jenis_produk FROM"
                    + " tb_produk WHERE id_jenis_produk = 'SHP'"
                    + " || id_jenis_produk = 'SHPSS')";
        } else {
            SELECT = "SELECT * FROM tb_produk where nama_produk='" + pilihan + "' and id_jenis_produk='" + jenis_produk + "'";
        }
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayProdukPrangko = new ArrayList<>();

                //selama result memiliki data 
                // return lebih dari 1 data 
                while (result.next()) {

                    //mengambil 1 data
                    Produk produk = new Produk();
                    produk.setIdProduk(result.getString(1));
                    int nominal = Integer.parseInt(result.getString(3));
                    produk.setNominal(nominal);
                    int stok = Integer.parseInt(result.getString(5));
                    produk.setStok(stok);

                    //menambahkan data ke array
                    arrayProdukPrangko.add(produk);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arrayProdukPrangko;
    }

    @Override
    public ArrayList<Regional> getIsiRegional(Object pilihan) {
        ArrayList<Regional> arrayRegional = null;
        String SELECT = "SELECT * FROM tb_regional where regional='" + pilihan + "'";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayRegional = new ArrayList<>();

                //selama result memiliki data 
                // return lebih dari 1 data 
                while (result.next()) {

                    //mengambil 1 data
                    Regional regional = new Regional();
                    regional.setIdRegional(result.getString(1));
                    regional.setKodePos(result.getString(3));

                    //menambahkan data ke array
                    arrayRegional.add(regional);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arrayRegional;
    }

    @Override
    public ArrayList<Regional> getRegional() {
        ArrayList<Regional> arrayRegional = null;
        String SELECT = "SELECT * FROM tb_regional";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayRegional = new ArrayList<>();

                //selama result memiliki data 
                // return lebih dari 1 data 
                while (result.next()) {

                    //mengambil 1 data
                    Regional regional = new Regional();
                    regional.setNamaRegional(result.getString(2));

                    //menambahkan data ke array
                    arrayRegional.add(regional);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arrayRegional;
    }

    @Override
    public boolean tambahPengembalian(Pengembalian pengembalian) {
        String INSERT = "INSERT INTO tb_trans_pengembalian VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(INSERT);
            state.setString(1, pengembalian.getId_pengembalian());
            state.setDate(2, new java.sql.Date(pengembalian.getTanggal_pengembalian().getTime()));
            state.setString(3, pengembalian.getJumlah_pengembalian());
            state.setString(4, pengembalian.getDus());
            state.setString(5, pengembalian.getId_regional());
            state.setString(6, pengembalian.getId_produk());
            state.setString(7, pengembalian.getStok_awal());
            state.setString(8, pengembalian.getStok_akhir());
            state.setString(9, pengembalian.getKeterangan());

            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(PengembalianDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public ArrayList<Pengembalian> getPengembalian(String jenis_produk) {
        ArrayList<Pengembalian> arrayPengembalian = null;
        String SELECT = "";
        if (jenis_produk.compareTo("MS") == 0) {
            SELECT = "SELECT * FROM tb_trans_pengembalian where id_produk like 'MS%' OR id_produk like 'SS%'";
        } else if (jenis_produk.compareTo("SHP") == 0) {
            SELECT = "SELECT * FROM tb_trans_pengembalian where id_produk like 'SHP%' OR id_produk like 'SHPSS%'";
        }else{
            SELECT = "SELECT * FROM tb_trans_pengembalian where id_produk like '"+jenis_produk+"%'";
        }
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayPengembalian = new ArrayList<>();

                //selama result memiliki data 
                // return lebih dari 1 data 
                while (result.next()) {

                    //mengambil 1 data
                    Pengembalian pengembalian = new Pengembalian();
                    pengembalian.setId_pengembalian(result.getString(1));
                    pengembalian.setTanggal_pengembalian(result.getDate(2));
                    pengembalian.setJumlah_pengembalian(result.getString(3));
                    pengembalian.setDus(result.getString(4));
                    pengembalian.setId_regional(result.getString(5));
                    pengembalian.setId_produk(result.getString(6));
                    pengembalian.setStok_awal(result.getString(7));
                    pengembalian.setStok_akhir(result.getString(8));
                    pengembalian.setKeterangan(result.getString(9));

                    //menambahkan data ke array
                    arrayPengembalian.add(pengembalian);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PengembalianDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arrayPengembalian;
    }

    @Override
    public ArrayList<Produk> getNamaProduk(String jenis_produk) {
        conn = DatabaseConnectivity.getConnection();
        ArrayList<Produk> arrayProduk = null;
        String SELECT = "";
        if (jenis_produk.compareTo("MS") == 0) {
            SELECT = "SELECT distinct(nama_produk) FROM `tb_produk` where id_jenis_produk='MS' OR id_jenis_produk='SS' ORDER BY nama_produk ASC";
        } else if (jenis_produk.compareTo("SHP") == 0) {
            SELECT = "SELECT distinct(nama_produk) FROM `tb_produk` where id_jenis_produk='SHP' OR id_jenis_produk='SHPSS' ORDER BY nama_produk ASC";
        } else {
            SELECT = "SELECT distinct(nama_produk) FROM `tb_produk` where id_jenis_produk='" + jenis_produk + "' ORDER BY nama_produk ASC";
        }

        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayProduk = new ArrayList<>();

                //selama result memiliki data 
                // return lebih dari 1 data 
                while (result.next()) {

                    //mengambil 1 data
                    Produk produk = new Produk();
                    produk.setNamaProduk(result.getString(1));

                    //menambahkan data ke array
                    arrayProduk.add(produk);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                state.close();
            } catch (SQLException ex) {
                Logger.getLogger(PengembalianDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(PengembalianDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return arrayProduk;
    }

    @Override
    public ArrayList<Produk> getKodeProduk(Object nominal, Object tahun, Object nama_produk, String jenis_produk) {
        conn = DatabaseConnectivity.getConnection();
        ArrayList<Produk> arrayProduk = null;
        String SELECT = "";
        if (jenis_produk.compareTo("MS") == 0) {
            SELECT = "SELECT id_produk,stok FROM tb_produk "
                    + "WHERE nama_produk='" + nama_produk + "' && tahun='" + tahun + "' && nominal='" + nominal + "' && "
                    + "id_jenis_produk in (SELECT id_jenis_produk FROM"
                    + " tb_produk WHERE id_jenis_produk = 'SS'"
                    + " || id_jenis_produk = 'MS')";
        } else if (jenis_produk.compareTo("SHP") == 0) {
            SELECT = "SELECT id_produk,stok FROM tb_produk "
                    + "WHERE nama_produk='" + nama_produk + "' && tahun='" + tahun + "' && nominal='" + nominal + "' && "
                    + "id_jenis_produk in (SELECT id_jenis_produk FROM"
                    + " tb_produk WHERE id_jenis_produk = 'SHP'"
                    + " || id_jenis_produk = 'SHPSS')";
        } else {
            SELECT = "SELECT id_produk,stok FROM tb_produk "
                    + "WHERE nama_produk='" + nama_produk + "' && tahun='" + tahun + "' && nominal='" + nominal + "' && "
                    + "id_jenis_produk='" + jenis_produk + "'";
        }

        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayProduk = new ArrayList<>();

                //selama result memiliki data 
                // return lebih dari 1 data 
                while (result.next()) {

                    //mengambil 1 data
                    Produk produk = new Produk();
                    produk.setIdProduk(result.getString(1));
                    produk.setStok(Integer.parseInt(result.getString(2)));

                    //menambahkan data ke array
                    arrayProduk.add(produk);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                state.close();
            } catch (SQLException ex) {
                Logger.getLogger(PengembalianDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(PengembalianDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return arrayProduk;
    }

    @Override
    public ArrayList<Produk> getTahunProduk(Object nama_produk, String jenis_produk) {
        conn = DatabaseConnectivity.getConnection();
        ArrayList<Produk> arrayProduk = null;
        String SELECT = "";
        if (jenis_produk.compareTo("MS") == 0) {
            SELECT = "SELECT distinct(tahun) FROM `tb_produk` where nama_produk='" + nama_produk + "' AND "
                    + "id_jenis_produk in (SELECT id_jenis_produk FROM"
                    + " tb_produk WHERE id_jenis_produk = 'SS'"
                    + " || id_jenis_produk = 'MS')";
        } else if (jenis_produk.compareTo("SHP") == 0) {
            SELECT = "SELECT distinct(tahun) FROM `tb_produk` where nama_produk='" + nama_produk + "' AND "
                    + "id_jenis_produk in (SELECT id_jenis_produk FROM"
                    + " tb_produk WHERE id_jenis_produk = 'SHP'"
                    + " || id_jenis_produk = 'SHPSS')";
        } else {
            SELECT = "SELECT distinct(tahun) FROM `tb_produk` where nama_produk='" + nama_produk + "' AND id_jenis_produk='" + jenis_produk + "' ORDER BY nama_produk ASC";
        }

        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayProduk = new ArrayList<>();

                //selama result memiliki data 
                // return lebih dari 1 data 
                while (result.next()) {

                    //mengambil 1 data
                    Produk produk = new Produk();
                    produk.setTahun(result.getString(1));

                    //menambahkan data ke array
                    arrayProduk.add(produk);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                state.close();
            } catch (SQLException ex) {
                Logger.getLogger(PengembalianDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(PengembalianDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return arrayProduk;
    }

    @Override
    public ArrayList<Produk> getNominalProduk(Object nama_produk, Object tahun, String jenis_produk) {
        conn = DatabaseConnectivity.getConnection();
        ArrayList<Produk> arrayProduk = null;
        String SELECT = "";
        if (jenis_produk.compareTo("MS") == 0) {
            SELECT = "SELECT nominal FROM `tb_produk` where nama_produk='" + nama_produk + "' AND tahun='" + tahun + "' AND "
                    + "id_jenis_produk in (SELECT id_jenis_produk FROM"
                    + " tb_produk WHERE id_jenis_produk = 'SS'"
                    + " || id_jenis_produk = 'MS')";
        } else if (jenis_produk.compareTo("SHP") == 0) {
            SELECT = "SELECT nominal FROM `tb_produk` where nama_produk='" + nama_produk + "' AND tahun='" + tahun + "' AND "
                    + "id_jenis_produk in (SELECT id_jenis_produk FROM"
                    + " tb_produk WHERE id_jenis_produk = 'SHP'"
                    + " || id_jenis_produk = 'SHPSS')";
        } else {
            SELECT = "SELECT nominal FROM `tb_produk` where nama_produk='" + nama_produk + "' AND tahun='" + tahun + "' AND id_jenis_produk='" + jenis_produk + "' ORDER BY nama_produk ASC";
        }

        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayProduk = new ArrayList<>();

                //selama result memiliki data 
                // return lebih dari 1 data 
                while (result.next()) {

                    //mengambil 1 data
                    Produk produk = new Produk();
                    produk.setNominal(Integer.parseInt(result.getString(1)));

                    //menambahkan data ke array
                    arrayProduk.add(produk);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                state.close();
            } catch (SQLException ex) {
                Logger.getLogger(PengembalianDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(PengembalianDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return arrayProduk;
    }

    @Override
    public ArrayList<Produk> getNama(String kode_produk) {
        conn = DatabaseConnectivity.getConnection();
        ArrayList<Produk> arrayProduk = null;
        String SELECT = "SELECT nama_produk FROM `tb_produk` where id_produk='"+kode_produk+"'";


        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayProduk = new ArrayList<>();

                //selama result memiliki data 
                // return lebih dari 1 data 
                while (result.next()) {

                    //mengambil 1 data
                    Produk produk = new Produk();
                    produk.setNamaProduk(result.getString(1));

                    //menambahkan data ke array
                    arrayProduk.add(produk);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                state.close();
            } catch (SQLException ex) {
                Logger.getLogger(PengembalianDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(PengembalianDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return arrayProduk;
    }
}
