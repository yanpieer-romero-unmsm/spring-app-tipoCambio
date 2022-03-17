package pe.com.tcs.api.tipocambio.common.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pe.com.tcs.api.tipocambio.repository.dto.MonedaDto;
import pe.com.tcs.api.tipocambio.repository.entity.Moneda;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface MonedaMapper {

    @Mapping(target = "tipo", source = "moneda.tipo")
    @Mapping(target = "valor", source = "moneda.valor")
    MonedaDto toMonedaDto(Moneda moneda);

    @Mapping(target = "tipo", source = "monedaDto.tipo")
    @Mapping(target = "valor", source = "monedaDto.valor")
    Moneda toMonedaEntity(MonedaDto monedaDto);
}
