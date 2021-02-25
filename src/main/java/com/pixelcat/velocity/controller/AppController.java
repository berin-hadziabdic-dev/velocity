
package com.pixelcat.velocity.controller;

import com.pixelcat.velocity.entity.jsonentities.entitybuilders.FieldBuilderDelagateStrategy;
import com.pixelcat.velocity.javascriptypes.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/")
public class AppController {

    @Autowired
    FieldBuilderDelagateStrategy defaultStrategy;

    @RequestMapping(method=RequestMethod.GET)
    public String requestMethodName() throws Exception {
            Integer testKey = 1;
            JavascriptType type = new JavascriptType(0, "string");
            JavascriptType integer = new JavascriptType(1,"number");
            JavascriptType bool = new JavascriptType(1,"boolean");

            Object retObj = this.defaultStrategy.doStrategy(type, testKey);
            Object retObj2 = this.defaultStrategy.doStrategy(integer, testKey);
            Object retObj3 = this.defaultStrategy.doStrategy(bool, testKey);
            System.out.println(retObj.toString());
            return retObj.toString();
    }
    


}