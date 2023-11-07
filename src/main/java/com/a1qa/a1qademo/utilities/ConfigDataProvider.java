package com.a1qa.a1qademo.utilities;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
public class ConfigDataProvider {

    Properties pro;

    public ConfigDataProvider() {
        File src = new File("/Users/husnitdin/Documents/Automation/a1qa-demo/src/main/resources/config.properties");
        try {
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);
        } catch (Exception e){
            System.out.println("Unable to load config.properties "+e.getMessage());
        }
    }

    public String getBrowser(){
        return pro.getProperty( "Browser" );
    }

    public String getURL(){
        return pro.getProperty( "qaURL" );
    }

    public String getDataFromConfig( String keyToSearch ){
        return pro.getProperty( keyToSearch );
    }
}
