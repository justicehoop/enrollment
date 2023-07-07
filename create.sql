
    create table enrollment (
       grade float,
        lecture_id bigint not null,
        student_id varchar(255) not null,
        primary key (lecture_id, student_id)
    ) engine=InnoDB;

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB;

    insert into hibernate_sequence values ( 1 );

    create table interest_lecture (
       student_id varchar(255) not null,
        lecture_id bigint not null,
        primary key (student_id, lecture_id)
    ) engine=InnoDB;

    create table lecture (
       id bigint not null auto_increment,
        day_of_week varchar(10),
        end_hour_min varchar(5) not null,
        lecture_days integer not null,
        lecture_hour_of_day integer not null,
        lecture_name varchar(255),
        start_hour_min varchar(5) not null,
        professor_no bigint,
        subject_no bigint,
        primary key (id)
    ) engine=InnoDB;

    create table locker (
       id bigint not null auto_increment,
        location varchar(255),
        student_no varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table professor (
       national_type varchar(31) not null,
        id bigint not null,
        address_detail varchar(100),
        city varchar(30),
        zipcode varchar(20),
        email varchar(50) not null,
        gender varchar(255),
        mobile varchar(20) not null,
        name varchar(30) not null,
        identification_number varchar(30),
        country_code varchar(5),
        passport_number varchar(30),
        primary key (id)
    ) engine=InnoDB;

    create table student (
       id varchar(255) not null,
        day_of_birth varchar(30) not null,
        email varchar(30) not null,
        name varchar(30) not null,
        password varchar(25) not null,
        primary key (id)
    ) engine=InnoDB;

    create table subject (
       id bigint not null auto_increment,
        credit float,
        description varchar(250),
        name varchar(50),
        primary key (id)
    ) engine=InnoDB;

    alter table enrollment 
       add constraint FK4wdhkk0x7fwc6flfi04la2qe1 
       foreign key (lecture_id) 
       references lecture (id);

    alter table enrollment 
       add constraint FKio7fsy3vhvfgv7c0gjk15nyk4 
       foreign key (student_id) 
       references student (id);

    alter table interest_lecture 
       add constraint FK4g1jc3edm7lur7oc2ytmeyu83 
       foreign key (lecture_id) 
       references lecture (id);

    alter table interest_lecture 
       add constraint FKmyrureawxw2w1iokuli3ncpme 
       foreign key (student_id) 
       references student (id);

    alter table lecture 
       add constraint FK6xhpl7umuo4ulh5eg1ank9qwr 
       foreign key (professor_no) 
       references professor (id);

    alter table lecture 
       add constraint FKfuhbdoh80ktg0qo34qx8qhxp 
       foreign key (subject_no) 
       references subject (id);

    alter table locker 
       add constraint FKb9rodjiho9rvjcbt6sn05k5m9 
       foreign key (student_no) 
       references student (id);

    create table enrollment (
       grade float,
        lecture_id bigint not null,
        student_id varchar(255) not null,
        primary key (lecture_id, student_id)
    ) engine=InnoDB;

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB;

    insert into hibernate_sequence values ( 1 );

    create table interest_lecture (
       student_id varchar(255) not null,
        lecture_id bigint not null,
        primary key (student_id, lecture_id)
    ) engine=InnoDB;

    create table lecture (
       id bigint not null auto_increment,
        day_of_week varchar(10),
        end_hour_min varchar(5) not null,
        lecture_days integer not null,
        lecture_hour_of_day integer not null,
        lecture_name varchar(255),
        start_hour_min varchar(5) not null,
        professor_no bigint,
        subject_no bigint,
        primary key (id)
    ) engine=InnoDB;

    create table locker (
       id bigint not null auto_increment,
        location varchar(255),
        student_no varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table professor (
       national_type varchar(31) not null,
        id bigint not null,
        address_detail varchar(100),
        city varchar(30),
        zipcode varchar(20),
        email varchar(50) not null,
        gender varchar(255),
        mobile varchar(20) not null,
        name varchar(30) not null,
        identification_number varchar(30),
        country_code varchar(5),
        passport_number varchar(30),
        primary key (id)
    ) engine=InnoDB;

    create table student (
       id varchar(255) not null,
        day_of_birth varchar(30) not null,
        email varchar(30) not null,
        name varchar(30) not null,
        password varchar(25) not null,
        primary key (id)
    ) engine=InnoDB;

    create table subject (
       id bigint not null auto_increment,
        credit float,
        description varchar(250),
        name varchar(50),
        primary key (id)
    ) engine=InnoDB;

    alter table enrollment 
       add constraint FK4wdhkk0x7fwc6flfi04la2qe1 
       foreign key (lecture_id) 
       references lecture (id);

    alter table enrollment 
       add constraint FKio7fsy3vhvfgv7c0gjk15nyk4 
       foreign key (student_id) 
       references student (id);

    alter table interest_lecture 
       add constraint FK4g1jc3edm7lur7oc2ytmeyu83 
       foreign key (lecture_id) 
       references lecture (id);

    alter table interest_lecture 
       add constraint FKmyrureawxw2w1iokuli3ncpme 
       foreign key (student_id) 
       references student (id);

    alter table lecture 
       add constraint FK6xhpl7umuo4ulh5eg1ank9qwr 
       foreign key (professor_no) 
       references professor (id);

    alter table lecture 
       add constraint FKfuhbdoh80ktg0qo34qx8qhxp 
       foreign key (subject_no) 
       references subject (id);

    alter table locker 
       add constraint FKb9rodjiho9rvjcbt6sn05k5m9 
       foreign key (student_no) 
       references student (id);

    create table enrollment (
       grade float,
        lecture_id bigint not null,
        student_id varchar(255) not null,
        primary key (lecture_id, student_id)
    ) engine=InnoDB;

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB;

    insert into hibernate_sequence values ( 1 );

    create table interest_lecture (
       student_id varchar(255) not null,
        lecture_id bigint not null,
        primary key (student_id, lecture_id)
    ) engine=InnoDB;

    create table lecture (
       id bigint not null auto_increment,
        day_of_week varchar(10),
        end_hour_min varchar(5) not null,
        lecture_days integer not null,
        lecture_hour_of_day integer not null,
        lecture_name varchar(255),
        start_hour_min varchar(5) not null,
        professor_no bigint,
        subject_no bigint,
        primary key (id)
    ) engine=InnoDB;

    create table locker (
       id bigint not null auto_increment,
        location varchar(255),
        student_no varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table professor (
       national_type varchar(31) not null,
        id bigint not null,
        address_detail varchar(100),
        city varchar(30),
        zipcode varchar(20),
        email varchar(50) not null,
        gender varchar(255),
        mobile varchar(20) not null,
        name varchar(30) not null,
        identification_number varchar(30),
        country_code varchar(5),
        passport_number varchar(30),
        primary key (id)
    ) engine=InnoDB;

    create table student (
       id varchar(255) not null,
        day_of_birth varchar(30) not null,
        email varchar(30) not null,
        name varchar(30) not null,
        password varchar(25) not null,
        primary key (id)
    ) engine=InnoDB;

    create table subject (
       id bigint not null auto_increment,
        credit float,
        description varchar(250),
        name varchar(50),
        primary key (id)
    ) engine=InnoDB;

    alter table enrollment 
       add constraint FK4wdhkk0x7fwc6flfi04la2qe1 
       foreign key (lecture_id) 
       references lecture (id);

    alter table enrollment 
       add constraint FKio7fsy3vhvfgv7c0gjk15nyk4 
       foreign key (student_id) 
       references student (id);

    alter table interest_lecture 
       add constraint FK4g1jc3edm7lur7oc2ytmeyu83 
       foreign key (lecture_id) 
       references lecture (id);

    alter table interest_lecture 
       add constraint FKmyrureawxw2w1iokuli3ncpme 
       foreign key (student_id) 
       references student (id);

    alter table lecture 
       add constraint FK6xhpl7umuo4ulh5eg1ank9qwr 
       foreign key (professor_no) 
       references professor (id);

    alter table lecture 
       add constraint FKfuhbdoh80ktg0qo34qx8qhxp 
       foreign key (subject_no) 
       references subject (id);

    alter table locker 
       add constraint FKb9rodjiho9rvjcbt6sn05k5m9 
       foreign key (student_no) 
       references student (id);

    create table enrollment (
       grade float,
        lecture_id bigint not null,
        student_id varchar(255) not null,
        primary key (lecture_id, student_id)
    ) engine=InnoDB;

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB;

    insert into hibernate_sequence values ( 1 );

    create table interest_lecture (
       student_id varchar(255) not null,
        lecture_id bigint not null,
        primary key (student_id, lecture_id)
    ) engine=InnoDB;

    create table lecture (
       id bigint not null auto_increment,
        day_of_week varchar(10),
        end_hour_min varchar(5) not null,
        lecture_days integer not null,
        lecture_hour_of_day integer not null,
        lecture_name varchar(255),
        start_hour_min varchar(5) not null,
        professor_no bigint,
        subject_no bigint,
        primary key (id)
    ) engine=InnoDB;

    create table locker (
       id bigint not null auto_increment,
        location varchar(255),
        student_no varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table professor (
       national_type varchar(31) not null,
        id bigint not null,
        address_detail varchar(100),
        city varchar(30),
        zipcode varchar(20),
        email varchar(50) not null,
        gender varchar(255),
        mobile varchar(20) not null,
        name varchar(30) not null,
        identification_number varchar(30),
        country_code varchar(5),
        passport_number varchar(30),
        primary key (id)
    ) engine=InnoDB;

    create table student (
       id varchar(255) not null,
        day_of_birth varchar(30) not null,
        email varchar(30) not null,
        name varchar(30) not null,
        password varchar(25) not null,
        primary key (id)
    ) engine=InnoDB;

    create table subject (
       id bigint not null auto_increment,
        credit float,
        description varchar(250),
        name varchar(50),
        primary key (id)
    ) engine=InnoDB;

    alter table enrollment 
       add constraint FK4wdhkk0x7fwc6flfi04la2qe1 
       foreign key (lecture_id) 
       references lecture (id);

    alter table enrollment 
       add constraint FKio7fsy3vhvfgv7c0gjk15nyk4 
       foreign key (student_id) 
       references student (id);

    alter table interest_lecture 
       add constraint FK4g1jc3edm7lur7oc2ytmeyu83 
       foreign key (lecture_id) 
       references lecture (id);

    alter table interest_lecture 
       add constraint FKmyrureawxw2w1iokuli3ncpme 
       foreign key (student_id) 
       references student (id);

    alter table lecture 
       add constraint FK6xhpl7umuo4ulh5eg1ank9qwr 
       foreign key (professor_no) 
       references professor (id);

    alter table lecture 
       add constraint FKfuhbdoh80ktg0qo34qx8qhxp 
       foreign key (subject_no) 
       references subject (id);

    alter table locker 
       add constraint FKb9rodjiho9rvjcbt6sn05k5m9 
       foreign key (student_no) 
       references student (id);

    create table enrollment (
       grade float,
        lecture_id bigint not null,
        student_id varchar(255) not null,
        primary key (lecture_id, student_id)
    ) engine=InnoDB;

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB;

    insert into hibernate_sequence values ( 1 );

    create table interest_lecture (
       student_id varchar(255) not null,
        lecture_id bigint not null,
        primary key (student_id, lecture_id)
    ) engine=InnoDB;

    create table lecture (
       id bigint not null auto_increment,
        day_of_week varchar(10),
        end_hour_min varchar(5) not null,
        lecture_days integer not null,
        lecture_hour_of_day integer not null,
        lecture_name varchar(255),
        start_hour_min varchar(5) not null,
        professor_no bigint,
        subject_no bigint,
        primary key (id)
    ) engine=InnoDB;

    create table locker (
       id bigint not null auto_increment,
        location varchar(255),
        student_no varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table professor (
       national_type varchar(31) not null,
        id bigint not null,
        address_detail varchar(100),
        city varchar(30),
        zipcode varchar(20),
        email varchar(50) not null,
        gender varchar(255),
        mobile varchar(20) not null,
        name varchar(30) not null,
        identification_number varchar(30),
        country_code varchar(5),
        passport_number varchar(30),
        primary key (id)
    ) engine=InnoDB;

    create table student (
       id varchar(255) not null,
        day_of_birth varchar(30) not null,
        email varchar(30) not null,
        name varchar(30) not null,
        password varchar(25) not null,
        primary key (id)
    ) engine=InnoDB;

    create table subject (
       id bigint not null auto_increment,
        credit float,
        description varchar(250),
        name varchar(50),
        primary key (id)
    ) engine=InnoDB;

    alter table enrollment 
       add constraint FK4wdhkk0x7fwc6flfi04la2qe1 
       foreign key (lecture_id) 
       references lecture (id);

    alter table enrollment 
       add constraint FKio7fsy3vhvfgv7c0gjk15nyk4 
       foreign key (student_id) 
       references student (id);

    alter table interest_lecture 
       add constraint FK4g1jc3edm7lur7oc2ytmeyu83 
       foreign key (lecture_id) 
       references lecture (id);

    alter table interest_lecture 
       add constraint FKmyrureawxw2w1iokuli3ncpme 
       foreign key (student_id) 
       references student (id);

    alter table lecture 
       add constraint FK6xhpl7umuo4ulh5eg1ank9qwr 
       foreign key (professor_no) 
       references professor (id);

    alter table lecture 
       add constraint FKfuhbdoh80ktg0qo34qx8qhxp 
       foreign key (subject_no) 
       references subject (id);

    alter table locker 
       add constraint FKb9rodjiho9rvjcbt6sn05k5m9 
       foreign key (student_no) 
       references student (id);

    create table enrollment (
       grade float,
        lecture_id bigint not null,
        student_id varchar(255) not null,
        primary key (lecture_id, student_id)
    ) engine=InnoDB;

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB;

    insert into hibernate_sequence values ( 1 );

    create table interest_lecture (
       student_id varchar(255) not null,
        lecture_id bigint not null,
        primary key (student_id, lecture_id)
    ) engine=InnoDB;

    create table lecture (
       id bigint not null auto_increment,
        day_of_week varchar(10),
        end_hour_min varchar(5) not null,
        lecture_days integer not null,
        lecture_hour_of_day integer not null,
        lecture_name varchar(255),
        start_hour_min varchar(5) not null,
        professor_no bigint,
        subject_no bigint,
        primary key (id)
    ) engine=InnoDB;

    create table locker (
       id bigint not null auto_increment,
        location varchar(255),
        student_no varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table professor (
       national_type varchar(31) not null,
        id bigint not null,
        address_detail varchar(100),
        city varchar(30),
        zipcode varchar(20),
        email varchar(50) not null,
        gender varchar(255),
        mobile varchar(20) not null,
        name varchar(30) not null,
        identification_number varchar(30),
        country_code varchar(5),
        passport_number varchar(30),
        primary key (id)
    ) engine=InnoDB;

    create table student (
       id varchar(255) not null,
        day_of_birth varchar(30) not null,
        email varchar(30) not null,
        name varchar(30) not null,
        password varchar(25) not null,
        primary key (id)
    ) engine=InnoDB;

    create table subject (
       id bigint not null auto_increment,
        credit float,
        description varchar(250),
        name varchar(50),
        primary key (id)
    ) engine=InnoDB;

    alter table enrollment 
       add constraint FK4wdhkk0x7fwc6flfi04la2qe1 
       foreign key (lecture_id) 
       references lecture (id);

    alter table enrollment 
       add constraint FKio7fsy3vhvfgv7c0gjk15nyk4 
       foreign key (student_id) 
       references student (id);

    alter table interest_lecture 
       add constraint FK4g1jc3edm7lur7oc2ytmeyu83 
       foreign key (lecture_id) 
       references lecture (id);

    alter table interest_lecture 
       add constraint FKmyrureawxw2w1iokuli3ncpme 
       foreign key (student_id) 
       references student (id);

    alter table lecture 
       add constraint FK6xhpl7umuo4ulh5eg1ank9qwr 
       foreign key (professor_no) 
       references professor (id);

    alter table lecture 
       add constraint FKfuhbdoh80ktg0qo34qx8qhxp 
       foreign key (subject_no) 
       references subject (id);

    alter table locker 
       add constraint FKb9rodjiho9rvjcbt6sn05k5m9 
       foreign key (student_no) 
       references student (id);

    create table enrollment (
       grade float,
        lecture_id bigint not null,
        student_id varchar(255) not null,
        primary key (lecture_id, student_id)
    ) engine=InnoDB;

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB;

    insert into hibernate_sequence values ( 1 );

    create table interest_lecture (
       student_id varchar(255) not null,
        lecture_id bigint not null,
        primary key (student_id, lecture_id)
    ) engine=InnoDB;

    create table lecture (
       id bigint not null auto_increment,
        day_of_week varchar(10),
        end_hour_min varchar(5) not null,
        lecture_days integer not null,
        lecture_hour_of_day integer not null,
        lecture_name varchar(255),
        start_hour_min varchar(5) not null,
        professor_no bigint,
        subject_no bigint,
        primary key (id)
    ) engine=InnoDB;

    create table locker (
       id bigint not null auto_increment,
        location varchar(255),
        student_no varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table professor (
       national_type varchar(31) not null,
        id bigint not null,
        address_detail varchar(100),
        city varchar(30),
        zipcode varchar(20),
        email varchar(50) not null,
        gender varchar(255),
        mobile varchar(20) not null,
        name varchar(30) not null,
        identification_number varchar(30),
        country_code varchar(5),
        passport_number varchar(30),
        primary key (id)
    ) engine=InnoDB;

    create table student (
       id varchar(255) not null,
        day_of_birth varchar(30) not null,
        email varchar(30) not null,
        name varchar(30) not null,
        password varchar(25) not null,
        primary key (id)
    ) engine=InnoDB;

    create table subject (
       id bigint not null auto_increment,
        credit float,
        description varchar(250),
        name varchar(50),
        primary key (id)
    ) engine=InnoDB;

    alter table enrollment 
       add constraint FK4wdhkk0x7fwc6flfi04la2qe1 
       foreign key (lecture_id) 
       references lecture (id);

    alter table enrollment 
       add constraint FKio7fsy3vhvfgv7c0gjk15nyk4 
       foreign key (student_id) 
       references student (id);

    alter table interest_lecture 
       add constraint FK4g1jc3edm7lur7oc2ytmeyu83 
       foreign key (lecture_id) 
       references lecture (id);

    alter table interest_lecture 
       add constraint FKmyrureawxw2w1iokuli3ncpme 
       foreign key (student_id) 
       references student (id);

    alter table lecture 
       add constraint FK6xhpl7umuo4ulh5eg1ank9qwr 
       foreign key (professor_no) 
       references professor (id);

    alter table lecture 
       add constraint FKfuhbdoh80ktg0qo34qx8qhxp 
       foreign key (subject_no) 
       references subject (id);

    alter table locker 
       add constraint FKb9rodjiho9rvjcbt6sn05k5m9 
       foreign key (student_no) 
       references student (id);

    create table enrollment (
       grade float,
        lecture_id bigint not null,
        student_id varchar(255) not null,
        primary key (lecture_id, student_id)
    ) engine=InnoDB;

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB;

    insert into hibernate_sequence values ( 1 );

    create table interest_lecture (
       student_id varchar(255) not null,
        lecture_id bigint not null,
        primary key (student_id, lecture_id)
    ) engine=InnoDB;

    create table lecture (
       id bigint not null auto_increment,
        day_of_week varchar(10),
        end_hour_min varchar(5) not null,
        lecture_days integer not null,
        lecture_hour_of_day integer not null,
        lecture_name varchar(255),
        start_hour_min varchar(5) not null,
        professor_no bigint,
        subject_no bigint,
        primary key (id)
    ) engine=InnoDB;

    create table locker (
       id bigint not null auto_increment,
        location varchar(255),
        student_no varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table professor (
       national_type varchar(31) not null,
        id bigint not null,
        address_detail varchar(100),
        city varchar(30),
        zipcode varchar(20),
        email varchar(50) not null,
        gender varchar(255),
        mobile varchar(20) not null,
        name varchar(30) not null,
        identification_number varchar(30),
        country_code varchar(5),
        passport_number varchar(30),
        primary key (id)
    ) engine=InnoDB;

    create table student (
       id varchar(255) not null,
        day_of_birth varchar(30) not null,
        email varchar(30) not null,
        name varchar(30) not null,
        password varchar(25) not null,
        primary key (id)
    ) engine=InnoDB;

    create table subject (
       id bigint not null auto_increment,
        credit float,
        description varchar(250),
        name varchar(50),
        primary key (id)
    ) engine=InnoDB;

    alter table enrollment 
       add constraint FK4wdhkk0x7fwc6flfi04la2qe1 
       foreign key (lecture_id) 
       references lecture (id);

    alter table enrollment 
       add constraint FKio7fsy3vhvfgv7c0gjk15nyk4 
       foreign key (student_id) 
       references student (id);

    alter table interest_lecture 
       add constraint FK4g1jc3edm7lur7oc2ytmeyu83 
       foreign key (lecture_id) 
       references lecture (id);

    alter table interest_lecture 
       add constraint FKmyrureawxw2w1iokuli3ncpme 
       foreign key (student_id) 
       references student (id);

    alter table lecture 
       add constraint FK6xhpl7umuo4ulh5eg1ank9qwr 
       foreign key (professor_no) 
       references professor (id);

    alter table lecture 
       add constraint FKfuhbdoh80ktg0qo34qx8qhxp 
       foreign key (subject_no) 
       references subject (id);

    alter table locker 
       add constraint FKb9rodjiho9rvjcbt6sn05k5m9 
       foreign key (student_no) 
       references student (id);
