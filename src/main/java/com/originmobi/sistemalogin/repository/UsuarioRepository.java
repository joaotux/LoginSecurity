package com.originmobi.sistemalogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.originmobi.sistemalogin.dao.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	public Usuario findByUsuarioContaining(String usuario);

}
