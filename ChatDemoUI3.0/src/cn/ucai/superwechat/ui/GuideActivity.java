package cn.ucai.superwechat.ui;

import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.ucai.superwechat.R;
import cn.ucai.superwechat.utils.MFGT;

public class GuideActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);
    }


    @OnClick({R.id.btn_guide_login, R.id.btn_guide_register})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_guide_login:
                MFGT.gotoLogin(this);
                break;
            case R.id.btn_guide_register:
                MFGT.gotoRegister(this);
                break;
        }
    }

/*

    @OnClick({R.id.btn_guide_register, R.id.btn_guide_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_guide_register:
                startActivity(new Intent(GuideActivity.this, RegisterActivity.class));
                break;
            case R.id.btn_guide_login:
                startActivity(new Intent(GuideActivity.this, LoginActivity.class));
                break;
        }
    }*/
}
