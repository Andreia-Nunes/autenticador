package br.edu.ifpb.autenticador.autenticador.service;

import br.edu.ifpb.autenticador.autenticador.domain.Permissions;

import java.util.HashMap;
import java.util.Map;

public class PermissionsRegistry {
    private  Map<String, Permissions> prototypesItems = new HashMap();

    public PermissionsRegistry(){
        Permissions permission = new Permissions();

        //administrador
        permission.setAdminPermission(true);
        this.prototypesItems.put("admin", permission);

        //somente leitura
        permission = new Permissions();
        permission.setAdminPermission(false);
        permission.setListPermission(true);
        permission.setDeletePermission(false);
        permission.setInsertPermission(false);
        permission.setUpdatePermission(false);
        this.prototypesItems.put("somenteLeitura", permission);

        //operador
        permission = new Permissions();
        permission.setAdminPermission(false);
        permission.setDeletePermission(false);
        permission.setListPermission(true);
        permission.setInsertPermission(true);
        permission.setUpdatePermission(true);
        this.prototypesItems.put("operador", permission);

        //default
        permission = new Permissions();
        permission.setAdminPermission(false);
        permission.setDeletePermission(false);
        permission.setListPermission(false);
        permission.setInsertPermission(false);
        permission.setUpdatePermission(false);
        this.prototypesItems.put("default", permission);
    }

    public void addItem(String key, Permissions value){
        prototypesItems.put(key, value);
    }

    public Permissions getItem(String key){
        return this.prototypesItems.get(key).clonar();
    }

}
