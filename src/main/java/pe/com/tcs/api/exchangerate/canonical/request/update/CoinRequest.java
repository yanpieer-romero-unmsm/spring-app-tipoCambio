package pe.com.tcs.api.exchangerate.canonical.request.update;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CoinRequest {
    @NotBlank(message = "type must not be empty, must not have white spaces and must not be null")
    private String type;
    @NotBlank(message = "value must not be empty, must not have white spaces and must not be null")
    private Double value;
}
