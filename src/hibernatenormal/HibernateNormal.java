/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernatenormal;

import hibernatenormal.DAO.ContactoDAO;
import hibernatenormal.entidades.Contacto;
import hibernatenormal.entidades.Direccion;
import hibernatenormal.entidades.Participante;
import hibernatenormal.entidades.Persona;
import hibernatenormal.entidades.Taller;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Samuel
 */
public class HibernateNormal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ContactoDAO contactosDAO = new ContactoDAO(); 
        Contacto contactoRecuperado = null;  
        long idAEliminar = 0;  

        //Creamos tes instancias de Contacto 
        Contacto contacto1 = new Contacto("Contacto 1", "contacto1@contacto.com", "12345678"); 
        Contacto contacto2 = new Contacto("Contacto 2", "contacto2@contacto.com", "87654321"); 
        Contacto contacto3 = new Contacto("Contacto 3", "contacto3@contacto.com", "45612378");  

        //Guardamos las tres instancias, guardamos el id del contacto1 para usarlo posteriormente 
        idAEliminar = contactosDAO.guardaContacto(contacto1); 
        contactosDAO.guardaContacto(contacto2); 
        contactosDAO.guardaContacto(contacto3);  

        //Modificamos el contacto 2 y lo actualizamos 
        contacto2.setNombre("Nuevo Contacto 2"); 
        contactosDAO.actulizarContacto(contacto2);  

        //Recuperamos el contacto1 de la base de datos 
        contactoRecuperado = contactosDAO.getContacato(idAEliminar); 
        System.out.println("Recuperamos a " + contactoRecuperado.getNombre());  

        //Eliminamos al contactoRecuperado (que es el contacto3) 
        contactosDAO.eliminarContacto(contactoRecuperado);  

        //Obtenemos la lista de contactos que quedan en la base de datos y la mostramos 
        List<Contacto> listaContactos = contactosDAO.obtenerListaContacactos();
        System.out.println("Hay " + listaContactos.size() + "contactos en la base de datos");  

        for(Contacto c : listaContactos) 
        { 
            System.out.println("-> " + c.getNombre()); 
        } 
        
        Persona persona1 = new Persona(); 
        persona1.setNombre("Persona que sera borrada");  

        Persona persona2 = new Persona(); 
        persona2.setNombre("Persona que permanecera");  

        Direccion direccion1 = new Direccion(); 
        direccion1.setCalle("Calle 1"); 
        direccion1.setCodigoPostal("12345");  

        Direccion direccion2 = new Direccion(); 
        direccion2.setCalle("Calle 2"); 
        direccion2.setCodigoPostal("54321");  

        persona1.setDireccion(direccion1); 
        persona2.setDireccion(direccion2);  

        Session sesion = HibernateUtil.getSessionFactory().openSession();
    
        Direccion d = new Direccion(); 
        d.setCalle("Calle de Prueba de identificadores"); 
        d.setCodigoPostal("21345");  
        
        sesion.beginTransaction();
        sesion.persist(d);
        sesion.persist(persona1);
        sesion.persist(persona2);
        
        sesion.getTransaction().commit();
        sesion.close();
         
        sesion = HibernateUtil.getSessionFactory().openSession(); 
        sesion.beginTransaction();  

        sesion.delete(persona1);  

        sesion.getTransaction().commit(); 
        sesion.close(); 
        
        //////////////////////////////////////////
        
        sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();  
        Participante estu = new Participante();
        estu.setApellidos("Mestanza");
        estu.setNombre("Samuel");
        estu.setProcedencia("UNC");
        
        Taller taller = new Taller();
        taller.setDescripcion("C# Basico");
        taller.setActivo(true);
        
        estu.addTaller(taller);       
        sesion.persist(estu);

        sesion.getTransaction().commit(); 
        sesion.close(); 
        
        
    }
}
