package com.zfwl.zhengfeishop.activity;
//搜索页面
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zfwl.zhengfeishop.R;
import com.zfwl.zhengfeishop.adapter.DiscoverAdapter;
import com.zfwl.zhengfeishop.db.RecordsDao;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class SearchActivity extends Base2Activity {

    private EditText editSearch;
    private ImageView returnSearch,dustbinSearch,imgCancel;
    private TagFlowLayout flSearchRecords;
    private LinearLayout searchHistoryLayout,ivArrow;
    private RecordsDao mRecordsDao;
    //默然展示词条个数
    private final int DEFAULT_RECORD_NUMBER = 10;
    private List<String> recordList = new ArrayList<>();
    private TagAdapter mRecordsAdapter;
    private TextView textSearch;
    private AlertDialog selfdialog;
    private Dialog dialog;
    private RecyclerView rvDiscover;
    private DiscoverAdapter discoverAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        //默认账号
        String username = "007";
        //初始化数据库
        mRecordsDao = new RecordsDao(this, username);
        editSearch=findViewById(R.id.edit_search);
        returnSearch=findViewById(R.id.return_search);
        dustbinSearch=findViewById(R.id.dustbin_search);
        flSearchRecords=findViewById(R.id.fl_search_records);
        ivArrow=findViewById(R.id.iv_arrow);
        searchHistoryLayout=findViewById(R.id.search_history_layout);
        textSearch=findViewById(R.id.text_search);
        imgCancel=findViewById(R.id.img_cancel);
        rvDiscover=findViewById(R.id.rv_discover);
        dialog = new Dialog(this);
        showSoftInputFromWindow(this,editSearch);
        init();
        discoverAdapter = new DiscoverAdapter(this);
        rvDiscover.setLayoutManager(new GridLayoutManager(this,2));
        rvDiscover.setAdapter(discoverAdapter);
        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (editSearch.getText().length()==0){
                    imgCancel.setVisibility(View.GONE);
                }else {
                    imgCancel.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //创建历史标签适配器
        //为标签设置对应的内容
        mRecordsAdapter = new TagAdapter<String>(recordList) {

            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) LayoutInflater.from(SearchActivity.this).inflate(R.layout.tv_history,
                        flSearchRecords, false);
                //为标签设置对应的内容
                tv.setText(s);
                return tv;
            }
        };
        flSearchRecords.setAdapter(mRecordsAdapter);
        flSearchRecords.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public void onTagClick(View view, int position, FlowLayout parent) {
                //清空editText之前的数据
                editSearch.setText("");
                //将获取到的字符串传到搜索结果界面,点击后搜索对应条目内容
                editSearch.setText(recordList.get(position));
                editSearch.setSelection(editSearch.length());
            }
        });
        //view加载回调
        flSearchRecords.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                boolean overFlow = flSearchRecords.isOverFlow();
                boolean limit = flSearchRecords.isLimit();
                if (limit && overFlow) {
                    ivArrow.setVisibility(View.VISIBLE);
                } else {
                    ivArrow.setVisibility(View.GONE);
                }
            }
        });

        ivArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flSearchRecords.setLimit(false);
                mRecordsAdapter.notifyDataChanged();
            }
        });
        //清除所有记录
        dustbinSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               ShowSelfDiaglog();
            }

        });
        textSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flSearchRecords.setLimit(true);
                String string = editSearch.getText().toString();
                if (!TextUtils.isEmpty(string)){
                    mRecordsDao.addRecords(string);
                }
            }
        });
        //清除文字
        imgCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editSearch.setText("");
            }
        });
        mRecordsDao.setNotifyDataChanged(new RecordsDao.NotifyDataChanged() {
            @Override
            public void notifyDataChanged() {
                init();
            }
        });
        //返回
        returnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void init() {
        Observable.create(new ObservableOnSubscribe<List<String>>() {
            @Override
            public void subscribe(ObservableEmitter<List<String>> emitter) throws Exception {
                emitter.onNext(mRecordsDao.getRecordsByNumber(DEFAULT_RECORD_NUMBER));
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<String>>() {
                    @Override
                    public void accept(List<String> strings) throws Exception {
                        recordList.clear();
                        recordList=strings;
                        if (null==recordList || recordList.size()==0){
                            searchHistoryLayout.setVisibility(View.GONE);
                        }else {
                            searchHistoryLayout.setVisibility(View.VISIBLE);
                        }
                        if (mRecordsAdapter!=null){
                            mRecordsAdapter.setData(recordList);
                            mRecordsAdapter.notifyDataChanged();
                        }
                    }
                });
    }
    public static void showSoftInputFromWindow(Activity activity, EditText editText) {
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        //显示软键盘
        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        //如果上面的代码没有弹出软键盘 可以使用下面另一种方式
        //InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        // imm.showSoftInput(editText, 0);
    }
    private void ShowSelfDiaglog() {
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getWindow().setDimAmount(0f);
        LayoutInflater from = getLayoutInflater().from(this);
        View view=from.inflate(R.layout.zdy_pop_up,null);
        TextView cancelPop = view.findViewById(R.id.cancel_pop);
        TextView confirmPop=view.findViewById(R.id.confirm_pop);
        dialog.setContentView(view);
        dialog.show();
        //取消
        cancelPop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
        //确定
        confirmPop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flSearchRecords.setLimit(false);
                mRecordsDao.deleteUsernameAllRecords();
                dialog.cancel();
            }
        });
    }

    @Override
    protected void onDestroy() {
        mRecordsDao.closeDatabase();
        mRecordsDao.removeNotifyDataChanged();
        super.onDestroy();
    }
}
