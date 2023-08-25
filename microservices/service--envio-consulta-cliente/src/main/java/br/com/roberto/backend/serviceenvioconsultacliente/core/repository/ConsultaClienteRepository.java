package br.com.roberto.backend.serviceenvioconsultacliente.core.repository;

import br.com.roberto.backend.serviceenvioconsultacliente.core.entities.Cliente;

import java.util.Optional;

public interface ConsultaClienteRepository {

    Optional<Cliente> findByCpf(String cpf);

    public void add(Cliente cliente);

}
