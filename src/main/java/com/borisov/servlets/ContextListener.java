package com.borisov.servlets;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebListener
public class ContextListener implements ServletContextListener {


    private static final String SQL_CREATE = "CREATE TABLE IF NOT EXISTS students\n" +
            "(\n" +
            "    Id          SERIAL PRIMARY KEY,\n" +
            "    StudentName CHARACTER VARYING(30),\n" +
            "    LessonName  CHARACTER VARYING(30)\n" +
            ");";
    private static final String SQL_CREATE_LESSONS = "CREATE TABLE IF NOT EXISTS  lesson\n" +
            "(\n" +
            "    Id          SERIAL PRIMARY KEY,\n" +
            "    LessonName  CHARACTER VARYING(30),\n" +
            "    StudentName CHARACTER VARYING(30)\n" +
            ");";

    private static final String SQL_CREATE_FOREIGN_KEY_TABLE = "CREATE TABLE IF NOT EXISTS  student_lesson\n" +
            "(\n" +
            "    student_id int NOT NULL ,\n" +
            "    lesson_id  int NOT NULL,\n" +
            "    PRIMARY KEY(student_id, lesson_id),\n" +
            "    FOREIGN KEY (student_id) REFERENCES students (Id),\n" +
            "    FOREIGN KEY (lesson_id) REFERENCES lesson (Id)\n" +
            ");";

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String jdbcPassword = "123";
        String jdbcUsername = "myuser";
        String jdbcURL = "jdbc:postgresql://localhost:5432/postgres";
        try (Connection conn = DriverManager.getConnection(
                jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_CREATE))
        {
            preparedStatement.execute();

        }
        catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(
                jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_CREATE_LESSONS))
        {
            preparedStatement.execute();

        }
        catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(
                jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_CREATE_FOREIGN_KEY_TABLE))
        {
            preparedStatement.execute();

        }
        catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
