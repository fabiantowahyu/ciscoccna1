package com.onlinelearningcenter.cisco.ccna1.pojo;

/**
 * Created by danang on 11/29/2016.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponses {

    @SerializedName("success")
    @Expose
    private Integer success;
    private String message;
    private String emp_id;
    private String emp_name;
    private String username;
    private String position_id;
    private String gender;
    private String position_name;
    private String hp;
    private String join_date;
    private String branch_id;
    private String branch;
    private String email;
    private String grade_id;
    private String photo;
    private String token;
    private String is_superior;

    /**
     *
     * @return
     * The success
     */
    public Integer getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getEmpId() {
        return emp_id;
    }
    public String getisSuperior() {
        return is_superior;
    }

    public String getEmpName() {
        return emp_name;
    }

    public String getUsername() {
        return username;
    }

    public String getPositionId() {
        return position_id;
    }

    public String getGender() {
        return gender;
    }

    public String getPositionName() {
        return position_name;
    }

    public String getHp() {
        return hp;
    }

    public String getJoinDate() {
        return join_date;
    }

    public String getBranchId() {
        return branch_id;
    }

    public String getBranch() {
        return branch;
    }

    public String getEmail() {
        return email;
    }

    public String getGradeId() {
        return grade_id;
    }

    public String getPhoto() {
        return photo;
    }

    /**
     *
     * @param success
     * The success
     */
    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getToken() {
        return token;
    }
}

