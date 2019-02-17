create table product(
   id VARCHAR(50) NOT NULL COMMENT 'id',
   name VARCHAR(200) DEFAULT NULL COMMENT '名称',
   productType VARCHAR(200) DEFAULT NULL COMMENT '类型',
   description VARCHAR(500) DEFAULT NULL COMMENT '描述',
   unitPurchasePrice DOUBLE DEFAULT 0 COMMENT '整件进价',
   unitCount INT(10) DEFAULT 0 COMMENT '整件中单品数量',
   singlePurchasePrice DOUBLE DEFAULT 0 COMMENT '单个进价',
   unitSalePrice DOUBLE DEFAULT 0 COMMENT '整件售价',
   singleSalePrice DOUBLE DEFAULT 0 COMMENT '单个售价',
   userId VARCHAR(50) DEFAULT NULL COMMENT '用户id',
   userName VARCHAR(200) DEFAULT NULL COMMENT '用户名称',
   PRIMARY KEY ( id )
);