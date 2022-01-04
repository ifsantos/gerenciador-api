CREATE TABLE `gerenciador`.`produto` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(128) NOT NULL,
  `preco` DECIMAL NOT NULL,
  `observacoes` VARCHAR(256) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);

  CREATE TABLE `gerenciador`.`item_venda` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `quantidade` INT NOT NULL,
  `id_produto` BIGINT NOT NULL,
  PRIMARY KEY (`id`));

  ALTER TABLE `gerenciador`.`item_venda` 
ADD COLUMN `id_venda` BIGINT NOT NULL AFTER `id_produto`;
  
ALTER TABLE `gerenciador`.`item_venda` 
CHANGE COLUMN `id_produto` `produto_id` BIGINT NOT NULL ,
CHANGE COLUMN `id_venda` `venda_id` BIGINT NOT NULL ;
  
  CREATE TABLE `gerenciador`.`venda` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `data` DATETIME NOT NULL,
  `id_cliente` BIGINT NOT NULL,
  `desconto` DECIMAL NULL,
  `em_aberto` TINYINT NOT NULL,
  `observacoes` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

  ALTER TABLE `gerenciador`.`venda` 
CHANGE COLUMN `id_cliente` `cliente_id` BIGINT NOT NULL ;
  
  CREATE TABLE `gerenciador`.`cliente` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(128) NOT NULL,
  `telefone` VARCHAR(30) NULL,
  `instagram` VARCHAR(128) NULL,
  `facebook` VARCHAR(128) NULL,
  `observacoes` VARCHAR(128) NULL,
  PRIMARY KEY (`id`));
  