package com.ictproject.student.ulti;

import com.ictproject.student.models.mainmodels.*;
import com.ictproject.student.models.mainmodels.FixedStudent.StudyYear;
import com.ictproject.student.ui.mainui.admin.StudentsController;

import static com.ictproject.student.models.mainmodels.StudentList.STUDENTLIST;

public class App {

    public static App app = new App();

    StudentsController controller = new StudentsController();

    public void setController(StudentsController controller) {
        this.controller = controller;
    }

    // Computer Science courses
    public static Course cst111 = new CreditCourse(111,"Introduction to Computer Science and Information Technology","CST111", 2);
    public static Course cst112 = new CreditCourse(112,"Introduction to Object-Oriented Programming","CST112", 2);
    public static Course cst121 = new CreditCourse(121,"Computer Organization and Assembly Language Programming", "CST121", 2);
    public static Course cst125 = new CreditCourse(125,"Installing, Configuring and Administering Windows", "CST125", 2);
    public static Course cst141 = new CreditCourse(141,"Principles of Computing Using Java I", "CST141", 2);
    public static Course cst222 = new CreditCourse(222,"Computer Architecture", "CST222", 2);
    public static Course cst227 = new CreditCourse(227,"Network Operating Systems and Network Infrastructure", "CST227", 2);
    public static Course cst242 = new CreditCourse(242,"Advanced Programming and Problem Solving with Java", "CST242",3);
    public static Course cst246 = new CreditCourse(246,"Data Structures", "CST246", 3);
    public static Course cst288 = new CreditCourse(288,"Internship for Information Technology", "CST288",2);
    // ELT courses
    public static Course elt112 = new CreditCourse(112,"Electricity I", "ELT112", 2);
    public static Course elt150 = new CreditCourse(150,"The Workings of Personal Computers", "ELT150", 2);
    public static Course elt151 = new CreditCourse(151,"CISCO - Computer Networking I", "ELT151", 2);
    public static Course elt152 = new CreditCourse(152,"CISCO - Computer Networking II", "ELT152", 2);
    public static Course elt224 = new CreditCourse(224,"Electricity II", "ELT224", 2);
    // Math cours, 2es
    public static Course mat107 = new CreditCourse(107,"Computer Mathematics Concepts", "MAT107", 2);
    public static Course mat141 = new CreditCourse(141,"Calculus with Analytic Geometry I", "MAT141", 2);
    public static Course mat142 = new CreditCourse(142,"Calculus with Analytic Geometry II", "MAT142", 2);
    public static Course mat203 = new CreditCourse(203,"Calculus with Analytic Geometry III", "MAT203", 2);
    public static Course mat204 = new CreditCourse(204,"Differential Equations", "MAT204", 2);
    public static Course mat205 = new CreditCourse(205,"Discrete Mathematics", "MAT205", 2);


    // Physics courses
    public static Course phy130 = new Course(130,"Physics I", "PHY130");
    public static Course phy132 = new Course(132,"Physics I Lab", "PHY132");
    public static Course phy230 = new Course(230,"Physics II", "PHY230");
    public static Course phy232 = new Course(232,"Physics II Lab", "PHY232");
    public static Course phy245 = new Course(245,"Physics III", "PHY245");
    public static Course phy246 = new Course(246,"Physics III Lab", "PHY246");

    // Chemistry courses
    public static Course che133 = new Course(133,"College Chemistry I", "CHE133");
    public static Course che134 = new Course(134,"College Chemistry II", "CHE134");
    public static Course che250 = new Course(250,"Organic Chemistry I", "CHE250");
    public static Course che251 = new Course(251,"Organic Chemistry II", "CHE251");

    // Biology courses
    public static Course bio150 = new Course(150,"Modern Biology I", "BIO150");
    public static Course bio152 = new Course(152,"Modern Biology II", "BIO152");

    // English courses
    public static Course eng101 = new Course(101,"Standard Freshman Composition", "ENG101");
    public static Course eng102 = new Course(102,"Introduction to Literature", "ENG102");
    public static Course eng121 = new Course(121,"Technical Writing", "ENG121");

    // History courses
    public static Course his101 = new Course(101,"Western Civilization I", "HIS101");
    public static Course his103 = new Course(103,"Foundations of American History", "HIS103");

    // Philosophy courses
    Course phl105 = new Course(105,"Logic", "PHL105");

    // Physical education courses
    public static Course ped119 = new Course(119,"Fitness Walking", "PED119");
    public static Course ped126 = new Course(126,"Pilates", "PED126");

    // Freshman Seminar
    public static Course col101 = new Course(101, "Freshman Seminar", "COL101");

    public static Student student1 = new FixedStudent(20143798, "Son", "Do Hong", "Male", "28/10/1996", "0966540957", "sonstephendo@gmail.com",  "Ha Noi", StudyYear.FRESHMAN);
    public static Student student2 = new CreditStudent(20143799,"Emy", "Yo", "Female", "27/10/1996", "0966854737", "loveinarmy@gmail.com", "Ha Noi", 120);
    public static Student student3 = new CreditStudent(20455434, "Son", "Do", "Male", "23/05/1997","09668547534", "loveinarmy@email.com","Thai Nguyen", 120);
    public static Student student4 = new FixedStudent(11111111,"Son4", "Do2", "Male", "23/05/2000","", "","",StudyYear.SENIOR);

    public static Major csMajor = new Major("Major 1", 120);
    public static Major seMajor = new Major("Major 2", 110);

    public void adding() {
//        STUDENTLIST.addStudent(App.student1);
//        STUDENTLIST.addStudent(App.student2);
//        STUDENTLIST.addStudent(App.student3);
//        STUDENTLIST.addStudent(App.student4);

        csMajor.addMajorCourse((CreditCourse) App.cst246);
        csMajor.addMajorCourse((CreditCourse) App.cst288);
        csMajor.addMajorCourse((CreditCourse) App.cst227);
        csMajor.addMajorCourse((CreditCourse) App.cst111);
        csMajor.addMajorCourse((CreditCourse) App.cst121);
        csMajor.addMajorCourse((CreditCourse) App.cst112);
        csMajor.addMajorCourse((CreditCourse) App.cst125);
        csMajor.addMajorCourse((CreditCourse) App.cst141);
        csMajor.addMajorCourse((CreditCourse) App.cst222);

        csMajor.addMajorCourse((CreditCourse) App.elt112);
        csMajor.addMajorCourse((CreditCourse) App.elt150);
        csMajor.addMajorCourse((CreditCourse) App.elt151);
        csMajor.addMajorCourse((CreditCourse) App.elt152);
        csMajor.addMajorCourse((CreditCourse) App.elt224);
        csMajor.addMajorCourse((CreditCourse) App.mat107);
        csMajor.addMajorCourse((CreditCourse) App.mat141);
        csMajor.addMajorCourse((CreditCourse) App.mat142);
        csMajor.addMajorCourse((CreditCourse) App.mat203);
        csMajor.addMajorCourse((CreditCourse) App.mat204);
        csMajor.addMajorCourse((CreditCourse) App.mat205);
    }


    
}
