CREATE TABLE Eixo(
     id INT AUTO_INCREMENT PRIMARY KEY,
     cod VARCHAR(10) NOT NULL,
     descricao VARCHAR(500) NOT NULL
);

create table endereco(
     endereco_id  int primary key auto_increment,
     cep varchar(20),
     numero int(6),
     logradouro varchar(500),
     complemento varchar(50)
);

CREATE TABLE Cnae(
     id INT AUTO_INCREMENT PRIMARY KEY,
     cod VARCHAR(10) NOT NULL,
     descricao VARCHAR(500) NOT NULL
);

CREATE TABLE Funcionario(
    funcionario_id INT auto_increment primary KEY,
    nome varchar(30) NOT NULL,
    numeroRegistro int(3) NOT NULL,
    turno varchar(5),
    CPF varchar(11) NOT NULL
);