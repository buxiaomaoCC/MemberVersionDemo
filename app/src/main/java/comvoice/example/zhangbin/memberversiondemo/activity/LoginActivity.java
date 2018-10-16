package comvoice.example.zhangbin.memberversiondemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import comvoice.example.zhangbin.memberversiondemo.R;
import comvoice.example.zhangbin.memberversiondemo.view.FixedEditText;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.tv_forget_password)
    TextView tvForgetPassword;
    @BindView(R.id.bt_login)
    Button btLogin;
    @BindView(R.id.login_cardView)
    CardView loginCardView;
    @BindView(R.id.tv_register)
    TextView tvRegister;
    @BindView(R.id.tv_forget_password1)
    TextView tvForgetPassword1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initView();

    }

    private void initView() {

    }

    @OnClick({R.id.tv_forget_password, R.id.bt_login, R.id.tv_register, R.id.tv_forget_password1})
    public void onViewClicked(View view) {
        Intent intent=null;
        switch (view.getId()) {
            case R.id.tv_forget_password:
                intent=new Intent(LoginActivity.this,RetrieveThePasswordActivity.class);
                break;
            case R.id.bt_login:
                intent=new Intent(LoginActivity.this,MainActivity.class);
                break;
            case R.id.tv_register:
                break;
            case R.id.tv_forget_password1:
                break;
                default:break;
        }
        startActivity(intent);
    }
}
