package con.huajia.clock.view;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import con.huajia.clock.R;

public class SelectView extends RecyclerView {
    private static final String TAG = "tanhuajia";

    private MediaPlayer player;

    private boolean isPlay = false;

    public SelectView(@NonNull Context context) {
        super(context);
    }

    public SelectView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SelectView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        LinearLayoutManager layoutManager = (LinearLayoutManager) this.getLayoutManager();
        int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();

        LinearLayout view = (LinearLayout) layoutManager.findViewByPosition(firstVisibleItemPosition+2);
        TextView textView = (TextView) view.getChildAt(0);
        textView.setTextColor(getResources().getColor(R.color.black));
        textView.setTextSize(50);

        view = (LinearLayout) layoutManager.findViewByPosition(firstVisibleItemPosition + 1);
        textView = (TextView) view.getChildAt(0);
        textView.setTextColor(getResources().getColor(R.color.color_C1C1C1));
        textView.setTextSize(30);

        view = (LinearLayout) layoutManager.findViewByPosition(firstVisibleItemPosition+3);
        textView = (TextView) view.getChildAt(0);
        textView.setTextColor(getResources().getColor(R.color.color_C1C1C1));
        textView.setTextSize(30);

//        view = (LinearLayout) layoutManager.findViewByPosition(lastVisibleItemPosition);
//        textView = (TextView) view.getChildAt(0);
//        textView.setTextColor(getResources().getColor(R.color.color_C1C1C1));
//        textView.setTextSize(30);
    }

    public String getValue(){
        LinearLayoutManager layoutManager = (LinearLayoutManager) this.getLayoutManager();
        int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
        LinearLayout view = (LinearLayout) layoutManager.findViewByPosition(firstVisibleItemPosition+2);
        TextView textView = (TextView) view.getChildAt(0);
        return textView.getText().toString();
    }




}
