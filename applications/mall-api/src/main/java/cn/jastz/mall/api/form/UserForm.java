package cn.jastz.mall.api.form;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author zhiwen
 */
public class UserForm {
    @ApiModelProperty(value = "api-user")
    private String username;
    @ApiModelProperty(value = "123456")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
