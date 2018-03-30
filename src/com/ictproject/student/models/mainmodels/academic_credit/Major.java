package com.ictproject.student.models.mainmodels.academic_credit;

import com.ictproject.student.models.mainmodels.CoursesCatalog;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Major class is class taken by each Student. Student need to do specific required for degree
 */
public class Major {

    private final StringProperty titleMajor = new SimpleStringProperty();
    private final IntegerProperty majorCredits = new SimpleIntegerProperty();
    private final IntegerProperty minorCredits = new SimpleIntegerProperty();
    private CoursesCatalog<CreditCourse> majorCatalog;
    private CoursesCatalog<CreditCourse> minorCatalog; // TODO: Xét điều kiện tốt nghiệp

    public Major() {
    }

    public Major(String titleMajor, int majorCredits, int minorCredits) {
        this.titleMajor.set(titleMajor);
        this.majorCredits.set(majorCredits);
        this.minorCredits.set(minorCredits);
        majorCatalog = new CoursesCatalog<>();
        minorCatalog = new CoursesCatalog<>();
    }

    public int getMinorCredits() {
        return minorCredits.get();
    }

    public IntegerProperty minorCreditsProperty() {
        return minorCredits;
    }

    public void setMinorCredits(int minorCredits) {
        this.minorCredits.set(minorCredits);
    }

    public CoursesCatalog<CreditCourse> getMajorCatalog() {
        return majorCatalog;
    }

    public void setMajorCatalog(CoursesCatalog<CreditCourse> majorCatalog) {
        this.majorCatalog = majorCatalog;
    }

    public CoursesCatalog<CreditCourse> getMinorCatalog() {
        return minorCatalog;
    }

    public void setMinorCatalog(CoursesCatalog<CreditCourse> minorCatalog) {
        this.minorCatalog = minorCatalog;
    }

    public String getTitleMajor() {
        return titleMajor.get();
    }

    public StringProperty titleMajorProperty() {
        return titleMajor;
    }

    public void setTitleMajor(String titleMajor) {
        this.titleMajor.set(titleMajor);
    }

    public int getMajorCredits() {
        return majorCredits.get();
    }

    public IntegerProperty majorCreditsProperty() {
        return majorCredits;
    }

    public void setMajorCredits(int majorCredits) {
        this.majorCredits.set(majorCredits);
    }

    @Override
    public String toString() {
        return getTitleMajor();
    }
}
