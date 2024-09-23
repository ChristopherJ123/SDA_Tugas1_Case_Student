package courses;

public class CourseDirector {
    public void constructOnlineCourse(Builder builder) {
        builder.setOnline(true);
        builder.setLocation("Online Platform");
        /*
        Dan varaibel2 baru lainnya yang mau ditambahkan
         */
    }

    public void constructOnsiteCourse(Builder builder) {
        builder.setOnline(false);
        /*
        Dan varaibel2 baru lainnya yang mau ditambahkan
         */
    }
}
