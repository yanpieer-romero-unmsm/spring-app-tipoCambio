package pe.com.tcs.api.exchangerate.common.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ResponseStatus {
    private String status;
    private String responseCode;
    private String responseDescription;
    private String errorLocation;
    private Date date;
    private String source;
    private ErrorDetail errorDetail;
}
