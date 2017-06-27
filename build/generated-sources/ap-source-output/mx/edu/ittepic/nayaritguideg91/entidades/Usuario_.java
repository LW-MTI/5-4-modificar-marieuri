package mx.edu.ittepic.nayaritguideg91.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mx.edu.ittepic.nayaritguideg91.entidades.Pais;
import mx.edu.ittepic.nayaritguideg91.entidades.Visita;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-26T00:06:49")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> nombreusuario;
    public static volatile SingularAttribute<Usuario, Pais> idpais;
    public static volatile SingularAttribute<Usuario, String> contrasena;
    public static volatile ListAttribute<Usuario, Visita> visitaList;
    public static volatile SingularAttribute<Usuario, String> correoelectronico;
    public static volatile SingularAttribute<Usuario, Integer> idusuario;

}