package MainApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import MainApp.dto.Usuario;

public interface IUsuarioDAO extends JpaRepository<Usuario, Long> {

	Usuario findByUsername(String username);
}
