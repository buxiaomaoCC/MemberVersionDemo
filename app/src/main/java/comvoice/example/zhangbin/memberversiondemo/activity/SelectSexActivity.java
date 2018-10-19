package comvoice.example.zhangbin.memberversiondemo.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import comvoice.example.zhangbin.memberversiondemo.R;

public class SelectSexActivity extends AppCompatActivity {

    @BindView(R.id.tv_top_title)
    TextView tvTopTitle;
    @BindView(R.id.iv_men)
    ImageView ivMen;
    @BindView(R.id.ll_men)
    LinearLayout llMen;
    @BindView(R.id.iv_women)
    ImageView ivWomen;
    @BindView(R.id.ll_women)
    LinearLayout llWomen;
    @BindView(R.id.bt_return)
    Button btReturn;
    @BindView(R.id.bt_next)
    Button btNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_sex);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        tvTopTitle.setText(R.string.sex);
        btReturn.setVisibility(View.INVISIBLE);
        btNext.setVisibility(View.INVISIBLE);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @OnClick({R.id.ll_men, R.id.ll_women, R.id.bt_return, R.id.bt_next})
    public void onViewClicked(View view) {
        ivMen.setImageDrawable(this.getDrawable(R.drawable.gouxuanqx));
        ivWomen.setImageDrawable(getDrawable(R.drawable.gouxuanqx));
        btReturn.setVisibility(View.VISIBLE);
        btNext.setVisibility(View.VISIBLE);
        Intent intent=null;
        switch (view.getId()) {
            case R.id.ll_men:
                ivMen.setImageDrawable(getDrawable(R.drawable.gouxuan));
                break;
            case R.id.ll_women:
                ivWomen.setImageDrawable(getDrawable(R.drawable.gouxuan));
                break;
            case R.id.bt_return:
                finish();
                break;
            case R.id.bt_next:
                intent=new Intent(SelectSexActivity.this,SelectAgeActivity.class);
                startActivity(intent);
                break;
        }

    }
}
