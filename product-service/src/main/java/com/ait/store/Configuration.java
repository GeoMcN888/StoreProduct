package com.ait.store;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@ConfigurationProperties("product-service")
@Component
public class Configuration {

    private String name;
    private String countryMade;

    private String boo;

    public String getBoo() {
        return boo;
    }

    public void setBoo(String boo) {
        this.boo = boo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryMade() {
        return countryMade;
    }

    public void setCountryMade(String countryMade) {
        this.countryMade = countryMade;
    }
}
