
package com.pixelcat.velocity.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pixelcat.velocity.entity.jsonentities.dto.JsonFieldDTO;
import com.pixelcat.velocity.entity.jsonentities.dto.JsonObjectTemplateDTO;
import com.pixelcat.velocity.entity.jsonentities.entitybuilders.FieldBuilderDelagateStrategy;
import com.pixelcat.velocity.entity.jsonentities.entitybuilders.JsonBuilder;
import com.pixelcat.velocity.javaandjavascripttypes.JavascriptField;
import com.pixelcat.velocity.javaandjavascripttypes.JavascriptType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.netty.handler.codec.json.JsonObjectDecoder;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(path="/",produces = {"application/json"})
public class AppController {

    @Autowired
    JsonBuilder builder;

    @RequestMapping(method=RequestMethod.GET)
    public String requestMethodName() throws Exception {
            Integer testKey = 1;
        Map<String,Object> recievedRestrictions = new HashMap<String,Object>();
        recievedRestrictions.put(JavascriptField.MIN, 0.0f);
        recievedRestrictions.put(JavascriptField.MAX,100.11f);
        recievedRestrictions.put(JavascriptField.STRING_LENGTH, 15);

        JsonObjectTemplateDTO jsonObject;
        JsonObjectTemplateDTO nestedJsonObject;
        List<JsonFieldDTO> dtos = new ArrayList<JsonFieldDTO>();
        List<JsonFieldDTO> nestedDto = new ArrayList<JsonFieldDTO>();
        
        List<JsonObjectTemplateDTO> nestedObjTest = new ArrayList<>();
        

        JsonFieldDTO intDTO = new JsonFieldDTO();
        JsonFieldDTO floatDTO = new JsonFieldDTO();
        JsonFieldDTO stringDTO = new JsonFieldDTO();
        JsonFieldDTO string2DTO = new JsonFieldDTO();
        JsonFieldDTO boolDTO = new JsonFieldDTO();
        
        JsonFieldDTO nestedInt = new JsonFieldDTO();
        JsonFieldDTO nestedStringTitle= new JsonFieldDTO();
        JsonFieldDTO nestedStringParagraph= new JsonFieldDTO();

        intDTO.setFieldName("account");
        intDTO.setFieldType(JavascriptType.integer);
        intDTO.setRestrictions(recievedRestrictions);

        floatDTO.setFieldName("balance");
        floatDTO.setFieldType(JavascriptType.float_);
        floatDTO.setRestrictions(recievedRestrictions);

        stringDTO.setFieldName("username");
        stringDTO.setFieldType(JavascriptType.string);
        stringDTO.setRestrictions(recievedRestrictions);

        string2DTO.setFieldName("password");
        string2DTO.setFieldType(JavascriptType.string);
        string2DTO.setRestrictions(recievedRestrictions);

        boolDTO.setFieldName("isActive");
        boolDTO.setFieldType(JavascriptType.boolean_);
        boolDTO.setRestrictions(recievedRestrictions);

        dtos.add(stringDTO);
        dtos.add(string2DTO);
        dtos.add(intDTO);
        dtos.add(boolDTO);
        dtos.add(floatDTO);

        nestedInt.setFieldType(JavascriptType.integer);
        nestedInt.setFieldName("id");
        nestedInt.setRestrictions(recievedRestrictions);

        nestedStringTitle.setFieldType(JavascriptType.string);
        nestedStringTitle.setFieldName("title");
        nestedStringTitle.setRestrictions(recievedRestrictions);
       
        nestedStringParagraph.setFieldType(JavascriptType.string);
        nestedStringParagraph.setFieldName("paragraph");
        nestedStringParagraph.setRestrictions(recievedRestrictions);

      
        nestedDto.add(nestedInt);
        nestedDto.add(nestedStringTitle);
        nestedDto.add(nestedStringParagraph);

        nestedJsonObject = new JsonObjectTemplateDTO("about_me",nestedDto);
        List<JsonObjectTemplateDTO> nestedObjectTemplates = new ArrayList<JsonObjectTemplateDTO>();
        nestedObjectTemplates.add(nestedJsonObject);
        
        jsonObject = new JsonObjectTemplateDTO(dtos,nestedObjectTemplates);
        
    
		
        return builder.buildJsonString(jsonObject);
    }
    


}