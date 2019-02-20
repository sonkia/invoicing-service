
-- 导出 invoicing 的数据库结构
CREATE DATABASE IF NOT EXISTS `invoicing`;
USE `invoicing`;

-- 导出  表 invoicing.product 结构
CREATE TABLE IF NOT EXISTS `product` (
  `id` varchar(50) DEFAULT NULL COMMENT 'id',
  `name` varchar(50) DEFAULT NULL COMMENT '产品名称',
  `code` varchar(50) DEFAULT NULL COMMENT '产品编码',
  `product_type` varchar(50) DEFAULT NULL COMMENT '产品类型',
  `description` varchar(500) DEFAULT NULL COMMENT '产品描述',
  `unit_count` int(8) DEFAULT NULL COMMENT '整件中单品数量'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品';


-- 导出  表 invoicing.product_type 结构
CREATE TABLE IF NOT EXISTS `product_type` (
  `id` varchar(50) DEFAULT NULL COMMENT 'id',
  `name` varchar(50) DEFAULT NULL COMMENT '产品类型名称',
  `code` varchar(50) DEFAULT NULL COMMENT '产品类型编码',
  `description` varchar(500) DEFAULT NULL COMMENT '产品类型描述'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品类型';

