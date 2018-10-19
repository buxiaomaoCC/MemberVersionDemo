package comvoice.example.zhangbin.memberversiondemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import comvoice.example.zhangbin.memberversiondemo.R;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.et_register_phone)
    EditText etRegisterPhone;
    @BindView(R.id.et_register_password)
    EditText etRegisterPassword;
    @BindView(R.id.et_register_yanzhenng)
    EditText etRegisterYanzhenng;
    @BindView(R.id.bt_register_yanzheng)
    Button btRegisterYanzheng;
    @BindView(R.id.register_cb)
    CheckBox registerCb;
    @BindView(R.id.bt_register_next)
    Button btRegisterNext;
    @BindView(R.id.login_cardView)
    CardView loginCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {

    }

    @OnClick({R.id.bt_register_yanzheng, R.id.bt_register_next})
    public void onViewClicked(View view) {
        Intent intent=null;
        switch (view.getId()) {
            case R.id.bt_register_yanzheng:
                btRegisterYanzheng.setEnabled(false);
                btRegisterYanzheng.setText(R.string.hasSend);
                break;
            case R.id.bt_register_next:
                intent=new Intent(RegisterActivity.this,MainActivity.class);
                break;
        }
        startActivity(intent);
    }
}
