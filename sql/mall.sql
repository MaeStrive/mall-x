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

 Date: 27/03/2024 12:05:21
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
) ENGINE = InnoDB AUTO_INCREMENT = 67 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

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
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES (1, 'user1', '123456', '111111901', '用户1', NULL, NULL, NULL);
INSERT INTO `member` VALUES (4, 'wahaha', '123456', '17896544521', '娃哈哈', '2024-03-12 20:35:18', 0, NULL);
INSERT INTO `member` VALUES (5, '6', '66', '17662367890', '滴滴滴', '2024-03-27 10:21:38', 0, NULL);
INSERT INTO `member` VALUES (6, '8', '6', '17662367890', '滴滴滴', '2024-03-27 10:21:50', 0, NULL);
INSERT INTO `member` VALUES (7, '9', '9', '17662368999', '9', '2024-03-27 10:36:52', 0, NULL);
INSERT INTO `member` VALUES (8, '4', '4', '17668990908', '阿狗', '2024-03-27 10:43:35', 0, NULL);
INSERT INTO `member` VALUES (9, '996', '996', '17668990908', '阿狗', '2024-03-27 10:44:45', 0, NULL);

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
  `member_tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `member_id` int(0) NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of member_address
-- ----------------------------
INSERT INTO `member_address` VALUES (1, '山东省', '青岛市', '城阳区', '1', '11111111', '公司', 1, '某某小区');
INSERT INTO `member_address` VALUES (2, '山东省', '泰安市', '泰山区', '1', '11', '家', 1, '某某小区');
INSERT INTO `member_address` VALUES (8, '987', '987', '987', '987', '987', '家', 9, '987');
INSERT INTO `member_address` VALUES (10, '山东省', '泰安市', '泰山区', '阿狗', '17662362990', '公司', 9, '阿狗大街');
INSERT INTO `member_address` VALUES (11, '山东省', '青岛市', '胶州市', '大叔', '18567890986', '公司', 9, '阿狗大街');

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
) ENGINE = InnoDB AUTO_INCREMENT = 67 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of order_address
-- ----------------------------
INSERT INTO `order_address` VALUES (67, '山东省', '青岛市', '胶州市', '阿狗大街', '大叔', '18567890986', 67);
INSERT INTO `order_address` VALUES (68, '山东省', '泰安市', '泰山区', '阿狗大街', '阿狗', '17662362990', 68);
INSERT INTO `order_address` VALUES (69, '山东省', '青岛市', '胶州市', '阿狗大街', '大叔', '18567890986', 69);
INSERT INTO `order_address` VALUES (70, '山东省', '青岛市', '城阳区', '某某小区', '1', '11111111', 70);

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
) ENGINE = InnoDB AUTO_INCREMENT = 70 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES (60, 58, 8, 1, 399.00);
INSERT INTO `order_detail` VALUES (61, 59, 8, 1, 399.00);
INSERT INTO `order_detail` VALUES (62, 59, 7, 1, 50.00);
INSERT INTO `order_detail` VALUES (63, 60, 5, 1, 69.90);
INSERT INTO `order_detail` VALUES (64, 61, 6, 1, 20.00);
INSERT INTO `order_detail` VALUES (65, 62, 7, 1, 50.00);
INSERT INTO `order_detail` VALUES (66, 63, 6, 2, 20.00);
INSERT INTO `order_detail` VALUES (67, 64, 6, 7, 20.00);
INSERT INTO `order_detail` VALUES (68, 65, 6, 1, 20.00);
INSERT INTO `order_detail` VALUES (69, 66, 14, 1, 199.90);
INSERT INTO `order_detail` VALUES (70, 67, 14, 2, 199.90);
INSERT INTO `order_detail` VALUES (71, 68, 14, 3, 199.90);
INSERT INTO `order_detail` VALUES (72, 69, 7, 2, 50.00);
INSERT INTO `order_detail` VALUES (73, 70, 7, 1, 50.00);

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
) ENGINE = InnoDB AUTO_INCREMENT = 67 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of order_info
-- ----------------------------
INSERT INTO `order_info` VALUES (58, '1767907995850719232', '2024-03-13 21:38:07', 2, 399.00, NULL, '待支付');
INSERT INTO `order_info` VALUES (59, '1767913225732562944', '2024-03-13 21:58:54', 2, 449.00, NULL, '待支付');
INSERT INTO `order_info` VALUES (60, '1770781012251426816', '2024-03-21 19:54:27', 2, 69.90, NULL, '待支付');
INSERT INTO `order_info` VALUES (61, '1772250050770944000', '2024-03-25 21:11:54', 2, 20.00, NULL, '待支付');
INSERT INTO `order_info` VALUES (62, '1772250417848090624', '2024-03-25 21:13:21', 2, 50.00, NULL, '待支付');
INSERT INTO `order_info` VALUES (63, '1772250696253407232', '2024-03-25 21:14:27', 2, 40.00, NULL, '待支付');
INSERT INTO `order_info` VALUES (64, '1772588743226486784', '2024-03-26 19:37:44', 2, 140.00, NULL, '待支付');
INSERT INTO `order_info` VALUES (65, '1772588971304349696', '2024-03-26 19:38:39', 2, 20.00, NULL, '待支付');
INSERT INTO `order_info` VALUES (66, '1772813575654363136', '2024-03-27 10:31:08', 5, 199.90, NULL, '待支付');
INSERT INTO `order_info` VALUES (67, '1772829914053951488', '2024-03-27 11:36:04', 9, 399.80, NULL, '待支付');
INSERT INTO `order_info` VALUES (68, '1772831894788780032', '2024-03-27 11:43:56', 5, 599.70, NULL, '待支付');
INSERT INTO `order_info` VALUES (69, '1772832172413956096', '2024-03-27 11:45:02', 5, 100.00, NULL, '待支付');
INSERT INTO `order_info` VALUES (70, '1772832308204548096', '2024-03-27 11:45:35', 5, 50.00, NULL, '待支付');

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
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (5, '斯伯丁篮球', 77.90, '良', '黄色', 0, 39, '/file/img.png');
INSERT INTO `product` VALUES (6, '哈格钉篮球', 20.00, '优', '红色', 0, 39, 'img_1.png');
INSERT INTO `product` VALUES (7, '猛男哑铃', 50.00, '差', '黄色', 0, 49, 'img_2.png');
INSERT INTO `product` VALUES (8, '哈丁跑鞋', 399.00, '优', '红色', 0, 29, 'img_3.png');
INSERT INTO `product` VALUES (9, '嘎嘎牛指压板', 9.90, '1', '绿色', 0, 50, 'zhi.png');
INSERT INTO `product` VALUES (10, '', 8.90, '1', '红', 0, 20, '/file/68.jpg');
INSERT INTO `product` VALUES (11, '嘎嘎牛牌蛋白粉', 8.88, '1', '无色', 0, 60, '/file/屏幕截图 2023-12-11 105415.png');
INSERT INTO `product` VALUES (12, 'giao牌头带', 9.90, '2.0', '绿', 0, 13, '/file/68.jpg');
INSERT INTO `product` VALUES (13, '头带', 18.80, '2.0.0', '粉色', 0, 13, '/file/1.jpg');
INSERT INTO `product` VALUES (14, '极兔2.0', 199.90, '2.0', '绿', 0, 29, '/file/2.jpg');

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
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (8, 'admin', '123456', 1, '1', '1', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
