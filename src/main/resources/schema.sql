create table product
(
   permissionId int not null,
   name varchar(255) not null,
   value int not null,
   stock int not null,
   totalAmount int not null,
   primary key(permissionId)
);