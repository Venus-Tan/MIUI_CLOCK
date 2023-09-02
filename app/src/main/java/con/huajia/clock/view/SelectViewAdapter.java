package con.huajia.clock.view;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import con.huajia.clock.R;

public class SelectViewAdapter extends RecyclerView.Adapter<SelectViewAdapter.SelectViewHolder> {

    private List<String> list = new ArrayList<>();

    private Context context;

    public SelectViewAdapter(Context context, List<String> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public SelectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_select_view, parent, false);
        SelectViewHolder holder = new SelectViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull SelectViewHolder holder, int position) {
        int index = position % list.size();
        holder.textView.setText(list.get(index));
    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    public class SelectViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        public SelectViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
