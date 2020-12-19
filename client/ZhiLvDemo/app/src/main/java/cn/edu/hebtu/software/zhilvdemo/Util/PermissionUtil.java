package cn.edu.hebtu.software.zhilvdemo.Util;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;


import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

/**
 * @ProjectName:    ZhiLv
 * @Description:    权限申请
 * @Author:         张璐婷
 * @CreateDate:     2020/12/15 21:37
 * @Version:        1.0
 */
public class PermissionUtil {
    public static final int OPEN_CAMEAR_REQUEST_CODE = 1001;
    public static final int EXTERNAL_STORAGE_REQUEST_CODE = 1002;


    /**
     *  @author: 张璐婷
     *  @time: 2020/12/15  21:40
     *  @Description: 相机权限
     */
    public static boolean openCameraPermission(Activity activity){
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CAMERA,Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE}, OPEN_CAMEAR_REQUEST_CODE);
            return false;
        }else{
            if (!ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.CAMERA)) {
                ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CAMERA}, OPEN_CAMEAR_REQUEST_CODE);
                return false;
            } else {
                return true;
            }
        }

    }

    /**
     *  @author: 张璐婷
     *  @time: 2020/12/15  21:54
     *  @Description: 读SD卡权限（从相册选择图片）| 写SD卡权限(创建文件)
     */
    public static boolean openSDCardPermission(Activity activity){
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE}, EXTERNAL_STORAGE_REQUEST_CODE);
            return false;
        } else {
            return true;
        }
    }


}
