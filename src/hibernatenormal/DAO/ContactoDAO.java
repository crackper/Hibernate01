/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernatenormal.DAO;

import hibernatenormal.entidades.Contacto;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Samuel
 */
public class ContactoDAO {
    private Session sesion;
    private Transaction tx;
    
    private void iniciaOperacion() throws HibernateException
    {
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }
    
    private void manejaExcepcion(HibernateException he) throws HibernateException
    {
        tx.rollback();
        throw  new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
    }
    
    public long guardaContacto(Contacto contacto)
    {
        long id = 0;
        
        try {
            iniciaOperacion();
            id = (Long)sesion.save(contacto);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw  he;
        }finally{
            sesion.close();
        } 
        return id;
    }
    
    public void actulizarContacto(Contacto contacto)throws HibernateException
    {
        try {
            iniciaOperacion();
            sesion.update(contacto);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        }finally{
            sesion.close();
        }
    }
    
    public void eliminarContacto(Contacto contacto) throws HibernateException
    {
        try {
            iniciaOperacion();
            sesion.delete(contacto);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        }finally{
            sesion.close();
        }
    }
    
    public Contacto getContacato(long id)throws HibernateException
    {
        Contacto contacto = null;
        
        try {
            iniciaOperacion();
            contacto = (Contacto)sesion.get(Contacto.class, id);
        } finally{
            sesion.close();
        }
        
        return  contacto;
    }
    
    public List<Contacto> obtenerListaContacactos() throws HibernateException
    {
        List<Contacto> contactos = null;
        
        try {
            iniciaOperacion();
            contactos = sesion.createQuery("from Contacto").list();
        } finally {
            sesion.close();
        }
        
        return contactos;
    }
}
