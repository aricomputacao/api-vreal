/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vreal.api.services;

import com.vreal.api.entities.Regiao;
import com.vreal.api.repositories.RegiaoRepository;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

/**
 *
 * @author ari
 */
@SpringBootTest
@ActiveProfiles("test")
public class RegiaoServiceTest {
    
    @MockBean
    private RegiaoRepository regiaoRepository;
    
    @Autowired
    private RegiaoService regiaoService;
    
    @BeforeEach
    public void setUp(){
        BDDMockito.given(this.regiaoRepository.findByNome(Mockito.anyString())).willReturn(new Regiao());
        BDDMockito.given(this.regiaoRepository.save(Mockito.any(Regiao.class))).willReturn(new Regiao());
    }
    
    @Test
    public void testBuscarRegiaoPorNome(){
        Optional<Regiao> regiao = this.regiaoService.buscarPorNome("11 REgião");
        Assertions.assertTrue(regiao.isPresent());
    }
    
    @Test
    public void testPersistirRegiao(){
        Regiao regiao = this.regiaoService.persistir(new Regiao());
        
        Assertions.assertNotNull(regiao);
    }
}
