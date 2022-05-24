package com.bagal.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:${user.dir}/src/test/resources/config/config.properties"
})
public interface ReqResConfig extends Config {

   @DefaultValue("application/json")
    String contentType();

    String environment();

    @Key("${environment}.baseURI")
    String baseURI();

    @Key("${environment}.endPoint")
    String endPoint();

    int responseTime();
}
