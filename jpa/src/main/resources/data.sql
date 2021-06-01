INSERT INTO CUSTOM (EMAIL, URL, CONTENT)
VALUES ('test1', 'test1', 'test1'),
       ('test2', 'test2', 'test2'),
       ('test3', 'test3', 'test3'),
       ('test4', 'test4', 'test4'),
       ('test5', 'test5', 'test5'),
       ('test6', 'test6', 'test6'),
       ('test7', 'test7', 'test7'),
       ('test8', 'test8', 'test8'),
       ('test9', 'test9', 'test9'),
       ('test10', 'test10', 'test10'),
       ('test11', 'test11', 'test11'),
       ('test12', 'test12', 'test12'),
       ('test13', 'test13', 'test13'),
       ('test14', 'test14', 'test14'),
       ('test15', 'test15', 'test15'),
       ('test16', 'test16', 'test16'),
       ('test17', 'test17', 'test17'),
       ('test18', 'test18', 'test18'),
       ('test19', 'test19', 'test19'),
       ('test20', 'test20', 'test20')
;


INSERT INTO PUBLIC.CUSTOMERS (ADDRESS_CODE, ADDRESS_NUMBER, CITY, BIRTH_DATE, EMAIL_ADDRESS, GENDER, ID, IS_ACTIVE,
                              JOIN_DAY, LEVEL, FIRST_NAME, LAST_NAME, PASSWORD, PHONE_NUMBER)
VALUES ('UCT-001', 41000, '경기도', '1999-01-01 00:00:00.000000', 'test1@naver.com', 'M', 'test1', true, now(), 10, '박',
        '퇴물', '1234', '010-9999-0000'),
       ('UCT-001', 42000, '경기도', '2002-01-01 00:00:00.000000', 'test2@naver.com', 'W', 'test2', true, now(), 5, '김',
        '호수', '1234', '010-1111-0000'),
       ('UCT-001', 43000, '경기도', '2007-01-01 00:00:00.000000', 'test12@naver.com', 'M', 'test1', true, now(), 3, '최',
        '초원', '1234', '010-2222-0000')
;

