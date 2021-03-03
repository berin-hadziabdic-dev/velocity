
package com.pixelcat.velocity.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pixelcat.velocity.entity.jsonentities.dto.JsonFieldDTO;
import com.pixelcat.velocity.entity.jsonentities.dto.JsonObjectTemplateDTO;
import com.pixelcat.velocity.entity.jsonentities.entitybuilders.FieldBuilderDelagateStrategy;
import com.pixelcat.velocity.entity.jsonentities.entitybuilders.JsonBuilder;
import com.pixelcat.velocity.entity.jsonentities.fieldbuilders.fieldRestricitions.FieldRestrictionsLookUp;
import com.pixelcat.velocity.javaandjavascripttypes.javascript.JavascriptType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping(method=RequestMethod.POST)
    public String parseTest(@RequestBody  JsonObjectTemplateDTO dto) throws Exception {
        
     JsonObjectTemplateDTO jsonObject = dto;
     return  this.builder.buildJsonString(jsonObject);        
    }
    @RequestMapping(method=RequestMethod.GET)
    public String requestMethodName() throws Exception {
        
        
    
		
        return null;
    }
    


}