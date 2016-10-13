package com.liucheng.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liucheng.service.IndexService;

@Controller
@RequestMapping("/index")
public class IndexController {
	IndexService indexService=new IndexService();
	@RequestMapping("/indexList")
	public void getClassList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");  //这里不设置编码会有乱码
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache"); 
        PrintWriter out = response.getWriter();  //输出中文，这一句一定要放到后面，否则中文返回到页面是乱码  
        out.print(indexService.getClassList());
        out.flush();
        out.close();
	}
}