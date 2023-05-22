package com.creche.crecheapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;
@Builder
@Data

public class AttendanceDto {

    private Integer id;

    @JsonIgnore

    private Date creationDate;

}
