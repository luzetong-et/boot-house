DROP TABLE IF EXISTS `t_boot_house1910`;
CREATE TABLE `t_boot_house1910`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `province` int(11) NOT NULL COMMENT '所在省的id',
  `city` int(11) NOT NULL COMMENT '所在市的id',
  `area` int(11) NOT NULL COMMENT '所在区的id',
  `area_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所在区名称',
  `rent_mode` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '租赁方式',
  `rental` double(8, 2) NOT NULL COMMENT '租金',
  `house_type` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '户型',
  `orientation` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '朝向',
  `address` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '详细地址',
  `publish_time` datetime(0) NOT NULL COMMENT '发布时间',
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
)