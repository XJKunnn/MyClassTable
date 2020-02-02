import java.util.*;

/*
Timer类所要做的事情：
    第一：判断电脑系统当前的日期，同时计算出当前日期所在一年中的周数    systemDate
    第二：完成程序当前日期的初始化，并根据用户的调节改变当前日期，主要是周数    currentDate
    第三：记录用户输入的学期开始时间，并计算一年中的周数，完成开始时间和结束时间的计算   startDate， endDate
    第四：完成系统时间和当前时间到学期周数间的转化     targetWeek
 */

public class Timer {
    Calendar calendar = Calendar.getInstance();             //日历

    int systemWeek;                                        //系统时间所处一年中的第几周
    Date systemDate = new Date();                          //获取系统时间
    List<Date> systemWeekList = new ArrayList<>();         //系统时间所在的周的每一天

    static Date startDate;                                  //学期开始的日期
    int startWeek;                                          //学期开始所处一年中的第几周
    static int semesterLength;                                     //学期周数
    static Date endDate;

    static Date currentDate;                                       //当前程序所显示的日期
    static int currentWeek;                                        //当前程序所显示的周

    static int targetWeek;                                         //计算目标周数

    List<Date> wishWeekList = new ArrayList<>();

    //若不是第一次启动程序，即已经设置过学期开始时间和长度
    public Timer(){
        calendar.setTime(systemDate);
        systemWeek = calendar.get(calendar.WEEK_OF_YEAR);
        currentDate = systemDate;
        currentWeek = systemWeek;
    }

    //若第一次启动程序，即未设置过学期开始时间和长度
    public Timer(Date setDate, int semesterLength){
        this.semesterLength = semesterLength;
        calendar.setTime(systemDate);
        systemWeek = calendar.get(calendar.WEEK_OF_YEAR);
        currentDate = systemDate;
        currentWeek = systemWeek;
        setStartDate(setDate);
        setEndDate();
    }

    public void setTargetWeek(){
        targetWeek = getWeekOfYear(currentDate) - getWeekOfYear(startDate) + 1;
    }

    public static void addTargetWeek(){
        targetWeek += 1;
    }

    public static void subTargetWeek(){
        targetWeek -= 1;
    }

    public int getWeekOfYear(Date date){
        calendar.setTime(date);
        return calendar.get(calendar.WEEK_OF_YEAR);
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

    public void setStartDate(Date setDate){
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

    public int getSystemWeek(){
        return systemWeek;
    }

}
