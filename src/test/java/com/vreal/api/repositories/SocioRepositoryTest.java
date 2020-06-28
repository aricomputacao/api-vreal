/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vreal.api.repositories;

import com.vreal.api.entities.Nucleo;
import com.vreal.api.entities.Regiao;
import com.vreal.api.entities.Socio;
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
public class SocioRepositoryTest {

    @Autowired
    private RegiaoRepository regiaoRepository;

    @Autowired
    private NucleoRepository nucleoRepository;

    @Autowired
    private SocioRepository socioRepository;

    @BeforeEach
    public void setUp() throws Exception {
        Regiao regiao = this.regiaoRepository.save(obterDadosRegiao());
        Nucleo nucleo = this.nucleoRepository.save(obterDadosNucleo(regiao));
        regiaoRepository.save(regiao);
        nucleoRepository.save(nucleo);
        
        Socio s1 = new Socio();
        s1.setIdReuni(new Long(1));
        s1.setApelido("Joel");
        s1.setCpf("00255423112");
        s1.setEmail("jj@gmail.com");
        s1.setNome("Joel da Silva");
        s1.setNucleo(nucleo);
        s1.setTelefone("01432545555");
        
        Socio s2 = new Socio();
        s2.setIdReuni(new Long(2));
        s2.setApelido("Joel Pedro");
        s2.setCpf("00255423111");
        s2.setEmail("jj@gmail.com");
        s2.setNome("Joel da Silva");
        s2.setNucleo(nucleo);
        s2.setTelefone("01432545555");
        
        this.socioRepository.save(s1);
        this.socioRepository.save(s2);
        
        
    }

    @AfterEach
    public void tearDown() throws Exception {
        this.socioRepository.deleteAll();
        this.nucleoRepository.deleteAll();
        this.regiaoRepository.deleteAll();
    }

    @Test
    public void testBuscarSocioNucleoId() {
        List<Socio> socios = this.socioRepository.findByNucleoId(1);

        assertEquals(2, socios.size());
    }

    @Test
    public void testBuscarSocioNucleoIdPaginado() {
        Page<Socio> socio = this.socioRepository.findByNucleoId(1, PageRequest.of(0, 10));

        assertEquals(2, socio.getTotalElements());
    }

    private Regiao obterDadosRegiao() {
        Regiao regiao = new Regiao();
        regiao.setId(1);
        regiao.setNome("11ª");
        return regiao;
    }

    private Nucleo obterDadosNucleo(Regiao regiao) {
        Nucleo nucleo = new Nucleo();
        nucleo.setId(1);
        nucleo.setNome("Tucunacá");
        nucleo.setRegiao(regiao);
        nucleo.setCnpj("12460440000100");
        return nucleo;
    }

}
