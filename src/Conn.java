//导入包
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    private Course findCourse;

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
            sql = "SELECT name, start_time, end_time, course_day, location, start_week, end_week " +
                    "FROM course_table " +
                    "WHERE start_week <= " + Init.targetWeek + " AND end_week >= " + Init.targetWeek + ";";
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                String name = rs.getString("name");
                int start_time = rs.getInt("start_time");
                int end_time = rs.getInt("end_time");
                int course_day = rs.getInt("course_day");
                String location = rs.getString("location");
                int start_week = rs.getInt("start_week");
                int end_week = rs.getInt("end_week");
                Course course = new Course(name, start_time, end_time, course_day, location, start_week, end_week);
                getCourseList.add(course);
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

    public void addCourse(Course course){
        try{

            stmt = con.createStatement();
            String sql = "INSERT INTO course_table VALUES (" + "'" + course.getName()+ "'," +
                        course.getStart_time() + "," + course.getEnd_time() + "," +
                        course.getCourse_day() + "," + course.getStart_week() + "," +
                        course.getEnd_week() + ",'" + course.getLocation() + "')";
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

    public Course findCourse(String name){
        try{
            stmt = con.createStatement();
            String sql;
            sql = "SELECT start_time, end_time, course_day, location, start_week, end_week FROM course_table " +
                    "WHERE name = " + "'" + name + "'" + ";";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                int start_time = rs.getInt("start_time");
                int end_time = rs.getInt("end_time");
                int course_day = rs.getInt("course_day");
                String location = rs.getString("location");
                int start_week = rs.getInt("start_week");
                int end_week = rs.getInt("end_week");
                findCourse = new Course(name, start_time, end_time, course_day, location, start_week, end_week);
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
        return findCourse;
    }

    public void addTime(Timer timer){
        try{
            stmt = con.createStatement();
            int sYear = timer.getYear(timer.getStartDate());
            int sMonth = timer.getMonth(timer.getStartDate());
            int sDay = timer.getDay(timer.getStartDate());
            int eYear = timer.getYear(timer.getEndDate());
            int eMonth = timer.getMonth(timer.getEndDate());
            int eDay = timer.getDay(timer.getEndDate());

            String sql = "INSERT INTO semester_time VALUES ("
                            + sYear + ", " + sMonth + ", " + sDay + ", "
                            + eYear + ", " + eMonth + ", " + eDay + ");";
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

    public boolean findDate(){
        try{
            stmt = con.createStatement();
            String sql;
            sql = "SELECT startYear, startMonth, startDay, endYear, endMonth, endDay FROM semester_time; ";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                int start_Year = rs.getInt("startYear");
                int start_month = rs.getInt("startMonth");
                String month = Integer.toString(start_month);
                int start_day = rs.getInt("startDay");
                String day = Integer.toString(start_day);
                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
                if(start_month < 10){
                    month = "0" + start_month;
                }
                if(start_day < 10){
                    day = "0" + start_day;
                }
                int end_Year = rs.getInt("endYear");
                int end_month = rs.getInt("endMonth");
                String e_month = Integer.toString(end_month);
                int end_day = rs.getInt("endDay");
                String e_day = Integer.toString(end_day);
                if(end_month < 10){
                    e_month = "0" + end_month;
                }
                if(end_day < 10){
                    e_day = "0" + end_day;
                }
                Demo.startDate = sf.parse(start_Year + "-" + month + "-" + day);
                Demo.endDate = sf.parse(end_Year + "-" + e_month + "-" + e_day);
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
        return true;
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
