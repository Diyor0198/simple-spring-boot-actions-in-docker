package com.example.springbootactions.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class  ResponseDto<T> {
         private boolean success;

         private String message;

         /*
          * 0  - it is ok
          * -1 - database error
          *-2  - validation error
          *-3  - not found
          * */

         private int code;

         private T data;

         private List<ErrorDto> errors;

}