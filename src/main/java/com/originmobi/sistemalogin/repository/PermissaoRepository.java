package com.originmobi.sistemalogin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.originmobi.sistemalogin.dao.Grupo;
import com.originmobi.sistemalogin.dao.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Long>{
	
	public List<Permissao> findByGruposIn(Grupo grupo);

}
