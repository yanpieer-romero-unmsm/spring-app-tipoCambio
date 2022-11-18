package pe.com.tcs.api.exchangerate.common.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pe.com.tcs.api.exchangerate.integration.repository.coin.dto.CoinDto;
import pe.com.tcs.api.exchangerate.integration.repository.coin.entity.Coin;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface CoinMapper {

    @Mapping(target = "type", source = "coin.type")
    @Mapping(target = "value", source = "coin.value")
    CoinDto toCoinDto(Coin coin);

    @Mapping(target = "type", source = "coinDto.type")
    @Mapping(target = "value", source = "coinDto.value")
    Coin toCoinEntity(CoinDto coinDto);
}
