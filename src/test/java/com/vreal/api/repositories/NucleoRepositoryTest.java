/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vreal.api.repositories;

import com.vreal.api.entities.Nucleo;
import com.vreal.api.entities.Regiao;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;

/**
 *
 * @author ari
 */
@SpringBootTest
@ActiveProfiles("test")
public class NucleoRepositoryTest {

    @Autowired
    private RegiaoRepository regiaoRepository;

    @Autowired
    private NucleoRepository nucleoRepository;


    @BeforeEach
    public void setUp() throws Exception {
        Regiao regiao = this.regiaoRepository.save(obterDadosRegiao());

        Nucleo nucleo = new Nucleo();
        nucleo.setId(1);
        nucleo.setNome("Tucunacá");
        nucleo.setRegiao(regiao);
        nucleo.setCnpj("12460440000100");

        nucleoRepository.save(nucleo);
    }

    @AfterEach
    public void tearDown() throws Exception {
        this.nucleoRepository.deleteAll();
        this.regiaoRepository.deleteAll();
    }

    @Test
    public void testBuscarNucleoPorRegiaoId() {
        List<Nucleo> regiao = this.nucleoRepository.findByRegiaoId(1);

        assertEquals(1, regiao.size());
    }

    @Test
    public void testBuscarBuscarNucleoPorRegiaoIdPaginado() {
        Page<Nucleo> regiao = this.nucleoRepository.findByRegiaoId(1, PageRequest.of(0, 10));

        assertEquals(1, regiao.getTotalElements());
    }

    private Regiao obterDadosRegiao() {
        Regiao regiao = new Regiao();
        regiao.setId(1);
        regiao.setNome("11ª");
        return regiao;
    }

}
