package pe.com.tcs.api.exchangerate.domain.service;

import pe.com.tcs.api.exchangerate.canonical.request.update.CoinRequest;
import pe.com.tcs.api.exchangerate.canonical.request.convert.ExchangeRateRequest;
import pe.com.tcs.api.exchangerate.canonical.response.update.CoinResponse;
import pe.com.tcs.api.exchangerate.canonical.response.convert.ExchangeRateResponse;
import pe.com.tcs.api.exchangerate.common.bean.HeaderRequest;
import pe.com.tcs.api.exchangerate.common.exception.BaseException;

public interface ExchangeRateService {
    ExchangeRateResponse convert(HeaderRequest headerRequest, ExchangeRateRequest request) throws BaseException;
    CoinResponse update(HeaderRequest headerRequest, CoinRequest request) throws BaseException;
}
