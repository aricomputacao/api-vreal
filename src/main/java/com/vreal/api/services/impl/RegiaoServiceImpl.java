/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vreal.api.services.impl;

import com.vreal.api.entities.Regiao;
import com.vreal.api.repositories.RegiaoRepository;
import com.vreal.api.services.RegiaoService;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ari
 */
@Service
public class RegiaoServiceImpl implements RegiaoService {

    private static final Logger log = LoggerFactory.getLogger(RegiaoServiceImpl.class);

    @Autowired
    private RegiaoRepository regiaoRepository;

    @Override
    public Optional<Regiao> buscarPorNome(String nome) {
        log.info("Buscando uma região por {}", nome);
        return Optional.ofNullable(regiaoRepository.findByNome(nome));
    }

    @Override
    public List<Regiao> consultarTodosOderAscId() {
        log.info("Buscando todas regiões por ");
        return regiaoRepository.findAllByOrderByIdAsc();
    }

    @Override
    public Regiao persistir(Regiao regiao) {
        log.info("Persistindo região: {}", regiao);
        return this.regiaoRepository.save(regiao);
    }

}
