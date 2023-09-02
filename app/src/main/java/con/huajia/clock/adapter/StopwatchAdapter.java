package con.huajia.clock.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import con.huajia.clock.R;
import con.huajia.clock.bean.TimeRecordBean;

public class StopwatchAdapter extends RecyclerView.Adapter<StopwatchAdapter.StopwatchHolder> {

    private Context context;

    private List<TimeRecordBean> list = new ArrayList<>();

    public StopwatchAdapter(Context context,List<TimeRecordBean> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public StopwatchHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.item_stop_watch, parent, false);
        StopwatchHolder holder = new StopwatchHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull StopwatchHolder holder, int position) {
        holder.serialNum.setText(list.get(position).getSerialNum());
        holder.extraTime.setText(list.get(position).getExtraTime());
        holder.recordTime.setText(list.get(position).getRecordTime());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public void addItem(TimeRecordBean timeRecordBean){
        list.add(timeRecordBean);
        notifyDataSetChanged();
    }

    public void cleanList(){
        list = new ArrayList<>();
        notifyDataSetChanged();
    }

    class StopwatchHolder extends RecyclerView.ViewHolder{
        private TextView serialNum,extraTime,recordTime;
        public StopwatchHolder(@NonNull View itemView) {
            super(itemView);
            serialNum = itemView.findViewById(R.id.serialNum);
            extraTime = itemView.findViewById(R.id.extraTime);
            recordTime = itemView.findViewById(R.id.recordTime);
        }
    }

}
