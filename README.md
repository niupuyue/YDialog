# YDialog

[![](https://jitpack.io/v/niupuyue/YDialog.svg)](https://jitpack.io/#niupuyue/YDialog)
[![PRs Welcome](https://img.shields.io/badge/PRs-Welcome-brightgreen.svg)](https://github.com/niupuyue/YDialog/pulls)

## 原生dialog

原生dialog实现了单个按钮弹窗，两个按钮弹窗，三个按钮弹窗，列表弹窗，单选列表弹窗,多选列表弹窗,加载中弹窗
所有的原生dialog都可以直接调用GeneralDialog中的静态方法，传入相应的数据即可

### 单个按钮弹窗

```java
                GeneralDialog.dialogWithOneBtn(MainActivity.this, "单个按钮", "单个按钮弹窗", new IBaseDialogClickCallback() {
                    @Override
                    public void onClickPositive() {
                        Toast.makeText(MainActivity.this, "点击确认按钮", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onClickNegative() {

                    }
                });

```

### 两个按钮弹窗
```java
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

```

### 三个按钮弹窗
```java
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

```

### 列表弹窗
```java
                final String[] items = new String[]{"选项1", "选项2", "选项3", "选项4", "选项5", "选项6", "选项7"};
                GeneralDialog.dialogWithList(MainActivity.this, "列表弹窗", items, new IDialogListClickCallback() {
                    @Override
                    public void onClickDialogList(int position) {
                        Toast.makeText(MainActivity.this, "你选了第" + (position + 1) + "个对象，内容是" + items[position], Toast.LENGTH_SHORT).show();
                    }
                });

```

### 单选列表弹窗
```java
                final String[] items = new String[]{"选项1", "选项2", "选项3", "选项4", "选项5", "选项6", "选项7"};
                GeneralDialog.dialogSingleSelect(MainActivity.this, "单选弹窗", items, new IListDialogSelectCallback() {
                    @Override
                    public void onListDialogClick(List<Integer> positions) {
                        Toast.makeText(MainActivity.this, "你选择了第" + (positions.get(0) + 1) + "个对象，内容是" + items[positions.get(0)], Toast.LENGTH_SHORT).show();
                    }
                });

```

### 多选列表弹窗
```java
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

```

### 加载中弹窗
```java
                final ProgressDialog dialog = GeneralDialog.dialogProgress(MainActivity.this,"加载中弹窗","加载中");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (dialog != null){
                            dialog.dismiss();
                        }
                    }
                },3000);

```
