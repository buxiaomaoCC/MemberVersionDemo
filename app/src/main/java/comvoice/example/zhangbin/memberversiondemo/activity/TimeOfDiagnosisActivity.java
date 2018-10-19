package comvoice.example.zhangbin.memberversiondemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import comvoice.example.zhangbin.memberversiondemo.R;
import comvoice.example.zhangbin.memberversiondemo.view.RulerView;

public class TimeOfDiagnosisActivity extends AppCompatActivity {

    @BindView(R.id.tv_top_title)
    TextView tvTopTitle;
    @BindView(R.id.tv_age)
    TextView tvAge;
    @BindView(R.id.ruler_time)
    RulerView rulerTime;
    @BindView(R.id.bt_return)
    Button btReturn;
    @BindView(R.id.bt_next)
    Button btNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_of_diagnosis);
        ButterKnife.bind(this);
        initView();
        initValueChangeListener();
    }

    private void initValueChangeListener() {
        rulerTime.setOnValueChangeListener(new RulerView.OnValueChangeListener() {
            @Override
            public void onValueChange(float value) {
                int age = (int) value;
                tvAge.setText(age + "年2月1日");
            }
        });
        rulerTime.setValue(1990, 1920, 2018, 1);
    }

    private void initView() {
        tvTopTitle.setText(getString(R.string.time));
    }

    @OnClick({R.id.bt_return, R.id.bt_next})
    public void onViewClicked(View view) {
        Intent intent=null;
        switch (view.getId()) {
            case R.id.bt_return:
                finish();
                break;
            case R.id.bt_next:
                intent=new Intent(TimeOfDiagnosisActivity.this,MainActivity.class);
                break;
            default:break;
        }
        startActivity(intent);
    }
}
