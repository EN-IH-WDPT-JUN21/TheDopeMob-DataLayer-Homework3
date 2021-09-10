
    create table account (
       account_id bigint not null auto_increment,
        city varchar(255),
        company_name varchar(255),
        country varchar(255),
        employee_count integer,
        industry_type integer,
        primary key (account_id)
    ) engine=InnoDB

    create table contact (
       contact_id bigint not null auto_increment,
        company_name varchar(255),
        email varchar(255),
        name varchar(255),
        phone_number varchar(255),
        primary key (contact_id)
    ) engine=InnoDB

    create table lead_contact (
       lead_id bigint not null auto_increment,
        company_name varchar(255),
        email varchar(255),
        name varchar(255),
        phone_number varchar(255),
        sales_rep_id bigint,
        primary key (lead_id)
    ) engine=InnoDB

    create table opportunity (
       opportunity_id bigint not null auto_increment,
        product_type varchar(255),
        quantity integer not null,
        status varchar(255),
        account_id bigint,
        contact_id bigint not null,
        sales_rep_id bigint not null,
        primary key (opportunity_id)
    ) engine=InnoDB

    create table sales_rep (
       sales_rep_id bigint not null auto_increment,
        name varchar(255),
        primary key (sales_rep_id)
    ) engine=InnoDB

    alter table account 
       add constraint UK_cj0gox4iypf9xyh7jmhuubq82 unique (company_name)

    alter table contact 
       add constraint UK_gnqwbwwcn7x0m5jlt4158dass unique (email)

    alter table lead_contact 
       add constraint UK_jc6ud34fbotfwv6omsah24lqr unique (email)

    alter table lead_contact 
       add constraint FKjv73wtf8wtucjtm7q7149byys 
       foreign key (sales_rep_id) 
       references sales_rep (sales_rep_id)

    alter table opportunity 
       add constraint FK9mvhqgny93la8u8k2gd531nex 
       foreign key (account_id) 
       references account (account_id)

    alter table opportunity 
       add constraint FKo5iiy8cn6h1f2kae3s49yteot 
       foreign key (contact_id) 
       references contact (contact_id)

    alter table opportunity 
       add constraint FK4k71m0964k1f2505y0vtta83l 
       foreign key (sales_rep_id) 
       references sales_rep (sales_rep_id)

    create table account (
       account_id bigint not null auto_increment,
        city varchar(255),
        company_name varchar(255),
        country varchar(255),
        employee_count integer,
        industry_type integer,
        primary key (account_id)
    ) engine=InnoDB

    create table contact (
       contact_id bigint not null auto_increment,
        company_name varchar(255),
        email varchar(255),
        name varchar(255),
        phone_number varchar(255),
        primary key (contact_id)
    ) engine=InnoDB

    create table lead_contact (
       lead_id bigint not null auto_increment,
        company_name varchar(255),
        email varchar(255),
        name varchar(255),
        phone_number varchar(255),
        sales_rep_id bigint,
        primary key (lead_id)
    ) engine=InnoDB

    create table opportunity (
       opportunity_id bigint not null auto_increment,
        product_type varchar(255),
        quantity integer not null,
        status varchar(255),
        account_id bigint,
        contact_id bigint not null,
        sales_rep_id bigint not null,
        primary key (opportunity_id)
    ) engine=InnoDB

    create table sales_rep (
       sales_rep_id bigint not null auto_increment,
        name varchar(255),
        primary key (sales_rep_id)
    ) engine=InnoDB

    alter table account 
       add constraint UK_cj0gox4iypf9xyh7jmhuubq82 unique (company_name)

    alter table contact 
       add constraint UK_gnqwbwwcn7x0m5jlt4158dass unique (email)

    alter table lead_contact 
       add constraint UK_jc6ud34fbotfwv6omsah24lqr unique (email)

    alter table lead_contact 
       add constraint FKjv73wtf8wtucjtm7q7149byys 
       foreign key (sales_rep_id) 
       references sales_rep (sales_rep_id)

    alter table opportunity 
       add constraint FK9mvhqgny93la8u8k2gd531nex 
       foreign key (account_id) 
       references account (account_id)

    alter table opportunity 
       add constraint FKo5iiy8cn6h1f2kae3s49yteot 
       foreign key (contact_id) 
       references contact (contact_id)

    alter table opportunity 
       add constraint FK4k71m0964k1f2505y0vtta83l 
       foreign key (sales_rep_id) 
       references sales_rep (sales_rep_id)

    create table account (
       account_id bigint not null auto_increment,
        city varchar(255),
        company_name varchar(255),
        country varchar(255),
        employee_count integer,
        industry_type integer,
        primary key (account_id)
    ) engine=InnoDB

    create table contact (
       contact_id bigint not null auto_increment,
        company_name varchar(255),
        email varchar(255),
        name varchar(255),
        phone_number varchar(255),
        primary key (contact_id)
    ) engine=InnoDB

    create table lead_contact (
       lead_id bigint not null auto_increment,
        company_name varchar(255),
        email varchar(255),
        name varchar(255),
        phone_number varchar(255),
        sales_rep_id bigint,
        primary key (lead_id)
    ) engine=InnoDB

    create table opportunity (
       opportunity_id bigint not null auto_increment,
        product_type varchar(255),
        quantity integer not null,
        status varchar(255),
        account_id bigint,
        contact_id bigint not null,
        sales_rep_id bigint not null,
        primary key (opportunity_id)
    ) engine=InnoDB

    create table sales_rep (
       sales_rep_id bigint not null auto_increment,
        name varchar(255),
        primary key (sales_rep_id)
    ) engine=InnoDB

    alter table account 
       add constraint UK_cj0gox4iypf9xyh7jmhuubq82 unique (company_name)

    alter table contact 
       add constraint UK_gnqwbwwcn7x0m5jlt4158dass unique (email)

    alter table lead_contact 
       add constraint UK_jc6ud34fbotfwv6omsah24lqr unique (email)

    alter table lead_contact 
       add constraint FKjv73wtf8wtucjtm7q7149byys 
       foreign key (sales_rep_id) 
       references sales_rep (sales_rep_id)

    alter table opportunity 
       add constraint FK9mvhqgny93la8u8k2gd531nex 
       foreign key (account_id) 
       references account (account_id)

    alter table opportunity 
       add constraint FKo5iiy8cn6h1f2kae3s49yteot 
       foreign key (contact_id) 
       references contact (contact_id)

    alter table opportunity 
       add constraint FK4k71m0964k1f2505y0vtta83l 
       foreign key (sales_rep_id) 
       references sales_rep (sales_rep_id)

    create table account (
       account_id bigint not null auto_increment,
        city varchar(255),
        company_name varchar(255),
        country varchar(255),
        employee_count integer,
        industry_type integer,
        primary key (account_id)
    ) engine=InnoDB

    create table contact (
       contact_id bigint not null auto_increment,
        company_name varchar(255),
        email varchar(255),
        name varchar(255),
        phone_number varchar(255),
        primary key (contact_id)
    ) engine=InnoDB

    create table lead_contact (
       lead_id bigint not null auto_increment,
        company_name varchar(255),
        email varchar(255),
        name varchar(255),
        phone_number varchar(255),
        sales_rep_id bigint,
        primary key (lead_id)
    ) engine=InnoDB

    create table opportunity (
       opportunity_id bigint not null auto_increment,
        product_type varchar(255),
        quantity integer not null,
        status varchar(255),
        account_id bigint,
        contact_id bigint not null,
        sales_rep_id bigint not null,
        primary key (opportunity_id)
    ) engine=InnoDB

    create table sales_rep (
       sales_rep_id bigint not null auto_increment,
        name varchar(255),
        primary key (sales_rep_id)
    ) engine=InnoDB

    alter table account 
       add constraint UK_cj0gox4iypf9xyh7jmhuubq82 unique (company_name)

    alter table contact 
       add constraint UK_gnqwbwwcn7x0m5jlt4158dass unique (email)

    alter table lead_contact 
       add constraint UK_jc6ud34fbotfwv6omsah24lqr unique (email)

    alter table lead_contact 
       add constraint FKjv73wtf8wtucjtm7q7149byys 
       foreign key (sales_rep_id) 
       references sales_rep (sales_rep_id)

    alter table opportunity 
       add constraint FK9mvhqgny93la8u8k2gd531nex 
       foreign key (account_id) 
       references account (account_id)

    alter table opportunity 
       add constraint FKo5iiy8cn6h1f2kae3s49yteot 
       foreign key (contact_id) 
       references contact (contact_id)

    alter table opportunity 
       add constraint FK4k71m0964k1f2505y0vtta83l 
       foreign key (sales_rep_id) 
       references sales_rep (sales_rep_id)

    create table account (
       account_id bigint not null auto_increment,
        city varchar(255),
        company_name varchar(255),
        country varchar(255),
        employee_count integer,
        industry_type integer,
        primary key (account_id)
    ) engine=InnoDB

    create table contact (
       contact_id bigint not null auto_increment,
        company_name varchar(255),
        email varchar(255),
        name varchar(255),
        phone_number varchar(255),
        primary key (contact_id)
    ) engine=InnoDB

    create table lead_contact (
       lead_id bigint not null auto_increment,
        company_name varchar(255),
        email varchar(255),
        name varchar(255),
        phone_number varchar(255),
        sales_rep_id bigint,
        primary key (lead_id)
    ) engine=InnoDB

    create table opportunity (
       opportunity_id bigint not null auto_increment,
        product_type varchar(255),
        quantity integer not null,
        status varchar(255),
        account_id bigint,
        contact_id bigint not null,
        sales_rep_id bigint not null,
        primary key (opportunity_id)
    ) engine=InnoDB

    create table sales_rep (
       sales_rep_id bigint not null auto_increment,
        name varchar(255),
        primary key (sales_rep_id)
    ) engine=InnoDB

    alter table account 
       add constraint UK_cj0gox4iypf9xyh7jmhuubq82 unique (company_name)

    alter table contact 
       add constraint UK_gnqwbwwcn7x0m5jlt4158dass unique (email)

    alter table lead_contact 
       add constraint UK_jc6ud34fbotfwv6omsah24lqr unique (email)

    alter table lead_contact 
       add constraint FKjv73wtf8wtucjtm7q7149byys 
       foreign key (sales_rep_id) 
       references sales_rep (sales_rep_id)

    alter table opportunity 
       add constraint FK9mvhqgny93la8u8k2gd531nex 
       foreign key (account_id) 
       references account (account_id)

    alter table opportunity 
       add constraint FKo5iiy8cn6h1f2kae3s49yteot 
       foreign key (contact_id) 
       references contact (contact_id)

    alter table opportunity 
       add constraint FK4k71m0964k1f2505y0vtta83l 
       foreign key (sales_rep_id) 
       references sales_rep (sales_rep_id)

    create table account (
       account_id bigint not null auto_increment,
        city varchar(255),
        company_name varchar(255),
        country varchar(255),
        employee_count integer,
        industry_type integer,
        primary key (account_id)
    ) engine=InnoDB

    create table contact (
       contact_id bigint not null auto_increment,
        company_name varchar(255),
        email varchar(255),
        name varchar(255),
        phone_number varchar(255),
        primary key (contact_id)
    ) engine=InnoDB

    create table lead_contact (
       lead_id bigint not null auto_increment,
        company_name varchar(255),
        email varchar(255),
        name varchar(255),
        phone_number varchar(255),
        sales_rep_id bigint,
        primary key (lead_id)
    ) engine=InnoDB

    create table opportunity (
       opportunity_id bigint not null auto_increment,
        product_type varchar(255),
        quantity integer not null,
        status varchar(255),
        account_id bigint,
        contact_id bigint not null,
        sales_rep_id bigint not null,
        primary key (opportunity_id)
    ) engine=InnoDB

    create table sales_rep (
       sales_rep_id bigint not null auto_increment,
        name varchar(255),
        primary key (sales_rep_id)
    ) engine=InnoDB

    alter table account 
       add constraint UK_cj0gox4iypf9xyh7jmhuubq82 unique (company_name)

    alter table contact 
       add constraint UK_gnqwbwwcn7x0m5jlt4158dass unique (email)

    alter table lead_contact 
       add constraint UK_jc6ud34fbotfwv6omsah24lqr unique (email)

    alter table lead_contact 
       add constraint FKjv73wtf8wtucjtm7q7149byys 
       foreign key (sales_rep_id) 
       references sales_rep (sales_rep_id)

    alter table opportunity 
       add constraint FK9mvhqgny93la8u8k2gd531nex 
       foreign key (account_id) 
       references account (account_id)

    alter table opportunity 
       add constraint FKo5iiy8cn6h1f2kae3s49yteot 
       foreign key (contact_id) 
       references contact (contact_id)

    alter table opportunity 
       add constraint FK4k71m0964k1f2505y0vtta83l 
       foreign key (sales_rep_id) 
       references sales_rep (sales_rep_id)

    create table account (
       account_id bigint not null auto_increment,
        city varchar(255),
        company_name varchar(255),
        country varchar(255),
        employee_count integer,
        industry_type integer,
        primary key (account_id)
    ) engine=InnoDB

    create table contact (
       contact_id bigint not null auto_increment,
        company_name varchar(255),
        email varchar(255),
        name varchar(255),
        phone_number varchar(255),
        primary key (contact_id)
    ) engine=InnoDB

    create table lead_contact (
       lead_id bigint not null auto_increment,
        company_name varchar(255),
        email varchar(255),
        name varchar(255),
        phone_number varchar(255),
        sales_rep_id bigint,
        primary key (lead_id)
    ) engine=InnoDB

    create table opportunity (
       opportunity_id bigint not null auto_increment,
        product_type varchar(255),
        quantity integer not null,
        status varchar(255),
        account_id bigint,
        contact_id bigint not null,
        sales_rep_id bigint not null,
        primary key (opportunity_id)
    ) engine=InnoDB

    create table sales_rep (
       sales_rep_id bigint not null auto_increment,
        name varchar(255),
        primary key (sales_rep_id)
    ) engine=InnoDB

    alter table account 
       add constraint UK_cj0gox4iypf9xyh7jmhuubq82 unique (company_name)

    alter table contact 
       add constraint UK_gnqwbwwcn7x0m5jlt4158dass unique (email)

    alter table lead_contact 
       add constraint UK_jc6ud34fbotfwv6omsah24lqr unique (email)

    alter table lead_contact 
       add constraint FKjv73wtf8wtucjtm7q7149byys 
       foreign key (sales_rep_id) 
       references sales_rep (sales_rep_id)

    alter table opportunity 
       add constraint FK9mvhqgny93la8u8k2gd531nex 
       foreign key (account_id) 
       references account (account_id)

    alter table opportunity 
       add constraint FKo5iiy8cn6h1f2kae3s49yteot 
       foreign key (contact_id) 
       references contact (contact_id)

    alter table opportunity 
       add constraint FK4k71m0964k1f2505y0vtta83l 
       foreign key (sales_rep_id) 
       references sales_rep (sales_rep_id)

    create table account (
       account_id bigint not null auto_increment,
        city varchar(255),
        company_name varchar(255),
        country varchar(255),
        employee_count integer,
        industry_type integer,
        primary key (account_id)
    ) engine=InnoDB

    create table contact (
       contact_id bigint not null auto_increment,
        company_name varchar(255),
        email varchar(255),
        name varchar(255),
        phone_number varchar(255),
        primary key (contact_id)
    ) engine=InnoDB

    create table lead_contact (
       lead_id bigint not null auto_increment,
        company_name varchar(255),
        email varchar(255),
        name varchar(255),
        phone_number varchar(255),
        sales_rep_id bigint,
        primary key (lead_id)
    ) engine=InnoDB

    create table opportunity (
       opportunity_id bigint not null auto_increment,
        product_type varchar(255),
        quantity integer not null,
        status varchar(255),
        account_id bigint,
        contact_id bigint not null,
        sales_rep_id bigint not null,
        primary key (opportunity_id)
    ) engine=InnoDB

    create table sales_rep (
       sales_rep_id bigint not null auto_increment,
        name varchar(255),
        primary key (sales_rep_id)
    ) engine=InnoDB

    alter table account 
       add constraint UK_cj0gox4iypf9xyh7jmhuubq82 unique (company_name)

    alter table contact 
       add constraint UK_gnqwbwwcn7x0m5jlt4158dass unique (email)

    alter table lead_contact 
       add constraint UK_jc6ud34fbotfwv6omsah24lqr unique (email)

    alter table lead_contact 
       add constraint FKjv73wtf8wtucjtm7q7149byys 
       foreign key (sales_rep_id) 
       references sales_rep (sales_rep_id)

    alter table opportunity 
       add constraint FK9mvhqgny93la8u8k2gd531nex 
       foreign key (account_id) 
       references account (account_id)

    alter table opportunity 
       add constraint FKo5iiy8cn6h1f2kae3s49yteot 
       foreign key (contact_id) 
       references contact (contact_id)

    alter table opportunity 
       add constraint FK4k71m0964k1f2505y0vtta83l 
       foreign key (sales_rep_id) 
       references sales_rep (sales_rep_id)
