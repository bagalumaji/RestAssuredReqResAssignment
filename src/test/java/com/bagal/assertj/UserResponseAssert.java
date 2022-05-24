package com.bagal.assertj;

import com.bagal.pojo.UserResponse;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

public class UserResponseAssert extends AbstractAssert<UserResponseAssert, UserResponse> {


    private UserResponseAssert(UserResponse userResponse, Class<?> selfType) {
        super(userResponse, selfType);
    }

    public static UserResponseAssert verifyThat(UserResponse userResponse){
        return new UserResponseAssert(userResponse, UserResponseAssert.class);
    }

    public UserResponseAssert hasName(String name){
        Assertions
                .assertThat(actual)
                .extracting(UserResponse::getName)
                .withFailMessage(()->"name is not matching")
                .isEqualTo(name);
        return this;
    }

    public UserResponseAssert hasJab(String job){
        Assertions
                .assertThat(actual)
                .extracting(UserResponse::getJob)
                .withFailMessage(()->"job is not matching")
                .isEqualTo(job);
        return this;
    }
}
