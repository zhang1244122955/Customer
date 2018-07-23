package com.zz624.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zz624.biz.BroadcastBiz;
import com.zz624.entry.Broadcast;

@RequestMapping("file")
@Controller
public class BroadcastController {
	
	@Autowired
	BroadcastBiz broadcastBiz;
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody
	public String upload(String name,MultipartFile file, HttpServletRequest request,HttpServletResponse response) throws IOException {
		//设置相应编码
		response.setContentType("text/html;charset=utf-8");
		String path = request.getSession().getServletContext().getRealPath("resources/images");
		String fileName = file.getOriginalFilename();
		String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
		System.out.println(path+name+suffix);
		File dir = new File(path, name+suffix);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		// MultipartFile自带的解析方法
		file.transferTo(dir);
		String str = "{\"name\":\""+name+suffix+"?"+System.currentTimeMillis()+"\"}";
		return str;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public String update(String onehref,String onepath,String onetitle,String twohref,String twopath,String twotitle,String threehref,String threepath,String threetitle,String fourhref,String fourpath,String fourtitle){
		
		System.out.println(onehref+"--"+onepath+"--"+onetitle);
		Broadcast broadcast = new Broadcast();
		broadcast.setId(1);
		broadcast.setHref(onehref);
		broadcast.setPath(onepath);
		broadcast.setTitle(onetitle);
		broadcastBiz.modifyBroadcast(broadcast);
		broadcast.setId(2);
		broadcast.setHref(twohref);
		broadcast.setPath(twopath);
		broadcast.setTitle(twotitle);
		broadcastBiz.modifyBroadcast(broadcast);
		broadcast.setId(3);
		broadcast.setHref(threehref);
		broadcast.setPath(threepath);
		broadcast.setTitle(threetitle);
		broadcastBiz.modifyBroadcast(broadcast);
		broadcast.setId(4);
		broadcast.setHref(fourhref);
		broadcast.setPath(fourpath);
		broadcast.setTitle(fourtitle);
		broadcastBiz.modifyBroadcast(broadcast);
		return "";
	} 
	
	//让broadcast.jsp页面有数据
	@RequestMapping(value = "/broadcast")
	public String broadcast(HttpServletRequest request){
		List<Broadcast> list = broadcastBiz.findBroadcast();
		request.setAttribute("list", list);
		return "forward:/broadcastmanager.jsp?"+System.currentTimeMillis();
		
	}
	

}
