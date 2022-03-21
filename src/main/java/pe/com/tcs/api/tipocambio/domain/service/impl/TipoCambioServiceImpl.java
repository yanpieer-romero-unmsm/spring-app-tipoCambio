package pe.com.tcs.api.tipocambio.domain.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.com.tcs.api.tipocambio.canonical.request.actualizar.MonedaRequestType;
import pe.com.tcs.api.tipocambio.canonical.request.convertir.TipoCambioRequestType;
import pe.com.tcs.api.tipocambio.canonical.response.actualizar.MonedaResponseType;
import pe.com.tcs.api.tipocambio.canonical.response.convertir.TipoCambioResponseType;
import pe.com.tcs.api.tipocambio.common.bean.HeaderRequest;
import pe.com.tcs.api.tipocambio.common.bean.ResponseStatus;
import pe.com.tcs.api.tipocambio.common.exceptions.BaseException;
import pe.com.tcs.api.tipocambio.common.mapper.MonedaMapper;
import pe.com.tcs.api.tipocambio.common.util.Constantes;
import pe.com.tcs.api.tipocambio.common.util.PropertiesExternos;
import pe.com.tcs.api.tipocambio.common.util.UtilService;
import pe.com.tcs.api.tipocambio.domain.service.TipoCambioService;
import pe.com.tcs.api.tipocambio.integration.repository.monedas.MonedaRepository;
import pe.com.tcs.api.tipocambio.integration.repository.monedas.dto.MonedaDto;
import pe.com.tcs.api.tipocambio.integration.repository.monedas.entity.Moneda;

@RequiredArgsConstructor
@Service
public class TipoCambioServiceImpl implements TipoCambioService {

    private final MonedaRepository repositorio;
    private final MonedaMapper mapper;
    private final PropertiesExternos properties;
    private final UtilService utilService;

    @Override
    public TipoCambioResponseType convertir(HeaderRequest headerRequest, TipoCambioRequestType request) throws BaseException {
        TipoCambioResponseType response = new TipoCambioResponseType();

        boolean requestValido = utilService.validarRequestConvertir(request);

        try {

            if (requestValido){
                MonedaDto monedaDtoOrigen = mapper.toMonedaDto(repositorio.findByTipo(request.getMonedaOrigen()));
                MonedaDto monedaDtoDestino = mapper.toMonedaDto(repositorio.findByTipo(request.getMonedaDestino()));

                response = TipoCambioResponseType.builder()
                        .desarrollador(Constantes.DESARROLLADOR)
                        .monto(request.getMonto())
                        .montoConTipoCambio(utilService.redondear(utilService.calcularMontoConTipoDeCambio(request.getMonto(), monedaDtoOrigen.getValor(), monedaDtoDestino.getValor())))
                        .monedaOrigen(monedaDtoOrigen.getTipo())
                        .monedaDestino(monedaDtoDestino.getTipo())
                        .tipoCambio(utilService.redondear(utilService.calcularTipoDeCambio(monedaDtoOrigen.getValor(), monedaDtoDestino.getValor())))
                        .build();
            }else {
                response.setResponseStatus(ResponseStatus.builder()
                        .codigoRespuesta(properties.idf1Codigo)
                        .descripcionRespuesta(properties.idf1Mensaje)
                        .build());
                response.setDesarrollador(Constantes.DESARROLLADOR);
            }

        } catch (Exception e) {
            e.printStackTrace();
            response = utilService.getResponseIDTConvertir(e);
            throw new BaseException(properties.idt3Codigo, String.format(properties.idt3Mensaje, e.toString()), e);
        }
        return response;
    }

    @Override
    public MonedaResponseType actualizar(HeaderRequest headerRequest, MonedaRequestType request) throws BaseException {
        MonedaResponseType response = new MonedaResponseType();

        boolean requestValido = utilService.validarRequestActualizar(request);

        try {

            if (requestValido){
                Moneda monedaEntity = repositorio.findByTipo(request.getTipo());

                monedaEntity.setTipo(request.getTipo());
                monedaEntity.setValor(request.getValor());

                repositorio.save(monedaEntity);

                response = MonedaResponseType.builder()
                        .desarrollador(Constantes.DESARROLLADOR)
                        .mensaje(properties.idf0Mensaje)
                        .tipo(monedaEntity.getTipo())
                        .valor(monedaEntity.getValor())
                        .build();
            } else {
                response.setResponseStatus(ResponseStatus.builder()
                        .codigoRespuesta(properties.idf1Codigo)
                        .descripcionRespuesta(properties.idf1Mensaje)
                        .build());
                response.setDesarrollador(Constantes.DESARROLLADOR);
            }

        } catch (Exception e) {
            e.printStackTrace();
            response = utilService.getResponseIDTActualizar(e);
            throw new BaseException(properties.idt3Codigo, String.format(properties.idt3Mensaje, e.toString()), e);
        }
        return response;

    }

}
