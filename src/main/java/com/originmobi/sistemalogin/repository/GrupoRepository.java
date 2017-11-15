package com.originmobi.sistemalogin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.originmobi.sistemalogin.dao.Grupo;
import com.originmobi.sistemalogin.dao.Usuario;

public interface GrupoRepository extends JpaRepository<Grupo, Long>{
	
	List<Grupo> findByUsuariosIn(Usuario usuario);

}
