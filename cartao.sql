-- MySQL Script generated by MySQL Workbench
-- Mon Aug 19 10:55:04 2024
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Cliente` (
  `id_cliente` INT NOT NULL,
  `nome_cliente` VARCHAR(45) NULL,
  `cpf` CHAR(11) NULL,
  `data_nascimento` DATE NULL,
  `email` VARCHAR(45) NULL,
  `celular` VARCHAR(11) NULL,
  PRIMARY KEY (`id_cliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Cartao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Cartao` (
  `id_cartao` INT NOT NULL,
  `id_cliente_cartao` INT NOT NULL,
  `numero_cartao` VARCHAR(45) NULL,
  `limite_disponivel` FLOAT NULL,
  `senha` CHAR(4) NULL,
  `status` INT NULL,
  PRIMARY KEY (`id_cartao`),
  INDEX `id_cliente_idx` (`id_cliente_cartao` ASC) VISIBLE,
  CONSTRAINT `id_cliente_cartao`
    FOREIGN KEY (`id_cliente_cartao`)
    REFERENCES `mydb`.`Cliente` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Comerciante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Comerciante` (
  `id_comerciante` INT NOT NULL,
  `nome_comerciante` VARCHAR(45) NULL,
  `localizacao` VARCHAR(45) NULL,
  PRIMARY KEY (`id_comerciante`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Transacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Transacao` (
  `id_transacao` INT NOT NULL,
  `id_cartao_transacao` INT NOT NULL,
  `id_comerciante_transacao` INT NOT NULL,
  `data_hora_transacao` DATETIME NULL,
  `valor` FLOAT NULL,
  `autorizacao` INT NULL,
  PRIMARY KEY (`id_transacao`),
  INDEX `id_cartao_idx` (`id_cartao_transacao` ASC) VISIBLE,
  INDEX `id_comerciante_idx` (`id_comerciante_transacao` ASC) VISIBLE,
  CONSTRAINT `id_cartao_transacao`
    FOREIGN KEY (`id_cartao_transacao`)
    REFERENCES `mydb`.`Cartao` (`id_cartao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_comerciante_transacao`
    FOREIGN KEY (`id_comerciante_transacao`)
    REFERENCES `mydb`.`Comerciante` (`id_comerciante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Notificacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Notificacao` (
  `id_notificacao` INT NOT NULL,
  `id_cliente_notificacao` INT NOT NULL,
  `data_hora_notificacao` DATETIME NULL,
  `mensagem` VARCHAR(45) NULL,
  PRIMARY KEY (`id_notificacao`),
  INDEX `id_cliente_idx` (`id_cliente_notificacao` ASC) VISIBLE,
  CONSTRAINT `id_cliente_notificacao`
    FOREIGN KEY (`id_cliente_notificacao`)
    REFERENCES `mydb`.`Cliente` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
