package br.edu.ifpb.autenticador.autenticador.domain.builder;

public interface Builder {
    Builder reset();
    Builder setStreet(String street);
    Builder setNumber(String number);
    Builder setNeighborhood(String neighborhood);
    Builder setCity(String nomeCidade, String nomeEstado, String nomePais);
}
