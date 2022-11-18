package pe.com.tcs.api.exchangerate.canonical.response.update;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.tcs.api.exchangerate.common.bean.ResponseStatus;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CoinResponse {
    private ResponseStatus responseStatus;
    private String developer;
    private String message;
    private String type;
    private Double value;
}
