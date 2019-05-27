package vu.che.mvcrest;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/rest")
public class RestApp extends ResourceConfig {

    public RestApp() {
         packages("vu.che.mvcrest.Coupon");
    }
}