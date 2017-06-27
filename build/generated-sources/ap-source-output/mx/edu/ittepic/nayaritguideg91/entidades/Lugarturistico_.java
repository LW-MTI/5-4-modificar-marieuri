package mx.edu.ittepic.nayaritguideg91.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mx.edu.ittepic.nayaritguideg91.entidades.Marcaturistica;
import mx.edu.ittepic.nayaritguideg91.entidades.Poblacion;
import mx.edu.ittepic.nayaritguideg91.entidades.Recursosmultimedia;
import mx.edu.ittepic.nayaritguideg91.entidades.Visita;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-26T00:06:49")
@StaticMetamodel(Lugarturistico.class)
public class Lugarturistico_ { 

    public static volatile SingularAttribute<Lugarturistico, String> descripcion;
    public static volatile ListAttribute<Lugarturistico, Recursosmultimedia> recursosmultimediaList;
    public static volatile SingularAttribute<Lugarturistico, Character> tipolugar;
    public static volatile SingularAttribute<Lugarturistico, Marcaturistica> idmarca;
    public static volatile SingularAttribute<Lugarturistico, Integer> idlugarturistico;
    public static volatile SingularAttribute<Lugarturistico, Poblacion> idpoblacion;
    public static volatile ListAttribute<Lugarturistico, Visita> visitaList;
    public static volatile SingularAttribute<Lugarturistico, String> nombrelugar;
    public static volatile SingularAttribute<Lugarturistico, byte[]> codigoqr;

}