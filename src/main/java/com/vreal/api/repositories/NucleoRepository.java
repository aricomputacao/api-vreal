/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vreal.api.repositories;

import com.vreal.api.entities.Nucleo;
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
    @NamedQuery(name = "NucleoRepository.findByRegiaoId",
            query = "SELECT nuc FROM Nucleo nuc WHERE nuc.regiao.id = :regiaoId")})
public interface NucleoRepository extends JpaRepository<Nucleo, Integer> {

    Nucleo findByCnpj(String cnpj);

    List<Nucleo> findByRegiaoId(@Param("regiaoId") Integer regiaoId);

    Page<Nucleo> findByRegiaoId(@Param("regiaoId") Integer regiaoId, Pageable pageable);
}
