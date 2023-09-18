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

 Date: 31/05/2023 09:46:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for problem
-- ----------------------------
DROP TABLE IF EXISTS `problem`;
CREATE TABLE `problem`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品名称',
  `dcount` int(0) NULL DEFAULT NULL COMMENT '问题药品数量',
  `dprice` float(20, 2) NULL DEFAULT NULL COMMENT '药品单价',
  `reason` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '问题原因',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 150552579 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '问题药品' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of problem
-- ----------------------------
INSERT INTO `problem` VALUES (2, '奖金', 10212, 1299212.00, '罗锐测试', '2023-05-29 15:57:29');
INSERT INTO `problem` VALUES (3, '安慕希', 1000, 12.00, '测试测试', '2023-05-29 15:57:33');
INSERT INTO `problem` VALUES (4, '安慕希', 21, 21.00, '21', '2023-05-29 15:57:35');
INSERT INTO `problem` VALUES (5, '奖金', 21, 21.00, '2121', '2023-05-29 15:57:37');
INSERT INTO `problem` VALUES (6, '白药片', 21, 21.00, '212', '2023-05-29 15:57:41');
INSERT INTO `problem` VALUES (7, '感冒灵', 12, 12.00, '三大打算打打', '2023-05-29 15:57:45');
INSERT INTO `problem` VALUES (8, '维生素C片', 121, 21.00, '212', '2023-05-29 15:57:48');
INSERT INTO `problem` VALUES (9, '维生素C片', 1212, 3213.00, '大的', '2023-05-29 15:57:50');
INSERT INTO `problem` VALUES (10, '维生素C片', 11, 111.00, '111', '2023-05-29 15:57:52');
INSERT INTO `problem` VALUES (11, '白药片', 11, 11.00, '11', '2023-05-29 15:57:54');
INSERT INTO `problem` VALUES (12, '白药片', 11, 11.00, '11', '2023-05-29 15:57:57');
INSERT INTO `problem` VALUES (13, '大的', 121, 21.00, '撒大大', '2023-05-29 15:58:04');
INSERT INTO `problem` VALUES (14, '氯化钠注射液', 90, 90.00, 'xec', '2023-05-29 15:58:00');
INSERT INTO `problem` VALUES (15, '鹿茸', 21, 12.00, 'ces1', NULL);
INSERT INTO `problem` VALUES (150552583, '安慕希', 21, 2121.00, '21', NULL);
INSERT INTO `problem` VALUES (150552584, '白药片', 3123, 21.00, '212', '2023-05-30 03:04:03');
INSERT INTO `problem` VALUES (150552585, '维生素C片', 321, 32.00, '231', '2023-05-30 03:04:24');

SET FOREIGN_KEY_CHECKS = 1;
