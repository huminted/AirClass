package Model;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {



    public void addCookie(HttpServletResponse response,String name,String value){



        Cookie cookie = new Cookie(name,value);
        cookie.setMaxAge(600*60*24);
        response.addCookie(cookie);

    }







}
