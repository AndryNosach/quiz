-- MySQL Script generated by MySQL Workbench
-- Wed May 16 17:54:04 2018
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema quiz-project
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema quiz-project
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `quiz-project` DEFAULT CHARACTER SET utf8mb4 ;
USE `quiz-project` ;

-- -----------------------------------------------------
-- Table `quiz-project`.`subjects`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `quiz-project`.`subjects` ;

CREATE TABLE IF NOT EXISTS `quiz-project`.`subjects` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `subject` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 15
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `quiz-project`.`quizzies`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `quiz-project`.`quizzies` ;

CREATE TABLE IF NOT EXISTS `quiz-project`.`quizzies` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `theme` VARCHAR(45) NOT NULL,
  `author` VARCHAR(45) NOT NULL,
  `subjects_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`, `subjects_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_quizzies_subjects_idx` (`subjects_id` ASC),
  CONSTRAINT `fk_quizzies_subjects`
    FOREIGN KEY (`subjects_id`)
    REFERENCES `quiz-project`.`subjects` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `quiz-project`.`questions`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `quiz-project`.`questions` ;

CREATE TABLE IF NOT EXISTS `quiz-project`.`questions` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `issue` VARCHAR(255) NOT NULL,
  `quiz_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`, `quiz_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_quiestions_quizzies1_idx` (`quiz_id` ASC),
  CONSTRAINT `fk_quiestions_quizzies1`
    FOREIGN KEY (`quiz_id`)
    REFERENCES `quiz-project`.`quizzies` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `quiz-project`.`answers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `quiz-project`.`answers` ;

CREATE TABLE IF NOT EXISTS `quiz-project`.`answers` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `answer` VARCHAR(255) NOT NULL,
  `correct` TINYINT(4) NOT NULL DEFAULT '1',
  `question_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`, `question_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_answers_quiestions1_idx` (`question_id` ASC),
  CONSTRAINT `fk_answers_quiestions1`
    FOREIGN KEY (`question_id`)
    REFERENCES `quiz-project`.`questions` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 14
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `quiz-project`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `quiz-project`.`users` ;

CREATE TABLE IF NOT EXISTS `quiz-project`.`users` (
  `id` INT(11) NOT NULL DEFAULT '0',
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
