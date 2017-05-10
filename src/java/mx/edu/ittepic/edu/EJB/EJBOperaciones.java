/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.ittepic.edu.EJB;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
    rol= (Rol) em.createNamedQuery("Rol.findByIdrol").setParameter("idrol", idrol).
            getSingleResult();
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
//SECCIÓN DE CONSULTAS
//1
public String consultaPais(){
   
        
        try{
            
            Query q;
            List<Pais> listaPais;
            q= em.createNamedQuery("Pais.findAll");
            //Ejecución de la consulta
            listaPais = q.getResultList();

            for(int i =0; i<listaPais.size(); i++) {
                listaPais.get(i).setUsuarioList(null);
                listaPais.get(i).setEntidadList(null);
            }


            //Convertir la lista de objetos a JSON
            GsonBuilder builder = new GsonBuilder();
            Gson gson=builder.create();
        
            return gson.toJson(listaPais);
        }catch(Exception e){
            return "{msg:'Error'}";
        }
       
        
    }
//2
    public String consultaMarcaTuristica(){
       try{
            Query q;
            List<Marcaturistica> listaMarca;
            q= em.createNamedQuery("Marcaturistica.findAll");
            //Ejecución de la consulta
            listaMarca = q.getResultList();

            for(int i =0; i<listaMarca.size(); i++) {
                listaMarca.get(i).setLugarturisticoList(null);
            }


            //Convertir la lista de objetos a JSON
            GsonBuilder builder = new GsonBuilder();
            Gson gson=builder.create();

            return gson.toJson(listaMarca);
       }catch(Exception e){
           return "{msg:'error'}";
       }
        
    }
    //3
    public String consultaRol(){
    try{
           Query q;
            List<Rol> listaRol;
            q= em.createNamedQuery("Rol.findAll");
            //Ejecución de la consulta
            listaRol = q.getResultList();

            for(int i =0; i<listaRol.size(); i++) {
                listaRol.get(i).setUsuariosistema(null);
            }


            //Convertir la lista de objetos a JSON
            GsonBuilder builder = new GsonBuilder();
            Gson gson=builder.create();

            return gson.toJson(listaRol);
            
        }catch(Exception e){
            return "{msg:'Error'}";
        }
}
    //4
   public String consultaLugarTuristico(){
        
    try{
         
        Query q;
            List<Lugarturistico> listaLugar;
            q= em.createNamedQuery("Lugarturistico.findAll");
            //Ejecución de la consulta
            listaLugar = q.getResultList();

            for(int i =0; i<listaLugar.size(); i++) {
                listaLugar.get(i).setRecursosmultimediaList(null);
                listaLugar.get(i).setVisitaList(null);
            }
        //Convertir la lista de objetos a JSON
            GsonBuilder builder = new GsonBuilder();
            Gson gson=builder.create();
            return gson.toJson(listaLugar);
    }catch(Exception e){
        return "{msg:'error'}";
    } 
   }
   //5
   public String consultaPoblacion(){
        try{

            Query q;
            List<Poblacion> listaPoblacion;
            q= em.createNamedQuery("Poblacion.findAll");
            //Ejecución de la consulta
            listaPoblacion = q.getResultList();

            for(int i =0; i<listaPoblacion.size(); i++) {
                listaPoblacion.get(i).getIdpoblacion();
               
            }
            GsonBuilder builder = new GsonBuilder();
            Gson gson=builder.create();

            return gson.toJson(listaPoblacion);
        }catch(Exception e){
            return "{msg:'error'}";
        } 
    }
   //6
   public String consultaRecursoMultimedia(){
        try{

            Query q;
            List<Recursosmultimedia> listaRecursos;
            q= em.createNamedQuery("Recursosmultimedia.findAll");
            //Ejecución de la consulta
            listaRecursos = q.getResultList();

            for(int i =0; i<listaRecursos.size(); i++) {
                listaRecursos.get(i).setIdlugarturistico(null);
               
            }
            GsonBuilder builder = new GsonBuilder();
            Gson gson=builder.create();

            return gson.toJson(listaRecursos);
        }catch(Exception e){
            return "{msg:'error'}";
        } 
   }
   //7
   public String consultaUsuario(){
        try{

            Query q;
            List<Usuario> listaUsuario;
            q= em.createNamedQuery("Usuario.findAll");
            //Ejecución de la consulta
            listaUsuario = q.getResultList();

            for(int i =0; i<listaUsuario.size(); i++) {
                listaUsuario.get(i).setVisitaList(null);
                listaUsuario.get(i).getIdpais().setEntidadList(null);
                listaUsuario.get(i).getIdpais().setUsuarioList(null);
               
            }
            GsonBuilder builder = new GsonBuilder();
            Gson gson=builder.create();

            return gson.toJson(listaUsuario);
        }catch(Exception e){
            return "{msg:'error'}";
        } 
       
   }
   //8
    public String consultaUsuarioSistema(){
      try{

            Query q;
            List<Usuariosistema> listaUsuarioSistema;
            q= em.createNamedQuery("Usuariosistema.findAll");
            //Ejecución de la consulta
            listaUsuarioSistema = q.getResultList();

            for(int i =0; i<listaUsuarioSistema.size(); i++) {
                listaUsuarioSistema.get(i).setRol(null);
               
            }
            GsonBuilder builder = new GsonBuilder();
            Gson gson=builder.create();

            return gson.toJson(listaUsuarioSistema);
        }catch(Exception e){
            return "{msg:'error'}";
        }  
   }
   //9
   
   public String consultaVisita(){
       try{

            Query q;
            List<Visita> listaVisita;
            q= em.createNamedQuery("Visita.findAll");
            //Ejecución de la consulta
            listaVisita = q.getResultList();

            for(int i =0; i<listaVisita.size(); i++) {
                listaVisita.get(i).getIdlugarturistico().setRecursosmultimediaList(null);
                listaVisita.get(i).getIdlugarturistico().setVisitaList(null);
                listaVisita.get(i).getIdlugarturistico().getIdmarca().setLugarturisticoList(null);
                
                listaVisita.get(i).getIdusuario().setVisitaList(null);
                listaVisita.get(i).getIdusuario().getIdpais().setUsuarioList(null);
                listaVisita.get(i).getIdusuario().getIdpais().setEntidadList(null);
                
                
                
              
                
                
               
                //listaVisita.get(i).getIdlugarturistico().getRecursosmultimediaList();
                //listaVisita.get(i).getIdusuario().getVisitaList();
       
               
            }
            GsonBuilder builder = new GsonBuilder();
            Gson gson=builder.create();

            return gson.toJson(listaVisita);
        }catch(Exception e){
            return "{msg:'error'}";
        }  
   }
   //10
   
   public String consultaEntidad(){
       try{

           Query q;
            List<Entidad> listaEntidad;
            q= em.createNamedQuery("Entidad.findAll");
            //Ejecución de la consulta
            listaEntidad = q.getResultList();

            for(int i =0; i<listaEntidad.size(); i++) {
                listaEntidad.get(i).getIdpais().setEntidadList(null);
                listaEntidad.get(i).getIdpais().setUsuarioList(null);
            }
             
            GsonBuilder builder = new GsonBuilder();
            Gson gson=builder.create();

            return gson.toJson(listaEntidad);
        }catch(Exception e){
            return "{msg:'error'}";
        } 
   }
   
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
