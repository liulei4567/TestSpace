/*
Navicat MySQL Data Transfer

Source Server         : xuxin
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : wuwei

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-03-15 10:09:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '上级菜单ID',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) DEFAULT NULL COMMENT '访问路径',
  `display_order` int(11) DEFAULT NULL COMMENT '显示顺序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '0', '站外CR3000', '/project/index', '0');
INSERT INTO `menu` VALUES ('2', '0', '玉米滴灌通量站', '/station/index', '1');
INSERT INTO `menu` VALUES ('3', '0', '玉米畦灌通量站', '/channel/index', '2');
INSERT INTO `menu` VALUES ('4', '0', '波文比', '/data/index', '3');
INSERT INTO `menu` VALUES ('5', '0', '气象园', '/user/index', '4');
INSERT INTO `menu` VALUES ('6', '0', 'XX站点', '/syslog/index', '5');
INSERT INTO `menu` VALUES ('7', '1', '通量', '/data/panel/index', '6');
INSERT INTO `menu` VALUES ('8', '1', '气象', '/data/tendency/index', '7');
INSERT INTO `menu` VALUES ('9', '1', '土壤', '/data/station/index', '8');
INSERT INTO `menu` VALUES ('10', '2', '通量', '/alarm/index', '9');
INSERT INTO `menu` VALUES ('11', '2', '气象', 'XXX', '10');
INSERT INTO `menu` VALUES ('12', '2', '土壤', 'XXX', '11');
INSERT INTO `menu` VALUES ('13', '3', '通量', 'XXX', '12');
INSERT INTO `menu` VALUES ('14', '3', '气象', '/alarm/index', '13');
INSERT INTO `menu` VALUES ('15', '3', '土壤', '/data/tendency/index', '14');
INSERT INTO `menu` VALUES ('16', '4', '气象', '/alarm/index', '15');
INSERT INTO `menu` VALUES ('17', '4', '土壤', '/data/tendency/index', '16');
INSERT INTO `menu` VALUES ('18', '5', '气象园', '/alarm/index', '17');
INSERT INTO `menu` VALUES ('19', '1', '土壤', '/data/tendency/index', '18');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '123', '123');
