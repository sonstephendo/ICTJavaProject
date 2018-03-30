package com.ictproject.student.models.mainmodels.fixed_curriculum;


import com.ictproject.student.models.mainmodels.Course;
import com.ictproject.student.models.mainmodels.CoursesCatalog;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class FixedClass {

    private final StringProperty className = new SimpleStringProperty();
//    private final IntegerProperty numOfEdu = new SimpleIntegerProperty();

    // TODO: 30/03/2018 make more catalog ???
    private CoursesCatalog<Course> coursesCatalog;

    public FixedClass() {
    }

    public FixedClass(String className) {
        this.className.set(className);
       coursesCatalog = new CoursesCatalog<>();
    }

    public CoursesCatalog<Course> getCoursesCatalog() {
        return coursesCatalog;
    }

    public void setCoursesCatalog(CoursesCatalog<Course> coursesCatalog) {
        this.coursesCatalog = coursesCatalog;
    }

    public String getClassName() {
        return className.get();
    }

    public StringProperty classNameProperty() {
        return className;
    }

    public void setClassName(String className) {
        this.className.set(className);
    }

    @Override
    public String toString() {
        return getClassName();
    }
}
