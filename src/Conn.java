//导入包
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
 * 数据库连接
 */
public class Conn {
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/course_table?&useSSL=false&serverTimezone=UTC";

    private static final String user = "XJKunnn";
    private static final String password = "xjk..990626";

    Connection con;
    Statement stmt;
    private List<Course> getCourseList = new ArrayList<>();

    public Conn(){
        try {
            //注册JDBC驱动程序
            Class.forName(driver);
            //建立连接
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed()) {
                System.out.println("数据库连接成功");
            }
//            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("数据库驱动没有安装");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }
    }

    public List<Course> getCourse(){
        try{
            stmt = con.createStatement();
            String sql;
            sql = "SELECT name, start_time, end_time, course_day, location FROM course_table;";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                String name = rs.getString("name");
                int start_time = rs.getInt("start_time");
                int end_time = rs.getInt("end_time");
                int course_day = rs.getInt("course_day");
                String location = rs.getString("location");
                Course course = new Course(name, start_time, end_time, course_day, location);
                getCourseList.add(course);
//                System.out.println(name+" "+start_time+" "+end_time+" "+course_day+" "+location);
            }

            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException se){
            se.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try{
                if(stmt != null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(con != null) con.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        return getCourseList;
    }

    public void deleteCourse(String name){
        try{
            stmt = con.createStatement();
            String sql= "DELETE FROM course_table WHERE name = " + "'" + name + "'" + ";";
            stmt.execute(sql);
            stmt.close();
            con.close();
        } catch (SQLException se){
            se.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try{
                if(stmt != null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(con != null) con.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }

    public void addCourse(JPanel course_panel, Course course){
        try{

            stmt = con.createStatement();
            String sql = "INSERT INTO course_table VALUES (" + "'" + course.getName()+ "'," +
                        course.getStart_time() + "," + course.getEnd_time() + "," +
                        course.getCourse_day() + "," + course.getStart_week() + "," +
                        course.getEnd_week() + ",'" + course.getLocation() + "')";
            stmt.execute(sql);
            new AddCourse(course_panel, course);
            stmt.close();
            con.close();
        } catch (SQLException se){
            se.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try{
                if(stmt != null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(con != null) con.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Connection con;
        //jdbc驱动
        String driver="com.mysql.cj.jdbc.Driver";
        //这里我的数据库是cxxt
        String url="jdbc:mysql://localhost:3306/course_table?&useSSL=false&serverTimezone=UTC";
        String user="XJKunnn";
        String password="xjk..990626";
        try {
            //注册JDBC驱动程序
            Class.forName(driver);
            //建立连接
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed()) {
                System.out.println("数据库连接成功");
            }
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("数据库驱动没有安装");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }
    }
}
