package com.borisov.servlets;


import com.borisov.DAO.StudentDAO;
import com.borisov.model.Student;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AddStudentServlet extends HttpServlet {

    StudentDAO studentDAO;

    @Override
    public void init() throws ServletException {
        studentDAO = new StudentDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/WEB-INF/view/insert-student-page.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String name = request.getParameter("name");
            Student student = new Student(name);
            studentDAO.create(student);
            response.sendRedirect(request.getContextPath()+"/");
        }
        catch(Exception ex) {
            response.sendRedirect(request.getContextPath()+"/");
        }
    }

}
