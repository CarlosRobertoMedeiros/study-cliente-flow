package br.com.roberto.backend.serviceenvioconsultacliente.datasources.exceptions;

public class ClientePersistenceException extends RuntimeException {

    public ClientePersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
