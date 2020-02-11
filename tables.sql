drop table studentdemo;
  CREATE TABLE "SCOTT"."STUDENTDEMO" 
   (	"SNAME" VARCHAR2(20) NOT NULL ENABLE, 
	"SID" NUMBER(10,0), 
	"SBRANCH" VARCHAR2(20), 
	"SCOLLEGE" VARCHAR2(10), 
	"SEMAIL" VARCHAR2(10), 
	"SMARKS" NUMBER(10,0), 
	"ADDRESSID" NUMBER(6,0), 
	 PRIMARY KEY ("SID");
	 INSERT INTO studentdemo values('tab',15,'ece','aditya','tab@',900,12345);
INSERT INTO studentdemo values('ani',16,'ece','aditya','anitha@',990,12345);
INSERT INTO studentdemo values('navya',17,'ece','aditya','navya@',980,12345);
INSERT INTO studentdemo values('anu',18,'ece','aditya','anu@',980,12345);
INSERT INTO studentdemo values('ramu',19,'ece','aditya','ramu@',970,12345);
