package config;

import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigurationManager {

    private static ConfigurationManager configurationManager = new ConfigurationManager();

    private ConfigData configData;

    private ConfigurationManager(){
        Yaml yaml = new Yaml();
        Path path = Paths.get(System.getProperty("user.dir"),"src","main","java","config","config.yaml");
        try (InputStream in = Files.newInputStream(path)) {
            configData = yaml.loadAs(in, ConfigData.class);
        } catch (IOException ie) {
            //TODO:Log exception.
            ie.printStackTrace();
            throw new ExceptionInInitializerError(ie);
        }
    }

    private static ConfigurationManager getInstance() {
        if (configurationManager == null) {
            //synchronized block to remove overhead
            synchronized (ConfigurationManager.class) {
                if (configurationManager == null) {
                    // if instance is null, initialize
                    configurationManager = new ConfigurationManager();
                }
            }
        }
        return configurationManager;
    }

    public static ConfigData getConfigData() {
        return getInstance().configData;
    }
}
