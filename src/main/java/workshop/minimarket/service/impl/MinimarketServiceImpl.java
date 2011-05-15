/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop.minimarket.service.impl;

import java.util.List;
import workshop.minimarket.entity.Barang;
import workshop.minimarket.entity.Grup;
import workshop.minimarket.entity.Produk;
import workshop.minimarket.service.MinimarketService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Jaka
 */
@Service("minimarketService")
@Transactional
public class MinimarketServiceImpl implements MinimarketService {

    @Autowired
    private SessionFactory sessionFactory;
    
    //GRUP

    @Override
    public void simpanGrup(Grup grup) {
        sessionFactory.getCurrentSession().saveOrUpdate(grup);
    }

    @Override
    public void hapusGrup(Grup grup) {
        sessionFactory.getCurrentSession().delete(grup);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Grup> cariSemuaGrup() {
        return sessionFactory.getCurrentSession()
    	.createQuery("from Grup order by kodeGrup")
    	.list();
    }

    @Override
    public Grup cariGrupByKodeGrup(Long kodeGrup) {
        return (Grup) sessionFactory.getCurrentSession().get(Grup.class, kodeGrup);
    }

    
    //PRODUK
    
    @Override
    public void simpanProduk(Produk produk) {
        sessionFactory.getCurrentSession().saveOrUpdate(produk);
    }

    @Override
    public void hapusProduk(Produk produk) {
        sessionFactory.getCurrentSession().delete(produk);
    }

    @Override
    public List<Produk> cariSemuaProduk() {
        return sessionFactory.getCurrentSession()
    	.createQuery("from Produk order by namaProduk")
    	.list();
    }

    @Override
    public Produk cariProdukByKodeProduk(Long kodeProduk) {
        return (Produk) sessionFactory.getCurrentSession().get(Produk.class, kodeProduk);
    }
    
    //BARANG

    @Override
    public void simpanBarang(Barang barang) {
        sessionFactory.getCurrentSession().saveOrUpdate(barang);
    }

    @Override
    public void hapusBarang(Barang barang) {
        sessionFactory.getCurrentSession().delete(barang);
    }

    @Override
    public List<Barang> cariSemuaBarang() {
        return sessionFactory.getCurrentSession()
    	.createQuery("from Barang order by namaBarang")
    	.list();
    }

    @Override
    public Barang cariBarangByKodeBarang(Long kodeBarang) {
        return (Barang) sessionFactory.getCurrentSession().get(Barang.class, kodeBarang);
    }
}