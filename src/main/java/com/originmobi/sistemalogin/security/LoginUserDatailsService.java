package com.originmobi.sistemalogin.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.originmobi.sistemalogin.dao.Grupo;
import com.originmobi.sistemalogin.dao.Permissao;
import com.originmobi.sistemalogin.dao.Usuario;
import com.originmobi.sistemalogin.repository.GrupoRepository;
import com.originmobi.sistemalogin.repository.PermissaoRepository;
import com.originmobi.sistemalogin.repository.UsuarioRepository;

@Component
public class LoginUserDatailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarios;

	@Autowired
	private GrupoRepository grupos;

	@Autowired
	private PermissaoRepository permissoes;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarios.findByUsuarioContaining(username);
		

		if (usuario == null)
			throw new UsernameNotFoundException("Usuário não encontrado!");

		return new UsuarioSistema(usuario.getNome(), usuario.getUsuario(), usuario.getSenha(), authorities(usuario));
	}

	public Collection<? extends GrantedAuthority> authorities(Usuario usuario) {
		return authorities(grupos.findByUsuariosIn(usuario));
	}

	public Collection<? extends GrantedAuthority> authorities(List<Grupo> grupos) {
		Collection<GrantedAuthority> auths = new ArrayList<>();

		for (Grupo grupo : grupos) {
			List<Permissao> lista = permissoes.findByGruposIn(grupo);

			for (Permissao permissao : lista) {
				auths.add(new SimpleGrantedAuthority("ROLE_" + permissao.getNome()));
				System.out.println("Permissão " + "ROLE_" + permissao.getNome());
			}
		}
		return auths;
	}

}
