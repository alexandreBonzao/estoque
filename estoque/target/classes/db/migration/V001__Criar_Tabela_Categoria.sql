create table categoria(
    id int not null primary key auto_increment,
    nome varchar(100)

);

create table produto(
    id bigint not null primary key auto_increment,
    nomeproduto varchar(100),
    preco decimal(12,2),
    categoria_id int not null
);

    alter table produto add constraint FK_categoria_produto
    foreign key(categoria_id) references categoria(id);