/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Credencial;

/**
 *
 * @author 1513 X-MXTI
 */

public class FiltroSeguranca implements Filter {
    
    
    public FiltroSeguranca() {
    }  
    
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            //HttpSession sessao = request.getSession();
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;

            String url = httpServletRequest .getRequestURI();

            HttpSession sessao = httpServletRequest .getSession();

            if (sessao.getAttribute("credencial")!=null || url.lastIndexOf("login.jsp")>-1 ||
            url.lastIndexOf("AutenticadorCredencialController") >-1 ){
            chain.doFilter(request, response); 
            }else{
            ((HttpServletResponse) response).sendRedirect("login.jsp");
            }
    }

    public void init(FilterConfig fConfig) throws ServletException {

    }
    
}
