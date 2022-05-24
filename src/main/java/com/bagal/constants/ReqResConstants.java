package com.bagal.constants;

import lombok.Getter;

public final class ReqResConstants {
    private ReqResConstants() {
    }

    private static final String RESOURCE_PATH = System.getProperty("user.dir") + "/src/test/resources";
    private @Getter
    static final String baseURI = "https://reqres.in/api";
    private @Getter
    static final String endPointUsers = "users";
    private @Getter
    static final String userSchema = RESOURCE_PATH + "/schema/UserSchema.json";

    private @Getter
    static final String extentReportPath = System.getProperty("user.dir") + "/target/extent-report/index.html";
}
