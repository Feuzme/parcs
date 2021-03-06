-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema parcs
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema parcs
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `parcs` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `parcs` ;

-- -----------------------------------------------------
-- Table `parcs`.`parc`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `parcs`.`parc` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NULL,
  `capacite` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `parcs`.`attraction`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `parcs`.`attraction` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NULL,
  `nbPlaces` INT NULL,
  `parc_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_attraction_parc1_idx` (`parc_id` ASC) VISIBLE,
  CONSTRAINT `fk_attraction_parc1`
    FOREIGN KEY (`parc_id`)
    REFERENCES `parcs`.`parc` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `parcs`.`visiteur`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `parcs`.`visiteur` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NULL,
  `prenom` VARCHAR(45) NULL,
  `age` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `parcs`.`ticket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `parcs`.`ticket` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `prix` INT NULL,
  `visiteur_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ticket_visiteur_idx` (`visiteur_id` ASC) VISIBLE,
  CONSTRAINT `fk_ticket_visiteur`
    FOREIGN KEY (`visiteur_id`)
    REFERENCES `parcs`.`visiteur` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `parcs`.`attraction_has_visiteur`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `parcs`.`attraction_has_visiteur` (
  `attraction_id` INT NOT NULL,
  `visiteur_id` INT NOT NULL,
  PRIMARY KEY (`attraction_id`, `visiteur_id`),
  INDEX `fk_attraction_has_visiteur_visiteur1_idx` (`visiteur_id` ASC) VISIBLE,
  INDEX `fk_attraction_has_visiteur_attraction1_idx` (`attraction_id` ASC) VISIBLE,
  CONSTRAINT `fk_attraction_has_visiteur_attraction1`
    FOREIGN KEY (`attraction_id`)
    REFERENCES `parcs`.`attraction` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_attraction_has_visiteur_visiteur1`
    FOREIGN KEY (`visiteur_id`)
    REFERENCES `parcs`.`visiteur` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
