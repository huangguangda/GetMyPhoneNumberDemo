package cn.edu.gdmec.android.getmyphonenumberdemo;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract.CommonDataKinds.Phone;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jack on 2018/4/16.
 * 获取手机通讯录信息
 * 数据的封装
 */

public class GetNumber {
    //list<PhoneInfo>集合框架
    public static List<PhoneInfo> lists = new ArrayList<>();
    public static String getNumber(Context context){
        Cursor cursor=context.getContentResolver().query(Phone.CONTENT_URI,null,null,null,null);
        String phoneNumber;
        String phoneName;
        while (cursor.moveToNext()){
            phoneNumber=cursor.getString(cursor.getColumnIndex(Phone.NUMBER));
            phoneName=cursor.getString(cursor.getColumnIndex(Phone.DISPLAY_NAME));
            PhoneInfo phoneInfo = new PhoneInfo(phoneName,phoneNumber);
            lists.add(phoneInfo);
            System.out.println(phoneName+phoneNumber);
        }
        return null;
    }
}
