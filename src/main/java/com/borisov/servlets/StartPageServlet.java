package com.borisov.servlets;


import com.borisov.DAO.StudentDAO;
import com.borisov.model.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class StartPageServlet extends HttpServlet {

    StudentDAO studentDAO;


    @Override
    public void init() throws ServletException {
        studentDAO = new StudentDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        List<Student> studentList = studentDAO.showAll();
        request.setAttribute("students", studentList);
        String index = "/WEB-INF/view/start-page.jsp";
        getServletContext().getRequestDispatcher(index).forward(request,response);
   }
}
