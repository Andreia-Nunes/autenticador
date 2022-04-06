package br.edu.ifpb.autenticador.autenticador.domain.builder;

import br.edu.ifpb.autenticador.autenticador.domain.*;

public class AdressBuilder implements Builder {
    private String street;
    private String number;
    private String neighborhood;
    private City city;

    @Override
    public Builder reset() {
        this.street = null;
        this.number = null;
        this.neighborhood = null;
        this.city = null;
        return this;
    }

    @Override
    public Builder setStreet(String street) {
        this.street = street;
        return this;
    }

    @Override
    public Builder setNumber(String number) {
        this.number = number;
        return this;
    }

    @Override
    public Builder setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
        return this;
    }

    @Override
    public Builder setCity(String nomeCidade, String nomeEstado, String nomePais) {
        Country country = new Country();
        country.setName(nomePais);

        State state = new State();
        state.setName(nomeEstado);
        state.setCountry(country);

        City city = new City();
        city.setName(nomeCidade);
        city.setState(state);

        this.city = city;
        return this;
    }

    public Address getResult(){
        return new Address(this.street, this.neighborhood, this.number, this.city);
    }
}
