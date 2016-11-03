package cn.ucai.superwechat.ui;

import android.content.Intent;
import android.os.Bundle;

import com.hyphenate.chat.EMClient;
import com.hyphenate.util.EasyUtils;

import cn.ucai.superwechat.R;
import cn.ucai.superwechat.SuperChatHelper;
import cn.ucai.superwechat.db.UserDao;
import cn.ucai.superwechat.domain.User;
import cn.ucai.superwechat.utils.L;

/**
 * 开屏页
 *
 */
public class SplashActivity extends BaseActivity {
	private  static final  String TAG=SplashActivity.class.getSimpleName();

	private static final int sleepTime = 2000;
	SplashActivity mContext;

	@Override
	protected void onCreate(Bundle arg0) {
		setContentView(R.layout.em_activity_splash);
		super.onCreate(arg0);
		mContext=this;


	}

	@Override
	protected void onStart() {
		super.onStart();

		new Thread(new Runnable() {
			public void run() {
				if (SuperChatHelper.getInstance().isLoggedIn()) {
					// auto login mode, make sure all group and conversation is loaed before enter the main screen
					long start = System.currentTimeMillis();
					EMClient.getInstance().groupManager().loadAllGroups();
					EMClient.getInstance().chatManager().loadAllConversations();
					UserDao dao=new UserDao(mContext);
                    User user = dao.getUser(EMClient.getInstance().getCurrentUser());
                    L.e(TAG,"user"+user);
					SuperChatHelper.getInstance().setCurrentUser(user);
					long costTime = System.currentTimeMillis() - start;
					//wait
					if (sleepTime - costTime > 0) {
						try {
							Thread.sleep(sleepTime - costTime);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					String topActivityName = EasyUtils.getTopActivityName(EMClient.getInstance().getContext());
					if (topActivityName != null && (topActivityName.equals(VideoCallActivity.class.getName()) || topActivityName.equals(VoiceCallActivity.class.getName()))) {
						// nop
						// avoid main screen overlap Calling Activity
					} else {
						//enter main screen
						startActivity(new Intent(SplashActivity.this, MainActivity.class));
					}
					finish();
				}else {
					try {
						Thread.sleep(sleepTime);
					} catch (InterruptedException e) {
					}
					startActivity(new Intent(SplashActivity.this, GuideActivity.class));
					finish();
				}
			}
		}).start();

	}
	
	/**
	 * get sdk version
	 */
	private String getVersion() {

		return EMClient.getInstance().getChatConfig().getVersion();
	}
}
