create table if not exists categoria (
    categoria_id integer not null auto_increment,
    descricao varchar(255),
    primary key (categoria_id)
);
create table if not exists cliente (
    cliente_id uuid not null,
    cpf varchar(255) not null,
    email varchar(255) not null,
    nome varchar(255) not null,
    primary key (cliente_id)
);
create table if not exists produto (
    categoria_id integer,
    preco float(53) not null,
    produto_id uuid not null,
    descricao varchar(255) not null,
    nome varchar(255) not null,
    primary key (produto_id)
) engine=InnoDB;