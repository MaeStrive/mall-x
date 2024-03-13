/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : mall

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 13/03/2024 20:37:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart`  (
  `Id` int(0) NOT NULL AUTO_INCREMENT,
  `product_id` int(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `amount` int(0) NULL DEFAULT NULL,
  `member_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of cart
-- ----------------------------

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
) ENGINE = InnoDB AUTO_INCREMENT = 64 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '运动护具', 0, '', 4);
INSERT INTO `category` VALUES (2, '运动服饰', 0, NULL, 5);
INSERT INTO `category` VALUES (3, '运动鞋类', 0, NULL, 3);
INSERT INTO `category` VALUES (4, '运动项目', 0, '', 1);
INSERT INTO `category` VALUES (5, '健身器械', 0, NULL, 2);
INSERT INTO `category` VALUES (6, '健身伴侣', 0, NULL, 6);
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

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member`  (
  `Id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tel` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `status` int(0) NULL DEFAULT 0,
  `avatar` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES (1, 'user1', '123456', '111111901', '用户1', NULL, NULL, NULL);
INSERT INTO `member` VALUES (2, '1', '1', '1', '1', NULL, NULL, NULL);
INSERT INTO `member` VALUES (4, 'wahaha', '123456', '17896544521', '娃哈哈', '2024-03-12 20:35:18', 0, NULL);

-- ----------------------------
-- Table structure for member_address
-- ----------------------------
DROP TABLE IF EXISTS `member_address`;
CREATE TABLE `member_address`  (
  `Id` int(0) NOT NULL AUTO_INCREMENT,
  `province` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `city` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `area` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `member_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `member_tel` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `member_id` int(0) NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of member_address
-- ----------------------------
INSERT INTO `member_address` VALUES (1, '山东省', '青岛市', '城阳区', '1', '11111111', '公司', 1, '某某小区');
INSERT INTO `member_address` VALUES (2, '山东省', '泰安市', '泰山区', '1', '11', '家', 1, '某某小区');
INSERT INTO `member_address` VALUES (4, '1', '1', '1', '1', '1', '家', 2, '1');

-- ----------------------------
-- Table structure for order_address
-- ----------------------------
DROP TABLE IF EXISTS `order_address`;
CREATE TABLE `order_address`  (
  `Id` int(0) NOT NULL AUTO_INCREMENT,
  `province` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `city` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `area` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `member_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `member_tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `order_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 54 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of order_address
-- ----------------------------
INSERT INTO `order_address` VALUES (36, '山东省', '泰安市', '泰山区', '某某小区', '1', NULL, 36);
INSERT INTO `order_address` VALUES (37, '山东省', '泰安市', '泰山区', '某某小区', '1', NULL, 37);
INSERT INTO `order_address` VALUES (38, '山东省', '泰安市', '泰山区', '某某小区', '1', NULL, 38);
INSERT INTO `order_address` VALUES (39, '山东省', '泰安市', '泰山区', '某某小区', '1', NULL, 39);
INSERT INTO `order_address` VALUES (40, '1', '1', '1', '1', '1', NULL, 40);
INSERT INTO `order_address` VALUES (41, '山东省', '泰安市', '泰山区', '某某小区', '1', NULL, 41);
INSERT INTO `order_address` VALUES (42, '1', '1', '1', '1', '1', NULL, 42);
INSERT INTO `order_address` VALUES (43, '山东省', '泰安市', '泰山区', '某某小区', '1', NULL, 43);
INSERT INTO `order_address` VALUES (44, '山东省', '泰安市', '泰山区', '某某小区', '1', NULL, 44);
INSERT INTO `order_address` VALUES (45, '山东省', '泰安市', '泰山区', '某某小区', '1', NULL, 45);
INSERT INTO `order_address` VALUES (46, '山东省', '泰安市', '泰山区', '某某小区', '1', NULL, 46);
INSERT INTO `order_address` VALUES (47, '山东省', '泰安市', '泰山区', '某某小区', '1', NULL, 47);
INSERT INTO `order_address` VALUES (48, '1', '1', '1', '1', '1', NULL, 48);
INSERT INTO `order_address` VALUES (49, '1', '1', '1', '1', '1', NULL, 49);
INSERT INTO `order_address` VALUES (50, '山东省', '泰安市', '泰山区', '某某小区', '1', NULL, 50);
INSERT INTO `order_address` VALUES (51, '山东省', '泰安市', '泰山区', '某某小区', '1', NULL, 51);
INSERT INTO `order_address` VALUES (52, '山东省', '泰安市', '泰山区', '某某小区', '1', NULL, 52);
INSERT INTO `order_address` VALUES (53, '山东省', '泰安市', '泰山区', '某某小区', '1', NULL, 53);
INSERT INTO `order_address` VALUES (54, '山东省', '泰安市', '泰山区', '某某小区', '1', NULL, 54);

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail`  (
  `Id` int(0) NOT NULL AUTO_INCREMENT,
  `order_id` int(0) NULL DEFAULT NULL,
  `product_id` int(0) NULL DEFAULT NULL,
  `amount` int(0) NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 55 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES (36, NULL, 1, 2, 2999.00);
INSERT INTO `order_detail` VALUES (37, 37, 4, 1, 560.00);
INSERT INTO `order_detail` VALUES (38, 37, 3, 1, 2000.00);
INSERT INTO `order_detail` VALUES (39, 38, 4, 1, 560.00);
INSERT INTO `order_detail` VALUES (40, 39, 3, 3, 2000.00);
INSERT INTO `order_detail` VALUES (41, 40, 4, 1, 560.00);
INSERT INTO `order_detail` VALUES (42, 41, 4, 1, 560.00);
INSERT INTO `order_detail` VALUES (43, 42, 3, 1, 2000.00);
INSERT INTO `order_detail` VALUES (44, 43, 4, 1, 560.00);
INSERT INTO `order_detail` VALUES (45, 44, 4, 1, 560.00);
INSERT INTO `order_detail` VALUES (46, 45, 4, 1, 560.00);
INSERT INTO `order_detail` VALUES (47, 46, 4, 1, 560.00);
INSERT INTO `order_detail` VALUES (48, 47, 4, 1, 560.00);
INSERT INTO `order_detail` VALUES (49, 48, 3, 1, 2000.00);
INSERT INTO `order_detail` VALUES (50, 49, 3, 1, 2000.00);
INSERT INTO `order_detail` VALUES (51, 50, 3, 1, 2000.00);
INSERT INTO `order_detail` VALUES (52, 51, 4, 1, 560.00);
INSERT INTO `order_detail` VALUES (53, 52, 3, 1, 2000.00);
INSERT INTO `order_detail` VALUES (54, 53, 4, 1, 560.00);
INSERT INTO `order_detail` VALUES (55, 54, 4, 1, 560.00);

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info`  (
  `Id` int(0) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `member_id` int(0) NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `addid` int(0) NULL DEFAULT NULL,
  `status` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 54 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of order_info
-- ----------------------------
INSERT INTO `order_info` VALUES (36, '1667069315741978624', '2023-06-09 15:21:12', 2, 5998.00, NULL, '已取消');
INSERT INTO `order_info` VALUES (37, '1667090987907854336', '2023-06-09 16:47:19', 2, 2560.00, NULL, '已支付 ');
INSERT INTO `order_info` VALUES (38, '1667102459895496704', '2023-06-09 17:32:54', 2, 560.00, NULL, '已取消');
INSERT INTO `order_info` VALUES (39, '1667112473343410176', '2023-06-09 18:12:42', 2, 6000.00, NULL, '已支付 ');
INSERT INTO `order_info` VALUES (40, '1667138863266557952', '2023-06-09 19:57:34', 2, 560.00, NULL, '已取消');
INSERT INTO `order_info` VALUES (41, '1667139134411538432', '2023-06-09 19:58:38', 2, 560.00, NULL, '已支付 ');
INSERT INTO `order_info` VALUES (42, '1667141009852628992', '2023-06-09 20:06:05', 2, 2000.00, NULL, '已支付 ');
INSERT INTO `order_info` VALUES (43, '1667147596826673152', '2023-06-09 20:32:16', 2, 560.00, NULL, '已支付 ');
INSERT INTO `order_info` VALUES (44, '1667149596544991232', '2023-06-09 20:40:13', 2, 560.00, NULL, '已支付 ');
INSERT INTO `order_info` VALUES (45, '1667150695960178688', '2023-06-09 20:44:35', 2, 560.00, NULL, '已支付 ');
INSERT INTO `order_info` VALUES (46, '1667151896131002368', '2023-06-09 20:49:21', 2, 560.00, NULL, '已支付 ');
INSERT INTO `order_info` VALUES (47, '1667152857654226944', '2023-06-09 20:53:10', 2, 560.00, NULL, '已支付 ');
INSERT INTO `order_info` VALUES (48, '1667154061700493312', '2023-06-09 20:57:57', 2, 2000.00, NULL, '已支付 ');
INSERT INTO `order_info` VALUES (49, '1667154539096047616', '2023-06-09 20:59:51', 2, 2000.00, NULL, '已支付 ');
INSERT INTO `order_info` VALUES (50, '1667324254158430208', '2023-06-10 08:14:14', 2, 2000.00, NULL, '已支付 ');
INSERT INTO `order_info` VALUES (51, '1667341826664714240', '2023-06-10 09:24:04', 2, 560.00, NULL, '已支付 ');
INSERT INTO `order_info` VALUES (52, '1667347894694367232', '2023-06-10 09:48:11', 1, 2000.00, NULL, '已支付 ');
INSERT INTO `order_info` VALUES (53, '1667356080432226304', '2023-06-10 10:20:42', 2, 560.00, NULL, '已取消');
INSERT INTO `order_info` VALUES (54, '1667356811797209088', '2023-06-10 10:23:37', 2, 560.00, NULL, '已支付 ');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `Id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `edition` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `color` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(0) NULL DEFAULT NULL,
  `category_id` int(0) NULL DEFAULT NULL,
  `img_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (5, '斯伯丁篮球', 69.90, '良', '黄色', 0, 39, NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `Id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(0) NULL DEFAULT NULL,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `status` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '1', '1', 1, '1', '1', '1899-12-30 01:00:00', NULL);
INSERT INTO `user` VALUES (2, '2', '2', 2, '3', '男', '2023-06-02 19:24:25', NULL);
INSERT INTO `user` VALUES (5, '3', '3', 3, '3', '男', '2023-06-02 19:28:39', 0);
INSERT INTO `user` VALUES (6, '6', '6', 6, '6', '男', '2023-06-02 19:28:54', 0);
INSERT INTO `user` VALUES (7, '7', '7', 7, '7', '男', '2023-06-02 19:29:19', 0);
INSERT INTO `user` VALUES (8, 'admin', '123456', 1, '1', 'nv', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
