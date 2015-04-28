package org.davewang.innovation.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.davewang.innovation.util.SignUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller  
@RequestMapping("/user")  
public class TestSpringMVCController {
  
  
    @RequestMapping(value="/test",method=RequestMethod.GET)     
    public String list(HttpServletRequest request, HttpServletResponse response) throws Exception {  
                
        // 微信加密签名  
        String signature = request.getParameter("signature");  
        // 时间戳  
        String timestamp = request.getParameter("timestamp");  
        // 随机数  
        String nonce = request.getParameter("nonce");  
        // 随机字符串  
        String echostr = request.getParameter("echostr");  
  
        PrintWriter out = response.getWriter();  
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败  
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {  
            out.print(echostr);  
        }  
        out.close();  
        out = null; 
        return null;       
    }  
  
    
      
    @RequestMapping(value="/list",method=RequestMethod.GET)  
    public String popWindow() throws Exception{  
    	return "user/list";
    }  
      
    
      
    @RequestMapping(value="/delete",method=RequestMethod.POST)  
    @ResponseBody  
    public Map<String, String> delete(@RequestParam("uid")List<Integer> uid)throws Exception{  
        //<span style="color: #ff0000;">spring mvc 还可以将参数绑定为list类型</span>  
  
  
        Map<String, String> map = new HashMap<String, String>();  
        try {  
            //userService.deleteUsers(uid);  
            map.put("mes", "删除成功");  
        } catch (Exception e) {  
            e.printStackTrace();  
            map.put("mes", "删除失败");  
            throw e;  
        }  
        return map;//重定向  
    }
}  
