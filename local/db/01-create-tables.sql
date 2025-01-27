
    create table organization (
        id uuid not null,
        display_name varchar(255) not null,
        organization_type varchar(255) not null check (organization_type in ('ADMIN','DEALER','WORKSHOP')),
        primary key (id)
    );

    create table user_example (
        id uuid not null,
        organization_id uuid not null,
        display_name varchar(255) not null,
        email varchar(255) not null unique,
        pass varchar(255) not null,
        role varchar(255) not null check (role in ('ADMIN','SUPER_USER','USER','GUEST')),
        primary key (id)
    );

    alter table if exists user_example 
       add constraint FKlvyx21v6retmgqcdae22cww5 
       foreign key (organization_id) 
       references organization;
