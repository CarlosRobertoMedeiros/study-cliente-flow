package br.com.roberto.backend.serviceenvioconsultacliente.transportlayer.rest.api.response;

import java.util.Objects;

public class ClienteResponse {
    private final String cpf;
    private final String email;
    private final String nome;
    private final String sobrenome;
    private final EnderecoResponse endereco;

    public ClienteResponse(

            String cpf,
            String email,
            String nome,
            String sobrenome,
            EnderecoResponse endereco
    ) {
        this.cpf = cpf;
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.endereco = endereco;
    }

    public String cpf() {
        return cpf;
    }

    public String email() {
        return email;
    }

    public String nome() {
        return nome;
    }

    public String sobrenome() {
        return sobrenome;
    }

    public EnderecoResponse endereco() {
        return endereco;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (ClienteResponse) obj;
        return Objects.equals(this.cpf, that.cpf) &&
                Objects.equals(this.email, that.email) &&
                Objects.equals(this.nome, that.nome) &&
                Objects.equals(this.sobrenome, that.sobrenome) &&
                Objects.equals(this.endereco, that.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, email, nome, sobrenome, endereco);
    }

    @Override
    public String toString() {
        return "ClienteResponse[" +
                "cpf=" + cpf + ", " +
                "email=" + email + ", " +
                "nome=" + nome + ", " +
                "sobrenome=" + sobrenome + ", " +
                "endereco=" + endereco + ']';
    }
}
