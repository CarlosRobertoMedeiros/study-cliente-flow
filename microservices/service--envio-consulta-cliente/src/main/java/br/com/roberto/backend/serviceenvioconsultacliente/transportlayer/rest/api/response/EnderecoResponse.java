package br.com.roberto.backend.serviceenvioconsultacliente.transportlayer.rest.api.response;

import java.util.Objects;

public class EnderecoResponse {
    private final String cep;
    private final String logradouro;
    private final String complemento;
    private final String bairro;
    private final String localidade;
    private final String uf;
    private final String ibge;
    private final String gia;
    private final String ddd;
    private final String siafi;

    public EnderecoResponse(
            String cep,
            String logradouro,
            String complemento,
            String bairro,
            String localidade,
            String uf,
            String ibge,
            String gia,
            String ddd,
            String siafi
    ) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.ibge = ibge;
        this.gia = gia;
        this.ddd = ddd;
        this.siafi = siafi;
    }

    public String cep() {
        return cep;
    }

    public String logradouro() {
        return logradouro;
    }

    public String complemento() {
        return complemento;
    }

    public String bairro() {
        return bairro;
    }

    public String localidade() {
        return localidade;
    }

    public String uf() {
        return uf;
    }

    public String ibge() {
        return ibge;
    }

    public String gia() {
        return gia;
    }

    public String ddd() {
        return ddd;
    }

    public String siafi() {
        return siafi;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (EnderecoResponse) obj;
        return Objects.equals(this.cep, that.cep) &&
                Objects.equals(this.logradouro, that.logradouro) &&
                Objects.equals(this.complemento, that.complemento) &&
                Objects.equals(this.bairro, that.bairro) &&
                Objects.equals(this.localidade, that.localidade) &&
                Objects.equals(this.uf, that.uf) &&
                Objects.equals(this.ibge, that.ibge) &&
                Objects.equals(this.gia, that.gia) &&
                Objects.equals(this.ddd, that.ddd) &&
                Objects.equals(this.siafi, that.siafi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cep, logradouro, complemento, bairro, localidade, uf, ibge, gia, ddd, siafi);
    }

    @Override
    public String toString() {
        return "EnderecoResponse[" +
                "cep=" + cep + ", " +
                "logradouro=" + logradouro + ", " +
                "complemento=" + complemento + ", " +
                "bairro=" + bairro + ", " +
                "localidade=" + localidade + ", " +
                "uf=" + uf + ", " +
                "ibge=" + ibge + ", " +
                "gia=" + gia + ", " +
                "ddd=" + ddd + ", " +
                "siafi=" + siafi + ']';
    }
}
