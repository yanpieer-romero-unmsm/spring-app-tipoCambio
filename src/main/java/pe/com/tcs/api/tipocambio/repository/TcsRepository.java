package pe.com.tcs.api.tipocambio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.com.tcs.api.tipocambio.repository.entity.Moneda;

@Repository
public interface TcsRepository extends CrudRepository<Moneda, Long> {
    Moneda findByTipo(String tipo);
}
