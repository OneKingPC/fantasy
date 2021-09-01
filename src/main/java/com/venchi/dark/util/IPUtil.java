package com.venchi.dark.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liwc
 * @date 2021/09/01
 */
public class IPUtil {

    public static String getIPAddr(HttpServletRequest request){
        return request.getRemoteAddr();
    }

}
