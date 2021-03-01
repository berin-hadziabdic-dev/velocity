package com.pixelcat.velocity.entity.jsonentities.dto;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class JsonFieldDTO {
    String fieldName;
    String fieldType;

    Map<String,Object> restrictions;
  
}
