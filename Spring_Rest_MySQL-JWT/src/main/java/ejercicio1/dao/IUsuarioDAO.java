package ejercicio1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ejercicio1.dto.Usuario;

public interface IUsuarioDAO extends JpaRepository<Usuario, Long> {
	Usuario findByUsername(String username);
}