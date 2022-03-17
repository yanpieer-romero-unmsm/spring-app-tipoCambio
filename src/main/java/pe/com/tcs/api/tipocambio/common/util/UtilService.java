package pe.com.tcs.api.tipocambio.common.util;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.com.tcs.api.tipocambio.canonical.request.actualizar.MonedaRequestType;
import pe.com.tcs.api.tipocambio.canonical.request.convertir.TipoCambioRequestType;
import pe.com.tcs.api.tipocambio.canonical.response.actualizar.MonedaResponseType;
import pe.com.tcs.api.tipocambio.canonical.response.convertir.TipoCambioResponseType;
import pe.com.tcs.api.tipocambio.common.bean.DetalleErrorType;
import pe.com.tcs.api.tipocambio.common.bean.ResponseStatus;

import java.util.Date;

@RequiredArgsConstructor
@Component
public class UtilService {
    private final PropertiesExternos properties;

    public double redondear(Object valor) {
        double dblValor = Double.parseDouble(valor.toString());
        return (double) Math.round(dblValor * 100) / 100;
    }

    public double calcularMontoConTipoDeCambio(Object valor1, Object valor2, Object valor3){
        double dblValor1 = Double.parseDouble(valor1.toString());
        double dblValor2 = Double.parseDouble(valor2.toString());
        double dblValor3 = Double.parseDouble(valor3.toString());
        return dblValor1 * dblValor2 / dblValor3;
    }

    public double calcularTipoDeCambio(Object valor1, Object valor2){
        double dblValor1 = Double.parseDouble(valor1.toString());
        double dblValor2 = Double.parseDouble(valor2.toString());
        return dblValor1 / dblValor2;
    }

    public TipoCambioResponseType getResponseIDTConvertir(Exception e) {
        String error = (e.getMessage() == Constantes.NULO) ? Constantes.ERROR: e.getMessage();

        ResponseStatus responseStatus = ResponseStatus.builder()
                .status(properties.idf1Codigo)
                .codigoRespuesta(properties.idt3Codigo)
                .descripcionRespuesta(error)
                .origen(Constantes.TEXTO_VACIO)
                .fecha(new Date())
                .ubicacionError(error)
                .build();

        DetalleErrorType detalleError = DetalleErrorType.builder()
                .errorCode(properties.idt3Codigo)
                .errorDescripcion(e.toString())
                .build();

        responseStatus.setDetalleError(detalleError);

        return TipoCambioResponseType.builder().responseStatus(responseStatus).desarrollador(Constantes.DESARROLLADOR).build();
    }

    public MonedaResponseType getResponseIDTActualizar(Exception e) {
        String error = (e.getMessage() == Constantes.NULO) ? Constantes.ERROR: e.getMessage();

        ResponseStatus responseStatus = ResponseStatus.builder()
                .status(properties.idf1Codigo)
                .codigoRespuesta(properties.idt3Codigo)
                .descripcionRespuesta(error)
                .origen(Constantes.TEXTO_VACIO)
                .fecha(new Date())
                .ubicacionError(error)
                .build();

        DetalleErrorType detalleError = DetalleErrorType.builder()
                .errorCode(properties.idt3Codigo)
                .errorDescripcion(e.toString())
                .build();

        responseStatus.setDetalleError(detalleError);

        return MonedaResponseType.builder().responseStatus(responseStatus).desarrollador(Constantes.DESARROLLADOR).build();
    }

    public boolean validarRequestConvertir(TipoCambioRequestType request) {
        return request.getMonto() != Constantes.NULO && request.getMonto() >= 0
                && request.getMonedaOrigen() != Constantes.NULO && !request.getMonedaOrigen().isBlank()
                && request.getMonedaDestino() != Constantes.NULO && !request.getMonedaDestino().isBlank();
    }

    public boolean validarRequestActualizar(MonedaRequestType request) {
        return request.getTipo() != Constantes.NULO && !request.getTipo().isBlank()
                && request.getValor() >= 0 && request.getValor() != Constantes.NULO;
    }

}
