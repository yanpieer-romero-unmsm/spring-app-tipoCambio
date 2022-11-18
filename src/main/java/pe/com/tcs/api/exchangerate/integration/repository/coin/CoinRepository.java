package pe.com.tcs.api.exchangerate.integration.repository.coin;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.com.tcs.api.exchangerate.integration.repository.coin.entity.Coin;

@Repository
public interface CoinRepository extends CrudRepository<Coin, Long> {
    Coin findByType(String type);
}
