package con.huajia.clock.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import con.huajia.clock.R;
import con.huajia.clock.bean.AlarmClockBean;

public class AlarmClockAdapter extends RecyclerView.Adapter<AlarmClockAdapter.AlarmClockHolder> {
    List<AlarmClockBean> list = new ArrayList<>();

    private Context context;

    public AlarmClockAdapter(Context context,List<AlarmClockBean> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public AlarmClockHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_alarm_clock, parent,false);
        AlarmClockHolder holder = new AlarmClockHolder(view);
        return holder;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onBindViewHolder(@NonNull AlarmClockHolder holder, int position) {

    }

    class AlarmClockHolder extends RecyclerView.ViewHolder{

        private TextView timeView,stageView,tipsView;
        private ImageView operateView;

        public AlarmClockHolder(@NonNull View itemView) {
            super(itemView);
            timeView = itemView.findViewById(R.id.time);
            stageView = itemView.findViewById(R.id.stage);
            tipsView = itemView.findViewById(R.id.tips);
            operateView = itemView.findViewById(R.id.operate);
        }
    }
}
