package com.jojo.countryService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {
    private Date createDate = new Date();

    @Id
    private String id;
    private String name;
}