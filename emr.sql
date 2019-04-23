/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50146
Source Host           : localhost:3306
Source Database       : emr

Target Server Type    : MYSQL
Target Server Version : 50146
File Encoding         : 65001

Date: 2019-04-20 14:23:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `department_name` varchar(20) NOT NULL COMMENT '科室名称',
  `code` varchar(10) NOT NULL COMMENT '科室编码',
  `hospital_name` varchar(40) NOT NULL COMMENT '所属医院',
  `address` varchar(40) NOT NULL COMMENT '科室地址',
  `lastchanged_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  KEY `code` (`code`),
  KEY `department_name` (`department_name`) USING BTREE,
  KEY `hospital_name` (`hospital_name`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('3', '儿科', '001', '安徽医科大学第二附属医院', '门诊楼 2F', '2019-04-16 13:51:54');
INSERT INTO `department` VALUES ('4', '检验科', '002', '安徽医科大学第二附属医院', '门诊楼 1F', '2019-04-16 15:16:32');
INSERT INTO `department` VALUES ('5', '放射科', '003', '安徽医科大学第二附属医院', '门诊楼 1F', '2019-04-16 15:17:01');
INSERT INTO `department` VALUES ('7', '急诊部', '0001', '安徽医科大学第二附属医院', '急诊大楼', '2019-04-17 18:16:02');

-- ----------------------------
-- Table structure for `disease`
-- ----------------------------
DROP TABLE IF EXISTS `disease`;
CREATE TABLE `disease` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `icd_code` varchar(10) NOT NULL COMMENT 'icd编码',
  `disease_name` varchar(50) NOT NULL COMMENT '疾病名称',
  `code` varchar(20) NOT NULL COMMENT '助记码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of disease
-- ----------------------------
INSERT INTO `disease` VALUES ('1', 'A00.051', '古典型霍乱', 'GDXHL');
INSERT INTO `disease` VALUES ('2', 'A00.052', '中型[典型]霍乱', 'ZXDXHL');
INSERT INTO `disease` VALUES ('4', 'A00.151', '轻型[非典型]霍乱', 'QXFDXHL');
INSERT INTO `disease` VALUES ('5', 'A01.001', '伤寒', 'SH');
INSERT INTO `disease` VALUES ('6', 'A02.008', '婴儿沙门氏菌肠炎', 'YESMSJCY');
INSERT INTO `disease` VALUES ('7', 'A02.101', '沙门氏菌败血症', 'SMSJBXZ');
INSERT INTO `disease` VALUES ('8', 'A03.951', '细菌性结肠炎', 'XJXJCY');
INSERT INTO `disease` VALUES ('9', 'A04.901', '肠道感染', 'CDGR');
INSERT INTO `disease` VALUES ('10', '1', '1', '1');
INSERT INTO `disease` VALUES ('11', 'A08.401', '病毒性胃肠炎', 'BDXWCY');

-- ----------------------------
-- Table structure for `hospital`
-- ----------------------------
DROP TABLE IF EXISTS `hospital`;
CREATE TABLE `hospital` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `code` varchar(10) NOT NULL COMMENT '医院编码',
  `hospital_name` varchar(40) NOT NULL COMMENT '医院名称',
  `level` varchar(10) NOT NULL COMMENT '医院级别',
  `telephone` varchar(15) NOT NULL COMMENT '医院联系电话',
  `address` varchar(255) NOT NULL COMMENT '医院地址',
  `lastchanged_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  KEY `hospital_name` (`hospital_name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hospital
-- ----------------------------
INSERT INTO `hospital` VALUES ('4', 'AYDEFY', '安徽医科大学第二附属医院', '三级甲等', '0551-12345678', '合肥市蜀山区芙蓉路666号', '2019-04-16 13:51:32');

-- ----------------------------
-- Table structure for `patient`
-- ----------------------------
DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uid` varchar(20) NOT NULL COMMENT '患者uid   身份证号',
  `patient_name` varchar(10) NOT NULL COMMENT '姓名',
  `sex` enum('女','未登记','男') NOT NULL DEFAULT '未登记' COMMENT '性别  ',
  `birth_year` varchar(4) NOT NULL COMMENT '出生年份',
  `native_place` varchar(10) NOT NULL COMMENT '籍贯地',
  `address` varchar(40) NOT NULL COMMENT '家庭住址',
  `phone` varchar(20) NOT NULL COMMENT '联系电话',
  `lastchanged_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`),
  KEY `patient_name` (`patient_name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of patient
-- ----------------------------
INSERT INTO `patient` VALUES ('1', '330512199702162546', '马龙', '男', '1997', '安徽合肥', '安徽省合肥市蜀山区安徽大学', '12345678910', '2019-04-16 14:20:48');
INSERT INTO `patient` VALUES ('3', '1', '1', '男', '1', '1', '1', '1', '2019-04-18 12:48:55');

-- ----------------------------
-- Table structure for `record`
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `uid` varchar(20) NOT NULL COMMENT '患者uid',
  `patient_name` varchar(10) NOT NULL COMMENT '患者姓名',
  `doctor_name` varchar(10) NOT NULL COMMENT '医生姓名',
  `consultation_date` date NOT NULL COMMENT '就诊日期',
  `test` varchar(200) DEFAULT '' COMMENT '检查',
  `description` varchar(3000) DEFAULT '' COMMENT '患者描述病症',
  `disease_type` varchar(20) DEFAULT '' COMMENT '疾病类型  ICD 10',
  `conclusion` varchar(10000) DEFAULT '' COMMENT '医生诊治结论',
  `treatment` varchar(200) DEFAULT '' COMMENT '治疗',
  `visit_type` enum('转院','急诊','门诊') DEFAULT NULL COMMENT '就诊类型',
  `lastchanged_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`),
  KEY `patient_name` (`patient_name`),
  KEY `doctor2` (`doctor_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('2', '330512199702162546', '马龙', '李安', '2019-04-16', '', '', '1', '', '', '门诊', '2019-04-18 13:50:23');

-- ----------------------------
-- Table structure for `staff`
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `job_number` varchar(10) NOT NULL COMMENT '工号  D开头表示医生 N开头表示护士  O开头表示其他 后跟两位入职年份 五位入职顺序',
  `staff_name` varchar(10) NOT NULL COMMENT '姓名',
  `type` enum('未登记','护工','护士','医生') DEFAULT '未登记' COMMENT '员工',
  `grade` varchar(10) NOT NULL COMMENT '工作职级',
  `hospital` varchar(40) NOT NULL COMMENT '所属医院',
  `department_name` varchar(20) NOT NULL COMMENT '所属科室',
  `lastchanged_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  KEY `hospital` (`hospital`),
  KEY `department_name` (`department_name`),
  KEY `staff_name` (`staff_name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES ('3', 'D1900001', '李安', '医生', '主治医师', '安徽医科大学第二附属医院', '儿科', '2019-04-18 13:12:10');
INSERT INTO `staff` VALUES ('4', 'N1900001', '张悦', '护士', '护士', '安徽医科大学第二附属医院', '儿科', '2019-04-18 13:12:14');
INSERT INTO `staff` VALUES ('6', '0', '0', null, '0', '0', '0', '2019-04-18 13:15:39');

-- ----------------------------
-- Table structure for `test`
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `test_name` varchar(20) NOT NULL COMMENT '检查名称',
  `department` varchar(20) NOT NULL COMMENT '所属科室',
  PRIMARY KEY (`id`),
  KEY `department` (`department`),
  KEY `test_name` (`test_name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('1', '血常规', '检验科');
INSERT INTO `test` VALUES ('2', '核磁共振', '放射科');
INSERT INTO `test` VALUES ('4', '1', '000');

-- ----------------------------
-- Table structure for `test_record`
-- ----------------------------
DROP TABLE IF EXISTS `test_record`;
CREATE TABLE `test_record` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `test_name` varchar(20) NOT NULL COMMENT '检查名称',
  `department` varchar(20) NOT NULL COMMENT '所在科室',
  `uid` varchar(20) NOT NULL COMMENT '患者uid',
  `status` enum('已完成','未完成') DEFAULT '未完成' COMMENT ' 状态',
  `lastchanged_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `test_name` (`test_name`),
  KEY `department-` (`department`),
  KEY `uid` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test_record
-- ----------------------------
INSERT INTO `test_record` VALUES ('1', '血常规', '检验科', '330512199702162546', '未完成', '2019-04-16 15:27:16');
INSERT INTO `test_record` VALUES ('2', '1', '1', '00000', '已完成', '2019-04-18 14:04:43');

-- ----------------------------
-- Table structure for `treatment`
-- ----------------------------
DROP TABLE IF EXISTS `treatment`;
CREATE TABLE `treatment` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `treatment_name` varchar(30) NOT NULL COMMENT '治疗名称',
  PRIMARY KEY (`id`),
  KEY `treatment_name` (`treatment_name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of treatment
-- ----------------------------
INSERT INTO `treatment` VALUES ('2', '心脏移植手术');
INSERT INTO `treatment` VALUES ('6', '拔牙');
INSERT INTO `treatment` VALUES ('4', '拔除智齿');
INSERT INTO `treatment` VALUES ('3', '肝切除手术');
INSERT INTO `treatment` VALUES ('5', '静脉滴注');

-- ----------------------------
-- Table structure for `treatment_record`
-- ----------------------------
DROP TABLE IF EXISTS `treatment_record`;
CREATE TABLE `treatment_record` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uid` varchar(20) NOT NULL COMMENT '患者uid',
  `treatment_name` varchar(30) NOT NULL COMMENT '治疗名称',
  `doctor` char(10) NOT NULL COMMENT '治疗医生',
  `status` enum('已完成','未完成') DEFAULT '未完成',
  `lastchanged_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `uid1` (`uid`),
  KEY `treatment_name` (`treatment_name`),
  KEY `doctor1` (`doctor`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of treatment_record
-- ----------------------------
INSERT INTO `treatment_record` VALUES ('1', '330512199702162546', '静脉滴注', '李安', '未完成', '2019-04-16 15:34:26');
INSERT INTO `treatment_record` VALUES ('2', '2', '666', '888', '未完成', '2019-04-17 15:39:27');
INSERT INTO `treatment_record` VALUES ('4', '4', '4', '4', '未完成', '2019-04-17 15:31:57');
INSERT INTO `treatment_record` VALUES ('5', '0', '0', '0', '已完成', '2019-04-18 14:03:18');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` varchar(20) NOT NULL COMMENT '账号   医务人员即工号  患者即uid  管理员为其他值',
  `password` varchar(20) NOT NULL COMMENT '密码',
  `user_type` enum('护士','医生','管理员','患者') DEFAULT NULL COMMENT '用户类型',
  `lastchanged_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('6', 'D1900001', 'D1900001', '医生', '2019-04-16 13:53:50');
INSERT INTO `user` VALUES ('7', 'N1900001', 'N1900001', '护士', '2019-04-16 13:54:05');
INSERT INTO `user` VALUES ('8', '330512199702162546', '330512199702162546', '患者', '2019-04-16 14:21:01');
INSERT INTO `user` VALUES ('9', 'S000001', '123456', '管理员', '2019-04-17 14:47:07');
INSERT INTO `user` VALUES ('11', 'S000002', '123456', '管理员', '2019-04-17 15:14:41');
