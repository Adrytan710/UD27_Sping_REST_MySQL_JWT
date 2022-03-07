package com.service;

import static java.util.Collections.emptyList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dao.IUsuarioDao;
import com.dto.Usuario;

@Service
public class UsuarioService implements UserDetailsService {

    private IUsuarioDao iUsuarioDao;

    public UsuarioService(IUsuarioDao iUsuarioDao) {
        this.iUsuarioDao = iUsuarioDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = iUsuarioDao.findByUsername(username);
        if (usuario == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(usuario.getUsername(), usuario.getPassword(), emptyList());
    }
}