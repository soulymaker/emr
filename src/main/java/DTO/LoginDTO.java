package DTO;

/**
 * @创建人 :  菠萝
 * @创建时间 : 2019-04-20 14:47
 * @描述 :
 */
public class LoginDTO {
    private String userId;
    private String password;
    private String userType;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
