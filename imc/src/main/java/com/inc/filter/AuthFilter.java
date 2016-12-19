package com.inc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.log4j.Log4j;

@Log4j
public class AuthFilter implements Filter{

	private static ServletContext context;
	
	private String  code ="wafer";
	
	private String  command = "wp";
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		context = arg0.getServletContext();
	}
	

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		log.info("进入系统过滤器");
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		String url = request.getServletPath();
		System.out.println(url);
		
		
		Cookie[] cookies = request.getCookies();
		if(cookies == null){
			//放入cookie,登陆识别
			Cookie cookie = new Cookie(code, code);
			//放入的cookie的内容和下面方法一致，采用加密，避免cookie伪造
			response.addCookie(cookie);
			arg2.doFilter(request, response);
		}else{
			for (Cookie cookie : cookies) {
				System.out.println(cookie.getMaxAge());
				if(cookie.getName().equals(code)){
					arg2.doFilter(request, response);
				}
			}
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 通过MD4，关键词和随机数生成随机cookie
	 * username+md5+randomStr
	 * 假设用户仍以用户名"admin"，口令"hello"登录成功，系统可以知道：
		
		该用户的id，例如，1230001；
		该用户的口令，例如，"hello"；
		Cookie过期时间，可由当前时间戳＋固定时长计算，例如，1461288165；
		系统固定的一个随机字符串，例如，"secret"。
		把上面4部分拼起来，得到：
		
		"1230001:hello:1461288165:secret"
		计算上述字符串的md5，得到："d9753...004d5"。
		
		最后，按照用户id，过期时间和最终的hash值，拼接得到Cookie如下：
		
		"1230001:1461288165:d9753...004d5"
		当浏览器发送Cookie回服务器时，我们就可以按照下面的方式验证Cookie：
		
		把Cookie分割成三部分，得到用户id，过期时间和hash值；
		如果过期时间已到，直接丢弃；
		根据用户id查找用户，得到用户口令；
		按照生成Cookie时的算法计算md5，与Cookie自带的hash值对比。
	 * @return
	 */
	private String geneAuthCode(){
		String authCode = code+command.hashCode();
		return authCode;
	}
	
	public static void main(String[] args) {
		System.out.println("asdf".hashCode());
	}
}
