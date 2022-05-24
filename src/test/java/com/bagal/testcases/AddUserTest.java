package com.bagal.testcases;

import com.bagal.assertj.ResponseAssert;
import com.bagal.assertj.UserResponseAssert;
import com.bagal.constants.FrameworkConstants;
import com.bagal.datasupplier.DataSuppliers;
import com.bagal.pojo.User;
import com.bagal.pojo.UserResponse;
import com.bagal.rest.Rest;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

import static com.bagal.config.ReqResConfigFactory.getConfig;

public class AddUserTest {
    @Test(dataProvider = "getData",dataProviderClass = DataSuppliers.class)
    public void addUserTest(User user) {
        Response response = Rest.POST(user);
        ResponseAssert
                .verifyThat(response)
                .isSuccessfulPostResponse()
                .hasHeaderApplicationJson()
                .hasResponseTimeLessThan(getConfig().responseTime());

        UserResponse userResponse = response.as(UserResponse.class);
        UserResponseAssert
                .verifyThat(userResponse)
                .hasName(user.getName())
                .hasJab(user.getJob());

        response.then().body(JsonSchemaValidator.matchesJsonSchema(new File(FrameworkConstants.getUserSchema())));
    }
}
