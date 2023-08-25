package br.com.roberto.backend.serviceenvioconsultacliente.datasources;

import br.com.roberto.backend.serviceenvioconsultacliente.core.entities.Cliente;
import br.com.roberto.backend.serviceenvioconsultacliente.core.repository.ConsultaClienteRepository;
import br.com.roberto.backend.serviceenvioconsultacliente.datasources.exceptions.ClienteConvertJsonException;
import br.com.roberto.backend.serviceenvioconsultacliente.datasources.exceptions.ClientePersistenceException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Repository
public class ConsultaClienteDataSource implements ConsultaClienteRepository {

    private static final Logger log = LoggerFactory.getLogger(ConsultaClienteDataSource.class);
    private final RedisTemplate<String, String> redisTemplate;
    private final ObjectMapper objectMapper;

    public ConsultaClienteDataSource(RedisTemplate<String, String> redisTemplate,
                                     ObjectMapper objectMapper) {
        this.redisTemplate = redisTemplate;
        this.objectMapper = objectMapper;
    }

    public void add(Cliente cliente){
        try {
            redisTemplate.opsForValue().set(cliente.cpf(), objectMapper.writeValueAsString(cliente));
        }catch (Exception e){
            throw new ClientePersistenceException("[Inclusão de Consulta] Erro ao persistir os dados de consulta no Redis. (cpf=%s)"
                    .formatted(cliente.cpf()),e);
        }
    }

    @Override
    public Optional<Cliente> findByCpf(String cpf) {
        log.info("[Get ConsultaCliente] - retornando cliente pelo cpf. (cpf={})", cpf);

        Set<String> keys = redisTemplate.keys(cpf);

        return keys.stream()
                .findFirst()
                .map(key -> redisTemplate.opsForValue().get(key))
                .map(this::converteJsonParaCliente);
    }

    private Cliente converteJsonParaCliente(String clienteJson) {
        try {
            return objectMapper.readValue(clienteJson, Cliente.class);
        } catch (JsonProcessingException e) {
            throw new ClienteConvertJsonException(e);
        }

    }

    public RedisTemplate<String, String> redisTemplate() {
        return redisTemplate;
    }

    public ObjectMapper objectMapper() {
        return objectMapper;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (ConsultaClienteDataSource) obj;
        return Objects.equals(this.redisTemplate, that.redisTemplate) &&
                Objects.equals(this.objectMapper, that.objectMapper);
    }

    @Override
    public int hashCode() {
        return Objects.hash(redisTemplate, objectMapper);
    }

    @Override
    public String toString() {
        return "ConsultaClienteDataSource[" +
                "redisTemplate=" + redisTemplate + ", " +
                "objectMapper=" + objectMapper + ']';
    }

}
