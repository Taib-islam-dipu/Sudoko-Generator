/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 100125
 Source Host           : localhost:3306
 Source Schema         : sudokodb

 Target Server Type    : MySQL
 Target Server Version : 100125
 File Encoding         : 65001

 Date: 29/04/2019 09:01:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for player
-- ----------------------------
DROP TABLE IF EXISTS `player`;
CREATE TABLE `player`  (
  `playerId` int(5) NOT NULL AUTO_INCREMENT,
  `email` varchar(35) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `uname` varchar(35) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `password` varchar(35) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `score` int(5) NULL DEFAULT NULL,
  PRIMARY KEY (`playerId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of player
-- ----------------------------
INSERT INTO `player` VALUES (26, 'dante@email.com', 'dante', '1234', 0);
INSERT INTO `player` VALUES (28, 'a', 'a', 'a', 0);
INSERT INTO `player` VALUES (29, 'b', 'b', 'b', 0);
INSERT INTO `player` VALUES (30, 'c', 'c', 'c', 0);

SET FOREIGN_KEY_CHECKS = 1;
