package comvoice.example.zhangbin.memberversiondemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import comvoice.example.zhangbin.memberversiondemo.R;

public class RetrieveThePasswordActivity extends AppCompatActivity {

    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_yanzhenng)
    EditText etYanzhenng;
    @BindView(R.id.bt_retrieve_yanzheng)
    Button btRetrieveYanzheng;
    @BindView(R.id.bt_retrieve_next)
    Button btRetrieveNext;
    @BindView(R.id.login_cardView)
    CardView loginCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_the_password);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_retrieve_yanzheng, R.id.bt_retrieve_next})
    public void onViewClicked(View view) {
        Intent intent=null;
        switch (view.getId()) {
            case R.id.bt_retrieve_yanzheng:
                break;
            case R.id.bt_retrieve_next:
                intent=new Intent(RetrieveThePasswordActivity.this,SettingPasswordActivity.class);
                break;
                default:break;
        }
        startActivity(intent);
    }
}
