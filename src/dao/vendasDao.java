/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.EtsCliente;
import bean.EtsVendas;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author eduardo
 */
public class vendasDao extends DAO_Abstract{
     @Override
    public void insert(Object object) {
    session.beginTransaction();
    session.save(object);
    session.getTransaction().commit();
    //transações podem ter duas "finalidades" commit ou rollback, onde o commit salva a transação e o rollback defaz 
    }

    @Override
    public void update(Object object) {
    session.beginTransaction();
    session.flush();
    session.clear();
    session.update(object);
    session.getTransaction().commit();
    }

    @Override
    public void delete(Object object) {
    session.beginTransaction(); 
    session.flush();
    session.clear();
    //flush e clear limpam o cache do hibernate pra não enviar as coisas erradas
    session.delete(object);
    session.getTransaction().commit();
    }

    @Override
    public Object list(int id) {
       session.beginTransaction();
        Criteria criteria = session.createCriteria(EtsVendas.class); //importar do bean e do hibernate; criteria é pra fazer select * from na O.O
        criteria.add(Restrictions.eq("ets_idvendas", id)); //é um método estático; id é o parametro da linha 46
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public List listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(EtsVendas.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return(ArrayList) lista;
    }
   public List listData(Date data) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(EtsVendas.class);
        criteria.add(Restrictions.eq("etsData", data));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

     public List listtotal(double total){
    session.beginTransaction();
    Criteria criteria = session.createCriteria(EtsVendas.class);
    criteria.add (Restrictions.gt("etsTotal", total));
    List lista = criteria.list();
    session.getTransaction().commit();
    return  lista;
    }


    public List listdatatotal(Date data, double total) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(EtsVendas.class);
        criteria.add(Restrictions.eq("etsValidade", data));
        criteria.add(Restrictions.gt("etsTotal", total));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    public List listVendas(EtsVendas vendas) {
    session.beginTransaction();
    Criteria criteria = session.createCriteria(EtsVendas.class);
    criteria.add(Restrictions.eq("etsCliente", vendas.getEtsCliente()));
    List lista = criteria.list();
    session.getTransaction().commit();
    return lista;
}
}




  

