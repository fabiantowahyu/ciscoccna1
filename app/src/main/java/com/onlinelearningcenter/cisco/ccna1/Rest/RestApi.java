package com.onlinelearningcenter.cisco.ccna1.Rest;




import com.onlinelearningcenter.cisco.ccna1.pojo.DevicesResponses;
import com.onlinelearningcenter.cisco.ccna1.pojo.GoalResponses;
import com.onlinelearningcenter.cisco.ccna1.pojo.LoginResponses;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RestApi {
    @GET("pa_rest_server/get_user?")
    Call<LoginResponses> get_user(@Query("userid") String user_id, @Query("pass") String password);

//    //Insert Idea
//    @FormUrlEncoded
//    @POST("idea/post_idea")
//    Call<IdeaResponses> post_idea(@Field("title_idea") String title_idea, @Field("remark_idea") String remark, @Field("emp_id") String emp_id);
//
//    @FormUrlEncoded
//    @POST("pa_cheers/index_post")
//    Call<Cheers> post_cheers(@Field("to_peers") String to_peers, @Field("description") String description, @Field("emp_id") String emp_id);
//
//    @GET("pa_cheers/index_get?")
//    Call<Cheers.CheersList> getCheers(@Query("emp_id") String emp_id, @Query("type") String type);
//
//    @DELETE("pa_cheers/index_delete/id/{id}/token/{token}")
//    Call<ResponseBody> deleteCheers(@Path("id") String id_cheers, @Path("token") String token);
//
//    @GET("employee/index_get?")
//    Call<Employee.EmployeeList> getEmployee();
//
//    @GET("pm_period/index_get?")
//    Call<PmResponses.PmList> get_pm_period(@Query("emp_id") String emp_id, @Query("type") String type);
//
//
//    @PUT("pa_cheers/index_put/id/{id}")
//    Call<ResponseBody> updateStatus(@Path("id") String id_cheers);
//
//    @Multipart
//    @POST("pa_cheers/index_post")
//    Call<Cheers> uploadImage(@Part MultipartBody.Part file, @Part("emp_id") RequestBody emp_id, @Part("description") RequestBody description, @Part("to_peers") RequestBody to_peers, @Part("file_exist") RequestBody file_exist, @Part("core_value") RequestBody core_value);
//
//    @GET("pa_self/index_get?")
//    Call<PaSelfResponsesAppraisal.AppraisalList> get_pa_self_appraisal(@Query("v_emp_id") String v_emp_id, @Query("v_emp_position_id") String v_emp_position_id, @Query("v_pm_id") String v_pm_id, @Query("v_pm_period") String v_pm_period, @Query("v_type") String v_type);
//
//    @GET("pa_self/index_get?")
//    Call<PaSelfResponsesCompetence.CompetenceList> get_pa_self_competence(@Query("v_emp_id") String v_emp_id, @Query("v_emp_position_id") String v_emp_position_id, @Query("v_pm_id") String v_pm_id, @Query("v_pm_period") String v_pm_period, @Query("v_type") String v_type);
//
//    @GET("notification_drawer/index_get?")
//    Call<NotificationDrawerResponses> getDrawerNotification(@Query("emp_id") String emp_id);


   // @POST("post_value/index_post")
    //Call<ValuePA> post_competence(@Body ArrayList<ValuePA> value_competence);

//    @FormUrlEncoded
//    @POST("pa_self/index_post")
//    Call<ValuePA> post_competence2(@Field("periode") String periode, @Field("pmperiod_id") String pmperiod_id, @Field("score_type") String score_type, @Field("competency_point_code") String competency_point_code, @Field("appraisal_point_code") String appraisal_point_code, @Field("branch_id") String branch_id, @Field("position_id") String position_id, @Field("grade_id") String grade_id, @Field("emp_id") String emp_id, @Field("valuecompetence") String valueCompetence, @Field("valueappraisal") String valueAppraisal, @Field("type") String type, @Field("pa_id") String pa_id, @Field("token") String token);
//
//
//    @FormUrlEncoded
//    @POST("pa_peers/index_post")
//    Call<ValuePA> post_peers(@Field("periode") String periode, @Field("pmperiod_id") String pmperiod_id, @Field("score_type") String score_type, @Field("competency_point_code") String competency_point_code, @Field("appraisal_point_code") String appraisal_point_code, @Field("branch_id") String branch_id, @Field("position_id") String position_id, @Field("grade_id") String grade_id, @Field("emp_id") String emp_id, @Field("valueappraisal") String valueAppraisal, @Field("type") String type, @Field("pa_id") String pa_id, @Field("emp_id_peers") String emp_id_peers, @Field("token") String token);
//
//    @GET("pa_peers/index_get?")
//    Call<PaSelfResponsesAppraisal.AppraisalList> get_pa_peers_appraisal(@Query("v_emp_id_reviewer") String v_emp_id_reviewer, @Query("v_emp_id") String v_emp_id, @Query("v_emp_position_id") String v_emp_position_id, @Query("v_pm_id") String v_pm_id, @Query("v_pm_period") String v_pm_period, @Query("v_type") String v_type, @Query("v_pa_id") String v_pa_id);
//
//    @GET("pa_reviewer/index_get?")
//    Call<PaSelfResponsesAppraisal.AppraisalList> get_pa_reviewer_appraisal(@Query("v_emp_id_reviewer") String v_emp_id_reviewer, @Query("v_emp_id") String v_emp_id, @Query("v_emp_position_id") String v_emp_position_id, @Query("v_pm_id") String v_pm_id, @Query("v_pm_period") String v_pm_period, @Query("v_type") String v_type, @Query("v_pa_id") String v_pa_id);
//
//    @GET("pa_reviewer/index_get?")
//    Call<PaSelfResponsesCompetence.CompetenceList> get_pa_reviewer_competence(@Query("v_emp_id_reviewer") String v_emp_id_reviewer, @Query("v_emp_id") String v_emp_id, @Query("v_emp_position_id") String v_emp_position_id, @Query("v_pm_id") String v_pm_id, @Query("v_pm_period") String v_pm_period, @Query("v_type") String v_type, @Query("v_pa_id") String v_pa_id);
//
//    @FormUrlEncoded
//    @POST("pa_reviewer/index_post")
//    Call<ValuePA> post_reviewer(@Field("periode") String periode, @Field("pmperiod_id") String pmperiod_id, @Field("score_type") String score_type, @Field("competency_point_code") String competency_point_code, @Field("appraisal_point_code") String appraisal_point_code, @Field("branch_id") String branch_id, @Field("position_id") String position_id, @Field("grade_id") String grade_id, @Field("emp_id") String emp_id, @Field("emp_id_subordinate") String emp_id_subordinate, @Field("valuecompetence") String valueCompetence, @Field("valueappraisal") String valueAppraisal, @Field("type") String type, @Field("pa_id") String pa_id, @Field("token") String token);
//
//    @GET("pa_others_appraisal/index_get?")
//    Call<PaOthersAppraisalResponses.OthersAppraisalList> get_pa_other_appraisal(@Query("v_pa_id") String v_pa_id, @Query("v_emp_id_reviewer") String v_emp_id_reviewer);
//
//
//    @GET("pa_conclusion/index_get?")
//    Call<PaSelfResponsesAppraisal.AppraisalList> get_pa_conclusion_appraisal(@Query("v_emp_id_reviewer") String v_emp_id_reviewer, @Query("v_emp_id") String v_emp_id, @Query("v_emp_position_id") String v_emp_position_id, @Query("v_pm_id") String v_pm_id, @Query("v_pm_period") String v_pm_period, @Query("v_type") String v_type, @Query("v_pa_id") String v_pa_id);
//
//    @GET("pa_total_achievement/index_get?")
//    Call<TotalAchievementResponses.TotalAchhievementList> get_pa_total_achievement(@Query("v_emp_id_reviewer") String v_pm_emp_id_reviewer, @Query("v_pa_id") String v_pa_id);
//
//
//    //Insert register
    @FormUrlEncoded
    @POST("pa_devices/index_post")
    Call<DevicesResponses> register_devices(@Field("token") String token, @Field("emp_id") String emp_id);
//
    @GET("pa_devices/index_get?")
    Call<DevicesResponses> getUpdate(@Query("emp_id") String emp_id,@Query("token") String token);
//
//    @PUT("pa_devices/index_put/emp_id/{emp_id}/password/{password}")
//    Call<ResponseBody> updatePassword(@Path("emp_id") String emp_id, @Path("password") String password);
//
//
//    @GET("information/index_get?")
//    Call<InformationResponses> getInformation(@Query("emp_id") String emp_id);
//
//    @PUT("information/index_put/emp_id/{emp_id}/id_information/{id_information}")
//    Call<ResponseBody> hideInformation(@Path("emp_id") String emp_id, @Path("id_information") String id_information);
//
    @GET("article/index_get?")
    Call<GoalResponses.GoalList> get_article(@Query("language") String language);

////    @FormUrlEncoded
////    @POST("goal_settings/index_post")
////    Call<ValueSettings> post_settings(@Field("emp_id") String emp_id, @Field("valuesetings") String valueSettingsJSON, @Field("token")  String token);
//
//    @FormUrlEncoded
//    @POST("goal_settings/index_post")
// //   Call<ValueSettings> post_settings(@Field("emp_id") String emp_id, @Field("member_emp_id") String member_emp_id, @Field("value") int value, @Field("token") String token);
//
//    @GET("goal_settings/index_get?")
//  //  Call<Employee.EmployeeList> getEmployeeSettings(@Query("emp_id") String emp_id, @Query("keyword") String keyword);
//
//
//    @FormUrlEncoded
//    @POST("pa_goal/index_post")
//  //  Call<GoalResponses> post_goal(@Header("token") String token, @Field("title_goal") String title_goal, @Field("emp_id") String emp_id);
//
//
//    @GET("pa_task/index_get?")
//  //  Call<TaskResponses.TaskList> get_task(@Query("emp_id") String emp_id, @Query("goal_id") String goal_id, @Query("goal_type") String goal_type);
//
//
//    @GET("task_detail_comments/index_get?")
//   // Call<Comments.CommentsList> getComments(@Query("id_goal") String id_goal);
//
//
//    @DELETE("pa_task/index_delete/id/{id}/token/{token}")
//    Call<ResponseBody> deleteTask(@Header("token") String token, @Path("id") String id_task);
//
//    @FormUrlEncoded
//    @POST("task_detail_comments/index_post")
//    //Call<Comments> post_comment(@Header("token") String token, @Field("comment") String comment, @Field("emp_id") String emp_id, @Field("v_id_task") String v_id_task);
//
//    @DELETE("task_detail_comments/index_delete/id/{id}/v_id_task/{v_id_task}/token/{token}")
//    Call<ResponseBody> deleteComment(@Path("id") String id, @Path("v_id_task") String v_id_task, @Path("token") String token);
//
//    @PUT("task_detail_comments/index_put/emp_id/{emp_id}/id/{id}/type/{type}/emp_id_subordinate/{emp_id_subordinate}")
//    Call<ResponseBody> updateStatusTask(@Path("emp_id") String emp_id, @Path("id") String v_id_task, @Path("type") String type, @Path("emp_id_subordinate") String emp_id_subordinate);
//
//
//    @PUT("pa_task/index_put/id/{id}/ratingValue/{ratingValue}")
//    Call<ResponseBody> updateRating(@Path("id") String v_id_task, @Path("ratingValue") String ratingValue);
//
//
//    @DELETE("pa_goal/index_delete/id/{id}/token/{token}")
//    Call<ResponseBody> deleteGoal(@Header("token") String token, @Path("id") String id);
//
//    @PUT("pa_goal/index_put/id/{id}/status/{status}")
//    Call<ResponseBody> finishGoal(@Header("token") String token, @Path("id") String id, @Path("status") int status);
//
//    @GET("notification_popup/index_get?")
//    Call<Notification.NotificationList> getNotification(@Query("emp_id") String emp_id);
//
//    @PUT("notification_popup/index_put/id/{id}")
//    Call<ResponseBody> updateStatusNotification(@Path("id") String id);
//
//
//    @GET("pa_task_notification/index_get?")
//    Call<TaskResponses> getTaskData(@Query("task_id") String task_id);



}
