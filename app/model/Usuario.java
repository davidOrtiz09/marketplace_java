package model;

import javax.persistence.*;

import io.ebean.*;
import play.data.validation.*;

@Entity
@Table(name = "usuarios")
public class Usuario extends BaseModel {

    @Constraints.Required
    public String nombre;

    @Constraints.Required
    public String apellido;

    public static final Finder<Long, Usuario> find = new Finder<>(Usuario.class);

}
