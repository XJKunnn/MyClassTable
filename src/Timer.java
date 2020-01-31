import javafx.scene.input.DataFormat;

import javax.xml.crypto.Data;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Timer {
    Calendar calendar = Calendar.getInstance();             //日历

    int currentWeek;                                        //系统时间所处一年中的第几周
    Date currentDate = new Date();                          //获取系统时间
    List<Date> currentWeekList = new ArrayList<>();         //系统时间所在的周的每一天

    Date startDate, setDate;                                //学期开始的日期
    int startWeek;                                          //学期开始所处一年中的第几周
    int semesterLength;                                     //学期周数
    Date endDate;

    List<Date> wishWeekList = new ArrayList<>();

    public Timer(){
        calendar.setTime(currentDate);
        currentWeek = calendar.get(calendar.WEEK_OF_YEAR);
    }

    public Timer(Date setDate, int semesterLength){
        this.setDate = setDate;
        this.semesterLength = semesterLength;
//        System.out.println(getYear(setDate) + " " + getMonth(setDate) + " " +getDay(setDate));
        calendar.setTime(currentDate);
        currentWeek = calendar.get(calendar.WEEK_OF_YEAR);
        setStartDate();
        getWishWeek(startDate);
//        System.out.println("-----start");
//        showWeek(wishWeekList);
        setEndDate();
        getWishWeek(endDate);
//        System.out.println("-----end");
//        showWeek(wishWeekList);
    }

    public void showWeek(List<Date> WeekList){
        Date date;
        for(int n = 0; n < WeekList.size(); n++){
            date = WeekList.get(n);
            System.out.println(getYear(date) + " " + getMonth(date) + " " + getDay(date));
        }
    }

    public int getYear(Date date){
        int year = Integer.parseInt(String.format("%tY", date));
        return year;
    }

    public int getMonth(Date date){
        int month = Integer.parseInt(String.format("%tm", date));
        return month;
    }

    public int getDay(Date date){
        int day = Integer.parseInt(String.format("%td", date));
        return day;
    }

    public void getWishWeek(Date date){
        wishWeekList.clear();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(calendar.DAY_OF_WEEK);
        calendar.add(calendar.DATE, 1 - dayOfWeek);
        for(int i = 0; i < 7; i++){
            wishWeekList.add(calendar.getTime());
            calendar.add(calendar.DATE, 1);
        }
    }

    public void setStartDate(){
        calendar.setTime(setDate);
        int dayOfWeek = calendar.get(calendar.DAY_OF_WEEK);
        calendar.add(calendar.DATE, 1 - dayOfWeek);
        startDate = calendar.getTime();
    }

    public void setEndDate(){
        calendar.setTime(startDate);
        calendar.add(calendar.DATE, 7 * semesterLength - 1);
        endDate = calendar.getTime();
    }

    public Date getStartDate(){
        return startDate;
    }

    public Date getEndDate(){
        return endDate;
    }

    public int getCurrentWeek(){
        return currentWeek;
    }

    public static void main(String args[]){
        Locale.setDefault(Locale.CHINA);
        Calendar myCalendar = new GregorianCalendar(2020, 8, 1);    //这里的日期比正常少1
        Date setDate = myCalendar.getTime();
        System.out.println("setDate is :" + setDate);
        Timer timer = new Timer(setDate, 17);
//        timer.showWeek(timer.wishWeekList);
    }
}
