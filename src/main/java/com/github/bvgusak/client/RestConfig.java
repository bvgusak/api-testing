package com.github.bvgusak.client;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.config.RestAssuredConfig;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public abstract class RestConfig {

    public static String baseURI;
    public static String basePath;
    public static boolean proxyEnabled;
    public static String proxyHost;
    public static int proxyPort;

    static {
        //Load configuration properties
        try {
            PropertiesConfiguration configuration = new PropertiesConfiguration("config.properties");
            baseURI = configuration.getString("app.base.uri");
            basePath = configuration.getString("app.base.path");
            proxyEnabled = configuration.getBoolean("proxy.enabled");
            proxyHost = configuration.getString("proxy.host");
            proxyHost = configuration.getString("proxy.port");
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }

        //Configure REST Assured
        RestAssured.baseURI = (baseURI == null) ? RestAssured.DEFAULT_URI : baseURI;
        RestAssured.basePath = (basePath == null) ? RestAssured.DEFAULT_PATH : basePath;
        RestAssured.config = new RestAssuredConfig().objectMapperConfig(new ObjectMapperConfig().jackson2ObjectMapperFactory(
                (cls, charset) -> new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        ));
        if (proxyEnabled) {
            RestAssured.proxy(proxyHost, proxyPort);
        }

    }

}
