/*
 Navicat Premium Data Transfer

 Source Server         : MYSQL
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : mybatis

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 31/05/2023 09:46:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for druginfo
-- ----------------------------
DROP TABLE IF EXISTS `druginfo`;
CREATE TABLE `druginfo`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `supplier` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商',
  `producttime` date NULL DEFAULT NULL COMMENT '生产时间',
  `warrenty` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '保质期（月）',
  `number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品编码',
  `price` float(20, 2) NULL DEFAULT NULL COMMENT '价格',
  `stock` int(0) NULL DEFAULT NULL COMMENT '库存',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '药品信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of druginfo
-- ----------------------------
INSERT INTO `druginfo` VALUES (2, '感冒灵', '哈药六厂', '2020-01-24', '231', '10013', 22.50, 50);
INSERT INTO `druginfo` VALUES (3, '白药片', '云南白药', '2021-02-02', '36', '2021052', 30.50, 100);
INSERT INTO `druginfo` VALUES (4, '维生素C片', '北京大学', '2023-05-05', '121', '2023054', 11.00, 22);
INSERT INTO `druginfo` VALUES (6, '奖金', '云南白药', '2023-05-02', '12', '05450', 12.00, 12);
INSERT INTO `druginfo` VALUES (7, '大的', '北京制药厂', '2023-05-09', '211', '1212', 121.00, 212);
INSERT INTO `druginfo` VALUES (8, '安慕希', '哈药六厂', '2023-05-04', '12', '0505', 40.00, 4000);
INSERT INTO `druginfo` VALUES (9, '氯化钠注射液', '云南白药', '2023-05-05', '24', '0555', 26.50, 2000);
INSERT INTO `druginfo` VALUES (10, '云芝', '哈药六厂', '2023-05-01', '222', '212', 999.00, 999);
INSERT INTO `druginfo` VALUES (11, '鹿茸', '北京制药厂', '2023-04-30', '1', '111', 656.00, 12);
INSERT INTO `druginfo` VALUES (12, '葡萄糖', '哈药六厂', '2023-05-05', '212', '212', 2122.00, 12);
INSERT INTO `druginfo` VALUES (13, '葡萄糖注射液', '哈药六厂', '2023-05-09', '212', '12121', 212.00, 212);
INSERT INTO `druginfo` VALUES (14, '鹿茸', '哈药六厂', '2023-05-16', '1212', '212', 1212.00, 12);
INSERT INTO `druginfo` VALUES (750338050, '天空之城', '云南白药', '2023-05-29', '321', '2311', 32.00, 321);
INSERT INTO `druginfo` VALUES (750338051, '葡萄糖', '北京制药厂', '2023-05-29', '31', '2', 31.00, 321);

SET FOREIGN_KEY_CHECKS = 1;
