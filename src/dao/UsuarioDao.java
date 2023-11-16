/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.EtsUsuario;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author eduardo
 */
public class UsuarioDao extends DAO_Abstract{
  
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
        Criteria criteria = session.createCriteria(EtsUsuario.class); //importar do bean e do hibernate; criteria é pra fazer select * from na O.O
        criteria.add(Restrictions.eq("ets_idusuario", id)); //é um método estático; id é o parametro da linha 46
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public List listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(EtsUsuario.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return(ArrayList) lista;
    }
    public List listNome(String nome){
    session.beginTransaction();
    Criteria criteria = session.createCriteria(EtsUsuario.class);
    criteria.add (Restrictions.like("etsNome", "%"+nome+"%"));
    List lista = criteria.list();
    session.getTransaction().commit();
    return  lista;
    }
    public List listCpf(String Cpf){
    session.beginTransaction();
    Criteria criteria = session.createCriteria(EtsUsuario.class);
    criteria.add (Restrictions.like("etsCpf", "%"+Cpf+"%"));
    List lista = criteria.list();
    session.getTransaction().commit();
    return  lista;
    }
      public List listCpfNome(String Cpf ,String nome){
    session.beginTransaction();
    Criteria criteria = session.createCriteria(EtsUsuario.class);
    criteria.add (Restrictions.like("etsCpf", "%"+Cpf+"%"));
    criteria.add (Restrictions.like("etsNome", "%"+nome+"%"));
    List lista = criteria.list();
    session.getTransaction().commit();
    return  lista;
    }
    
    public EtsUsuario login(String usuario, String senha) {
    session.beginTransaction();
    Criteria criteria = session.createCriteria(EtsUsuario.class);
    criteria.add(Restrictions.eq("etsApelido", usuario));
    criteria.add(Restrictions.eq("etsSenha", senha));
    EtsUsuario usuarioAutenticado = (EtsUsuario) criteria.uniqueResult();
    session.getTransaction().commit();
    return usuarioAutenticado;
}

}
    
