

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class Filter1
 */
@WebFilter("/Filter1")
public class Filter1 extends HttpFilter implements Filter {
  
    //public Filter1() {}
    public void init(FilterConfig fConfig) throws ServletException {}
	
	public void destroy() {}
    
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String url = "" ;
		if(request instanceof HttpServletRequest) {
			url = ((HttpServletRequest)request).getRequestURL().toString(); 
		}
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.print("Obtained request url:- " + url);
		writer.flush();
		//writer.close();
		chain.doFilter(request, response);
	}

	

}
