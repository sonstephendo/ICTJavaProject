CREATE DATABASE IF NOT EXISTS student;

USE student;

DROP TABLE IF EXISTS Student;

CREATE TABLE Student(
	Snum INT,
	Name VARCHAR(10),
	Major VARCHAR(10),
	Level VARCHAR(2),
	Age int,
	primary key(snum)
);

CREATE TABLE Faculty (
    Fid int,
    Name VARCHAR(10),
    Dept VARCHAR (10),
    PRIMARY KEY(fid)
);

CREATE TABLE Class (
    Name varchar(10),
    Time varchar(10),
    Room varchar (10),
    Fid int,
    primary key (Name),
    foreign key (Fid) references Faculty(Fid)
);

CREATE TABLE Enrolled (
    Snum int,
    ClassName varchar(10),
    primary key (Snum, ClassName),
    foreign key (Snum) references Student(Snum),
    foreign key (ClassName) references Class(Name)
);


INSERT INTO Student (Snum,Name,Major,Level,Age) VALUES
(1,'jhon','CS','Sr',19),
(2,'smith','CS','Jr',20),
(3,'jacob','CV','Sr',20),
(4,'tom','CS','Jr',20),
(5,'sid','CS','Jr',20),
(6,'harry','CS','Sr',21);
(6,'harry','CS','Sr',21);



INSERT INTO Faculty (Fid,Name, Dept) VALUES
(11,'Harshith',1000),
(12,'Mohan',1000),
(13,'Kumar',1001),
(14,'Shobha',1002),
(15,'Shan',1000);

INSERT INTO Class (Name,Time,Room,Fid) VALUES
('class1','noon','room1',14),
('class10','morning','room128',14),
('class2','morning','room2',12),
('class3','morning','room3',11),
('class4','evening','room4',14),
('class5','night','room3',15),
('class6','morning','room2',14),
('class7','morning','room3',14);

INSERT INTO Enrolled (Snum, ClassName) VALUES
(1,'class1'),
(2,'class1'),
(3,'class2'),
(4,'class3'),
(3,'class3'),
(5,'class4'),
(1,'class5'),
(2,'class5'),
(3,'class5'),
(4,'class5'),
(5,'class5'),
(6,'class5');