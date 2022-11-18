package pe.com.tcs.api.exchangerate.common.util;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pe.com.tcs.api.exchangerate.canonical.request.update.CoinRequest;
import pe.com.tcs.api.exchangerate.canonical.request.authenticate.AuthenticationRequest;
import pe.com.tcs.api.exchangerate.canonical.request.convert.ExchangeRateRequest;
import pe.com.tcs.api.exchangerate.canonical.response.update.CoinResponse;
import pe.com.tcs.api.exchangerate.canonical.response.authenticate.AuthenticationResponse;
import pe.com.tcs.api.exchangerate.canonical.response.convert.ExchangeRateResponse;
import pe.com.tcs.api.exchangerate.common.bean.ErrorDetail;
import pe.com.tcs.api.exchangerate.common.bean.ResponseStatus;

import java.util.Date;

@RequiredArgsConstructor
@Component
public class UtilService {
    private final ExternalProperties properties;

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

    public ExchangeRateResponse getResponseIDTConvertir(Exception e) {
        String error = (e.getMessage() == Constant.NULL) ? Constant.ERROR: e.getMessage();

        ResponseStatus responseStatus = ResponseStatus.builder()
                .status(properties.idf1Code)
                .responseCode(properties.idt3Code)
                .responseDescription(error)
                .source(Constant.EMPTY_TEXT)
                .date(new Date())
                .errorLocation(error)
                .build();

        ErrorDetail detalleError = ErrorDetail.builder()
                .errorCode(properties.idt3Code)
                .errorDescription(e.toString())
                .build();

        responseStatus.setErrorDetail(detalleError);

        return ExchangeRateResponse.builder().responseStatus(responseStatus).developer(Constant.DEVELOPER).build();
    }

    public CoinResponse getResponseIDTActualizar(Exception e) {
        String error = (e.getMessage() == Constant.NULL) ? Constant.ERROR: e.getMessage();

        ResponseStatus responseStatus = ResponseStatus.builder()
                .status(properties.idf1Code)
                .responseCode(properties.idt3Code)
                .responseDescription(error)
                .source(Constant.EMPTY_TEXT)
                .date(new Date())
                .errorLocation(error)
                .build();

        ErrorDetail detalleError = ErrorDetail.builder()
                .errorCode(properties.idt3Code)
                .errorDescription(e.toString())
                .build();

        responseStatus.setErrorDetail(detalleError);

        return CoinResponse.builder().responseStatus(responseStatus).developer(Constant.DEVELOPER).build();
    }

    public AuthenticationResponse getResponseIDTAutenticar(Exception e) {
        String error = (e.getMessage() == Constant.NULL) ? Constant.ERROR: e.getMessage();

        ResponseStatus responseStatus = ResponseStatus.builder()
                .status(properties.idf1Code)
                .responseCode(properties.idt3Code)
                .responseDescription(error)
                .source(Constant.EMPTY_TEXT)
                .date(new Date())
                .errorLocation(error)
                .build();

        ErrorDetail detalleError = ErrorDetail.builder()
                .errorCode(properties.idt3Code)
                .errorDescription(e.toString())
                .build();

        responseStatus.setErrorDetail(detalleError);

        return AuthenticationResponse.builder().responseStatus(responseStatus).developer(Constant.DEVELOPER).build();
    }

    public boolean validarRequestConvertir(ExchangeRateRequest request) {
        return request.getAmount() != Constant.NULL && request.getAmount() >= 0
                && request.getSourceCoin() != Constant.NULL && !request.getSourceCoin().isBlank()
                && request.getDestinationCoin() != Constant.NULL && !request.getDestinationCoin().isBlank();
    }

    public boolean validarRequestActualizar(CoinRequest request) {
        return request.getType() != Constant.NULL && !request.getType().isBlank()
                && request.getValue() >= 0 && request.getValue() != Constant.NULL;
    }

    public boolean validarRequestAutenticar(AuthenticationRequest request) {
        return request.getUsername() != Constant.NULL && !request.getUsername().isBlank()
                && request.getPassword() != Constant.NULL && !request.getPassword().isBlank();
    }
}
