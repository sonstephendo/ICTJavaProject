package com.ictproject.student.ulti;

import com.ictproject.student.controller.ProfileController;
import com.ictproject.student.models.*;

public class App {

    ProfileController controller = new ProfileController();

    public void setController(ProfileController controller) {
        this.controller = controller;
    }

    // Computer Science courses
    public static Course cst111 = new Course(111,"Introduction to Computer Science and Information Technology","CST111");
    public static Course cst112 = new Course(112,"Introduction to Computer Science and Information Technology","CST112");
    public static Course cst121 = new Course(121,"Computer Organization and Assembly Language Programming", "CST121");
    public static Course cst125 = new Course(125,"Installing, Configuring and Administering Windows", "CST125");
    public static Course cst141 = new Course(141,"Principles of Computing Using Java I", "CST141");
    public static Course cst222 = new Course(222,"Computer Architecture", "CST222");
    public static Course cst227 = new Course(227,"Network Operating Systems and Network Infrastructure", "CST227");
    public static Course cst242 = new Course(242,"Advanced Programming and Problem Solving with Java", "CST242");
    public static Course cst246 = new Course(246,"Data Structures", "CST246");
    public static Course cst288 = new Course(288,"Internship for Information Technology", "CST288");

    // Math courses
    public static Course mat107 = new Course(107,"Computer Mathematics Concepts", "MAT107");
    public static Course mat141 = new Course(141,"Calculus with Analytic Geometry I", "MAT141");
    public static Course mat142 = new Course(142,"Calculus with Analytic Geometry II", "MAT142");
    public static Course mat203 = new Course(203,"Calculus with Analytic Geometry III", "MAT203");
    public static Course mat204 = new Course(204,"Differential Equations", "MAT204");
    public static Course mat205 = new Course(205,"Discrete Mathematics", "MAT205");


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

    // ELT courses
    public static Course elt112 = new Course(112,"Electricity I", "ELT112");
    public static Course elt150 = new Course(150,"The Workings of Personal Computers", "ELT150");
    public static Course elt151 = new Course(151,"CISCO - Computer Networking I", "ELT151");
    public static Course elt152 = new Course(152,"CISCO - Computer Networking II", "ELT152");
    public static Course elt224 = new Course(224,"Electricity II", "ELT224");

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

    public static Student student1 = new StudentYearly("Son", "Do Hong", 20143798, "Male", "28/10/1996", "0966540957", "sonstephendo@gmail.com",  "Ha Noi","Third");
    public static Student student2 = new StudentCredit("Emy", "Yo", 20143799, "Female", "27/10/1996", "0966854737", "loveinarmy@gmail.com", "Ha Noi", 120);

}
