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
		request.setCharacterEncoding("utf-8");  //���ﲻ���ñ����������
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache"); 
        PrintWriter out = response.getWriter();  //������ģ���һ��һ��Ҫ�ŵ����棬�������ķ��ص�ҳ��������  
        out.print(indexService.getClassList());
        out.flush();
        out.close();
	}
}