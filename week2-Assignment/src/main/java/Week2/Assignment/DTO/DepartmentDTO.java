package Week2.Assignment.DTO;

import Week2.Assignment.annotations.PasswordValidation;
import Week2.Assignment.annotations.PrimeNumberValidation;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {

    private Long id;

    @NotBlank
    @Size(min = 3, max = 10, message = "title cannot be blank")
    private String title;

    @JsonProperty("isActive")
    @AssertTrue(message = "department should be active")
    private Boolean isActive;

    @PastOrPresent(message = "createdAt must be in past or present")
    @NotNull
    @JsonFormat(pattern = "hh:mm:ss dd-MM-yyyy")
    private LocalDateTime createdAt = LocalDateTime.now();

    @PrimeNumberValidation
    private Integer checkPrime;

    @PasswordValidation
    private String password;

}
