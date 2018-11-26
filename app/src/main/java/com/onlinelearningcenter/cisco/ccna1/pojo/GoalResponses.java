package com.onlinelearningcenter.cisco.ccna1.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GoalResponses {

    private String title;
    private String link;
    private String contributors;
    private String last_status;


    private String type_appraisal;
    private String emp_name;

    private String profile_pic;


    private String pm_status;

    private String emp_id;
    private String id;
    private String created_date;
    private String photo;


    public String getTitle() {
        return title;
    }


    public String getLink() {
        return link;
    }

    public String getTitleGoal() {
        return title;
    }

    public String getContributors() {
        return contributors;
    }
    public String getLastStatus() {
        return last_status;
    }



    public String getPm_status() {
        return pm_status;
    }
    public String getTypeAppraisal() {
        return type_appraisal;
    }

    public String getEmpName() {
        return emp_name;
    }

    public String getProfilPic() {
        return profile_pic;
    }



    public String getEmp_Id() {
        return emp_id;
    }



    public String getPhoto() {
        return photo;
    }



    public String getGoalId() {
        return id;
    }
    public void setTitleGoal(String title_goal) {
        this.title = title_goal;
    }

    public String getCreatedDate() {
        return created_date;
    }

    public static class GoalList {
        private GoalResponses[] GoalResponses;

        public GoalResponses[] getGoal() {
            return GoalResponses;
        }
    }
    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("message")
    @Expose
    private String message;

    /**
     *
     * @return
     * The success
     */
    public Integer getSuccess() {
        return success;
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
}
