DROP TABLE IF EXISTS `t_boot_area`;
CREATE TABLE `t_boot_area`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) NOT NULL COMMENT '父id',
  `area_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '地区名称',
  `sort` int(11) NOT NULL COMMENT '排序字段',
  PRIMARY KEY (`id`) USING BTREE
)