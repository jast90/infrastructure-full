package cn.jastz.mall.api.vo;

import java.util.List;

/**
 * @author zhiwen
 */
public class UserRoleResourceVo {
    private List<String> roleList;
    private List<String> resourceList;

    public List<String> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<String> roleList) {
        this.roleList = roleList;
    }

    public List<String> getResourceList() {
        return resourceList;
    }

    public void setResourceList(List<String> resourceList) {
        this.resourceList = resourceList;
    }
}
