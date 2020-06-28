/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vreal.api.repositories;

import com.vreal.api.entities.Socio;
import java.util.List;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ari
 */
@Transactional(readOnly = true)
@NamedQueries({
    @NamedQuery(name = "SocioRepository.findByNucleoId",
            query = "SELECT soc FROM Socio soc WHERE soc.nucleo.id = :nucleoId")})
public interface SocioRepository extends JpaRepository<Socio, Long>{
 
    Socio findByCpf(String cpf);

    List<Socio> findByNucleoId(@Param("nucleoId") Integer nucleoId);

    Page<Socio> findByNucleoId(@Param("nucleoId") Integer nucleoId, Pageable pageable);
}
