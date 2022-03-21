package pe.com.tcs.api.tipocambio.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.com.tcs.api.tipocambio.canonical.request.actualizar.MonedaRequestType;
import pe.com.tcs.api.tipocambio.canonical.request.authenticate.AuthenticationRequestType;
import pe.com.tcs.api.tipocambio.canonical.response.authenticate.AuthenticationResponseType;
import pe.com.tcs.api.tipocambio.canonical.request.convertir.TipoCambioRequestType;
import pe.com.tcs.api.tipocambio.canonical.response.actualizar.MonedaResponseType;
import pe.com.tcs.api.tipocambio.canonical.response.convertir.TipoCambioResponseType;
import pe.com.tcs.api.tipocambio.common.bean.HeaderRequest;
import pe.com.tcs.api.tipocambio.common.exceptions.BaseException;
import pe.com.tcs.api.tipocambio.common.util.Constantes;
import pe.com.tcs.api.tipocambio.common.util.UtilController;
import pe.com.tcs.api.tipocambio.domain.service.impl.UserDetailsServiceImpl;
import pe.com.tcs.api.tipocambio.common.util.security.util.JwtUtil;
import pe.com.tcs.api.tipocambio.domain.service.TipoCambioService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/tipocambios/v1")
public class TipoCambioController {

    private final UtilController utilController;
    private final TipoCambioService service;
    private final UserDetailsServiceImpl userDetailsService;


    @PostMapping(value = "/convertir", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TipoCambioResponseType> convertir(@RequestHeader(name = "accept", required = true) String accept,
                                            @RequestBody @Validated TipoCambioRequestType request) {
        long tiempoInicio = System.currentTimeMillis();
        HeaderRequest headerRequest = utilController.completarHeader(accept);
        System.out.println(Constantes.INICIO_METODO_CONVERTIR);
        TipoCambioResponseType response = new TipoCambioResponseType();

        try{
            response = service.convertir(headerRequest, request);
        } catch (BaseException e) {
            response = utilController.getResponseConvertir(e);
        } catch (Exception e) {
            response = utilController.getResponseConvertir(e);
        } finally {
            System.out.printf(Constantes.TIEMPO_TOTAL, (System.currentTimeMillis() - tiempoInicio));
            System.out.println(Constantes.FIN_METODO_CONVERTIR);
        }

        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MonedaResponseType> actualizar(@RequestHeader(name = "accept", required = true) String accept,
                                        @RequestBody @Validated MonedaRequestType request) {
        long tiempoInicio = System.currentTimeMillis();
        HeaderRequest headerRequest = utilController.completarHeader(accept);
        System.out.println(Constantes.INICIO_METODO_ACTUALIZAR);
        MonedaResponseType response = new MonedaResponseType();

        try{
            response = service.actualizar(headerRequest, request);
        } catch (BaseException e) {
            response = utilController.getResponseActualizar(e);
        } catch (Exception e) {
            response = utilController.getResponseActualizar(e);
        } finally {
            System.out.printf(Constantes.TIEMPO_TOTAL, (System.currentTimeMillis() - tiempoInicio));
            System.out.println(Constantes.FIN_METODO_ACTUALIZAR);
        }

        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/autenticar")
    public ResponseEntity<AuthenticationResponseType> createAuthenticationToken(@RequestBody AuthenticationRequestType authenticationRequestType) throws Exception {
        long tiempoInicio = System.currentTimeMillis();
        System.out.println(Constantes.INICIO_METODO_AUTENTICAR);
        AuthenticationResponseType response = new AuthenticationResponseType();
        try {
            response = userDetailsService.autenticar(authenticationRequestType);
        } catch (BaseException e) {
            response = utilController.getResponseAutenticar(e);
        } catch (Exception e) {
            response = utilController.getResponseAutenticar(e);
        } finally {
            System.out.printf(Constantes.TIEMPO_TOTAL, (System.currentTimeMillis() - tiempoInicio));
            System.out.println(Constantes.FIN_METODO_AUTENTICAR);
        }

        return ResponseEntity.ok(response);
    }

}
