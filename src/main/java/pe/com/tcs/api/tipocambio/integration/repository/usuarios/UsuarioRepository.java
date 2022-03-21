package pe.com.tcs.api.tipocambio.integration.repository.usuarios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.com.tcs.api.tipocambio.integration.repository.usuarios.entity.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    Usuario findByUsername(String username);
}
