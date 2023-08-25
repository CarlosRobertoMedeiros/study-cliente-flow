package br.com.roberto.backend.serviceenvioconsultacliente.core.entities;

public record Cliente(

  String cpf,
  String email,
  String nome,
  String sobrenome,
  Endereco endereco
){}
