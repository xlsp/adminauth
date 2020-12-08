package cn.arcdev.gym.adminauth.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class SignUpRequest {
    @NotNull
    @Size(min = 6, max = 32)
    private String username;
    @NotNull
    @Size(min = 6, max = 32)
    private String password;
}
