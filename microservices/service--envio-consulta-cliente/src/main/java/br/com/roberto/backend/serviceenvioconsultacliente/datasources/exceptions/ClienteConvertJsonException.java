package br.com.roberto.backend.serviceenvioconsultacliente.datasources.exceptions;

public class ClienteConvertJsonException extends RuntimeException{

    public ClienteConvertJsonException(Throwable cause) {
        super(cause);
    }

    public ClienteConvertJsonException(String message) {
        super(message);
    }
}
