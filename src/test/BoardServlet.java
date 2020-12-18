package test;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.article.Article;
import board.article.ArticleDao;

@WebServlet("/BoardServlet")
public class BoardServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArticleDao articleDao = new ArticleDao();
		
		ArrayList<Article> articles = articleDao.getArticles();
		for(int i=0; i<articles.size();i++) {
			System.out.println("제목:"+articles.get(i).getTitle());
		}
	}
}
