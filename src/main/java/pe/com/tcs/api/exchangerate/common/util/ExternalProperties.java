package pe.com.tcs.api.exchangerate.common.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExternalProperties {

    @Value("${idf0.code}")
    public String idf0Code;
    @Value("${idf0.message}")
    public String idf0Message;
    @Value("${idf1.code}")
    public String idf1Code;
    @Value("${idf1.message}")
    public String idf1Message;
    @Value("${idf2.code}")
    public String idf2Code;
    @Value("${idf2.message}")
    public String idf2Message;

    @Value("${idt1.code}")
    public String idt1Code;
    @Value("${idt1.message}")
    public String idt1Message;
    @Value("${idt2.code}")
    public String idt2Code;
    @Value("${idt2.message}")
    public String idt2Message;
    @Value("${idt3.code}")
    public String idt3Code;
    @Value("${idt3.message}")
    public String idt3Message;

    @Value("${secret.key}")
    public String secretKey;
}
