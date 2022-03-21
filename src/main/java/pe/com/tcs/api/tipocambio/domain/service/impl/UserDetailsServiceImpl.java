package pe.com.tcs.api.tipocambio.domain.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.com.tcs.api.tipocambio.canonical.request.authenticate.AuthenticationRequestType;
import pe.com.tcs.api.tipocambio.canonical.response.authenticate.AuthenticationResponseType;
import pe.com.tcs.api.tipocambio.common.bean.ResponseStatus;
import pe.com.tcs.api.tipocambio.common.exceptions.BaseException;
import pe.com.tcs.api.tipocambio.common.util.Constantes;
import pe.com.tcs.api.tipocambio.common.util.PropertiesExternos;
import pe.com.tcs.api.tipocambio.common.util.UtilService;
import pe.com.tcs.api.tipocambio.common.util.security.util.JwtUtil;
import pe.com.tcs.api.tipocambio.integration.repository.usuarios.UsuarioRepository;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;
    private final PropertiesExternos properties;
    private final UtilService utilService;
    private final JwtUtil jwtTokenUtil;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByUsername(username);
    }

    public AuthenticationResponseType autenticar(AuthenticationRequestType request) throws BaseException {
        AuthenticationResponseType response = new AuthenticationResponseType();
        boolean requestValido = utilService.validarRequestAutenticar(request);

        try {
            if (requestValido) {
                UserDetails userDetails = this.loadUserByUsername(request.getUsername());
                if (userDetails != Constantes.NULO && request.getPassword().equalsIgnoreCase(userDetails.getPassword())){
                    String jwt = jwtTokenUtil.generateToken(userDetails);
                    response.setDesarrollador(Constantes.DESARROLLADOR);
                    response.setJwt(jwt);
                } else{
                    response.setResponseStatus(ResponseStatus.builder()
                            .codigoRespuesta(properties.idf2Codigo)
                            .descripcionRespuesta(properties.idf2Mensaje)
                            .build());
                    response.setDesarrollador(Constantes.DESARROLLADOR);
                }
            } else {
                response.setResponseStatus(ResponseStatus.builder()
                        .codigoRespuesta(properties.idf1Codigo)
                        .descripcionRespuesta(properties.idf1Mensaje)
                        .build());
                response.setDesarrollador(Constantes.DESARROLLADOR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response = utilService.getResponseIDTAutenticar(e);
            throw new BaseException(properties.idt3Codigo, String.format(properties.idt3Mensaje, e.toString()), e);
        }

        return response;
    }

}