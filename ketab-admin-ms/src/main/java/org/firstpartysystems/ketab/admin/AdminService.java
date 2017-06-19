package org.firstpartysystems.ketab.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AdminService 
{
    public static void main( String[] args )
    {
       SpringApplication.run(AdminService.class, args);
    }
}
