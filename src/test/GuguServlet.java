package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GuguServlet")
public class GuguServlet extends HttpServlet {

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");//브라우저 출력기 인코딩 utf-8로 설정
		response.setContentType("text/html; charset=utf-8");//
		PrintWriter out = response.getWriter(); //브라우저에 출력기
		
		//int dan = Integer.parseInt(request.getParameter("dan"));
		//out.println("<h2>========"+dan+"단========</h2>");
		/*for(int i=1;i<=9;i++) {
			out.println(dan+" * "+i+" = "+dan*i);
			out.println("<br>");
		}*/
		for(int i=2;i<10;i++) {
			out.println("<h2>========"+i+"단========</h2>");
			for(int j=1;j<10;j++) {
				out.println(i+" * "+j+" = "+i*j);
				out.println("<br>");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
