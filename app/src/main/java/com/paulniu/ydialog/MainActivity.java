package com.paulniu.ydialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.paulniu.library.GeneralDialog;
import com.paulniu.library.callbacks.IBaseDialogClickCallback;
import com.paulniu.library.callbacks.IDialogListClickCallback;
import com.paulniu.library.callbacks.IListDialogSelectCallback;
import com.paulniu.library.callbacks.IThreeBtnDialogClickCallback;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btn01, btn02, btn03, btn04, btn05;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn01 = findViewById(R.id.btn01);
        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GeneralDialog.dialogWithTwoBtn(MainActivity.this, "两个按钮", "两个按钮的弹窗", new IBaseDialogClickCallback() {
                    @Override
                    public void onClickPositive() {
                        Toast.makeText(MainActivity.this, "点击确认按钮", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onClickNegative() {
                        Toast.makeText(MainActivity.this, "点击取消按钮", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        btn02 = findViewById(R.id.btn02);
        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GeneralDialog.dialogWithThreeBtn(MainActivity.this, "三个按钮", "三个按钮的弹窗", "中间按钮", new IThreeBtnDialogClickCallback() {
                    @Override
                    public void onClickNeutral() {
                        Toast.makeText(MainActivity.this, "点击中间按钮", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onClickPositive() {
                        Toast.makeText(MainActivity.this, "点击确认按钮", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onClickNegative() {
                        Toast.makeText(MainActivity.this, "点击取消按钮", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        btn03 = findViewById(R.id.btn03);
        btn03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] items = new String[]{"选项1", "选项2", "选项3", "选项4", "选项5", "选项6", "选项7"};
                GeneralDialog.dialogWithList(MainActivity.this, "列表弹窗", items, new IDialogListClickCallback() {
                    @Override
                    public void onClickDialogList(int position) {
                        Toast.makeText(MainActivity.this, "你选了第" + (position + 1) + "个对象，内容是" + items[position], Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        btn04 = findViewById(R.id.btn04);
        btn04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] items = new String[]{"选项1", "选项2", "选项3", "选项4", "选项5", "选项6", "选项7"};
                GeneralDialog.dialogSingleSelect(MainActivity.this, "单选弹窗", items, new IListDialogSelectCallback() {
                    @Override
                    public void onListDialogClick(List<Integer> positions) {
                        Toast.makeText(MainActivity.this, "你选择了第" + (positions.get(0) + 1) + "个对象，内容是" + items[positions.get(0)], Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        btn05 = findViewById(R.id.btn05);
        btn05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] items = new String[]{"选项1", "选项2", "选项3", "选项4", "选项5", "选项6", "选项7"};
                GeneralDialog.dialogMultiSelect(MainActivity.this, "复选弹窗", items, new IListDialogSelectCallback() {
                    @Override
                    public void onListDialogClick(List<Integer> positions) {
                        String ss = "";
                        for (int i = 0; i < positions.size(); i++) {
                            if (i == positions.size() - 1) {
                                ss += (i + 1);
                            } else {
                                ss += (i + 1 + ",");
                            }
                        }
                        Toast.makeText(MainActivity.this, "你选择的有一下几个对象：" + ss, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
