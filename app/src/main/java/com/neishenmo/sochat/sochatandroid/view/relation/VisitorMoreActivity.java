package com.neishenmo.sochat.sochatandroid.view.relation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.neishenmo.sochat.sochatandroid.R;
import com.neishenmo.sochat.sochatandroid.adapter.VisitorListAdapter;
import com.neishenmo.sochat.sochatandroid.bean.Visitor;

import java.util.List;

public class VisitorMoreActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 访问
     */

    /**
     * 访问
     */
    private TextView mNum;
    private RecyclerView mMoreList;
    private Visitor visitorData;
    /**
     * 访问
     */
    private TextView mVisitorMoreNum;
    private RecyclerView mVisitorMoreList;
    /**
     * 返回
     */
    private Button mVisitorFinish;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        initView();
        //拿到传递的数据
        visitorData = (Visitor) getIntent().getSerializableExtra("visitor_data");
        mNum.setText(visitorData.getData().getAmount() + "位");
        mMoreList.setLayoutManager(new GridLayoutManager(this, 3));
        List<Visitor.DataBean.VuiListBean> vuiList = visitorData.getData().getVuiList();
        VisitorListAdapter adapter = new VisitorListAdapter(this, vuiList, false);
        mMoreList.setAdapter(adapter);

    }

    private void initView() {

        mNum = (TextView) findViewById(R.id.visitor_more_num);
        mMoreList = (RecyclerView) findViewById(R.id.visitor_more_list);

        mVisitorMoreNum = (TextView) findViewById(R.id.visitor_more_num);
        mVisitorMoreList = (RecyclerView) findViewById(R.id.visitor_more_list);
        mVisitorFinish = (Button) findViewById(R.id.visitor_finish);
        mVisitorFinish.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.visitor_finish:
                this.finish();
                break;
        }
    }
}
