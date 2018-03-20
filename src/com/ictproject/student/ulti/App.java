package com.ictproject.student.ulti;

import com.ictproject.student.controller.ProfileController;
import com.ictproject.student.models.*;

public class App {

    ProfileController controller = new ProfileController();

    public void setController(ProfileController controller) {
        this.controller = controller;
    }

    // Computer Science courses
    Course cst111 = new Course(111,"Introduction to Computer Science and Information Technology","CST111");
    Course cst112 = new Course(112,"Introduction to Computer Science and Information Technology","CST112");
    Course cst121 = new Course(121,"Computer Organization and Assembly Language Programming", "CST121");
    Course cst125 = new Course(125,"Installing, Configuring and Administering Windows", "CST125");
    Course cst141 = new Course(141,"Principles of Computing Using Java I", "CST141");
    Course cst222 = new Course(222,"Computer Architecture", "CST222");
    Course cst227 = new Course(227,"Network Operating Systems and Network Infrastructure", "CST227");
    Course cst242 = new Course(242,"Advanced Programming and Problem Solving with Java", "CST242");
    Course cst246 = new Course(246,"Data Structures", "CST246");
    Course cst288 = new Course(288,"Internship for Information Technology", "CST288");

    // Math courses
    Course mat107 = new Course(107,"Computer Mathematics Concepts", "MAT107");
    Course mat141 = new Course(141,"Calculus with Analytic Geometry I", "MAT141");
    Course mat142 = new Course(142,"Calculus with Analytic Geometry II", "MAT142");
    Course mat203 = new Course(203,"Calculus with Analytic Geometry III", "MAT203");
    Course mat204 = new Course(204,"Differential Equations", "MAT204");
    Course mat205 = new Course(205,"Discrete Mathematics", "MAT205");


    // Physics courses
    Course phy130 = new Course(130,"Physics I", "PHY130");
    Course phy132 = new Course(132,"Physics I Lab", "PHY132");
    Course phy230 = new Course(230,"Physics II", "PHY230");
    Course phy232 = new Course(232,"Physics II Lab", "PHY232");
    Course phy245 = new Course(245,"Physics III", "PHY245");
    Course phy246 = new Course(246,"Physics III Lab", "PHY246");

    // Chemistry courses
    Course che133 = new Course(133,"College Chemistry I", "CHE133");
    Course che134 = new Course(134,"College Chemistry II", "CHE134");
    Course che250 = new Course(250,"Organic Chemistry I", "CHE250");
    Course che251 = new Course(251,"Organic Chemistry II", "CHE251");

    // Biology courses
    Course bio150 = new Course(150,"Modern Biology I", "BIO150");
    Course bio152 = new Course(152,"Modern Biology II", "BIO152");

    // ELT courses
    Course elt112 = new Course(112,"Electricity I", "ELT112");
    Course elt150 = new Course(150,"The Workings of Personal Computers", "ELT150");
    Course elt151 = new Course(151,"CISCO - Computer Networking I", "ELT151");
    Course elt152 = new Course(152,"CISCO - Computer Networking II", "ELT152");
    Course elt224 = new Course(224,"Electricity II", "ELT224");

    // English courses
    Course eng101 = new Course(101,"Standard Freshman Composition", "ENG101");
    Course eng102 = new Course(102,"Introduction to Literature", "ENG102");
    Course eng121 = new Course(121,"Technical Writing", "ENG121");

    // History courses
    Course his101 = new Course(101,"Western Civilization I", "HIS101");
    Course his103 = new Course(103,"Foundations of American History", "HIS103");

    // Philosophy courses
    Course phl105 = new Course(105,"Logic", "PHL105");

    // Physical education courses
    Course ped119 = new Course(119,"Fitness Walking", "PED119");
    Course ped126 = new Course(126,"Pilates", "PED126");

    // Freshman Seminar
    Course col101 = new Course(101, "Freshman Seminar", "COL101");

    Student student1 = new StudentYearly("Son", "Do Hong", 20143798, "Male", "27.10.1996", "0966540957", "sonstephendo@gmail.com",  "Ha Noi","Third");
    Student student2 = new StudentCredit("Son2", "Do Hong", 20143798, "Male", "27.10.1996", "0966540957", "sonstephendo@gmail.com", "Ha Noi", 120);


    public void addListStudent() {
        controller.getStudentData().addAll(student1, student2);
    }


}
