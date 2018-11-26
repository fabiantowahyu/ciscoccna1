package com.onlinelearningcenter.cisco.ccna1.pojo;

/**
 * Created by danang on 12/11/2016.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DevicesResponses {
    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("email")
    @Expose
    private String email;


    @SerializedName("information")
    @Expose
    private String information;

    @SerializedName("update_link")
    @Expose
    private String update_link;

    @SerializedName("is_superior")
    @Expose
    private String is_superior;


    @SerializedName("token")
    @Expose
    private String token;

    @SerializedName("emp_id")
    @Expose
    private String emp_id;

    @SerializedName("password")
    @Expose
    private String password;
    /**
     *
     * @return
     * The success
     */
    public Integer getSuccess() {
        return success;
    }

    public String getisSuperior() {
        return is_superior;
    }
    /**
     *
     * @param success
     * The success
     */
    public void setSuccess(Integer success) {
        this.success = success;
    }

    /**
     *
     * @return
     * The message
     */
    public String getMessage() {
        return message;
    }

    /**
     *
     * @param message
     * The message
     */
    public void setMessage(String message) {
        this.message = message;
    }


    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     * The message
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmp_id() {
        return emp_id;
    }

    /**
     *
     * @param emp_id
     * The message
     */
    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getUpdate_link() {
        return update_link;
    }

    /**
     *
     * @param update_link
     * The message
     */
    public void setUpdate_link(String update_link) {
        this.update_link = update_link;
    }


    public String getToken() {
        return token;
    }

    /**
     *
     * @param token
     * The message
     */
    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public String getInformation() {
        return information;
    }

    /**
     *
     * @param email
     * The message
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public void setInformation(String information) {
        this.information = information;
    }

}
