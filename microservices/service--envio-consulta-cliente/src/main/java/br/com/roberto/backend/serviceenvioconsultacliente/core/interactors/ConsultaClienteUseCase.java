package br.com.roberto.backend.serviceenvioconsultacliente.core.interactors;

import br.com.roberto.backend.serviceenvioconsultacliente.core.entities.Cliente;
import br.com.roberto.backend.serviceenvioconsultacliente.core.repository.ConsultaClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class ConsultaClienteUseCase {
    private static final Logger log = LoggerFactory.getLogger(ConsultaClienteUseCase.class);
    private final ConsultaClienteRepository consultaClienteRepository;

    public ConsultaClienteUseCase(ConsultaClienteRepository consultaClienteRepository) {
        this.consultaClienteRepository = consultaClienteRepository;
    }


    public Optional<Cliente> get(String cpf) {
        log.info("[Interactor ConsultaClienteUseCase] - Consulta Cliente. (cpf={})", cpf);

        Optional<Cliente> clienteOptional = consultaClienteRepository.findByCpf(cpf);
        //clienteOptional = clienteOptional.filter()
        clienteOptional.ifPresent(cliente -> log.info("[Get Cliente] Consulta Encontrada. (cpf=%s)",cpf));
        return clienteOptional;
    }

    public void add(Cliente cliente) {
        log.info("[Interactor ConsultaClienteUseCase] - Incluir Cliente. (cpf={})", cliente.cpf());
        consultaClienteRepository.add(cliente);
    }

    public ConsultaClienteRepository consultaClienteRepository() {
        return consultaClienteRepository;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (ConsultaClienteUseCase) obj;
        return Objects.equals(this.consultaClienteRepository, that.consultaClienteRepository);
    }

    @Override
    public int hashCode() {
        return Objects.hash(consultaClienteRepository);
    }

    @Override
    public String toString() {
        return "ConsultaClienteUseCase[" +
                "consultaClienteRepository=" + consultaClienteRepository + ']';
    }


}
