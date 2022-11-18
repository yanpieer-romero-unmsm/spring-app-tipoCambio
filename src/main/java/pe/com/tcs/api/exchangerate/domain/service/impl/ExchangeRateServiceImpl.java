package pe.com.tcs.api.exchangerate.domain.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.com.tcs.api.exchangerate.canonical.request.update.CoinRequest;
import pe.com.tcs.api.exchangerate.canonical.request.convert.ExchangeRateRequest;
import pe.com.tcs.api.exchangerate.canonical.response.update.CoinResponse;
import pe.com.tcs.api.exchangerate.canonical.response.convert.ExchangeRateResponse;
import pe.com.tcs.api.exchangerate.common.bean.HeaderRequest;
import pe.com.tcs.api.exchangerate.common.bean.ResponseStatus;
import pe.com.tcs.api.exchangerate.common.exception.BaseException;
import pe.com.tcs.api.exchangerate.common.mapper.CoinMapper;
import pe.com.tcs.api.exchangerate.common.util.Constant;
import pe.com.tcs.api.exchangerate.common.util.ExternalProperties;
import pe.com.tcs.api.exchangerate.common.util.UtilService;
import pe.com.tcs.api.exchangerate.domain.service.ExchangeRateService;
import pe.com.tcs.api.exchangerate.integration.repository.coin.CoinRepository;
import pe.com.tcs.api.exchangerate.integration.repository.coin.dto.CoinDto;
import pe.com.tcs.api.exchangerate.integration.repository.coin.entity.Coin;

@Service
@RequiredArgsConstructor
public class ExchangeRateServiceImpl implements ExchangeRateService {

    private final CoinRepository coinRepository;
    private final CoinMapper coinMapper;
    private final ExternalProperties externalProperties;
    private final UtilService utilService;

    @Override
    public ExchangeRateResponse convert(HeaderRequest headerRequest, ExchangeRateRequest request) throws BaseException {
        ExchangeRateResponse response = new ExchangeRateResponse();

        boolean validRequest = utilService.validarRequestConvertir(request);

        try {
            if (validRequest){
                CoinDto sourceCoinDto = coinMapper.toCoinDto(coinRepository.findByType(request.getSourceCoin()));
                CoinDto destinationCoinDto = coinMapper.toCoinDto(coinRepository.findByType(request.getDestinationCoin()));

                response = ExchangeRateResponse.builder()
                        .developer(Constant.DEVELOPER)
                        .amount(request.getAmount())
                        .exchangeRateAmount(utilService.redondear(utilService.calcularMontoConTipoDeCambio(request.getAmount(), sourceCoinDto.getValue(), destinationCoinDto.getValue())))
                        .sourceCoin(sourceCoinDto.getType())
                        .destinationCoin(destinationCoinDto.getType())
                        .exchangeRate(utilService.redondear(utilService.calcularTipoDeCambio(sourceCoinDto.getValue(), destinationCoinDto.getValue())))
                        .build();
            }else {
                response.setResponseStatus(ResponseStatus.builder()
                        .responseCode(externalProperties.idf1Code)
                        .responseDescription(externalProperties.idf1Message)
                        .build());
                response.setDeveloper(Constant.DEVELOPER);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response = utilService.getResponseIDTConvertir(e);
            throw new BaseException(externalProperties.idt3Code, String.format(externalProperties.idt3Message, e.toString()), e);
        }
        return response;
    }

    @Override
    public CoinResponse update(HeaderRequest headerRequest, CoinRequest request) throws BaseException {
        CoinResponse response = new CoinResponse();

        boolean validRequest = utilService.validarRequestActualizar(request);

        try {
            if (validRequest){
                Coin coinEntity = coinRepository.findByType(request.getType());

                coinEntity.setType(request.getType());
                coinEntity.setValue(request.getValue());

                coinRepository.save(coinEntity);

                response = CoinResponse.builder()
                        .developer(Constant.DEVELOPER)
                        .message(externalProperties.idf0Message)
                        .type(coinEntity.getType())
                        .value(coinEntity.getValue())
                        .build();
            } else {
                response.setResponseStatus(ResponseStatus.builder()
                        .responseCode(externalProperties.idf1Code)
                        .responseDescription(externalProperties.idf1Message)
                        .build());
                response.setDeveloper(Constant.DEVELOPER);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response = utilService.getResponseIDTActualizar(e);
            throw new BaseException(externalProperties.idt3Code, String.format(externalProperties.idt3Message, e.toString()), e);
        }
        return response;
    }

}

