package com.layer.atlas.messenger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.koushikdutta.ion.Ion;


public class SwitchModeActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_mode);
        findViewById(R.id.char_mica).setOnClickListener(this);
        findViewById(R.id.char_obama).setOnClickListener(this);
        findViewById(R.id.char_shakespeare).setOnClickListener(this);
        findViewById(R.id.char_cancel).setOnClickListener(this);
//        findViewById(R.id.char_old_chinese_people).setOnClickListener(this);
        Ion.with((ImageView) findViewById(R.id.char_img_mica)).load("android.resource://" + getPackageName() + "/" + R.drawable.mica);
        Ion.with((ImageView) findViewById(R.id.char_img_shakespeare)).load("android.resource://" + getPackageName() + "/" + R.drawable.shakespeare);
        Ion.with((ImageView) findViewById(R.id.char_img_obama)).load("android.resource://" + getPackageName() + "/" + R.drawable.obama);
        Ion.with((ImageView) findViewById(R.id.char_img_cancel)).load("android.resource://" + getPackageName() + "/" + R.drawable.man);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_switch_mode, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        Bundle data = new Bundle();
        switch(view.getId()) {
            case R.id.char_cancel:
                data.putInt("mode", -1);
                data.putInt("resId", R.drawable.man);
                break;
            case R.id.char_mica:
                data.putInt("mode", 3);
                data.putInt("resId", R.drawable.mica);
                break;
            case R.id.char_obama:
                data.putInt("mode", 2);
                data.putInt("resId", R.drawable.obama);
                break;
            case R.id.char_shakespeare:
                data.putInt("mode", 1);
                data.putInt("resId", R.drawable.shakespeare);
                break;
        }

        setResult(RESULT_OK, new Intent().putExtras(data));
        finish();
    }
}
