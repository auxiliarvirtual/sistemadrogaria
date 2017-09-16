CREATE DATABASE 'db_drogaria' DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE tbl_fabricante(
	fab_codigo BIGINT PRIMARY KEY AUTO_INCREMENT  NOT NULL UNIQUE,
	fab_descricao VARCHAR(50)
	
)

CREATE TABLE tbl_produto(
	pro_codigo BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL UNIQUE,
	pro_descricao varchar(50),
	pro_preco decimal(7,2) NOT NULL,
	pro_quantidade int NOT NULL
	
)

ALTER TABLE tbl_produto ADD COLUMN `fab_codigo` bigint
ALTER TABLE tbl_produto ADD CONSTRAINT fk_cod_fabricante FOREIGN KEY (`fab_codigo`) REFERENCES tbl_fabricante  (`fab_codigo`);

CREATE TABLE tbl_funcionario(
	fun_codigo bigint PRIMARY KEY AUTO_INCREMENT, 
	fun_nome varchar(60),
	fun_cpf varchar(14) UNIQUE KEY,
	fun_senha varchar(32) NOT NULL,
	fun_funcao VARCHAR(50) NOT NULL

)


CREATE TABLE tbl_venda(
	ven_codigo  BIGINT PRIMARY KEY AUTO_INCREMENT,
	ven_horario TIMESTAMP NOT NULL,
	ven_valor_total decimal(7,2) NOT NULL

)

ALTER TABLE tbl_venda ADD COLUMN `fun_codigo` bigint;
ALTER TABLE tbl_venda ADD CONSTRAINT fk_cod_funcionario FOREIGN KEY (`fun_codigo`) REFERENCES tbl_funcionario (`fun_codigo`);

CREATE TABLE tbl_item(
	ite_codigo bigint not null PRIMARY KEY AUTO_INCREMENT,
	ite_quantidade INT NOT NULL,
	ite_valor_parcial DECIMAL(7,2) NOT NULL

)

ALTER TABLE tbl_item ADD COLUMN `ven_codigo` BIGINT;
ALTER TABLE tbl_item ADD COLUMN `pro_codigo` BIGINT;

ALTER TABLE tbl_item ADD CONSTRAINT fk_ven_codigo FOREIGN KEY (`ven_codigo`) REFERENCES tbl_venda (`ven_codigo`);
ALTER TABLE tbl_item ADD CONSTRAINT fk_pro_codigo FOREIGN KEY (`pro_codigo`) REFERENCES tbl_produto (`pro_codigo`);
