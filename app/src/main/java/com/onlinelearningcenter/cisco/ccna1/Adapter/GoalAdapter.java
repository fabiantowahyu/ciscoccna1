package com.onlinelearningcenter.cisco.ccna1.Adapter;


import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.onlinelearningcenter.cisco.R;
import com.onlinelearningcenter.cisco.ccna1.pojo.GoalResponses;

import java.util.ArrayList;

public class GoalAdapter extends RecyclerView.Adapter<GoalAdapter.ViewHolder> {
    private ArrayList<GoalResponses> GoalResponses;
    private Context context;
    private String v_goal_type;
    String status;

    public GoalAdapter(Context context, ArrayList<GoalResponses> GoalResponses, String v_goal_type) {
        this.GoalResponses = GoalResponses;
        this.context = context;
        this.v_goal_type = v_goal_type;

    }


    @Override
    public GoalAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.goal_card_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {

        viewHolder.title_goal.setText(GoalResponses.get(i).getTitleGoal());
        viewHolder.contributors.setText(GoalResponses.get(i).getContributors());
        viewHolder.tv_created_date.setText(GoalResponses.get(i).getCreatedDate());

        if (GoalResponses.get(i).getLastStatus().equals("0")) {
            status = "Belum Dibaca";
          //  viewHolder.linear_goal.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.background_label_blue_grey));
            viewHolder.goalstatus.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.bg_circle_yellow_full));
            viewHolder.v_status_goal.setBackgroundDrawable(ContextCompat.getDrawable(context, R.color.orange));
            viewHolder.goalstatus.setTextColor(ContextCompat.getColor(context, R.color.white));
            viewHolder.goalstatus.setText(status);
        } else {
            status = "Selesai Dibaca";
          //  viewHolder.linear_goal.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.background_label_blue));
            viewHolder.goalstatus.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.bg_circle_success_full));
            viewHolder.v_status_goal.setBackgroundDrawable(ContextCompat.getDrawable(context, R.color.colorSuccess));
            viewHolder.goalstatus.setTextColor(ContextCompat.getColor(context, R.color.white));
            viewHolder.goalstatus.setText(status);
        }

        viewHolder.linear_goal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(context, GoalResponses.get(i).getGoalId(), Toast.LENGTH_SHORT).show();

//                 Intent intent = new Intent(context, MainActivity.class);
//                intent.putExtra("goal_id", GoalResponses.get(i).getGoalId());
//                intent.putExtra("title_goal", GoalResponses.get(i).getTitleGoal());
//                intent.putExtra("status_goal", GoalResponses.get(i).getLastStatus());
//                intent.putExtra("v_goal_type", v_goal_type);
//                   //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                ((Activity) context).startActivityForResult(intent, 10002);
                  // context.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return GoalResponses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title_goal, goalstatus, contributors, tv_created_date;
        private LinearLayout linear_goal;
        private View v_status_goal;


        public ViewHolder(View view) {
            super(view);

            title_goal = (TextView) view.findViewById(R.id.tv_title_goal);
            contributors = (TextView) view.findViewById(R.id.tv_contributors);

            goalstatus = (TextView) view.findViewById(R.id.tv_goal_status);
            linear_goal = (LinearLayout) view.findViewById(R.id.linear_goal);
            v_status_goal = (View) view.findViewById(R.id.v_status_goal);
            tv_created_date = (TextView) view.findViewById(R.id.tv_created_date);

        }
    }

}