
CREATE TABLE `departments`.`department` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(60) CHARACTER SET 'utf8' NOT NULL,
  PRIMARY KEY (`id`));



CREATE TABLE `departments`.`employee` (
  `employee_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(60) NOT NULL,
  `birthday` DATE NOT NULL,
  `salary` DOUBLE NULL,
  `address` VARCHAR(100) NULL,
  `email` VARCHAR(60) NOT NULL,
  `department_id` INT NOT NULL,
  PRIMARY KEY (`employee_id`),
  INDEX `fk_deparment_idx` (`department_id` ASC),
  CONSTRAINT `fk_deparment`
    FOREIGN KEY (`department_id`)
    REFERENCES `departments`.`department` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE);