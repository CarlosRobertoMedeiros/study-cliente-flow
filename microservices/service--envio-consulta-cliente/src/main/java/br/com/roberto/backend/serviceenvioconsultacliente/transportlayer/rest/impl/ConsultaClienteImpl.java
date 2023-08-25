package br.com.roberto.backend.serviceenvioconsultacliente.transportlayer.rest.impl;

import br.com.roberto.backend.serviceenvioconsultacliente.core.entities.Cliente;
import br.com.roberto.backend.serviceenvioconsultacliente.core.interactors.ConsultaClienteUseCase;
import br.com.roberto.backend.serviceenvioconsultacliente.transportlayer.rest.api.response.ClienteResponse;
import br.com.roberto.backend.serviceenvioconsultacliente.transportlayer.rest.api.response.EnderecoResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/v1/")
public class ConsultaClienteImpl {

    private static final Logger log = LoggerFactory.getLogger(ConsultaClienteImpl.class);
    private final ConsultaClienteUseCase consultaClienteUseCase;

    public ConsultaClienteImpl(ConsultaClienteUseCase consultaClienteUseCase) {
        this.consultaClienteUseCase = consultaClienteUseCase;
    }

    @GetMapping(value = "{cpf}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<ClienteResponse> get(@PathVariable("cpf") String cpf) {
        log.info("[Api ConsultaClienteImpl] - Consulta Cliente. (cpf={})", cpf);
        return consultaClienteUseCase.get(cpf)
                .map(cliente -> ResponseEntity.ok(getClienteResponse(cliente)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping()
    public void add(@RequestBody Cliente cliente) {
        log.info("[Api ConsultaClienteImpl] - Inclusão de Cliente. (cpf={})", cliente.cpf());
        consultaClienteUseCase.add(cliente);

    }

    private ClienteResponse getClienteResponse(Cliente cliente) {
        EnderecoResponse clienteEndereco = new EnderecoResponse(
                cliente.endereco().cep(),
                cliente.endereco().logradouro(),
                cliente.endereco().complemento(),
                cliente.endereco().bairro(),
                cliente.endereco().localidade(),
                cliente.endereco().uf(),
                cliente.endereco().ibge(),
                cliente.endereco().gia(),
                cliente.endereco().ddd(),
                cliente.endereco().siafi());

        ClienteResponse clienteResponse = new ClienteResponse(
                cliente.cpf(),
                cliente.email(),
                cliente.nome(),
                cliente.sobrenome(),
                clienteEndereco);

        return clienteResponse;
    }

    public ConsultaClienteUseCase consultaClienteUseCase() {
        return consultaClienteUseCase;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (ConsultaClienteImpl) obj;
        return Objects.equals(this.consultaClienteUseCase, that.consultaClienteUseCase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(consultaClienteUseCase);
    }

    @Override
    public String toString() {
        return "ConsultaClienteImpl[" +
                "consultaClienteUseCase=" + consultaClienteUseCase + ']';
    }

}





