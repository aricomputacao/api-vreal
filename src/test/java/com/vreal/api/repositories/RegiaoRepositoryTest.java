/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vreal.api.repositories;

import com.vreal.api.entities.Regiao;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 *
 * @author ari
 */
@SpringBootTest
@ActiveProfiles("test")
public class RegiaoRepositoryTest {

    @Autowired
    private RegiaoRepository regiaoRepository;

    private static final String nome = "SEDE GERAL";

    @BeforeEach
    public void setUp() throws Exception {
        Regiao regiao = new Regiao();
        regiao.setId(1);
        regiao.setNome(nome);
        this.regiaoRepository.save(regiao);
    }

    @AfterEach
    public final void tearDown() {
        this.regiaoRepository.deleteAll();
    }

    @Test
    public void testBuscarPorNome() {
        Regiao regiao = this.regiaoRepository.findByNome(nome);

        assertEquals(nome, regiao.getNome());
    }
    @Test
    public void testBuscarTodos() {
        List<Regiao> lista = this.regiaoRepository.findAllByOrderByIdAsc();

        assertEquals(false, lista.isEmpty());
    }

}
