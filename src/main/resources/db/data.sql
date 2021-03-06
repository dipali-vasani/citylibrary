DELETE FROM INV_EDITOR;
DELETE FROM JOURNAL_ISSUE;
DELETE FROM JOURNAL_VOLUME;
DELETE FROM BORROWS;
DELETE FROM WRITES;
DELETE FROM BOOK;
DELETE FROM PROCEEDINGS;
DELETE FROM COPY;
DELETE FROM DOCUMENT;
DELETE FROM READER;
DELETE FROM BRANCH;
DELETE FROM PUBLISHER;
DELETE FROM CHIEF_EDITOR;
DELETE FROM AUTHOR;
DELETE FROM RESERVES;
INSERT  INTO  AUTHOR (AUTHORID, ANAME) VALUES ('A1010', 'JOHN');
INSERT  INTO  AUTHOR (AUTHORID, ANAME) VALUES ('A1011', 'NOAH');
INSERT  INTO  AUTHOR (AUTHORID, ANAME) VALUES ('A1012', 'JACOB');
INSERT  INTO  AUTHOR (AUTHORID, ANAME) VALUES ('A1013', 'JACK');
INSERT  INTO  AUTHOR (AUTHORID, ANAME) VALUES ('A1014', 'ZOE');
INSERT  INTO  AUTHOR (AUTHORID, ANAME) VALUES ('A1015', 'LILY');
INSERT  INTO  AUTHOR (AUTHORID, ANAME) VALUES ('A1016', 'ANNA');
INSERT  INTO  AUTHOR (AUTHORID, ANAME) VALUES ('A1017', 'SARAH');
INSERT  INTO  AUTHOR (AUTHORID, ANAME) VALUES ('A1018', 'EMMA');
INSERT  INTO  AUTHOR (AUTHORID, ANAME) VALUES ('A1019', 'JOE');
INSERT  INTO  CHIEF_EDITOR (EDITORID, ENAME) VALUES ('E7010','JACOB');
INSERT  INTO  CHIEF_EDITOR (EDITORID, ENAME) VALUES ('E7011','JOHN');
INSERT  INTO  CHIEF_EDITOR (EDITORID, ENAME) VALUES ('E7012','ELLA');
INSERT  INTO  CHIEF_EDITOR (EDITORID, ENAME) VALUES ('E7013','EMMA');
INSERT  INTO  CHIEF_EDITOR (EDITORID, ENAME) VALUES ('E7014','ARIA');
INSERT  INTO  CHIEF_EDITOR (EDITORID, ENAME) VALUES ('E7015','HENRY');
INSERT  INTO  CHIEF_EDITOR (EDITORID, ENAME) VALUES ('E7016','DAVID');
INSERT  INTO  CHIEF_EDITOR (EDITORID, ENAME) VALUES ('E7017','GRACE');
INSERT  INTO  CHIEF_EDITOR (EDITORID, ENAME) VALUES ('E7018','JOSEPH');
INSERT  INTO  CHIEF_EDITOR (EDITORID, ENAME) VALUES ('E7019','JACKSON');
INSERT  INTO  PUBLISHER (PUBLISHERID, PUBNAME, ADDRESS) VALUES ('P1011', 'PEARSON','NEW JERSEY 07029');
INSERT  INTO  PUBLISHER (PUBLISHERID, PUBNAME, ADDRESS) VALUES ('P1012', 'TMCGRAW-HILL','NEW JERSEY 07012');
INSERT  INTO  PUBLISHER (PUBLISHERID, PUBNAME, ADDRESS) VALUES ('P1013', 'HOLTZBRINK','NEW YORK 10129');
INSERT  INTO  PUBLISHER (PUBLISHERID, PUBNAME, ADDRESS) VALUES ('P1014', 'PEARSON','NEW YORK 10029');
INSERT  INTO  PUBLISHER (PUBLISHERID, PUBNAME, ADDRESS) VALUES ('P1015', 'HOLTZBRINK','CALIFORNIA 94041');
INSERT  INTO  PUBLISHER (PUBLISHERID, PUBNAME, ADDRESS) VALUES ('P1016', 'INFORMA','CALIFORNIA 94044');
INSERT  INTO  PUBLISHER (PUBLISHERID, PUBNAME, ADDRESS) VALUES ('P1017', 'SIMON & SCHUSTER','ARIZONA 85029');
INSERT  INTO  PUBLISHER (PUBLISHERID, PUBNAME, ADDRESS) VALUES ('P1018', 'INFORMA','ARIZONA 84025');
INSERT  INTO  PUBLISHER (PUBLISHERID, PUBNAME, ADDRESS) VALUES ('P1019', 'HARPER COLLINS','VIRGINIA 22054');
INSERT  INTO  PUBLISHER (PUBLISHERID, PUBNAME, ADDRESS) VALUES ('P1010', 'PERSEUS','VIRGINIA 22046');
INSERT  INTO  BRANCH (LIBID, LNAME, LLOCATION) VALUES ('L1010', 'BR0NX', 'BR0NX');
INSERT  INTO  BRANCH (LIBID, LNAME, LLOCATION) VALUES ('L1011', 'ESSEX', 'ESSEX');
INSERT  INTO  BRANCH (LIBID, LNAME, LLOCATION) VALUES ('L1012', 'HUDSON', 'HUDSON');
INSERT  INTO  BRANCH (LIBID, LNAME, LLOCATION) VALUES ('L1013', 'PLAYMOUTH', 'PLAYMOUTH');
INSERT  INTO  BRANCH (LIBID, LNAME, LLOCATION) VALUES ('L1014', 'BRISTOL', 'BRISTOL');
INSERT  INTO  BRANCH (LIBID, LNAME, LLOCATION) VALUES ('L1015', 'ALBANY', 'ALBANY');
INSERT  INTO  BRANCH (LIBID, LNAME, LLOCATION) VALUES ('L1016', 'CAPEMAY', 'CAPEMAY');
INSERT  INTO  BRANCH (LIBID, LNAME, LLOCATION) VALUES ('L1017', 'BERGEN', 'BERGEN');
INSERT  INTO  BRANCH (LIBID, LNAME, LLOCATION) VALUES ('L1018', 'FULTON', 'FULTON');
INSERT  INTO  BRANCH (LIBID, LNAME, LLOCATION) VALUES ('L1019', 'GREENE', 'GREENE');
INSERT  INTO  READER (READERID, RTYPE, RNAME, ADDRESS) VALUES ('RED50', 'SENIOR', 'MAYA','NEW YORK');
INSERT  INTO  READER (READERID, RTYPE, RNAME, ADDRESS) VALUES ('RED51', 'STUDENT', 'JULIA','NEWARK');
INSERT  INTO  READER (READERID, RTYPE, RNAME, ADDRESS) VALUES ('RED52', 'CITIZEN', 'MARY','BOSTON');
INSERT  INTO  READER (READERID, RTYPE, RNAME, ADDRESS) VALUES ('RED53', 'STAFF', 'ARIA','HARRISON');
INSERT  INTO  READER (READERID, RTYPE, RNAME, ADDRESS) VALUES ('RED54', 'STAFF', 'EMMA','NEW YORK');
INSERT  INTO  READER (READERID, RTYPE, RNAME, ADDRESS) VALUES ('RED55', 'STUDENT', 'ESLA','BOSTON');
INSERT  INTO  READER (READERID, RTYPE, RNAME, ADDRESS) VALUES ('RED56', 'SENIOR', 'MAYA','MUMBAI');
INSERT  INTO  READER (READERID, RTYPE, RNAME, ADDRESS) VALUES ('RED57', 'STUDENT', 'TOM','MOUNTAIN VIEW');
INSERT  INTO  READER (READERID, RTYPE, RNAME, ADDRESS) VALUES ('RED58', 'CITIZEN', 'JERRY','ROSEWOOD');
INSERT  INTO  READER (READERID, RTYPE, RNAME, ADDRESS) VALUES ('RED59', 'STAFF', 'MONA','BOSTON');
INSERT  INTO  DOCUMENT (DOCID, TITLE, PDATE, PUBLISHERID) VALUES ('D2020', 'DATABASE','2016-02-23','P1011');
INSERT  INTO  DOCUMENT (DOCID, TITLE, PDATE, PUBLISHERID) VALUES ('DJ1026', 'DATA STRUCTURE','2016-07-27','P1012');
INSERT  INTO  DOCUMENT (DOCID, TITLE, PDATE, PUBLISHERID) VALUES ('D2021', 'NETWORKING','2016-06-27','P1013');
INSERT  INTO  DOCUMENT (DOCID, TITLE, PDATE, PUBLISHERID) VALUES ('DJ2026', 'COMPUTER ARCH','2014-07-27','P1014');
INSERT  INTO  DOCUMENT (DOCID, TITLE, PDATE, PUBLISHERID) VALUES ('DP2025', 'DATA MINING','2015-05-23','P1015');
INSERT  INTO  DOCUMENT (DOCID, TITLE, PDATE, PUBLISHERID) VALUES ('DP2026', 'VLSI','2016-04-12','P1016');
INSERT  INTO  DOCUMENT (DOCID, TITLE, PDATE, PUBLISHERID) VALUES ('D2022', 'PROGRAMMING','2010-05-23','P1017');
INSERT  INTO  DOCUMENT (DOCID, TITLE, PDATE, PUBLISHERID) VALUES ('DB2026', 'PROGRAMMING','2013-11-27','P1018');
INSERT  INTO  DOCUMENT (DOCID, TITLE, PDATE, PUBLISHERID) VALUES ('DB2027', 'JAVA','2016-01-23','P1019');
INSERT  INTO  DOCUMENT (DOCID, TITLE, PDATE, PUBLISHERID) VALUES ('DB2028', 'OPERATING SYSTEM','2016-01-09','P1010');
INSERT  INTO  COPY (DOCID, COPYNO, LIBID, POSITION) VALUES ('D2020', 1, 'L1011', '001A01');
INSERT  INTO  COPY (DOCID, COPYNO, LIBID, POSITION) VALUES ('D2020', 2, 'L1011', '001A02');
INSERT  INTO  COPY (DOCID, COPYNO, LIBID, POSITION) VALUES ('D2020', 3, 'L1011', '001A02');
INSERT  INTO  COPY (DOCID, COPYNO, LIBID, POSITION) VALUES ('D2020', 4, 'L1011', '001A01');
INSERT  INTO  COPY (DOCID, COPYNO, LIBID, POSITION) VALUES ('D2020', 5, 'L1011', '001A02');
INSERT  INTO  COPY (DOCID, COPYNO, LIBID, POSITION) VALUES ('D2020', 6, 'L1011', '001A02');
INSERT  INTO  COPY (DOCID, COPYNO, LIBID, POSITION) VALUES ('DB2026', 1, 'L1011', '001A03');
INSERT  INTO  COPY (DOCID, COPYNO, LIBID, POSITION) VALUES ('DB2026', 2, 'L1011', '001A04');
INSERT  INTO  COPY (DOCID, COPYNO, LIBID, POSITION) VALUES ('DB2026', 3, 'L1012', '001A02');
INSERT  INTO  COPY (DOCID, COPYNO, LIBID, POSITION) VALUES ('DB2026', 4, 'L1012', '001A03');
INSERT  INTO  COPY (DOCID, COPYNO, LIBID, POSITION) VALUES ('DB2026', 5, 'L1011', '001A03');
INSERT  INTO  COPY (DOCID, COPYNO, LIBID, POSITION) VALUES ('DB2026', 6, 'L1011', '001A04');
INSERT  INTO  COPY (DOCID, COPYNO, LIBID, POSITION) VALUES ('DB2026', 7, 'L1011', '001A02');
INSERT  INTO  COPY (DOCID, COPYNO, LIBID, POSITION) VALUES ('DB2026', 8, 'L1011', '001A03');
INSERT  INTO  COPY (DOCID, COPYNO, LIBID, POSITION) VALUES ('DB2027', 1, 'L1012', '001A06');
INSERT  INTO  COPY (DOCID, COPYNO, LIBID, POSITION) VALUES ('DB2027', 2, 'L1012', '001A07');
INSERT  INTO  COPY (DOCID, COPYNO, LIBID, POSITION) VALUES ('DJ2026', 1, 'L1012', '001A06');
INSERT  INTO  COPY (DOCID, COPYNO, LIBID, POSITION) VALUES ('DJ2026', 2, 'L1012', '001A08');
INSERT  INTO  COPY (DOCID, COPYNO, LIBID, POSITION) VALUES ('DJ2026', 3, 'L1012', '001A09');
INSERT  INTO  COPY (DOCID, COPYNO, LIBID, POSITION) VALUES ('DJ2026', 4, 'L1012', '001A05');
INSERT  INTO  COPY (DOCID, COPYNO, LIBID, POSITION) VALUES ('DJ2026', 5, 'L1012', '001A07');
INSERT  INTO  COPY (DOCID, COPYNO, LIBID, POSITION) VALUES ('DJ1026', 1, 'L1012', '001A08');
INSERT  INTO  COPY (DOCID, COPYNO, LIBID, POSITION) VALUES ('DJ1026', 2, 'L1012', '001A07');
INSERT  INTO  COPY (DOCID, COPYNO, LIBID, POSITION) VALUES ('DB2028', 3, 'L1011', '001A07');
INSERT  INTO  COPY (DOCID, COPYNO, LIBID, POSITION) VALUES ('DB2028', 4, 'L1011', '001A09');
INSERT  INTO  COPY (DOCID, COPYNO, LIBID, POSITION) VALUES ('DB2028', 5, 'L1011', '001A07');
INSERT  INTO  COPY (DOCID, COPYNO, LIBID, POSITION) VALUES ('DB2028', 6, 'L1011', '001A07');
INSERT  INTO  COPY (DOCID, COPYNO, LIBID, POSITION) VALUES ('DP2025', 1, 'L1012', '001A07');
INSERT  INTO  COPY (DOCID, COPYNO, LIBID, POSITION) VALUES ('DP2025', 2, 'L1012', '001A07');
INSERT  INTO  COPY (DOCID, COPYNO, LIBID, POSITION) VALUES ('DP2025', 3, 'L1012', '001A06');
INSERT  INTO  COPY (DOCID, COPYNO, LIBID, POSITION) VALUES ('DP2025', 4, 'L1012', '001A04');
INSERT  INTO  COPY (DOCID, COPYNO, LIBID, POSITION) VALUES ('DP2025', 5, 'L1012', '001A04');
INSERT  INTO  COPY (DOCID, COPYNO, LIBID, POSITION) VALUES ('DP2025', 6, 'L1012', '001A04');
INSERT  INTO  COPY (DOCID, COPYNO, LIBID, POSITION) VALUES ('DP2025', 7, 'L1012', '001A04');
INSERT  INTO  COPY (DOCID, COPYNO, LIBID, POSITION) VALUES ('DP2025', 8, 'L1012', '001A04');
INSERT  INTO  COPY (DOCID, COPYNO, LIBID, POSITION) VALUES ('DP2025', 9, 'L1012', '001A04');
INSERT  INTO  COPY (DOCID, COPYNO, LIBID, POSITION) VALUES ('DP2026', 1, 'L1013', '001A07');
INSERT  INTO  COPY (DOCID, COPYNO, LIBID, POSITION) VALUES ('DP2026', 2, 'L1013', '001A07');
INSERT  INTO  COPY (DOCID, COPYNO, LIBID, POSITION) VALUES ('DP2026', 3, 'L1013', '001A07');
INSERT  INTO  COPY (DOCID, COPYNO, LIBID, POSITION) VALUES ('DP2026', 4, 'L1013', '001A05');
INSERT  INTO  COPY (DOCID, COPYNO, LIBID, POSITION) VALUES ('DP2026', 5, 'L1013', '001A07');
INSERT  INTO  PROCEEDINGS (DOCID, CDATE, CLOCATION, CEDITOR) VALUES ('D2020', '2016-02-23', 'NEWYORK','CD1');
INSERT  INTO  PROCEEDINGS (DOCID, CDATE, CLOCATION, CEDITOR) VALUES ('D2021', '2015-11-23', 'NEWJERSY','CD2');
INSERT  INTO  PROCEEDINGS (DOCID, CDATE, CLOCATION, CEDITOR) VALUES ('D2022', '2015-02-23', 'NEWYORK','CD2');
INSERT  INTO  PROCEEDINGS (DOCID, CDATE, CLOCATION, CEDITOR) VALUES ('DB2026', '2014-05-24', 'MUMBAI','CD3');
INSERT  INTO  PROCEEDINGS (DOCID, CDATE, CLOCATION, CEDITOR) VALUES ('DB2027', '2015-07-15', 'CALIFORNIA','CD5');
INSERT  INTO  PROCEEDINGS (DOCID, CDATE, CLOCATION, CEDITOR) VALUES ('DB2028', '2016-04-21', 'BOSTON','CD5');
INSERT  INTO  PROCEEDINGS (DOCID, CDATE, CLOCATION, CEDITOR) VALUES ('DJ1026', '2014-11-23', 'CALIFORNIA','CD6');
INSERT  INTO  PROCEEDINGS (DOCID, CDATE, CLOCATION, CEDITOR) VALUES ('DJ2026', '2014-01-09', 'MUMBAI','CD7');
INSERT  INTO  PROCEEDINGS (DOCID, CDATE, CLOCATION, CEDITOR) VALUES ('DP2025', '2015-09-25', 'NEWYORK','CD7');
INSERT  INTO  PROCEEDINGS (DOCID, CDATE, CLOCATION, CEDITOR) VALUES ('DP2026', '2012-02-17', 'NEWJERSEY','CD1');
INSERT  INTO  BOOK (DOCID, ISBN) VALUES ('D2022', 9108);
INSERT  INTO  BOOK (DOCID, ISBN) VALUES ('D2021', 9109);
INSERT  INTO  BOOK (DOCID, ISBN) VALUES ('D2020', 9110);
INSERT  INTO  BOOK (DOCID, ISBN) VALUES ('DB2027', 9103);
INSERT  INTO  BOOK (DOCID, ISBN) VALUES ('DB2026', 9104);
INSERT  INTO  BOOK (DOCID, ISBN) VALUES ('DB2028', 9102);
INSERT  INTO  BOOK (DOCID, ISBN) VALUES ('DJ1026', 9101 );
INSERT  INTO  BOOK (DOCID, ISBN) VALUES ('DJ2026', 9105);
INSERT  INTO  BOOK (DOCID, ISBN) VALUES ('DP2025', 9106);
INSERT  INTO  BOOK (DOCID, ISBN) VALUES ('DP2026', 9107);
INSERT  INTO  WRITES (AUTHORID, DOCID) VALUES ('A1019', 'D2020');
INSERT  INTO  WRITES (AUTHORID, DOCID) VALUES ('A1018', 'D2021');
INSERT  INTO  WRITES (AUTHORID, DOCID) VALUES ('A1017', 'D2022');
INSERT  INTO  WRITES (AUTHORID, DOCID) VALUES ('A1016', 'DB2026');
INSERT  INTO  WRITES (AUTHORID, DOCID) VALUES ('A1015', 'DB2027');
INSERT  INTO  WRITES (AUTHORID, DOCID) VALUES ('A1014', 'DB2028');
INSERT  INTO  WRITES (AUTHORID, DOCID) VALUES ('A1013', 'DJ1026');
INSERT  INTO  WRITES (AUTHORID, DOCID) VALUES ('A1012', 'DJ2026');
INSERT  INTO  WRITES (AUTHORID, DOCID) VALUES ('A1011', 'DP2025');
INSERT  INTO  WRITES (AUTHORID, DOCID) VALUES ('A1010', 'DP2026');
INSERT  INTO  BORROWS (READERID, DOCID, COPYNO, LIBID, BDTIME, RDTIME) VALUES ('RED52', 'DB2026', 1, 'L1011', '2016-03-20 04:45:23','2016-04-10 09:32:56');
INSERT  INTO  BORROWS (READERID, DOCID, COPYNO, LIBID, BDTIME, RDTIME) VALUES ('RED53', 'DB2026', 2, 'L1011', '2016-01-10 08:45:23','2016-04-30 08:32:56');
INSERT  INTO  BORROWS (READERID, DOCID, COPYNO, LIBID, BDTIME, RDTIME) VALUES ('RED56', 'DJ2026', 1, 'L1012', '2016-04-20 10:45:23','2016-05-10 11:32:56');
INSERT  INTO  BORROWS (READERID, DOCID, COPYNO, LIBID, BDTIME, RDTIME) VALUES ('RED57', 'DJ2026', 2, 'L1012', '2016-03-20 04:45:23','2016-04-10 09:32:56');
INSERT  INTO  BORROWS (READERID, DOCID, COPYNO, LIBID, BDTIME, RDTIME) VALUES ('RED57', 'DJ2026', 3, 'L1012', '2016-02-20 09:45:23','2016-03-11 10:42:56');
INSERT  INTO  BORROWS (READERID, DOCID, COPYNO, LIBID, BDTIME, RDTIME) VALUES ('RED58', 'DJ2026', 4, 'L1012', '2016-03-20 04:45:23','2016-04-10 09:32:56');
INSERT  INTO  BORROWS (READERID, DOCID, COPYNO, LIBID, BDTIME, RDTIME) VALUES ('RED58', 'DJ2026', 5, 'L1012', '2016-02-20 09:45:23','2016-03-11 10:42:56');
INSERT  INTO  BORROWS (READERID, DOCID, COPYNO, LIBID, BDTIME, RDTIME) VALUES ('RED59', 'DJ1026', 1, 'L1012', '2016-04-20 10:45:23','2016-05-10 11:32:56');
INSERT  INTO  BORROWS (READERID, DOCID, COPYNO, LIBID, BDTIME, RDTIME) VALUES ('RED59', 'DJ1026', 2, 'L1012', '2016-02-20 09:45:23','2016-03-11 10:42:56');
INSERT  INTO  BORROWS (READERID, DOCID, COPYNO, LIBID, BDTIME, RDTIME) VALUES ('RED53', 'DB2028', 3, 'L1011', '2016-02-20 09:45:23','2016-03-11 10:42:56');
INSERT  INTO  BORROWS (READERID, DOCID, COPYNO, LIBID, BDTIME, RDTIME) VALUES ('RED53', 'DB2028', 4, 'L1011', '2016-04-20 10:45:23','2016-05-10 11:32:56');
INSERT  INTO  BORROWS (READERID, DOCID, COPYNO, LIBID, BDTIME, RDTIME) VALUES ('RED54', 'DB2028', 5, 'L1011', '2016-02-20 09:45:23','2016-03-11 10:42:56');
INSERT  INTO  BORROWS (READERID, DOCID, COPYNO, LIBID, BDTIME, RDTIME) VALUES ('RED55', 'DB2028', 6, 'L1011', '2016-04-20 10:45:23','2016-05-10 11:32:56');
INSERT  INTO  BORROWS (READERID, DOCID, COPYNO, LIBID, BDTIME, RDTIME) VALUES ('RED56', 'DP2025', 2, 'L1012', '2016-03-20 04:45:23','2016-04-10 09:32:56');
INSERT  INTO  BORROWS (READERID, DOCID, COPYNO, LIBID, BDTIME, RDTIME) VALUES ('RED58', 'DB2026', 5, 'L1011', '2016-03-20 04:45:23','2016-04-10 09:32:56');
INSERT  INTO  BORROWS (READERID, DOCID, COPYNO, LIBID, BDTIME, RDTIME) VALUES ('RED58', 'DB2026', 6, 'L1011', '2016-02-20 09:45:23','2016-03-11 10:42:56');
INSERT  INTO  BORROWS (READERID, DOCID, COPYNO, LIBID, BDTIME, RDTIME) VALUES ('RED59', 'DB2026', 7, 'L1011', '2016-04-20 10:45:23','2016-05-10 11:32:56');
INSERT  INTO  BORROWS (READERID, DOCID, COPYNO, LIBID, BDTIME, RDTIME) VALUES ('RED59', 'DB2026', 8, 'L1011', '2016-02-20 09:45:23','2016-03-11 10:42:56');
INSERT  INTO  BORROWS (READERID, DOCID, COPYNO, LIBID, BDTIME, RDTIME) VALUES ('RED51', 'DB2026', 3, 'L1012', '2016-03-20 04:45:23','2016-04-10 09:32:56');
INSERT  INTO  BORROWS (READERID, DOCID, COPYNO, LIBID, BDTIME, RDTIME) VALUES ('RED51', 'DB2026', 4, 'L1012', '2016-02-20 09:45:23','2016-03-11 10:42:56');
INSERT  INTO  BORROWS (READERID, DOCID, COPYNO, LIBID, BDTIME, RDTIME) VALUES ('RED52', 'DB2026', 3, 'L1012', '2016-04-20 10:45:23','2016-05-10 11:32:56');
INSERT  INTO  BORROWS (READERID, DOCID, COPYNO, LIBID, BDTIME, RDTIME) VALUES ('RED52', 'DB2027', 1, 'L1012', '2016-03-20 04:45:23','2016-04-10 09:32:56');
INSERT  INTO  BORROWS (READERID, DOCID, COPYNO, LIBID, BDTIME, RDTIME) VALUES ('RED53', 'DB2027', 2, 'L1012', '2016-02-20 09:45:23','2016-03-11 10:42:56');
INSERT  INTO  JOURNAL_VOLUME (DOCID, JVOLUME, EDITORID) VALUES ('D2020', 1, 'E7010');
INSERT  INTO  JOURNAL_VOLUME (DOCID, JVOLUME, EDITORID) VALUES ('D2021', 2, 'E7011');
INSERT  INTO  JOURNAL_VOLUME (DOCID, JVOLUME, EDITORID) VALUES ('D2022', 3, 'E7012');
INSERT  INTO  JOURNAL_VOLUME (DOCID, JVOLUME, EDITORID) VALUES ('DB2026', 4, 'E7013');
INSERT  INTO  JOURNAL_VOLUME (DOCID, JVOLUME, EDITORID) VALUES ('DB2027', 5, 'E7014');
INSERT  INTO  JOURNAL_VOLUME (DOCID, JVOLUME, EDITORID) VALUES ('DB2028', 6, 'E7015');
INSERT  INTO  JOURNAL_VOLUME (DOCID, JVOLUME, EDITORID) VALUES ('DJ1026', 7, 'E7016');
INSERT  INTO  JOURNAL_VOLUME (DOCID, JVOLUME, EDITORID) VALUES ('DJ2026', 8, 'E7017');
INSERT  INTO  JOURNAL_VOLUME (DOCID, JVOLUME, EDITORID) VALUES ('DP2025', 9, 'E7018');
INSERT  INTO  JOURNAL_VOLUME (DOCID, JVOLUME, EDITORID) VALUES ('DP2026', 10, 'E7019');
INSERT  INTO  JOURNAL_ISSUE (DOCID, ISSUENO, SCOPE) VALUES ('D2020', 1, 'COMPUTER SCIENCE');
INSERT  INTO  JOURNAL_ISSUE (DOCID, ISSUENO, SCOPE) VALUES ('D2021', 2, 'ELECTRICAL');
INSERT  INTO  JOURNAL_ISSUE (DOCID, ISSUENO, SCOPE) VALUES ('D2022', 3, 'ELECTRONICS');
INSERT  INTO  JOURNAL_ISSUE (DOCID, ISSUENO, SCOPE) VALUES ('DB2026', 4, 'COMPUTER ENGINEER');
INSERT  INTO  JOURNAL_ISSUE (DOCID, ISSUENO, SCOPE) VALUES ('DB2027', 5, 'SCIENCE');
INSERT  INTO  JOURNAL_ISSUE (DOCID, ISSUENO, SCOPE) VALUES ('DB2028', 6, 'CHEMISTRY');
INSERT  INTO  JOURNAL_ISSUE (DOCID, ISSUENO, SCOPE) VALUES ('DJ1026', 7, 'PHYSICS');
INSERT  INTO  JOURNAL_ISSUE (DOCID, ISSUENO, SCOPE) VALUES ('DJ2026', 8, 'MATHS');
INSERT  INTO  JOURNAL_ISSUE (DOCID, ISSUENO, SCOPE) VALUES ('DP2025', 9, 'ENGLISH');
INSERT  INTO  JOURNAL_ISSUE (DOCID, ISSUENO, SCOPE) VALUES ('DP2026', 10, 'BIOLOGY');
INSERT  INTO  INV_EDITOR (DOCID, ISSUENO, IENAME) VALUES ('D2020', 1, 'RITU');
INSERT  INTO  INV_EDITOR (DOCID, ISSUENO, IENAME) VALUES ('D2021', 2, 'KITU');
INSERT  INTO  INV_EDITOR (DOCID, ISSUENO, IENAME) VALUES ('D2022', 3, 'RINI');
INSERT  INTO  INV_EDITOR (DOCID, ISSUENO, IENAME) VALUES ('DB2026', 4, 'RIMI');
INSERT  INTO  INV_EDITOR (DOCID, ISSUENO, IENAME) VALUES ('DB2027', 5, 'RIA');
INSERT  INTO  INV_EDITOR (DOCID, ISSUENO, IENAME) VALUES ('DB2028', 6, 'RUSHA');
INSERT  INTO  INV_EDITOR (DOCID, ISSUENO, IENAME) VALUES ('DJ1026', 7, 'LATA');
INSERT  INTO  INV_EDITOR (DOCID, ISSUENO, IENAME) VALUES ('DJ2026', 8, 'GEETA');
INSERT  INTO  INV_EDITOR (DOCID, ISSUENO, IENAME) VALUES ('DP2025', 9, 'NEETA');
INSERT  INTO  INV_EDITOR (DOCID, ISSUENO, IENAME) VALUES ('DP2026', 10, 'PRIYA');
INSERT INTO ADMIN(ID, LOGINID, PASSWORD) VALUES (1, 'ABC', 'ABC')