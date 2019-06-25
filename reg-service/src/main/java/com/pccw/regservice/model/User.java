package com.pccw.regservice.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Getter
@Setter
@Table(name = "usertest")
@SQLDelete(sql="Update usertest SET deleted = 'true' where id=?")
@Where(clause="deleted != 'true'")
public class User {

    @NotNull(message = "Id cannot be null")
    @Id
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private Long id;

    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name is mandatory")
    @Column(name = "name")
    private String name;


    @Size(min = 9, max = 10)
    @Column(name = "phone")
    @Pattern(regexp="[0-9]+")
    private String phone;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email cannot be null")
    @NotNull(message = "Email cannot be null")
    @Column(name = "uemail", nullable = false)
    private String email;

    @Column(name="deleted", nullable = false)
    @NotNull(message = "Flag cannot be null")
    @NotBlank(message = "Flag cannot be null")
    private String deleteFlag;
}

