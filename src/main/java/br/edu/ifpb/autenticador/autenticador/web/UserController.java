package br.edu.ifpb.autenticador.autenticador.web;

import br.edu.ifpb.autenticador.autenticador.domain.*;
import br.edu.ifpb.autenticador.autenticador.domain.builder.AdressBuilder;
import br.edu.ifpb.autenticador.autenticador.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> listUsers() {
        return userService.listUsers();
    }

    // TODO - refatorar método para utilizar o padrão BUILDER para construir o endereço
    @PutMapping("/update-address")
    public ResponseEntity<Void> updateAddress(Long userId, String rua, String numero, String bairro, String cidade, String estado, String pais) {
        AdressBuilder builder = new AdressBuilder();

        builder.setStreet(rua)
                .setNumber(numero)
                .setNeighborhood(bairro)
                .setCity(cidade, estado, pais);

        Address address = builder.getResult();

        userService.updateUserAddress(userId, address);

        return ResponseEntity.ok().build();
    }

    @PutMapping("update-permissions")
    public ResponseEntity<Void> updatePermissions(Long userId, String permissionName) {
        userService.updateUserPermission(userId, permissionName);
        return ResponseEntity.ok().build();
    }


}
