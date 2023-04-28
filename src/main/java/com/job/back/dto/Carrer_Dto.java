package com.job.back.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carrer_Dto {

    private  String companyTelNumber;

    private String[] carrer;
    private int carrer_score;
    
}
