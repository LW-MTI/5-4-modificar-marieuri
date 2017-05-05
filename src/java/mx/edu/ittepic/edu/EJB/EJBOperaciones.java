/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.ittepic.edu.EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mx.edu.ittepic.nayaritguideg91.entidades.Entidad;
import mx.edu.ittepic.nayaritguideg91.entidades.Lugarturistico;
import mx.edu.ittepic.nayaritguideg91.entidades.Marcaturistica;
import mx.edu.ittepic.nayaritguideg91.entidades.Pais;
import mx.edu.ittepic.nayaritguideg91.entidades.Poblacion;
import mx.edu.ittepic.nayaritguideg91.entidades.Recursosmultimedia;
import mx.edu.ittepic.nayaritguideg91.entidades.Rol;
import mx.edu.ittepic.nayaritguideg91.entidades.Usuario;
import mx.edu.ittepic.nayaritguideg91.entidades.Usuariosistema;
import mx.edu.ittepic.nayaritguideg91.entidades.Visita;

/**
 *
 * @author marieuri
 */
@Stateless
public class EJBOperaciones {
    @PersistenceContext EntityManager em; 
    
    public  String nuevoPais(String pais){
        Pais r = new Pais();
        r.setNombrepais(pais);
        try{
        em.persist(r); //Crear un nuevo elemtno en la base de datos
        
        
            return "{msg:'El país se guardó correctamente'}";
        }catch(Exception e){
            return "{msg:'Error.'}";
        }
    }
    public String nuevaEntidad(String entidad, int idpais){
        Pais p = new Pais();
        
        p=(Pais) em.createNamedQuery("Pais.findByIdpais").setParameter("idpais",idpais).getSingleResult();
        Entidad e= new Entidad();
        e.setNombreentidad(entidad);
        e.setIdpais(p);
    
    
    try{
        em.persist(e); //Crear un nuevo elemtno en la base de datos
        
        
            return "{msg:'La <entidad> se guardó correctamente'}";
        }catch(Exception ex){
            return "{msg:'Error.'}";
        }
}
public String nuevaPoblacion(String poblacion, int identidad){
    Entidad entidad= new Entidad();
    
    entidad= (Entidad) em.createNamedQuery("Entidad.findByIdentidad").setParameter("identidad",identidad).getSingleResult();
    Poblacion p=new Poblacion();
    p.setNombrepoblacion(poblacion);
    try{
        em.persist(p); //Crear un nuevo elemtno en la base de datos
        
        
            return "{msg:'La población se guardó correctamente'}";
        }catch(Exception e){
            return "{msg:'Error.'}";
        }
} 

public String nuevoLugarTuristico(String descripcion,char tipolugar,
                                 int idmarca, String nombrelugar){
    Marcaturistica marca= new Marcaturistica();
    marca= (Marcaturistica) em.createNamedQuery("Marcaturistica.findByIdmarca").setParameter("idmarca", idmarca).getSingleResult();
    Lugarturistico l = new Lugarturistico();
    l.setDescripcion(descripcion);
    l.setTipolugar(tipolugar);
    l.setIdmarca(marca);
    l.setNombrelugar(nombrelugar);
    try{
        em.persist(l); //Crear un nuevo elemtno en la base de datos
        
        //em.merge();  Sirve para insertar y actualizar
            return "{msg:'El lugar turístico se guardó correctamente'}";
        }catch(Exception e){
            return "{msg:'Error.'}";
        }
}

public String nuevaMarcaTuristica(String nombremarcaturistica ){
    Marcaturistica m= new Marcaturistica();
    m.setNombremarcaturistica(nombremarcaturistica);
    try{
        em.persist(m);
        return "{msj:'La Marca Turística se guardó correctamente'}";
    }catch(Exception e){
        return "{msg:'Error'}";
    }
}
public String nuevoUsuario(String nombreUsuario, String contrasena,
                            String correoelectronico, int idpais){
    Pais p= new Pais();
    p=(Pais)em.createNamedQuery("Pais.findByIdpais").setParameter("idpais", idpais).getSingleResult();
    Usuario u = new Usuario();
    u.setNombreusuario(nombreUsuario);
    u.setContrasena(contrasena);
    u.setCorreoelectronico(correoelectronico);
    u.setIdpais(p);
    try{
        em.persist(u);
        return "{msg: 'El Usuario se ha guardado correctamente'}";
    }catch(Exception e){
        return "{msg: 'Error'}";
    }
    
}
public String nuevoRecursoMultimedia(String descripcion, long contenido){
    Recursosmultimedia r = new Recursosmultimedia();
    r.setDescripcion(descripcion);
    r.setContenido(contenido);
    
    try{
        em.persist(r);
        return "{msg:'El Recurso Multimedia se ha guardado correctamente'}";
    }catch(Exception e){
        return "{msg:'Error'}";
    }
}
public String nuevaVisita(int calificacion, String comentarios, int tiposubida,
        int idlugarturistico, int idusuario){
    Lugarturistico l= new Lugarturistico();
    l=(Lugarturistico)em.createNamedQuery("Lugarturistico.findByIdlugarturistico").setParameter("idlugarturistico", idlugarturistico).getSingleResult();
        
    Usuario u= new Usuario();
    u= (Usuario)em.createNamedQuery("Usuario.findByIdusuario").setParameter("idusuario", idusuario).getSingleResult();
    Visita v = new Visita();
    v.setCalificacion(calificacion);
    v.setComentarios(comentarios);
    v.setTiposubida(tiposubida);
    v.setIdlugarturistico(l);
    v.setIdusuario(u);
    try{
        em.persist(v);
        return "{msg:'La Visita se ha guardado correctamente'}";
    }catch(Exception e){
      return "{msg:'Error'}";
    }
}
public String nuevoUsuarioSistema(String nombreusuariosistema,
            String nombrecompleto,char vigente, int idrol,String contra){
    Rol rol= new Rol();
    rol= (Rol) em.createNamedQuery("Rol.findByIdrol").setParameter("idrol", idrol).getSingleResult();
    Usuariosistema u = new Usuariosistema();
    u.setNombreusuariosistema(nombreusuariosistema);
    u.setNombrecompleto(nombrecompleto);
    u.setVigente(vigente);
    u.setIdrol(idrol);
    u.setContra(contra);
   
    
    try{
        em.persist(u);
        return "{msg:'El usuario de sistema se ha insertado correctamente.'}";
    }catch(Exception e){
        return "msg:'Error'";}
       
}
public String nuevoRol(String nombrerol){
    Rol r= new Rol();
    r.setNombrerol(nombrerol);
    try{
        em.persist(r);
        return "{msg:'El Rol se ha insertado correctamente.'}";
    }catch(Exception e){
        return "{msg:'Nuevo rol se ha insertado correctamente.'}";
    }
}
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
