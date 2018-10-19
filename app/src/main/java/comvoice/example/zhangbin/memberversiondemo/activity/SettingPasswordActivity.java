package comvoice.example.zhangbin.memberversiondemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import comvoice.example.zhangbin.memberversiondemo.R;

public class SettingPasswordActivity extends AppCompatActivity {

    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_yanzhenng)
    EditText etYanzhenng;
    @BindView(R.id.bt_retrieve_next)
    Button btRetrieveNext;
    @BindView(R.id.login_cardView)
    CardView loginCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_password);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_retrieve_next)
    public void onViewClicked() {
        Intent intent=new Intent(SettingPasswordActivity.this,LoginActivity.class);
        startActivity(intent);
    }
}
