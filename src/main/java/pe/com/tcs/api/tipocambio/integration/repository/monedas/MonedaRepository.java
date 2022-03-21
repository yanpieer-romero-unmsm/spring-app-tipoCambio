package pe.com.tcs.api.tipocambio.integration.repository.monedas;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.com.tcs.api.tipocambio.integration.repository.monedas.entity.Moneda;

@Repository
public interface MonedaRepository extends CrudRepository<Moneda, Long> {
    Moneda findByTipo(String tipo);
}
