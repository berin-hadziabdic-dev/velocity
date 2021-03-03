package com.pixelcat.velocity.entity.testingentities.tests;

import java.util.List;
import java.util.Map;

import com.pixelcat.velocity.entity.endpointentities.ApiEndpoint;

import lombok.Data;

@Data
public class TestSet {
    Integer port; //Tcp port to send requests to
    String hostname; //hostname you'd like to send requests to.
    List<ApiEndpoint> testApiEndpoints; // this list contains all of the possible api end points you'd like to test.
    Map<TestType,TestDefinition> tests;
}
