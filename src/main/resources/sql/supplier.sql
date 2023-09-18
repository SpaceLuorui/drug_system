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

 Date: 31/05/2023 09:45:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商名称',
  `content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商描述',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '供应商' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES (1, '哈药六厂', '东北很知名的企业之一', '2018-01-17 11:52:53');
INSERT INTO `supplier` VALUES (2, '云南白药', '云南白药是云南著名的中成药，由名贵药材制成，具有化瘀止血、活血止痛、解毒消肿之功效。', '2021-02-18 14:20:49');
INSERT INTO `supplier` VALUES (3, '北京制药厂', '北京人民大学测试', '2023-05-04 11:04:10');
INSERT INTO `supplier` VALUES (4, '打算', '大萨达', '2023-05-04 11:04:47');
INSERT INTO `supplier` VALUES (5, '从性支出', '发大风车', '2023-05-04 11:04:57');
INSERT INTO `supplier` VALUES (7, '天空之城', '发给', '2023-05-30 03:22:09');

SET FOREIGN_KEY_CHECKS = 1;
