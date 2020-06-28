/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vreal.api.services;

import com.vreal.api.entities.Regiao;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author ari
 */
public interface RegiaoService {

    /**
     * Retorna uma região dado o nome
     *
     * @param nome
     * @return
     */
    Optional<Regiao> buscarPorNome(String nome);
    
    /**
     * Retorna todas as regiões por ordem ascendente de id
     *
     * @return
     */
    List<Regiao> consultarTodosOderAscId();
    
    /**
     * Cadastra uma nova região
     * @param regiao
     * @return 
     */    
    Regiao persistir(Regiao regiao);

}
