package pe.com.tcs.api.tipocambio.domain.service;

import pe.com.tcs.api.tipocambio.canonical.request.actualizar.MonedaRequestType;
import pe.com.tcs.api.tipocambio.canonical.request.convertir.TipoCambioRequestType;
import pe.com.tcs.api.tipocambio.canonical.response.actualizar.MonedaResponseType;
import pe.com.tcs.api.tipocambio.canonical.response.convertir.TipoCambioResponseType;
import pe.com.tcs.api.tipocambio.common.bean.HeaderRequest;
import pe.com.tcs.api.tipocambio.common.exceptions.BaseException;

public interface TipoCambioService {
    TipoCambioResponseType convertir(HeaderRequest headerRequest, TipoCambioRequestType request) throws BaseException;
    MonedaResponseType actualizar(HeaderRequest headerRequest, MonedaRequestType request) throws BaseException;
}
