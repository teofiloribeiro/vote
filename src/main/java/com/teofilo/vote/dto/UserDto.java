package com.teofilo.vote.dto;

import javax.validation.constraints.NotEmpty;

public class UserDto {
    private Long id;
    @NotEmpty(message = "firstName is required.")
    private String firstName;
    @NotEmpty(message = "lastName is required.")
    private String lastName;
    @NotEmpty(message = "documentNumber is required.")
    private String documentNumber;

    public UserDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }
}
