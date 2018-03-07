package Model;

import com.alibaba.fastjson.JSONArray;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class ShowResponse {

    public void show(HttpServletResponse response, HttpServletRequest request) throws IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/json; charset=UTF-8");

        Map<String ,Object> fileMap=new HashMap<String ,Object>();
        fileMap.put("state",200);
        fileMap.put("msg","成功");
        fileMap.put("code",1);

        String jsonText= JSONArray.toJSONString(fileMap,true);

        PrintWriter print=response.getWriter();
        print.print(jsonText);
        print.close();



    }
}
