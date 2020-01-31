public class Course {
    private String name;            //课程名称
    private int start_time;         //课程从第几节开始
    private int end_time;           //课程在第几节结束
    private int course_day;         //课程在周几上课
    private int start_week;         //课程从哪一周开始上课
    private int end_week;           //课程到第几周结束
    private String location;        //上课地点

    public Course(String name, int start_time, int end_time, int course_day, String location, int start_week, int end_week){
        this.name = name;
        this.start_time = start_time;
        this.end_time = end_time;
        this.course_day = course_day;
        this.start_week = start_week;
        this.end_week = end_week;
        this.location = location;
    }

    public String getName(){
        return this.name;
    }

    public int getStart_time(){
        return this.start_time;
    }

    public int getEnd_time(){
        return this.end_time;
    }

    public int getCourse_day(){
        return this.course_day;
    }

    public int getStart_week(){
        return start_week;
    }

    public int getEnd_week(){
        return this.end_week;
    }

    public String getLocation(){
        return this.location;
    }
}
