package comvoice.example.zhangbin.memberversiondemo.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import comvoice.example.zhangbin.memberversiondemo.R;
import comvoice.example.zhangbin.memberversiondemo.fragment.mainFragment.CircleOfFriendsFragment;
import comvoice.example.zhangbin.memberversiondemo.fragment.mainFragment.HomepageFragment;
import comvoice.example.zhangbin.memberversiondemo.fragment.mainFragment.OnlineClinicFragment;
import comvoice.example.zhangbin.memberversiondemo.fragment.mainFragment.PersonalCenterFragment;
import comvoice.example.zhangbin.memberversiondemo.fragment.mainFragment.ShoppingMallFragment;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_mainpager)
    TextView tvMainpager;
    @BindView(R.id.tv_onlineclinic)
    TextView tvOnlineclinic;
    @BindView(R.id.tv_circleoffriends)
    TextView tvCircleoffriends;
    @BindView(R.id.tv_shoppingmall)
    TextView tvShoppingmall;
    @BindView(R.id.tv_personalcenter)
    TextView tvPersonalcenter;
    @BindView(R.id.ll_main)
    LinearLayout llMain;
    @BindView(R.id.main_framelayout)
    FrameLayout mainFramelayout;
    private List<Fragment>fragments;//fragment集合
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private int mState=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        fragments=new ArrayList<>();
        fragments.clear();
        HomepageFragment homepageFragment=new HomepageFragment();
        OnlineClinicFragment onlineClinicFragment=new OnlineClinicFragment();
        CircleOfFriendsFragment circleOfFriendsFragment=new CircleOfFriendsFragment();
        ShoppingMallFragment shoppingMallFragment=new ShoppingMallFragment();
        PersonalCenterFragment personalCenterFragment=new PersonalCenterFragment();
        fragments.add(homepageFragment);
        fragments.add(onlineClinicFragment);
        fragments.add(circleOfFriendsFragment);
        fragments.add(shoppingMallFragment);
        fragments.add(personalCenterFragment);
        fragmentManager=getSupportFragmentManager();
        transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.main_framelayout,fragments.get(0));
        tvMainpager.setTextColor(Color.BLUE);
        tvMainpager.setSelected(true);
        transaction.commit();
    }

    @OnClick({R.id.tv_mainpager, R.id.tv_onlineclinic, R.id.tv_circleoffriends, R.id.tv_shoppingmall, R.id.tv_personalcenter})
    public void onViewClicked(View view) {
        if(fragmentManager==null){
            fragmentManager=getSupportFragmentManager();
        }
        transaction=fragmentManager.beginTransaction();
        switch (view.getId()) {
            case R.id.tv_mainpager:
                transaction.replace(R.id.main_framelayout,fragments.get(0));
                initState(0);
                break;
            case R.id.tv_onlineclinic:
                transaction.replace(R.id.main_framelayout,fragments.get(1));
                initState(1);
                break;
            case R.id.tv_circleoffriends:
                transaction.replace(R.id.main_framelayout,fragments.get(2));
                initState(2);
                break;
            case R.id.tv_shoppingmall:
                transaction.replace(R.id.main_framelayout,fragments.get(3));
                initState(3);
                break;
            case R.id.tv_personalcenter:
                transaction.replace(R.id.main_framelayout,fragments.get(4));
                initState(4);
                break;
        }
        transaction.commit();
    }
    //判断选中了哪个fragment
    private void initState(int state){
        if(mState==state){
            return;
        }
        mState=state;
        tvMainpager.setTextColor(Color.GRAY);
        tvOnlineclinic.setTextColor(Color.GRAY);
        tvCircleoffriends.setTextColor(Color.GRAY);
        tvShoppingmall.setTextColor(Color.GRAY);
        tvPersonalcenter.setTextColor(Color.GRAY);
        tvMainpager.setSelected(false);
        tvOnlineclinic.setSelected(false);
        tvCircleoffriends.setSelected(false);
        tvShoppingmall.setSelected(false);
        tvPersonalcenter.setSelected(false);

        switch (state){
            case 0:
                tvMainpager.setTextColor(Color.BLUE);
                tvMainpager.setSelected(true);
                break;
            case 1:
                tvOnlineclinic.setTextColor(Color.BLUE);
                tvOnlineclinic.setSelected(true);
                break;
            case 2:
                tvCircleoffriends.setTextColor(Color.BLUE);
                tvCircleoffriends.setSelected(true);
                break;
            case 3:
                tvShoppingmall.setTextColor(Color.BLUE);
                tvShoppingmall.setSelected(true);
                break;
            case 4:
                tvPersonalcenter.setTextColor(Color.BLUE);
                tvPersonalcenter.setSelected(true);
                break;
                default:
                    break;
        }
    }
}
