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
import javax.persistence.TransactionRequiredException;
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
public String nuevoRecursoMultimedia(String descripcion, long contenido, int idlugarturistico){
    Lugarturistico l= new Lugarturistico();
    l=(Lugarturistico)em.createNamedQuery("Lugarturistico.findByIdlugarturistico").setParameter("idlugarturistico", idlugarturistico).getSingleResult();
    Recursosmultimedia r = new Recursosmultimedia();
    r.setDescripcion(descripcion);
    r.setContenido(contenido);
    r.setIdlugarturistico(l);
    
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
   //****************INSERTAR
   //1
   public String actualizaPais(int idpais,String nombrePais){
      GsonBuilder builder = new GsonBuilder();
      Gson gson = builder.create(); 
      Pais pais= new Pais();
      
      
      try{
          
          pais.setIdpais(idpais);
          pais.setNombrepais(nombrePais);
         
          em.merge(pais);
          return gson.toJson(pais);
      }catch (NumberFormatException e) {
            
            return "{msg:'Error 400 Error de tipo dato'}";
        } catch(IllegalArgumentException e){
           return "{msg:'Error 422 Error no existe Entidad'}";
         
        } catch(TransactionRequiredException e){
            return "{msg:'Error Se ha excedido el número de peticiones'}";
        }
       
   }
   //2
   public String actualizaRol(int idrol, String nombreRol){
      GsonBuilder builder = new GsonBuilder();
      Gson gson = builder.create(); 
      Rol rol= new Rol();
      
      
      try{
          
          rol.setIdrol(idrol);
          rol.setNombrerol(nombreRol);
         
          em.merge(rol);
          return gson.toJson(rol);
      }catch (NumberFormatException e) {
            
            return "{msg:'Error 400 Error de tipo dato'}";
        } catch(IllegalArgumentException e){
           return "{msg:'Error 422 Error no existe Entidad'}";
         
        } catch(TransactionRequiredException e){
            return "{msg:'Error Se ha excedido el número de peticiones'}";
        }
   }
   //3
   public String actualizaMarcaTuristica(int idmarca, String nombreMarcaTuristica){
      GsonBuilder builder = new GsonBuilder();
      Gson gson = builder.create(); 
      Marcaturistica marca= new Marcaturistica();
      
      
      try{
          
          marca.setIdmarca(idmarca);
          marca.setNombremarcaturistica(nombreMarcaTuristica);
          
         
          em.merge(marca);
          return gson.toJson(marca);
      }catch (NumberFormatException e) {
            
            return "{msg:'Error 400 Error de tipo dato'}";
        } catch(IllegalArgumentException e){
           return "{msg:'Error 422 Error no existe Entidad'}";
         
        } catch(TransactionRequiredException e){
            return "{msg:'Error Se ha excedido el número de peticiones'}";
        }
   }
   //4
   public String actualizaEntidad(int identidad, String nombreentidad){
      GsonBuilder builder = new GsonBuilder();
      Gson gson = builder.create(); 
      Entidad entidad= new Entidad();
      
      
      try{
          
          entidad.setIdentidad(identidad);
          entidad.setNombreentidad(nombreentidad);
          
         
          em.merge(entidad);
          return gson.toJson(entidad);
      }catch (NumberFormatException e) {
            
            return "{msg:'Error 400 Error de tipo dato'}";
        } catch(IllegalArgumentException e){
           return "{msg:'Error 422 Error no existe Entidad'}";
         
        } catch(TransactionRequiredException e){
            return "{msg:'Error Se ha excedido el número de peticiones'}";
        }  
   }
   //5 población
   public String actualizaPoblacion(int idpoblacion, String nombrepoblacion){
      GsonBuilder builder = new GsonBuilder();
      Gson gson = builder.create(); 
      Poblacion poblacion= new Poblacion();
      
      
      try{
          
          poblacion.setIdpoblacion(idpoblacion);
          poblacion.setNombrepoblacion(nombrepoblacion);
          
         
          em.merge(poblacion);
          return gson.toJson(poblacion);
      }catch (NumberFormatException e) {
            
            return "{msg:'Error 400 Error de tipo dato'}";
        } catch(IllegalArgumentException e){
           return "{msg:'Error 422 Error no existe Entidad'}";
         
        } catch(TransactionRequiredException e){
            return "{msg:'Error Se ha excedido el número de peticiones'}";
        }  
   }
   
   //6 lugarturistico
   public String actualizaLugarTuristico(int idlugar, String nombreLugar,
                String descripcion,char tipolugar){
      GsonBuilder builder = new GsonBuilder();
      Gson gson = builder.create(); 
      Lugarturistico lugar= new Lugarturistico();
      
      
      try{
          
          lugar.setIdlugarturistico(idlugar);
          lugar.setDescripcion(descripcion);
          lugar.setNombrelugar(nombreLugar);
          lugar.setTipolugar(tipolugar);
          
         
          em.merge(lugar);
          return gson.toJson(lugar);
      }catch (NumberFormatException e) {
            
            return "{msg:'Error 400 Error de tipo dato'}";
        } catch(IllegalArgumentException e){
           return "{msg:'Error 422 Error no existe Entidad'}";
         
        } catch(TransactionRequiredException e){
            return "{msg:'Error Se ha excedido el número de peticiones'}";
        }  
   }
   
   //7 recursosmultimedia
   
   public String actualizaRecursoMultimedia(int idrecurso, String descripcion){
      GsonBuilder builder = new GsonBuilder();
      Gson gson = builder.create(); 
      Recursosmultimedia recurso= new Recursosmultimedia();
      try{
          
          recurso.setIdrecurso(idrecurso);
          recurso.setDescripcion(descripcion);
                
          em.merge(recurso);
          return gson.toJson(recurso);
      }catch (NumberFormatException e) {
            
            return "{msg:'Error 400 Error de tipo dato'}";
        } catch(IllegalArgumentException e){
           return "{msg:'Error 422 Error no existe Entidad'}";
         
        } catch(TransactionRequiredException e){
            return "{msg:'Error Se ha excedido el número de peticiones'}";
        }  
       
   }
   
   //8 usuario
   public String actualizaUsuario(int idusuario, String nombreusuario,
           String contrasena, String correoelectronico, int idpais){
      
       GsonBuilder builder = new GsonBuilder();
      Gson gson = builder.create(); 
      Usuario usuario= new Usuario();
      
      
      try{
          Pais pais= new Pais();
          pais=(Pais) em.createNamedQuery("Pais.findByIdpais").setParameter("idpais", idpais).getSingleResult();
          pais.setUsuarioList(null);
          usuario.setIdusuario(idusuario);
          usuario.setContrasena(contrasena);
          usuario.setNombreusuario(nombreusuario);
          usuario.setCorreoelectronico(correoelectronico);
          usuario.setIdpais(pais);
          usuario.setVisitaList(null);
          
         
          em.merge(usuario);
          return "{msg:'Se ha actualizado el Usuario'}";
          //return gson.toJson(usuario);
      }catch (NumberFormatException e) {
            
            return "{msg:'Error 400 Error de tipo dato'}";
        } catch(IllegalArgumentException e){
           return "{msg:'Error 422 Error no existe Entidad'}";
         
        } catch(TransactionRequiredException e){
            return "{msg:'Error Se ha excedido el número de peticiones'}";
        }  
   }
   
   //9 usuariosistema
   
   public String actualizaUsuarioSistema(int idusuariosistema,
                            String nombreusuariosistema,
                            String nombrecompleto, String contra,
                            char vigente ){
      GsonBuilder builder = new GsonBuilder();
      Gson gson = builder.create(); 
      Usuariosistema usuarioS= new Usuariosistema();
      
      
      try{
          
          usuarioS.setIdusuariosistema(idusuariosistema);
          usuarioS.setNombrecompleto(nombrecompleto);
          usuarioS.setNombreusuariosistema(nombreusuariosistema);
          usuarioS.setContra(contra);
          usuarioS.setVigente(vigente);
         
         
          em.merge(usuarioS);
          return gson.toJson(usuarioS);
      }catch (NumberFormatException e) {
            
            return "{msg:'Error 400 Error de tipo dato'}";
        } catch(IllegalArgumentException e){
           return "{msg:'Error 422 Error no existe Entidad'}";
         
        } catch(TransactionRequiredException e){
            return "{msg:'Error Se ha excedido el número de peticiones'}";
        }  
   }
   
   //10 visita
   
   public String actualizaVisita(int idvisita, int calificacion,
                                 String comentarios,
                                 int tiposubida,int idusuario,
                                 int idlugarturistico
                                 ){
      GsonBuilder builder = new GsonBuilder();
      Gson gson = builder.create(); 
      Visita visita= new Visita();
      
      
      try{
          
          Lugarturistico lugar= new Lugarturistico();
          lugar= (Lugarturistico) em.createNamedQuery("Lugarturistico.findByIdlugarturistico").setParameter("idlugarturistico", idlugarturistico).getSingleResult();
          lugar.setVisitaList(null);
          lugar.setRecursosmultimediaList(null);
          
          Usuario usuario=new Usuario();
          usuario=(Usuario)em.createNamedQuery("Usuario.findByIdusuario").setParameter("idusuario", idusuario).getSingleResult();
          usuario.setVisitaList(null);
          
          visita.setIdvisita(idvisita);
          visita.setComentarios(comentarios);
          visita.setCalificacion(calificacion);
          visita.setTiposubida(tiposubida);
          visita.setIdlugarturistico(lugar);
          visita.setIdusuario(usuario);
          em.merge(visita);
          //return gson.toJson(visita);
          // 
         return "{msg:'Se ha insertado la visita'}";
      }catch (NumberFormatException e) {
            
            return "{msg:'Error 400 Error de tipo dato'}";
        } catch(IllegalArgumentException e){
           return "{msg:'Error 422 Error no existe Entidad'}";
         
        } catch(TransactionRequiredException e){
            return "{msg:'Error Se ha excedido el número de peticiones'}";
        }catch(Exception e){ 
            return "msg: 'Error en Visita'";
        }
        
   }
   
   
   //***********sección de ELIMINAR
   //1
   public String eliminaVisita(int idvisita){
       
       Visita visita= new Visita();
       
       try{
           visita=(Visita) em.createNamedQuery("Visita.findByIdvisita").setParameter("idvisita",idvisita).getSingleResult();
           em.remove(em.merge(visita));
           return "{msg:'Se ha eliminado correctamente la visita'}";
       }catch(Exception e){
        return "{msg:'error al eliminar Visita'}";
       }
       
   }
   //2
   public String eliminaUsuarioSistema(int idusuariosistema){
       Usuariosistema usuario = new Usuariosistema();
     
     try{
           usuario=(Usuariosistema) em.createNamedQuery("Usuariosistema.findByIdusuariosistema").setParameter("idusuariosistema",idusuariosistema).getSingleResult();
           em.remove(em.merge(usuario));
           return "{msg:'Se ha eliminado correctamente el Usuario de Sistema}";
       }catch(Exception e){
        return "{msg:'error al eliminar Usuario Sistema'}";
       }
   }
   //3
   public String eliminaRol(int idrol){
     Rol rol = new Rol();
     
     try{
           rol=(Rol) em.createNamedQuery("Rol.findByIdrol").setParameter("idrol",idrol).getSingleResult();
           em.remove(em.merge(rol));
           return "{msg:'Se ha eliminado correctamente el Rol}";
       }catch(Exception e){
        return "{msg:'error al eliminar Rol'}";
       }
   
   }
   //4
   public String eliminaRecursosMultimedia(int idrecurso){
        Recursosmultimedia recurso = new Recursosmultimedia();
     
     try{
           recurso=(Recursosmultimedia) em.createNamedQuery("Recursosmultimedia.findByIdrecurso").setParameter("idrecurso",idrecurso).getSingleResult();
           em.remove(em.merge(recurso));
           return "{msg:'Se ha eliminado correctamente el Recurso Multimedia}";
       }catch(Exception e){
        return "{msg:'error al eliminar el Recurso Multimedia'}";
       }
   }
   //5
   public String eliminaLugarTuristico(int idlugarturistico){
       Lugarturistico lugar = new Lugarturistico();
       try{
           lugar=(Lugarturistico) em.createNamedQuery("Lugarturistico.findByIdlugarturistico").setParameter("idlugarturistico",idlugarturistico).getSingleResult();
           em.remove(em.merge(lugar));
           return "{msg:'Se ha eliminado correctamente el Lugar Turístico}";
       }catch(Exception e){
        return "{msg:'error al eliminar el Lugar Turístico'}";
       }
   }
   //6 
   public String eliminaMarcaTuristica(int idmarca){
       Marcaturistica marca= new Marcaturistica();
       try{
           marca=(Marcaturistica) em.createNamedQuery("Marcaturistica.findByIdmarca").setParameter("idmarca",idmarca).getSingleResult();
           em.remove(em.merge(marca));
           return "{msg:'Se ha eliminado correctamente la Marca Turística}";
       }catch(Exception e){
        return "{msg:'Error al eliminar el Marca Turística'}";
       }
   
   }
   //7
   public String eliminaPoblacion(int idpoblacion){
       Poblacion poblacion = new Poblacion();
       try{
           poblacion=(Poblacion) em.createNamedQuery("Poblacion.findByIdpoblacion").setParameter("idpoblacion",idpoblacion).getSingleResult();
           em.remove(em.merge(poblacion));
           return "{msg:'Se ha eliminado correctamente la Población}";
       }catch(Exception e){
        return "{msg:'Error al eliminar el Población'}";
       }
   
   }
   //8
   public String eliminaEntidad(int identidad){
       Entidad entidad = new Entidad();
        try{
           entidad=(Entidad) em.createNamedQuery("Entidad.findByIdentidad").setParameter("identidad",identidad).getSingleResult();
           em.remove(em.merge(entidad));
           return "{msg:'Se ha eliminado correctamente la Entidad}";
       }catch(Exception e){
        return "{msg:'Error al eliminar la Entidad'}";
       }
   }
   //9
   public String eliminaUsuario (int idusuario){
       Usuario usuario = new Usuario();
       try{
           usuario=(Usuario) em.createNamedQuery("Usuario.findByIdusuario").setParameter("idusuario",idusuario).getSingleResult();
           em.remove(em.merge(usuario));
           return "{msg:'Se ha eliminado correctamente el Usuario}";
       }catch(Exception e){
        return "{msg:'Error al eliminar el Usuario'}";
       }
   }
   //10
   public String eliminaPais(int idpais){
       Pais pais = new Pais();
       try{
           pais=(Pais) em.createNamedQuery("Pais.findByIdpais").setParameter("idpais",idpais).getSingleResult();
           em.remove(em.merge(pais));
           return "{msg:'Se ha eliminado correctamente el País}";
       }catch(Exception e){
        return "{msg:'Error al eliminar el País'}";
       }
   }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
