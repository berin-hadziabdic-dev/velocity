package com.pixelcat.velocity.entity.testingentities.endpointtests;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.pixelcat.velocity.entity.endpointentities.ApiEndpoint;
import com.pixelcat.velocity.entity.jsonentities.dto.JsonObjectTemplateDTO;

import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import lombok.Getter;

@Entity
@Getter
public class EndPointRequestTemplate {

    @Id
    private Integer id; 
    private HttpMethod method;
    private ApiEndpoint endpoint;
    private JsonObjectTemplateDTO body;
    private Boolean isDispatchedInRandomOrder;
    private HttpHeaders headers;

    public EndPointRequestTemplate(){
        this.isDispatchedInRandomOrder = false;
    }
}
