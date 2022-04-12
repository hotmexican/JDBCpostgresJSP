package com.borisov.DAO;

import com.borisov.model.Lesson;
import com.borisov.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements DAO<Student, String>{


    private String jdbcURL = "jdbc:postgresql://localhost:5432/postgres";
    private String jdbcUsername = "myuser";
    private String jdbcPassword = "123";

    private static final String INSERT_STUDENT_SQL = "INSERT INTO students (id, name) VALUES (DEFAULT, ?);";
    private static final String SELECT_STUDENT_BY_ID = "select id,StudentName,LessonName from students where id =?";
    private static final String SELECT_ALL_STUDENTS = "select * from students";
    private static final String DELETE_STUDENT_SQL = "delete from students where id = ?;";
    private static final String UPDATE_STUDENT_SQL = "update students set name = ? where id = ?;";

    public StudentDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            System.out.println("connection to db");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public boolean create(Student student) {
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT_SQL)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setArray(2, (Array) student.getLessonList());
            preparedStatement.executeQuery();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public Student read(String s) {
        return null;
    }

    @Override
    public boolean update(Student student) {
        return false;
    }

    @Override
    public boolean delete(Student student) {
        return false;
    }

    @Override
    public List<Student> showAll() {
        List<Student> studentList =new ArrayList<>();
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("studentname");
                studentList.add(new Student(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }
}
