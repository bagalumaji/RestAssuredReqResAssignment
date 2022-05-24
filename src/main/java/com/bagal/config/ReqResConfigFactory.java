package com.bagal.config;

import org.aeonbits.owner.ConfigCache;

public final class ReqResConfigFactory {
    private ReqResConfigFactory(){}

    public static ReqResConfig getConfig(){
        return ConfigCache.getOrCreate(ReqResConfig.class);
    }
}
