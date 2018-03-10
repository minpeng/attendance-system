package com.attendance.common.utils;

import com.attendance.vo.ResultVO;

/**
 * Created by pengmin on 2018/3/10.
 */
public class ResultVOUtil {

    public static ResultVO success(Object data){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("success");
        resultVO.setData(data);
        return resultVO;
    }

    public static ResultVO success(){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("success");

        return resultVO;
    }

    public static ResultVO error(){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(-1);
        resultVO.setMsg("error");
        return resultVO;
    }
    public static ResultVO error(String message){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(-1);
        resultVO.setMsg("error:"+message);
        return resultVO;
    }
}
