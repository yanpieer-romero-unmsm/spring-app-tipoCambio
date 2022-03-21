package pe.com.tcs.api.tipocambio.common.util;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pe.com.tcs.api.tipocambio.canonical.response.actualizar.MonedaResponseType;
import pe.com.tcs.api.tipocambio.canonical.response.authenticate.AuthenticationResponseType;
import pe.com.tcs.api.tipocambio.canonical.response.convertir.TipoCambioResponseType;
import pe.com.tcs.api.tipocambio.common.bean.DetalleErrorType;
import pe.com.tcs.api.tipocambio.common.bean.HeaderRequest;
import pe.com.tcs.api.tipocambio.common.bean.ResponseStatus;
import pe.com.tcs.api.tipocambio.common.exceptions.BaseException;

import java.util.Date;

@RequiredArgsConstructor
@Component
public class UtilController {
    private final PropertiesExternos properties;


    public HeaderRequest completarHeader(String accept) {
        return HeaderRequest.builder()
                .accept(accept)
                .build();
    }

    public TipoCambioResponseType getResponseConvertir(BaseException e) {
        String error = (e.getMessage() == Constantes.NULO) ? Constantes.ERROR: e.getMessage();
        String code = (e.getCode() == Constantes.NULO) ? properties.idt1Codigo: e.getCode();

        ResponseStatus responseStatus = ResponseStatus.builder()
                .status(code)
                .codigoRespuesta(code)
                .descripcionRespuesta(error)
                .origen(Constantes.TEXTO_VACIO)
                .fecha(new Date())
                .ubicacionError(error)
                .build();

        DetalleErrorType detalleError = DetalleErrorType.builder()
                .errorCode(code)
                .errorDescripcion(e.toString())
                .build();

        responseStatus.setDetalleError(detalleError);

        return TipoCambioResponseType.builder().responseStatus(responseStatus).desarrollador(Constantes.DESARROLLADOR).build();
    }

    public MonedaResponseType getResponseActualizar(BaseException e) {
        String error = (e.getMessage() == Constantes.NULO) ? Constantes.ERROR: e.getMessage();
        String code = (e.getCode() == Constantes.NULO) ? properties.idt1Codigo: e.getCode();

        ResponseStatus responseStatus = ResponseStatus.builder()
                .status(code)
                .codigoRespuesta(code)
                .descripcionRespuesta(error)
                .origen(Constantes.TEXTO_VACIO)
                .fecha(new Date())
                .ubicacionError(error)
                .build();

        DetalleErrorType detalleError = DetalleErrorType.builder()
                .errorCode(code)
                .errorDescripcion(e.toString())
                .build();

        responseStatus.setDetalleError(detalleError);

        return MonedaResponseType.builder().responseStatus(responseStatus).desarrollador(Constantes.DESARROLLADOR).build();
    }

    public AuthenticationResponseType getResponseAutenticar(BaseException e) {
        String error = (e.getMessage() == Constantes.NULO) ? Constantes.ERROR: e.getMessage();
        String code = (e.getCode() == Constantes.NULO) ? properties.idt1Codigo: e.getCode();

        ResponseStatus responseStatus = ResponseStatus.builder()
                .status(code)
                .codigoRespuesta(code)
                .descripcionRespuesta(error)
                .origen(Constantes.TEXTO_VACIO)
                .fecha(new Date())
                .ubicacionError(error)
                .build();

        DetalleErrorType detalleError = DetalleErrorType.builder()
                .errorCode(code)
                .errorDescripcion(e.toString())
                .build();

        responseStatus.setDetalleError(detalleError);

        return AuthenticationResponseType.builder().responseStatus(responseStatus).desarrollador(Constantes.DESARROLLADOR).build();
    }

    public TipoCambioResponseType getResponseConvertir(Exception e) {
        String error = (e.getMessage() == Constantes.NULO) ? Constantes.ERROR: e.getMessage();
        String code = properties.idt1Codigo;

        ResponseStatus responseStatus = ResponseStatus.builder()
                .status(code)
                .codigoRespuesta(code)
                .descripcionRespuesta(error)
                .origen(Constantes.TEXTO_VACIO)
                .fecha(new Date())
                .ubicacionError(error)
                .build();

        DetalleErrorType detalleError = DetalleErrorType.builder()
                .errorCode(code)
                .errorDescripcion(e.toString())
                .build();

        responseStatus.setDetalleError(detalleError);

        return TipoCambioResponseType.builder().responseStatus(responseStatus).desarrollador(Constantes.DESARROLLADOR).build();
    }

    public MonedaResponseType getResponseActualizar(Exception e) {
        String error = (e.getMessage() == Constantes.NULO) ? Constantes.ERROR: e.getMessage();
        String code = properties.idt1Codigo;

        ResponseStatus responseStatus = ResponseStatus.builder()
                .status(code)
                .codigoRespuesta(code)
                .descripcionRespuesta(error)
                .origen(Constantes.TEXTO_VACIO)
                .fecha(new Date())
                .ubicacionError(error)
                .build();

        DetalleErrorType detalleError = DetalleErrorType.builder()
                .errorCode(code)
                .errorDescripcion(e.toString())
                .build();

        responseStatus.setDetalleError(detalleError);

        return MonedaResponseType.builder().responseStatus(responseStatus).desarrollador(Constantes.DESARROLLADOR).build();
    }

    public AuthenticationResponseType getResponseAutenticar(Exception e) {
        String error = (e.getMessage() == Constantes.NULO) ? Constantes.ERROR: e.getMessage();
        String code = properties.idt1Codigo;

        ResponseStatus responseStatus = ResponseStatus.builder()
                .status(code)
                .codigoRespuesta(code)
                .descripcionRespuesta(error)
                .origen(Constantes.TEXTO_VACIO)
                .fecha(new Date())
                .ubicacionError(error)
                .build();

        DetalleErrorType detalleError = DetalleErrorType.builder()
                .errorCode(code)
                .errorDescripcion(e.toString())
                .build();

        responseStatus.setDetalleError(detalleError);

        return AuthenticationResponseType.builder().responseStatus(responseStatus).desarrollador(Constantes.DESARROLLADOR).build();
    }
}
