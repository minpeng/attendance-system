package com.attendance.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by pengmin on 2018/3/10.
 */
public class DateTimeUtils {


    public  static String getTodayString(String format){
        SimpleDateFormat sdf = new SimpleDateFormat( format );
        String str = sdf.format( new Date() );
        return str;
    }

    public  static Date getTodayDate(String format){
        SimpleDateFormat sdf = new SimpleDateFormat( format );
        Date date = null;
        try{
             date = sdf.parse(sdf.format(new Date()));
        }catch ( Exception e ){
            e.printStackTrace();
        }
        return date;
    }

    public static Date strToDate( String sDate,String format ) {
        Date date = null;
        try {
            if( sDate != null && !"".equals( sDate.trim() ) ) {
                SimpleDateFormat formatDate = new SimpleDateFormat( format );
                String dateStr = sDate.trim();
                date = formatDate.parse( dateStr );
            }
        }
        catch( Exception e ) {
            e.printStackTrace();
        }
        return date;
    }
}
