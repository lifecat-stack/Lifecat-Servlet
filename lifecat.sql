/*
 Navicat Premium Data Transfer

 Source Server         : tencent
 Source Server Type    : MySQL
 Source Server Version : 100131
 Source Host           : 111.230.244.153:3306
 Source Schema         : lifecat

 Target Server Type    : MySQL
 Target Server Version : 100131
 File Encoding         : 65001

 Date: 24/08/2018 19:47:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_id` int(6) UNSIGNED NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(30) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `admin_password` varchar(30) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `admin_level` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `admin_gmt_create` datetime(0) NOT NULL,
  `admin_gmt_modified` datetime(0) NOT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE,
  UNIQUE INDEX `uk_admin_name`(`admin_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', '123456', 'admin', '2018-01-01 00:00:00', '2018-01-01 00:00:00');
INSERT INTO `admin` VALUES (2, 'ten', 'ten', 'admin', '2018-01-01 00:00:00', '2018-01-01 00:00:00');
INSERT INTO `admin` VALUES (3, 'test', 'test', 'admin', '2000-01-01 00:00:00', '2000-01-01 00:00:00');

-- ----------------------------
-- Table structure for diary
-- ----------------------------
DROP TABLE IF EXISTS `diary`;
CREATE TABLE `diary`  (
  `diary_id` int(6) UNSIGNED NOT NULL AUTO_INCREMENT,
  `diary_name` varchar(200) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `diary_text` varchar(2000) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `is_deleted` tinyint(1) UNSIGNED NOT NULL,
  `user_id` int(6) UNSIGNED NOT NULL,
  `diary_gmt_create` datetime(0) NOT NULL,
  `diary_gmt_modified` datetime(0) NOT NULL,
  PRIMARY KEY (`diary_id`) USING BTREE,
  UNIQUE INDEX `uk_diary_name`(`diary_name`) USING BTREE,
  INDEX `idx_user_id`(`user_id`) USING BTREE,
  INDEX `idx_is_deleted`(`is_deleted`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of diary
-- ----------------------------
INSERT INTO `diary` VALUES (1, 'diary01', 'this is diary01', 1, 1, '2018-01-01 00:00:00', '2018-01-01 00:00:00');
INSERT INTO `diary` VALUES (2, 'diary02', 'adf', 1, 1, '2018-01-01 00:00:00', '2018-07-20 14:24:41');
INSERT INTO `diary` VALUES (3, 'tes', 'fgaetgae', 1, 1, '2018-01-01 00:00:00', '2018-08-22 16:51:22');
INSERT INTO `diary` VALUES (4, 'agfewr', 'feawaew', 1, 1, '2018-07-20 14:25:33', '2018-07-20 14:25:33');
INSERT INTO `diary` VALUES (5, 'k', 'j', 1, 1, '2018-07-20 15:24:03', '2018-07-20 16:25:30');
INSERT INTO `diary` VALUES (6, 'fasd', 'sdaf', 1, 1, '2018-07-20 16:25:36', '2018-07-20 16:25:36');
INSERT INTO `diary` VALUES (7, 'a', 'cftu', 1, 1, '2018-07-20 16:25:44', '2018-07-20 16:25:44');
INSERT INTO `diary` VALUES (8, 'fewafwa', 'wefaewfa', 1, 1, '2018-08-22 15:42:44', '2018-08-22 15:42:44');
INSERT INTO `diary` VALUES (10, 'this is test diary', 'this is update diary', 1, 1, '2019-01-01 00:00:00', '2019-01-01 00:00:00');
INSERT INTO `diary` VALUES (11, 'asfda', 'afewasf', 1, 1, '2018-08-23 19:13:03', '2018-08-23 19:13:03');
INSERT INTO `diary` VALUES (13, 'asdf', 'asfd', 1, 1, '2018-08-23 19:15:20', '2018-08-23 19:15:20');
INSERT INTO `diary` VALUES (15, 'eaf', 'eaf', 1, 1, '2018-08-23 19:15:29', '2018-08-23 19:15:29');
INSERT INTO `diary` VALUES (17, '', '', 1, 1, '2018-08-23 19:17:19', '2018-08-23 19:17:19');
INSERT INTO `diary` VALUES (21, 'wefa', 'awef', 1, 1, '2018-08-23 19:22:02', '2018-08-23 19:22:02');

-- ----------------------------
-- Table structure for image
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image`  (
  `image_id` int(6) UNSIGNED NOT NULL AUTO_INCREMENT,
  `image_text` varchar(200) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `image_path` varchar(200) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `is_deleted` tinyint(1) UNSIGNED NOT NULL,
  `user_id` int(6) UNSIGNED NOT NULL,
  `class_id` int(6) UNSIGNED NOT NULL,
  `image_gmt_create` datetime(0) NOT NULL,
  `image_gmt_modified` datetime(0) NOT NULL,
  PRIMARY KEY (`image_id`) USING BTREE,
  INDEX `idx_user_id`(`user_id`) USING BTREE,
  INDEX `idx_is_deleted`(`is_deleted`) USING BTREE,
  INDEX `idx_class_id`(`class_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of image
-- ----------------------------
INSERT INTO `image` VALUES (1, 'lifecat01', '/lifecatweb/upimage/image1.jpg', 1, 1, 1, '2018-01-01 00:00:00', '2018-01-01 00:00:00');
INSERT INTO `image` VALUES (2, 'img', '/lifecatweb/upimage/image2.jpg', 1, 1, 1, '2018-01-01 00:00:00', '2018-07-20 17:20:14');
INSERT INTO `image` VALUES (3, 'lifecat03', '/lifecatweb/upimage/image3.jpg', 1, 1, 1, '2018-01-01 00:00:00', '2018-01-01 00:00:00');
INSERT INTO `image` VALUES (4, 'this is update', '/lifecatweb/upimage/image4.jpg', 1, 1, 1, '2019-01-01 00:00:00', '2019-01-01 00:00:00');
INSERT INTO `image` VALUES (5, 'this is update', '/lifecatweb/upimage/image5.jpg', 1, 1, 1, '2019-01-01 00:00:00', '2019-01-01 00:00:00');
INSERT INTO `image` VALUES (6, 'this is test image', '/lifecatweb/upimage/image6.jpg', 1, 1, 1, '2019-01-01 00:00:00', '2019-01-01 00:00:00');

-- ----------------------------
-- Table structure for image_class
-- ----------------------------
DROP TABLE IF EXISTS `image_class`;
CREATE TABLE `image_class`  (
  `image_class_id` int(6) UNSIGNED NOT NULL AUTO_INCREMENT,
  `image_class_name` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `image_class_desc` varchar(200) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `class_gmt_create` datetime(0) NOT NULL,
  `class_gmt_modified` datetime(0) NOT NULL,
  PRIMARY KEY (`image_class_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for image_feature
-- ----------------------------
DROP TABLE IF EXISTS `image_feature`;
CREATE TABLE `image_feature`  (
  `image_id` int(6) UNSIGNED NOT NULL,
  `image_feature` varchar(2000) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `feature_gmt_create` datetime(0) NOT NULL,
  `feature_gmt_modified` datetime(0) NOT NULL,
  PRIMARY KEY (`image_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test`  (
  `test_id` int(6) UNSIGNED NOT NULL AUTO_INCREMENT,
  `test_name` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `test_text` varchar(200) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `test_gmt_create` datetime(0) NOT NULL,
  `test_gmt_modified` datetime(0) NOT NULL,
  PRIMARY KEY (`test_id`) USING BTREE,
  UNIQUE INDEX `uk_test_name`(`test_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(6) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_name` varchar(30) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `user_password` varchar(30) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `user_level` varchar(30) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `user_gmt_create` datetime(0) NOT NULL,
  `user_gmt_modified` datetime(0) NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `uk_user_name`(`user_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '123', 'user', '2018-07-20 15:24:16', '2018-07-20 16:12:09');
INSERT INTO `user` VALUES (17, 'feafeasf', 'faf', 'user', '2018-07-20 15:26:11', '2018-07-20 16:12:27');
INSERT INTO `user` VALUES (18, 'fd', 'fea', 'fasd', '2018-07-20 15:26:14', '2018-07-20 15:56:38');
INSERT INTO `user` VALUES (19, 'asdf', 'fa', 'user', '2018-07-20 15:26:39', '2018-07-20 16:00:12');
INSERT INTO `user` VALUES (20, 'fasdeafasfd', 'fsda', 'user', '2018-07-20 15:26:45', '2018-07-20 16:11:23');
INSERT INTO `user` VALUES (28, 'fa', 'asfd', 'fae', '2018-07-20 15:35:09', '2018-07-20 15:49:28');
INSERT INTO `user` VALUES (35, 'test', '123456', 'test', '2019-01-01 00:00:00', '2019-01-01 00:00:00');
INSERT INTO `user` VALUES (37, 'ccc', '123', 'user', '2018-08-24 19:21:13', '2018-08-24 19:21:13');

-- ----------------------------
-- Table structure for user_icon
-- ----------------------------
DROP TABLE IF EXISTS `user_icon`;
CREATE TABLE `user_icon`  (
  `user_id` int(6) UNSIGNED NOT NULL,
  `icon_path` varchar(200) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `icon_gmt_create` datetime(0) NOT NULL,
  `icon_gmt_modified` datetime(0) NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_icon
-- ----------------------------
INSERT INTO `user_icon` VALUES (1, '/lifecatweb/images/usericon.jpg', '2018-01-01 00:00:00', '2018-01-01 00:00:00');
INSERT INTO `user_icon` VALUES (6, '/lifecatweb/images/usericon.jpg', '2019-01-01 00:00:00', '2019-01-01 00:00:00');

-- ----------------------------
-- Table structure for user_property
-- ----------------------------
DROP TABLE IF EXISTS `user_property`;
CREATE TABLE `user_property`  (
  `user_id` int(6) UNSIGNED NOT NULL,
  `property_nickname` varchar(30) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `property_signature` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `property_sex` varchar(10) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `property_email` varchar(30) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `property_location` varchar(30) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `property_birthday` date NULL DEFAULT NULL,
  `property_gmt_create` datetime(0) NOT NULL,
  `property_gmt_modified` datetime(0) NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_property
-- ----------------------------
INSERT INTO `user_property` VALUES (1, 'admin', '???????', 'man', 'admin@qq.com', 'wuxi', '2000-01-01', '2018-01-01 00:00:00', '2018-01-01 00:00:00');
INSERT INTO `user_property` VALUES (2, 'two', 'this is two', 'man', 'two@qq.com', 'wuxi', '2000-01-01', '2018-01-01 00:00:00', '2018-01-01 00:00:00');
INSERT INTO `user_property` VALUES (3, 'three', 'this is three', 'woman', 'three@qq.com', 'wuxi', '2000-01-01', '2018-01-01 00:00:00', '2018-01-01 00:00:00');
INSERT INTO `user_property` VALUES (6, 'test', 'test', 'man', '123456@qq.com', 'wx', '1997-01-01', '2019-01-01 00:00:00', '2019-01-01 00:00:00');

SET FOREIGN_KEY_CHECKS = 1;
