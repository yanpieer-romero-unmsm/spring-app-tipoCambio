package pe.com.tcs.api.exchangerate.common.util;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pe.com.tcs.api.exchangerate.canonical.response.update.CoinResponse;
import pe.com.tcs.api.exchangerate.canonical.response.authenticate.AuthenticationResponse;
import pe.com.tcs.api.exchangerate.canonical.response.convert.ExchangeRateResponse;
import pe.com.tcs.api.exchangerate.common.bean.ErrorDetail;
import pe.com.tcs.api.exchangerate.common.bean.HeaderRequest;
import pe.com.tcs.api.exchangerate.common.bean.ResponseStatus;
import pe.com.tcs.api.exchangerate.common.exception.BaseException;

import java.util.Date;

@RequiredArgsConstructor
@Component
public class UtilController {
    private final ExternalProperties properties;


    public HeaderRequest completarHeader(String accept) {
        return HeaderRequest.builder()
                .accept(accept)
                .build();
    }

    public ExchangeRateResponse getResponseConvertir(BaseException e) {
        String error = (e.getMessage() == Constant.NULL) ? Constant.ERROR: e.getMessage();
        String code = (e.getCode() == Constant.NULL) ? properties.idt1Code : e.getCode();

        ResponseStatus responseStatus = ResponseStatus.builder()
                .status(code)
                .responseCode(code)
                .responseDescription(error)
                .source(Constant.EMPTY_TEXT)
                .date(new Date())
                .errorLocation(error)
                .build();

        ErrorDetail detalleError = ErrorDetail.builder()
                .errorCode(code)
                .errorDescription(e.toString())
                .build();

        responseStatus.setErrorDetail(detalleError);

        return ExchangeRateResponse.builder().responseStatus(responseStatus).developer(Constant.DEVELOPER).build();
    }

    public CoinResponse getResponseActualizar(BaseException e) {
        String error = (e.getMessage() == Constant.NULL) ? Constant.ERROR: e.getMessage();
        String code = (e.getCode() == Constant.NULL) ? properties.idt1Code : e.getCode();

        ResponseStatus responseStatus = ResponseStatus.builder()
                .status(code)
                .responseCode(code)
                .responseDescription(error)
                .source(Constant.EMPTY_TEXT)
                .date(new Date())
                .errorLocation(error)
                .build();

        ErrorDetail detalleError = ErrorDetail.builder()
                .errorCode(code)
                .errorDescription(e.toString())
                .build();

        responseStatus.setErrorDetail(detalleError);

        return CoinResponse.builder().responseStatus(responseStatus).developer(Constant.DEVELOPER).build();
    }

    public AuthenticationResponse getResponseAutenticar(BaseException e) {
        String error = (e.getMessage() == Constant.NULL) ? Constant.ERROR: e.getMessage();
        String code = (e.getCode() == Constant.NULL) ? properties.idt1Code : e.getCode();

        ResponseStatus responseStatus = ResponseStatus.builder()
                .status(code)
                .responseCode(code)
                .responseDescription(error)
                .source(Constant.EMPTY_TEXT)
                .date(new Date())
                .errorLocation(error)
                .build();

        ErrorDetail detalleError = ErrorDetail.builder()
                .errorCode(code)
                .errorDescription(e.toString())
                .build();

        responseStatus.setErrorDetail(detalleError);

        return AuthenticationResponse.builder().responseStatus(responseStatus).developer(Constant.DEVELOPER).build();
    }

    public ExchangeRateResponse getResponseConvertir(Exception e) {
        String error = (e.getMessage() == Constant.NULL) ? Constant.ERROR: e.getMessage();
        String code = properties.idt1Code;

        ResponseStatus responseStatus = ResponseStatus.builder()
                .status(code)
                .responseCode(code)
                .responseDescription(error)
                .source(Constant.EMPTY_TEXT)
                .date(new Date())
                .errorLocation(error)
                .build();

        ErrorDetail detalleError = ErrorDetail.builder()
                .errorCode(code)
                .errorDescription(e.toString())
                .build();

        responseStatus.setErrorDetail(detalleError);

        return ExchangeRateResponse.builder().responseStatus(responseStatus).developer(Constant.DEVELOPER).build();
    }

    public CoinResponse getResponseActualizar(Exception e) {
        String error = (e.getMessage() == Constant.NULL) ? Constant.ERROR: e.getMessage();
        String code = properties.idt1Code;

        ResponseStatus responseStatus = ResponseStatus.builder()
                .status(code)
                .responseCode(code)
                .responseDescription(error)
                .source(Constant.EMPTY_TEXT)
                .date(new Date())
                .errorLocation(error)
                .build();

        ErrorDetail detalleError = ErrorDetail.builder()
                .errorCode(code)
                .errorDescription(e.toString())
                .build();

        responseStatus.setErrorDetail(detalleError);

        return CoinResponse.builder().responseStatus(responseStatus).developer(Constant.DEVELOPER).build();
    }

    public AuthenticationResponse getResponseAutenticar(Exception e) {
        String error = (e.getMessage() == Constant.NULL) ? Constant.ERROR: e.getMessage();
        String code = properties.idt1Code;

        ResponseStatus responseStatus = ResponseStatus.builder()
                .status(code)
                .responseCode(code)
                .responseDescription(error)
                .source(Constant.EMPTY_TEXT)
                .date(new Date())
                .errorLocation(error)
                .build();

        ErrorDetail detalleError = ErrorDetail.builder()
                .errorCode(code)
                .errorDescription(e.toString())
                .build();

        responseStatus.setErrorDetail(detalleError);

        return AuthenticationResponse.builder().responseStatus(responseStatus).developer(Constant.DEVELOPER).build();
    }
}
