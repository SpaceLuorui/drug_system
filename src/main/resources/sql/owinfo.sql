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

 Date: 31/05/2023 09:46:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for owinfo
-- ----------------------------
DROP TABLE IF EXISTS `owinfo`;
CREATE TABLE `owinfo`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品名称',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出库/入库',
  `count` int(0) NULL DEFAULT NULL COMMENT '数量',
  `operator` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作人',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '出入库' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of owinfo
-- ----------------------------
INSERT INTO `owinfo` VALUES (1, '白药片', '出库', 3, '华佗', '2021-02-20 14:21:53');
INSERT INTO `owinfo` VALUES (2, '感冒灵', '入库', 20, '扁鹊', '2021-02-20 14:22:12');
INSERT INTO `owinfo` VALUES (4, '葡萄糖注射液', '入库', 9999, '安慕希', NULL);
INSERT INTO `owinfo` VALUES (5, '维生素C片', '入库', 212, '212', NULL);
INSERT INTO `owinfo` VALUES (6, '云芝', '出库', 12, '212', NULL);
INSERT INTO `owinfo` VALUES (7, '感冒灵', '出库', 32, '李白', NULL);
INSERT INTO `owinfo` VALUES (8, '安慕希', '入库', 23, '赵云', '2023-05-30 05:39:06');
INSERT INTO `owinfo` VALUES (9, '氯化钠注射液', '入库', 212, '王菲', '2023-05-30 05:39:42');

SET FOREIGN_KEY_CHECKS = 1;
