package com.example.teste.models;


import jakarta.persistence.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "locais")
public class LocaisModels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(max = 100)
    @NotNull
    @NotEmpty
    private String bairro;

    @Size(max = 200)
    @NotNull
    @NotEmpty
    private String endereco;

    @Size(max = 100)
    @NotNull
    @NotEmpty
    private String email;

    public @Size(max = 100) @NotNull @NotEmpty String getEmail() {
        return email;
    }

    public void setEmail(@Size(max = 100) @NotNull @NotEmpty String email) {
        this.email = email;
    }

    public @Size(max = 200) @NotNull @NotEmpty String getEndereco() {
        return endereco;
    }

    public void setEndereco(@Size(max = 200) @NotNull @NotEmpty String endereco) {
        this.endereco = endereco;
    }

    public @Size(max = 100) @NotNull @NotEmpty String getBairro() {
        return bairro;
    }

    public void setBairro(@Size(max = 100) @NotNull @NotEmpty String bairro) {
        this.bairro = bairro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
