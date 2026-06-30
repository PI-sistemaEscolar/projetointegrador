CREATE DATABASE  IF NOT EXISTS pi_sistema_escolar;
USE pi_sistema_escolar;

DROP TABLE IF EXISTS `alunos`;
CREATE TABLE `alunos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `matricula` varchar(20) DEFAULT NULL,
  `turma_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `matricula` (`matricula`),
  KEY `turma_id` (`turma_id`),
  CONSTRAINT `alunos_ibfk_1` FOREIGN KEY (`turma_id`) REFERENCES `turmas` (`id`)
);

DROP TABLE IF EXISTS `notas`;
CREATE TABLE `notas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `aluno_id` int DEFAULT NULL,
  `nota` decimal(4,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `aluno_id` (`aluno_id`),
  CONSTRAINT `notas_ibfk_1` FOREIGN KEY (`aluno_id`) REFERENCES `alunos` (`id`) ON DELETE CASCADE
);

DROP TABLE IF EXISTS `turmas`;
CREATE TABLE `turmas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome_turma` varchar(100) DEFAULT NULL,
  turno varchar(100) not null,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nome_turma` (`nome_turma`)
);

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `usuario` varchar(100) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

select * from usuarios;


