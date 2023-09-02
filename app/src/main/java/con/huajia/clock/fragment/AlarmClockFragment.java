package con.huajia.clock.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import con.huajia.clock.R;
import con.huajia.clock.adapter.AlarmClockAdapter;
import con.huajia.clock.bean.AlarmClockBean;

public class AlarmClockFragment extends Fragment {

    private View rootView;

    private RecyclerView recyclerView;

    private AlarmClockAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_alarm_clock, container, false);

        recyclerView = rootView.findViewById(R.id.recycleView);

        initRecycleView();

        return rootView;
    }

    private void initRecycleView() {
        List<AlarmClockBean> list = new ArrayList<>();
        list.add(new AlarmClockBean());
        list.add(new AlarmClockBean());
        list.add(new AlarmClockBean());
        adapter = new AlarmClockAdapter(getContext(), list);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
    }
}