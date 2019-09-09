CREATE TABLE EmployeeUsers (
    username VARCHAR2(20) PRIMARY KEY,
    password VARCHAR2(20),
    role VARCHAR2(8)
);

CREATE TABLE Tickets (
    ticketID NUMBER(5),
    employee_username VARCHAR2(20),
    amount NUMBER(10,2),
    ticket_description VARCHAR2(250),
    type VARCHAR2(10),
    status NUMBER(1),
    CONSTRAINT username_fk FOREIGN KEY (employee_username) REFERENCES EmployeeUsers(username)
);

CREATE SEQUENCE tickets_seq
    START WITH 1
    INCREMENT BY 1;
/

CREATE TRIGGER tickets_seq_trigger
BEFORE INSERT ON Tickets
FOR EACH ROW
BEGIN
    IF :new.ticketID IS NULL THEN
    SELECT tickets_seq.NEXTVAL INTO :new.ticketID FROM dual;
    END IF;
END;
/

CREATE OR REPLACE PROCEDURE update_ticket
(id IN NUMBER, uname IN VARCHAR2, amnt IN NUMBER, descript IN VARCHAR2, typ IN VARCHAR2, sttus IN NUMBER)
IS
BEGIN
    UPDATE Tickets SET employee_username = uname WHERE ticketid = id;
    UPDATE Tickets SET amount = amnt WHERE ticketid = id;
    UPDATE Tickets SET ticket_description = descript WHERE ticketid = id;
    UPDATE Tickets SET type = typ WHERE ticketid = id;
    UPDATE Tickets SET status = sttus WHERE ticketid = id;
END;
/

INSERT INTO EmployeeUsers VALUES('employee','3mpl0y33','employee');

INSERT INTO EmployeeUsers VALUES('manager', 'password', 'manager');

SELECT * FROM EmployeeUsers;
SELECT * FROM Tickets;

DROP TABLE EmployeeUsers;
DROP TABLE Tickets;

DROP SEQUENCE tickets_seq;

COMMIT;