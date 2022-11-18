package pe.com.tcs.api.exchangerate.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.com.tcs.api.exchangerate.canonical.request.update.CoinRequest;
import pe.com.tcs.api.exchangerate.canonical.request.authenticate.AuthenticationRequest;
import pe.com.tcs.api.exchangerate.canonical.response.authenticate.AuthenticationResponse;
import pe.com.tcs.api.exchangerate.canonical.request.convert.ExchangeRateRequest;
import pe.com.tcs.api.exchangerate.canonical.response.update.CoinResponse;
import pe.com.tcs.api.exchangerate.canonical.response.convert.ExchangeRateResponse;
import pe.com.tcs.api.exchangerate.common.bean.HeaderRequest;
import pe.com.tcs.api.exchangerate.common.exception.BaseException;
import pe.com.tcs.api.exchangerate.common.util.Constant;
import pe.com.tcs.api.exchangerate.common.util.UtilController;
import pe.com.tcs.api.exchangerate.domain.service.impl.UserDetailsServiceImpl;
import pe.com.tcs.api.exchangerate.domain.service.ExchangeRateService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/exchange-rates/v1")
public class ExchangeRateController {

    private final UtilController utilController;
    private final ExchangeRateService service;
    private final UserDetailsServiceImpl userDetailsService;


    @PostMapping(value = "/convert", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ExchangeRateResponse> convert(@RequestHeader(name = "accept", required = true) String accept,
                                                        @RequestBody @Validated ExchangeRateRequest request) {
        long startTime = System.currentTimeMillis();
        HeaderRequest headerRequest = utilController.completarHeader(accept);
        System.out.println(Constant.START_METHOD_CONVERT);
        ExchangeRateResponse response = new ExchangeRateResponse();

        try{
            response = service.convert(headerRequest, request);
        } catch (BaseException e) {
            response = utilController.getResponseConvertir(e);
        } catch (Exception e) {
            response = utilController.getResponseConvertir(e);
        } finally {
            System.out.printf(Constant.TOTAL_TIME, (System.currentTimeMillis() - startTime));
            System.out.println(Constant.END_METHOD_CONVERT);
        }

        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CoinResponse> update(@RequestHeader(name = "accept", required = true) String accept,
                                               @RequestBody @Validated CoinRequest request) {
        long startTime = System.currentTimeMillis();
        HeaderRequest headerRequest = utilController.completarHeader(accept);
        System.out.println(Constant.START_METHOD_UPDATE);
        CoinResponse response = new CoinResponse();

        try{
            response = service.update(headerRequest, request);
        } catch (BaseException e) {
            response = utilController.getResponseActualizar(e);
        } catch (Exception e) {
            response = utilController.getResponseActualizar(e);
        } finally {
            System.out.printf(Constant.TOTAL_TIME, (System.currentTimeMillis() - startTime));
            System.out.println(Constant.END_METHOD_UPDATE);
        }

        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity<AuthenticationResponse> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        long startTime = System.currentTimeMillis();
        System.out.println(Constant.START_METHOD_AUTHENTICATE);
        AuthenticationResponse response = new AuthenticationResponse();
        try {
            response = userDetailsService.authenticate(authenticationRequest);
        } catch (BaseException e) {
            response = utilController.getResponseAutenticar(e);
        } catch (Exception e) {
            response = utilController.getResponseAutenticar(e);
        } finally {
            System.out.printf(Constant.TOTAL_TIME, (System.currentTimeMillis() - startTime));
            System.out.println(Constant.END_METHOD_AUTHENTICATE);
        }

        return ResponseEntity.ok(response);
    }
}
