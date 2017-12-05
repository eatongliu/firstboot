package com.gpdata.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by liuyutong on 2017/12/1.
 */
@Controller
public class UserController {

    @RequestMapping("/user")
    public String getUser(Map<String, Object> map) {
        map.put("description", "这是一个测试哟！");
        return "user";
    }

    @RequestMapping("/wx/subscribe")
    public String subscribe(HttpServletRequest request, HttpServletResponse response) {
        try {
            String gzh = "方正阿帕比";//公众号名字
            String user_agent = request.getHeader("user-agent");
            System.out.println(user_agent);
            String url="http://weixin.qq.com/mp/getmasssendmsg?__biz=wx49ef724fe2aee8cf#wechat_webview_type=1&wechat_redirect#rd";
            String url2="https://mp.weixin.qq.com/mp/profile_ext?action=home&__biz=MzA3NzQzNTgyNw==&scene=110#wechat_redirect";

            if (user_agent.indexOf("MicroMessenger")>=0 &&
                    user_agent.indexOf("iPhone")>=0 ) {

                response.sendRedirect(url);
            }


            if (user_agent.indexOf("MicroMessenger")>=0 &&
                    user_agent.indexOf("Android")>=0 ) {
//                response.sendRedirect("weixin://profile/"+gzh);
                response.sendRedirect(url2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "subscribe";
    }
}
