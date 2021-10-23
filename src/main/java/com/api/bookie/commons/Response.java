package com.api.bookie.commons;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.Map;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Response {
  @JsonInclude
  private Object data;

  private Integer code;
  private Date dateTime;
  private String message;
  private Map<String, String> errors;

  public Map<String, String> getErrors() {
    return errors;
  }
}
