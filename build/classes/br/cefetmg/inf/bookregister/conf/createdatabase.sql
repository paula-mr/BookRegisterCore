/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Aluno
 * Created: 29/06/2017
 */

DROP TABLE IF EXISTS `book` CASCADE;

CREATE TABLE IF NOT EXISTS `book` (
  `COD_id` int(11) NOT NULL  AUTO_INCREMENT,
  `TXT_name` varchar(60) COLLATE utf8_bin NOT NULL,
  `TXT_author` varchar(60) COLLATE utf8_bin NOT NULL,
  `NUM_ISBN` int(11) NOT NULL,
  `NUM_volume` int(11) NOT NULL,
  `DAT_date` date NOT NULL,
  `TXT_editor` varchar(60) COLLATE utf8_bin NOT NULL,
  `NUM_pages` int(11) NOT NULL,
  PRIMARY KEY (`COD_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
