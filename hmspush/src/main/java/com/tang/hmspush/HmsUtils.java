package com.tang.hmspush;

import com.blankj.utilcode.util.Utils;
import com.huawei.hms.aaid.init.AutoInitHelper;

/**
 * description:
 * time: 2022/6/29 5:17 PM.
 *
 * @author TangAnna
 * email: tang_an@murongtech.com
 * copyright: 北京沐融信息科技股份有限公司
 */
public class HmsUtils {
    /**
     * 设置是否使用自动初始化
     * 此配置也可在清单文件中完成，官方更推荐代码设
     *
     * @param isAuto true-自动初始化
     *               false-非自动初始化
     */
    public static void setAutoInitHms(boolean isAuto) {
        AutoInitHelper.setAutoInitEnabled(Utils.getApp(), isAuto);
    }


}
