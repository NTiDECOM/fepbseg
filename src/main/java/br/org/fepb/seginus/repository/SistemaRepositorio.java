/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.fepb.seginus.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.org.fepb.seginus.model.Sistema;

/**
 *
 * @author Thiago
 */
@Repository
public interface SistemaRepositorio extends CrudRepository<Sistema, Long>{
    
}
