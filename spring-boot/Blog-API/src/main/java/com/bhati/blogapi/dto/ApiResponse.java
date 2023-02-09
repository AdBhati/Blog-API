package com.bhati.blogapi.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ApiResponse {

    private UUID recordId;
    private Boolean success;
    private String message;
    private Integer noOfRecords;
    private String objectName;
    private List<?> records = new ArrayList<>();

}
