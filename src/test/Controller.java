package test;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.article.Article;
import board.article.ArticleDao;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		ArticleDao dao = new ArticleDao();
		ArrayList<Article> articles = dao.getArticles(); 
		
		String action = request.getParameter("action");
		
		String dest="";
		if(action.equals("insert")) {
			String title = request.getParameter("title");
			String body = request.getParameter("body");
			int mid = Integer.parseInt(request.getParameter("mid"));
			dao.insertArticle(title, body, mid);
			dest = "/DBTest.jsp";
		}else if(action.equals("list")) {
			request.setAttribute("mydata",articles);
		}else{
			dest = "/list.jsp";
		}
		//jsp에 articles넘기기 1.request객체에 데이터 저장
		request.setAttribute("myData",articles);
		//2.위에서 저장한 request 객체를 이용해 새로운 jsp요청 -> 목적지 isp필요
		//String dest = "/DBTest.jsp";
		
		RequestDispatcher rd = request.getRequestDispatcher(dest); //적절한 목적지에 요청
		rd.forward(request,response); //request와 response가 넘어간다.
			
	}
}
