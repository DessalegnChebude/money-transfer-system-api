package edu.act.moneytransfersystem.domains;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First name is mandatory.")
    @Column(nullable = false)
    private String firstName;

    @NotBlank(message = "Middle name is mandatory.")
    @Column(nullable = false)
    private String middleName;

    @NotBlank(message = "Last name is mandatory.")
    @Column(nullable = false)
    private String lastName;

    @NotBlank(message = "Email is mandatory.")
    @Column(nullable = false)
    private String email;

    @NotBlank(message = "Phone number is mandatory.")
    @Column(nullable = false)
    private String phoneNumber;

    @NotNull(message = "Pin is mandatory.")
    @Column(nullable = false)
    private Integer pin;

    // assign default value
    private Boolean isVerified = Boolean.TRUE;

    // assign default value
    private Double balance = 0.0;
}
