package con.huajia.clock;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

import con.huajia.clock.adapter.ViewPagerAdapter;
import con.huajia.clock.fragment.AlarmClockFragment;
import con.huajia.clock.fragment.ClockFragment;
import con.huajia.clock.fragment.CountDownFragment;
import con.huajia.clock.fragment.StopwatchFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView alarmClockView;

    private TextView clockView;

    private TextView stopwatchView;

    private TextView countDownView;

    private ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        alarmClockView = findViewById(R.id.alarmClock);
        clockView = findViewById(R.id.clock);
        stopwatchView = findViewById(R.id.stopwatch);
        countDownView = findViewById(R.id.countDown);

        alarmClockView.setOnClickListener(this);
        clockView.setOnClickListener(this);
        stopwatchView.setOnClickListener(this);
        countDownView.setOnClickListener(this);

        List<Fragment> list = new ArrayList<>();
        list.add(new AlarmClockFragment());
        list.add(new ClockFragment());
        list.add(new StopwatchFragment());
        list.add(new CountDownFragment());
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), getLifecycle(), list);
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                changeTitleColor(position);
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.alarmClock){
            viewPager.setCurrentItem(0);
        } else if (view.getId() == R.id.clock) {
            viewPager.setCurrentItem(1);
        }else if(view.getId() == R.id.stopwatch){
            viewPager.setCurrentItem(2);
        }else if(view.getId() == R.id.countDown){
            viewPager.setCurrentItem(3);
        }
    }

    public void changeTitleColor(int position){
        alarmClockView.setTextColor(position == 0 ? getResources().getColor(R.color.select_text_color) : getResources().getColor(R.color.black));
        clockView.setTextColor(position == 1 ? getResources().getColor(R.color.select_text_color) : getResources().getColor(R.color.black));
        stopwatchView.setTextColor(position == 2 ? getResources().getColor(R.color.select_text_color) : getResources().getColor(R.color.black));
        countDownView.setTextColor(position == 3 ? getResources().getColor(R.color.select_text_color) : getResources().getColor(R.color.black));
    }
}