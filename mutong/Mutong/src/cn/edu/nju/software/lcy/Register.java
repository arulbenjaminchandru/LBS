package cn.edu.nju.software.lcy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

//ע���ҳ��
public class Register extends Activity {
	private Button registerConfirm;
	private TextView bottomback;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        
        this.registerConfirm = (Button)findViewById(R.id.registerConfirm);
        
        registerConfirm.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				//���ע���������ע�ᣬ�����ص�¼����
				intent.setClass(Register.this, Mutong.class);
				startActivity(intent);
				Register.this.finish();
			}
        });
        
        bottomback = (TextView)findViewById(R.id.bottomback);
        bottomback.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				//������ؼ����ص�¼����
				intent.setClass(Register.this, Mutong.class);
				startActivity(intent);
				Register.this.finish();
			}       	
        });
    }
}
