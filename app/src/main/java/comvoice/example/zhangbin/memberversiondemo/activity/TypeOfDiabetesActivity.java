package comvoice.example.zhangbin.memberversiondemo.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import comvoice.example.zhangbin.memberversiondemo.R;
import comvoice.example.zhangbin.memberversiondemo.utils.ConvertUtils;
import comvoice.example.zhangbin.memberversiondemo.view.WheelView;

public class TypeOfDiabetesActivity extends AppCompatActivity {

    @BindView(R.id.tv_top_title)
    TextView tvTopTitle;

    @BindView(R.id.bt_return)
    Button btReturn;
    @BindView(R.id.bt_next)
    Button btNext;
    @BindView(R.id.wheelview_single)
    WheelView wheelviewSingle;

    //    @BindView(R.id.pick_diabetes)
//    WheelView pickDiabetes;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_of_diabetes);
        ButterKnife.bind(this);
        initView();

        initData();
        initSelectListener();
    }

    private void initView() {
        tvTopTitle.setText(getString(R.string.Diabetes));

    }

    @SuppressLint("ResourceAsColor")
    private void initData() {
        list = new ArrayList<>();
        list.add("I型糖尿病");
        list.add("II型糖尿病");
        list.add("III型糖尿病");
        list.add("VI型糖尿病");
//        pickDiabetes.setOffset(0);
//        pickDiabetes.setItems(list);
        wheelviewSingle.setItems(list, 2);
        wheelviewSingle.setTextColor(R.color.main_gray,R.color.black);
        wheelviewSingle.setTextSize(28);
        WheelView.DividerConfig config = new WheelView.DividerConfig();
        config.setRatio(1.0f / 10.0f);//线比率
        config.setColor(R.color.main_gray);//线颜色
        config.setAlpha(100);//线透明度
        config.setThick(ConvertUtils.toPx(this, 2));//线粗
        wheelviewSingle.setDividerConfig(config);
    }

    private void initSelectListener() {
//        pickDiabetes.setOnWheelViewListener(new WheelView.OnWheelViewListener() {
//            @Override
//            public void onSelected(int selectedIndex, String item) {
//                super.onSelected(selectedIndex, item);
//                Toast.makeText(TypeOfDiabetesActivity.this, item + "", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @OnClick({R.id.bt_return, R.id.bt_next})
    public void onViewClicked(View view) {
        Intent intent=null;
        switch (view.getId()) {
            case R.id.bt_return:
                finish();
                break;
            case R.id.bt_next:
                intent=new Intent(TypeOfDiabetesActivity.this,TimeOfDiagnosisActivity.class);
                break;
        }
        startActivity(intent);
    }
}
