package com.yunongtong.yunong.opengl_es_dome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {


    private ListView mLv;
    private String[] mDates = {"openGL es 测试","toolbar","color_game","base-adapter-helper-dome","EventBus_test"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mLv = (ListView) findViewById(R.id.id_list);

        mLv.setAdapter(new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_expandable_list_item_1,mDates));

        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 0:
                        Intent intent1 = new Intent(getApplicationContext(),OpenGLES20Activity.class);
                        startActivity(intent1);

                        break;
                    case 1:
                        Intent intent2 = new Intent(getApplicationContext(),ThemeTestActivity.class);
                        startActivity(intent2);
                        break;
                    case 2:
                        Intent intent3 = new Intent(getApplicationContext(),ColorGameActivity.class);
                        startActivity(intent3);
                        break;
                    case 3:
                        Intent intent4 = new Intent(getApplicationContext(), com.example.zhy_baseadapterhelper.MainActivity.class);
                        startActivity(intent4);
                        break;
                    case 4:
                        Intent intent5 = new Intent(getApplicationContext(), com.event_bus.EventBusMainActivity.class);
                        startActivity(intent5);
                        break;

                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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


}
