package com.bagal.utils;

import com.bagal.pojo.User;
import io.github.sskorol.data.JsonReader;
import one.util.streamex.StreamEx;

import static io.github.sskorol.data.TestDataReader.use;

public final class JsonFileReaderUtil {
    private JsonFileReaderUtil(){}
    public static StreamEx<User> getJsonData(){
       return use(JsonReader.class)
                .withTarget(User.class)
                .withSource("testdata/user.json")
                .read();
    }
}
