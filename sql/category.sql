/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : mall

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 12/03/2024 10:39:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `Id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类名称',
  `parent_id` int(0) NULL DEFAULT NULL COMMENT '父id',
  `icon_path` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标地址',
  `sequence` int(0) NULL DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '运动护具', NULL, NULL, 1);
INSERT INTO `category` VALUES (2, '运动服饰', NULL, NULL, 2);
INSERT INTO `category` VALUES (3, '运动鞋类', NULL, NULL, 3);
INSERT INTO `category` VALUES (4, '运动项目', NULL, NULL, 4);
INSERT INTO `category` VALUES (5, '健身器械', NULL, NULL, 5);
INSERT INTO `category` VALUES (6, '健身伴侣', NULL, NULL, 6);
INSERT INTO `category` VALUES (9, '护膝', 1, NULL, 1);
INSERT INTO `category` VALUES (10, '护腕', 1, NULL, 2);
INSERT INTO `category` VALUES (11, '护肘', 1, NULL, 3);
INSERT INTO `category` VALUES (12, '腰带', 1, NULL, 4);
INSERT INTO `category` VALUES (13, '发带', 1, NULL, 5);
INSERT INTO `category` VALUES (14, '发箍', 1, NULL, 6);
INSERT INTO `category` VALUES (19, '瑜伽裤', 2, NULL, 1);
INSERT INTO `category` VALUES (20, '速干衣', 2, NULL, 2);
INSERT INTO `category` VALUES (21, '运动裤', 2, NULL, 3);
INSERT INTO `category` VALUES (22, '弹力服', 2, NULL, 4);
INSERT INTO `category` VALUES (23, '弹力裤', 2, NULL, 5);
INSERT INTO `category` VALUES (29, '跑鞋', 3, NULL, 1);
INSERT INTO `category` VALUES (30, '篮球鞋', 3, NULL, 2);
INSERT INTO `category` VALUES (31, '足球鞋', 3, NULL, 3);
INSERT INTO `category` VALUES (32, '钉鞋', 3, NULL, 4);
INSERT INTO `category` VALUES (33, '运动鞋', 3, NULL, 5);
INSERT INTO `category` VALUES (39, '篮球', 4, NULL, 1);
INSERT INTO `category` VALUES (40, '足球', 4, NULL, 2);
INSERT INTO `category` VALUES (41, '羽毛球', 4, NULL, 3);
INSERT INTO `category` VALUES (42, '乒乓球', 4, NULL, 4);
INSERT INTO `category` VALUES (43, '跳绳', 4, NULL, 5);
INSERT INTO `category` VALUES (49, '哑铃', 5, NULL, 1);
INSERT INTO `category` VALUES (50, '指压板', 5, NULL, 2);
INSERT INTO `category` VALUES (51, '弹力球', 5, NULL, 3);
INSERT INTO `category` VALUES (52, '拉力器', 5, NULL, 4);
INSERT INTO `category` VALUES (59, '黑咖啡', 6, NULL, 1);
INSERT INTO `category` VALUES (60, '蛋白粉', 6, NULL, 2);
INSERT INTO `category` VALUES (61, '荞麦面', 6, NULL, 3);
INSERT INTO `category` VALUES (62, '速食鸡胸', 6, NULL, 4);
INSERT INTO `category` VALUES (63, '低脂牛奶', 6, NULL, 5);

SET FOREIGN_KEY_CHECKS = 1;
