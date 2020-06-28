/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vreal.api.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ari
 */
@Entity
@Table(name = "socio",schema = "public")
public class Socio implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "soc_id",nullable = false,updatable = false)
    private Long id;
   
    @ManyToOne
    @JoinColumn(name = "nuc_id",referencedColumnName = "nuc_id",nullable = false)
    private Nucleo nucleo;
    
    @Column(name = "soc_id_reuni",nullable = false,updatable = false)
    private Long idReuni;
    
    @Column(name = "soc_nome",nullable = false)
    private String nome;
    
    @Column(name = "soc_apelido")
    private String apelido;
   
    @Column(name = "soc_cpf",nullable = false,unique = true)
    private String cpf;
    
    @Column(name = "soc_email")
    private String email;
    
    @Column(name = "soc_telefone")
    private String telefone;

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
    

    public Long getIdReuni() {
        return idReuni;
    }

    public Nucleo getNucleo() {
        return nucleo;
    }

    public void setNucleo(Nucleo nucleo) {
        this.nucleo = nucleo;
    }
    
    

    public void setIdReuni(Long idReuni) {
        this.idReuni = idReuni;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Long getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Socio other = (Socio) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}
