package com.olawale.criteriasearch.dto.request;

import lombok.Data;

@Data
public class AddResidentReq {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
}
