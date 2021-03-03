package com.pixelcat.velocity.entity.endpointentities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ApiEndpoint {
    @Id
    Integer id;
    String path;
}
