CREATE database city_library;
USE city_library;
CREATE TABLE IF NOT EXISTS Author(AUTHORID varchar(255), ANAME varchar(255), PRIMARY KEY(AUTHORID));
CREATE TABLE IF NOT EXISTS Publisher(PUBLISHERID varchar(255), PUBNAME varchar(255), ADDRESS varchar(255) ,PRIMARY KEY(PUBLISHERID));
CREATE TABLE IF NOT EXISTS Branch(LIBID varchar(255), LNAME varchar(255), LLOCATION varchar(255), PRIMARY KEY(LIBID));
CREATE TABLE IF NOT EXISTS Reader(READERID varchar(255), RTYPE varchar(255), RNAME varchar(255), ADDRESS varchar(255), PRIMARY KEY(READERID));
CREATE TABLE IF NOT EXISTS Chief_Editor(EDITORID varchar(255), ENAME varchar(255), PRIMARY KEY (EDITORID));
CREATE TABLE IF NOT EXISTS Document(DOCID varchar(255), TITLE varchar(255), PDATE Date, PUBLISHERID varchar(255), PRIMARY KEY (DOCID), FOREIGN KEY (PUBLISHERID) REFERENCES Publisher(PUBLISHERID));
CREATE TABLE IF NOT EXISTS Book(DOCID varchar(255), ISBN int, PRIMARY KEY (DOCID), FOREIGN KEY (DOCID) REFERENCES Document(DOCID));
CREATE TABLE IF NOT EXISTS Writes(AUTHORID varchar(255), DOCID varchar(255), PRIMARY KEY (DOCID, AUTHORID), FOREIGN KEY (DOCID) REFERENCES Book(DOCID), FOREIGN KEY (AUTHORID) REFERENCES AUTHOR(AUTHORID));
CREATE TABLE IF NOT EXISTS Copy(DOCID varchar(255), COPYNO int, LIBID varchar(255), POSITION varchar(255), PRIMARY KEY (DOCID, COPYNO, LIBID), FOREIGN KEY (DOCID) REFERENCES Document(DOCID), FOREIGN KEY (LIBID) REFERENCES BRANCH(LIBID));
CREATE TABLE IF NOT EXISTS Journal_Volume(DOCID varchar(255), JVOLUME int, EDITORID varchar(255), PRIMARY KEY (DOCID), FOREIGN KEY (EDITORID) REFERENCES Chief_Editor(EDITORID), FOREIGN KEY (DOCID) REFERENCES Document(DOCID));
CREATE TABLE IF NOT EXISTS Journal_Issue(DOCID varchar(255), ISSUENO int, SCOPE varchar(255), PRIMARY KEY (DOCID, ISSUENO), FOREIGN KEY (DOCID) REFERENCES Journal_Volume(DOCID));
CREATE TABLE IF NOT EXISTS Inv_Editor(DOCID varchar(255), ISSUENO int, IENAME varchar(255), PRIMARY KEY (DOCID, ISSUENO, IENAME), FOREIGN KEY (DOCID, ISSUENO) REFERENCES Journal_Issue(DOCID, ISSUENO));
CREATE TABLE IF NOT EXISTS Proceedings(DOCID varchar(255), CDATE Date, CLOCATION varchar(255), CEDITOR varchar(255), PRIMARY KEY (DOCID), FOREIGN KEY (DOCID) REFERENCES Document(DOCID));
CREATE TABLE IF NOT EXISTS Reserves(RESNUMBER int NOT NULL AUTO_INCREMENT, READERID varchar(255), DOCID varchar(255), COPYNO int, LIBID varchar(255), DTIME DateTime, PRIMARY KEY (RESNUMBER), FOREIGN KEY (DOCID, COPYNO, LIBID) REFERENCES COPY(DOCID, COPYNO, LIBID));
CREATE TABLE IF NOT EXISTS Borrows(BORNUMBER int NOT NULL AUTO_INCREMENT, READERID varchar(255), DOCID varchar(255), COPYNO int, LIBID varchar(255), BDTIME DateTime, RDTIME DateTime, PRIMARY KEY (BORNUMBER), FOREIGN KEY (DOCID, COPYNO, LIBID) REFERENCES COPY(DOCID, COPYNO, LIBID), FOREIGN KEY (READERID) REFERENCES Reader(READERID));
