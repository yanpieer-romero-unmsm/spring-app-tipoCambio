package pe.com.tcs.api.exchangerate.domain.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.com.tcs.api.exchangerate.canonical.request.authenticate.AuthenticationRequest;
import pe.com.tcs.api.exchangerate.canonical.response.authenticate.AuthenticationResponse;
import pe.com.tcs.api.exchangerate.common.bean.ResponseStatus;
import pe.com.tcs.api.exchangerate.common.exception.BaseException;
import pe.com.tcs.api.exchangerate.common.util.Constant;
import pe.com.tcs.api.exchangerate.common.util.ExternalProperties;
import pe.com.tcs.api.exchangerate.common.util.UtilService;
import pe.com.tcs.api.exchangerate.common.util.security.util.JwtUtil;
import pe.com.tcs.api.exchangerate.integration.repository.user.UserRepository;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final ExternalProperties externalProperties;
    private final UtilService utilService;
    private final JwtUtil jwtUtil;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) throws BaseException {
        AuthenticationResponse response = new AuthenticationResponse();
        boolean validRequest = utilService.validarRequestAutenticar(request);
        try {
            if (validRequest) {
                UserDetails userDetails = this.loadUserByUsername(request.getUsername());
                if (userDetails != Constant.NULL && request.getPassword().equalsIgnoreCase(userDetails.getPassword())){
                    String jwt = jwtUtil.generateToken(userDetails);
                    response.setDeveloper(Constant.DEVELOPER);
                    response.setJwt(jwt);
                } else{
                    response.setResponseStatus(ResponseStatus.builder()
                            .responseCode(externalProperties.idf2Code)
                            .responseDescription(externalProperties.idf2Message)
                            .build());
                    response.setDeveloper(Constant.DEVELOPER);
                }
            } else {
                response.setResponseStatus(ResponseStatus.builder()
                        .responseCode(externalProperties.idf1Code)
                        .responseDescription(externalProperties.idf1Message)
                        .build());
                response.setDeveloper(Constant.DEVELOPER);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response = utilService.getResponseIDTAutenticar(e);
            throw new BaseException(externalProperties.idt3Code, String.format(externalProperties.idt3Message, e), e);
        }
        return response;
    }

}