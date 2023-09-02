package con.huajia.clock.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import con.huajia.clock.R;
import con.huajia.clock.view.SelectView;
import con.huajia.clock.view.SelectViewAdapter;

public class CountDownFragment extends Fragment implements View.OnClickListener {

    private View rootView;

    private SelectView hourSelectView;

    private SelectView minuteSelectView;

    private SelectView secondSelectView;

    private ImageButton startButton;

    private ImageButton endButton;

    private ImageButton stopButton;

    private ImageButton continueButton;

    private long second;

    private Timer timer;

    private ConstraintLayout selectContainer;

    private RelativeLayout timeContainer;

    private TextView timeView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_count_down, container, false);

        initSelectView();

        initView();

        return rootView;
    }

    private void initView() {
        startButton = rootView.findViewById(R.id.button_start);
        endButton = rootView.findViewById(R.id.button_end);
        stopButton = rootView.findViewById(R.id.button_stop);
        selectContainer = rootView.findViewById(R.id.select_container);
        timeContainer = rootView.findViewById(R.id.time_container);
        timeView = rootView.findViewById(R.id.time);
        continueButton = rootView.findViewById(R.id.button_continue);
        startButton.setOnClickListener(this);
        stopButton.setOnClickListener(this);
        continueButton.setOnClickListener(this);
        endButton.setOnClickListener(this);
    }

    private void initSelectView() {
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        for(int i = 0; i <= 23; i++){
            list.add(i < 10 ? "0" + i : ""+i);
        }
        hourSelectView = rootView.findViewById(R.id.hour_select);
        SelectViewAdapter adapter = new SelectViewAdapter(rootView.getContext(), list);
        hourSelectView.setAdapter(adapter);
        list = new ArrayList<>();
        list.add("");
        list.add("");
        for(int i = 0; i <= 60; i++){
            list.add(i < 10 ? "0" + i : ""+i);
        }
        adapter = new SelectViewAdapter(rootView.getContext(), list);
        minuteSelectView = rootView.findViewById(R.id.minute_select);
        minuteSelectView.setAdapter(adapter);
        secondSelectView = rootView.findViewById(R.id.second_select);
        secondSelectView.setAdapter(adapter);


        LinearLayoutManager hourLayoutManager = new LinearLayoutManager(rootView.getContext());
        hourSelectView.setLayoutManager(hourLayoutManager);
        LinearLayoutManager minuteLayoutManager = new LinearLayoutManager(rootView.getContext());
        minuteSelectView.setLayoutManager(minuteLayoutManager);
        LinearLayoutManager secondLayoutManager = new LinearLayoutManager(rootView.getContext());
        secondSelectView.setLayoutManager(secondLayoutManager);

        //对齐的一种方式，但是不能丝滑滑动，不喜欢
        PagerSnapHelper hourPagerHelper = new PagerSnapHelper();
        hourPagerHelper.attachToRecyclerView(hourSelectView);

        PagerSnapHelper minutePagerHelper = new PagerSnapHelper();
        minutePagerHelper.attachToRecyclerView(minuteSelectView);

        PagerSnapHelper secondPagerHelper = new PagerSnapHelper();
        secondPagerHelper.attachToRecyclerView(secondSelectView);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_start){
            second = 0;
            second += (Long.parseLong(hourSelectView.getValue()) * 60 * 60);
            second += (Long.parseLong(minuteSelectView.getValue()) * 60);
            second += (Long.parseLong(secondSelectView.getValue()));
            timeView.setText(secondFormat(second));
            selectContainer.setVisibility(View.GONE);
            timeContainer.setVisibility(View.VISIBLE);
            startLoadTime();
            endButton.setVisibility(View.VISIBLE);
            stopButton.setVisibility(View.VISIBLE);
            startButton.setVisibility(View.GONE);
        }else if (view.getId() == R.id.button_stop){
            stopLoadTime();
            stopButton.setVisibility(View.GONE);
            continueButton.setVisibility(View.VISIBLE);
        } else if (view.getId() == R.id.button_continue) {
            startLoadTime();
            stopButton.setVisibility(View.VISIBLE);
            continueButton.setVisibility(View.GONE);
        } else if (view.getId() == R.id.button_end) {
            startButton.setVisibility(View.VISIBLE);
            endButton.setVisibility(View.GONE);
            stopButton.setVisibility(View.GONE);
            continueButton.setVisibility(View.GONE);
            selectContainer.setVisibility(View.VISIBLE);
            timeContainer.setVisibility(View.GONE);

            stopLoadTime();
        }
    }

    private String secondFormat(long second){
        int hour = (int) (second / 3600);
        second -= hour * 3600;
        int minute = (int) (second / 60);
        second -= minute * 60;
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    private void startLoadTime(){
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                second -= 1;
                timeView.post(new Runnable() {
                    @Override
                    public void run() {
                        timeView.setText(secondFormat(second));
                    }
                });
            }
        };
        timer = new Timer();
        timer.schedule(task,0,1000);
    }

    private void stopLoadTime(){
        timer.cancel();
    }
}