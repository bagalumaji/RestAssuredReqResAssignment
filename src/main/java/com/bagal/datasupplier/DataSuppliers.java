package com.bagal.datasupplier;

import com.bagal.pojo.User;
import com.bagal.utils.JsonFileReaderUtil;
import io.github.sskorol.core.DataSupplier;
import one.util.streamex.StreamEx;

public class DataSuppliers {
    @DataSupplier
    public StreamEx<User> getData() {
        return JsonFileReaderUtil.getJsonData();
    }
}
