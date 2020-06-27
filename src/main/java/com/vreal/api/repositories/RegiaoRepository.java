/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vreal.api.repositories;

import com.vreal.api.entities.Regiao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ari
 */
public interface RegiaoRepository extends  JpaRepository<Regiao,Integer>{
    
    @Transactional(readOnly = true)
    Regiao findByNome(String nome);
}
