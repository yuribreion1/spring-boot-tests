package com.training.api.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    Integer id;
    String name;
    String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    String password;

}
