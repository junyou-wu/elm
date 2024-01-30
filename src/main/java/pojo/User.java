package pojo;



import java.io.Serializable;


/**
* 
* @TableName user
*/
public class User{


    public User() {
    }

    /**
    * 用户编号
    */

    private String userId;
    /**
    * 密码
    */

    private String password;
    /**
    * 用户名称
    */

    private String userName;
    /**
    * 用户性别（1：男； 0：女）
    */

    private Integer userSex;
    /**
    * 用户头像
    */

    private String userImg;
    /**
    * 删除标记（1：正常； 0：删除）
    */

    private Integer delTag;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public Integer getDelTag() {
        return delTag;
    }

    public void setDelTag(Integer delTag) {
        this.delTag = delTag;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", userSex=" + userSex +
                ", userImg='" + userImg + '\'' +
                ", delTag=" + delTag +
                '}';
    }


}
