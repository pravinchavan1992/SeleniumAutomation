package config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppData {
    private String appUrl;
    private String userName;
    private String password;
    private String browserName;
}
