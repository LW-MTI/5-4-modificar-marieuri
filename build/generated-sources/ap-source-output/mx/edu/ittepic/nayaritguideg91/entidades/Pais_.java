package mx.edu.ittepic.nayaritguideg91.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mx.edu.ittepic.nayaritguideg91.entidades.Entidad;
import mx.edu.ittepic.nayaritguideg91.entidades.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-26T00:06:49")
@StaticMetamodel(Pais.class)
public class Pais_ { 

    public static volatile ListAttribute<Pais, Usuario> usuarioList;
    public static volatile SingularAttribute<Pais, Integer> idpais;
    public static volatile ListAttribute<Pais, Entidad> entidadList;
    public static volatile SingularAttribute<Pais, String> nombrepais;

}