package com.paulniu.library.callbacks;

import java.util.List;

/**
 * Coder: niupuyue
 * Date: 2019/9/18
 * Time: 15:17
 * Desc: 列表弹出框选择的对象
 * Version:
 */
public interface IListDialogSelectCallback {

    void onListDialogClick(List<Integer> positions);

}
