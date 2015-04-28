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
                
        // ΢�ż���ǩ��  
        String signature = request.getParameter("signature");  
        // ʱ���  
        String timestamp = request.getParameter("timestamp");  
        // �����  
        String nonce = request.getParameter("nonce");  
        // ����ַ���  
        String echostr = request.getParameter("echostr");  
  
        PrintWriter out = response.getWriter();  
        // ͨ������signature���������У�飬��У��ɹ���ԭ������echostr����ʾ����ɹ����������ʧ��  
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
        //<span style="color: #ff0000;">spring mvc �����Խ�������Ϊlist����</span>  
  
  
        Map<String, String> map = new HashMap<String, String>();  
        try {  
            //userService.deleteUsers(uid);  
            map.put("mes", "ɾ���ɹ�");  
        } catch (Exception e) {  
            e.printStackTrace();  
            map.put("mes", "ɾ��ʧ��");  
            throw e;  
        }  
        return map;//�ض���  
    }
}  
