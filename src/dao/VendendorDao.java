/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.EtsVendendor;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author eduardo
 */
public class VendendorDao extends DAO_Abstract{
 @Override
    public void insert(Object object) {
    session.beginTransaction();
    session.save(object);
    session.getTransaction().commit();
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
    session.delete(object);
    session.getTransaction().commit();
    }
    public List listcomissao(double comissao){
    session.beginTransaction();
    Criteria criteria = session.createCriteria(EtsVendendor.class);
    criteria.add (Restrictions.gt("etsComissao", comissao));
    List lista = criteria.list();
    session.getTransaction().commit();
    return  lista;
    }
    public List listTelefone(String Telefone){
    session.beginTransaction();
    Criteria criteria = session.createCriteria(EtsVendendor.class);
    criteria.add (Restrictions.like("etsTelefone", "%"+Telefone+"%"));
    List lista = criteria.list();
    session.getTransaction().commit();
    return  lista;
    }
      public List listTelefoneComissao(double comissao ,String Telefone){
    session.beginTransaction();
    Criteria criteria = session.createCriteria(EtsVendendor.class);
    criteria.add (Restrictions.gt("etsComissao", comissao));
    criteria.add (Restrictions.like("etsTelefone", "%"+Telefone+"%"));
    List lista = criteria.list();
    session.getTransaction().commit();
    return  lista;
    }

    @Override
    public Object list(int id) {
     session.beginTransaction();
        Criteria criteria = session.createCriteria(EtsVendendor.class); //importar do bean e do hibernate; criteria é pra fazer select * from na O.O
        criteria.add(Restrictions.eq("ets_idvendendor", id)); //é um método estático; id é o parametro da linha 46
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public List listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(EtsVendendor.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return(ArrayList) lista;
    }   
}
