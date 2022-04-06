package br.edu.ifpb.autenticador.autenticador.domain;

import br.edu.ifpb.autenticador.autenticador.service.Prototype;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Permissions{

    @Id
    @GeneratedValue
    private Long id;

    private Boolean adminPermission;
    private Boolean listPermission;
    private Boolean updatePermission;
    private Boolean insertPermission;
    private Boolean deletePermission;

    public Permissions(){}

    private Permissions(Permissions objeto){
        this.adminPermission = objeto.adminPermission;
        this.listPermission = objeto.listPermission;
        this.updatePermission = objeto.updatePermission;
        this.insertPermission = objeto.insertPermission;
        this.deletePermission = objeto.deletePermission;

    }

    public Permissions clonar() {
        return new Permissions(this);
    }
}
