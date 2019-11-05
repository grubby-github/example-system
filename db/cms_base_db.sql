-- --------------------------------------------------------
-- 主机:                           192.168.1.172
-- 服务器版本:                        5.7.18-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 cms_base_db 的数据库结构
CREATE DATABASE IF NOT EXISTS `cms_base_db` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `cms_base_db`;


-- 导出  表 cms_base_db.adddevice 结构
CREATE TABLE IF NOT EXISTS `adddevice` (
  `Id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ServiceId` int(11) NOT NULL DEFAULT '0' COMMENT '服务表主键',
  `GBId` varchar(255) DEFAULT NULL COMMENT '国标20位编码',
  `Name` varchar(255) DEFAULT NULL COMMENT '设备名称',
  `Type` varchar(255) DEFAULT NULL COMMENT '设备类型',
  `UserName` varchar(255) DEFAULT NULL COMMENT '用户名',
  `Password` varchar(255) DEFAULT NULL COMMENT '密码',
  `IP` varchar(255) DEFAULT NULL COMMENT '设备ip',
  `Port` int(11) DEFAULT NULL COMMENT '设备端口',
  `VStreamId` int(11) DEFAULT NULL COMMENT '抓拍机镜头id',
  `VStreamType` int(11) DEFAULT NULL COMMENT '设备类型平台-1，设备0，rtsp1，抓拍机 2，本地视频3',
  `RtspUrl` varchar(255) DEFAULT NULL COMMENT 'Rtsp串的 url',
  `CreateTime` datetime DEFAULT NULL COMMENT '创建时间',
  `UpdateTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='被动设备表';

-- 数据导出被取消选择。


-- 导出  表 cms_base_db.alarmnonvehi 结构
CREATE TABLE IF NOT EXISTS `alarmnonvehi` (
  `Id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ResourceId` varchar(500) DEFAULT NULL COMMENT '资源Id',
  `ResourceType` varchar(500) DEFAULT NULL COMMENT '资源类型',
  `TaskId` varchar(500) DEFAULT NULL COMMENT '分析任务Id',
  `TaskName` varchar(500) DEFAULT NULL COMMENT '分析任务名称',
  `CaptureAdd` varchar(500) DEFAULT NULL COMMENT '抓拍地点(实时,录像为镜头名称,本地文件为文件路径名)',
  `CaptureTime` datetime DEFAULT NULL COMMENT '抓拍时间',
  `CaptureImgUrl` varchar(500) DEFAULT NULL COMMENT '抓拍图地址',
  `OriginImgUrl` varchar(500) DEFAULT NULL COMMENT '原图地址',
  `FeaDataLen` int(11) DEFAULT '0' COMMENT '特征内存长度',
  `FeaLen` int(11) DEFAULT '0' COMMENT '特征长度',
  `Features` varchar(5000) DEFAULT '0' COMMENT '特征',
  `FrameIndex` int(11) DEFAULT '0' COMMENT '目标帧位置',
  `LocationXLeft` int(11) DEFAULT '0' COMMENT '目标坐标点',
  `LocationXRight` int(11) DEFAULT '0' COMMENT '目标坐标点',
  `LocationYLeft` int(11) DEFAULT '0' COMMENT '目标坐标点',
  `LocationYRight` int(11) DEFAULT '0' COMMENT '目标坐标点',
  `Color` varchar(500) DEFAULT '0',
  `Convertible` varchar(500) DEFAULT '0',
  `DriverHead` varchar(500) DEFAULT '0',
  `IsManed` varchar(500) DEFAULT '0',
  `IsPickUp` varchar(500) DEFAULT '0',
  `UpperColor` varchar(500) DEFAULT '0',
  `UpperStyle` varchar(500) DEFAULT '0',
  `Gender` varchar(500) DEFAULT '0',
  `NonVehiType` varchar(500) DEFAULT '0',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分析结果-结构化-非机动车';

-- 数据导出被取消选择。


-- 导出  表 cms_base_db.alarmped 结构
CREATE TABLE IF NOT EXISTS `alarmped` (
  `Id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ResourceId` varchar(500) DEFAULT NULL COMMENT '资源Id',
  `ResourceType` varchar(500) DEFAULT NULL COMMENT '资源类型',
  `TaskId` varchar(500) DEFAULT NULL COMMENT '分析任务Id',
  `TaskName` varchar(500) DEFAULT NULL COMMENT '分析任务名称',
  `CaptureAdd` varchar(500) DEFAULT NULL COMMENT '抓拍地点(实时,录像为镜头名称,本地文件为文件路径名)',
  `CaptureTime` datetime DEFAULT NULL COMMENT '抓拍时间',
  `CaptureImgUrl` varchar(500) DEFAULT NULL COMMENT '抓拍图地址',
  `OriginImgUrl` varchar(500) DEFAULT NULL COMMENT '原图地址',
  `FeaDataLen` int(11) DEFAULT '0' COMMENT '特征内存长度',
  `FeaLen` int(11) DEFAULT '0' COMMENT '特征长度',
  `Features` varchar(5000) DEFAULT '0' COMMENT '特征',
  `FrameIndex` int(11) DEFAULT '0' COMMENT '目标帧位置',
  `LocationXLeft` int(11) DEFAULT '0' COMMENT '目标坐标点',
  `LocationXRight` int(11) DEFAULT '0' COMMENT '目标坐标点',
  `LocationYLeft` int(11) DEFAULT '0' COMMENT '目标坐标点',
  `LocationYRight` int(11) DEFAULT '0' COMMENT '目标坐标点',
  `DoubleBag` varchar(500) DEFAULT '0',
  `IsPickUp` varchar(500) DEFAULT '0',
  `IsTrolleyCase` varchar(500) DEFAULT '0',
  `LowerColor` varchar(500) DEFAULT '0',
  `LowerStyle` varchar(500) DEFAULT '0',
  `MessengerBag` varchar(500) DEFAULT '0',
  `UpperColor` varchar(500) DEFAULT '0',
  `UpperStyle` varchar(500) DEFAULT '0',
  `Gender` varchar(500) DEFAULT '0',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分析结果-结构化-人';

-- 数据导出被取消选择。


-- 导出  表 cms_base_db.alarmvehi 结构
CREATE TABLE IF NOT EXISTS `alarmvehi` (
  `Id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ResourceId` varchar(500) DEFAULT NULL COMMENT '资源Id',
  `ResourceType` varchar(500) DEFAULT NULL COMMENT '资源类型',
  `TaskId` varchar(500) DEFAULT NULL COMMENT '分析任务Id',
  `TaskName` varchar(500) DEFAULT NULL COMMENT '分析任务名称',
  `CaptureAdd` varchar(500) DEFAULT NULL COMMENT '抓拍地点(实时,录像为镜头名称,本地文件为文件路径名)',
  `CaptureTime` datetime DEFAULT NULL COMMENT '抓拍时间',
  `CaptureImgUrl` varchar(500) DEFAULT NULL COMMENT '抓拍图地址',
  `OriginImgUrl` varchar(500) DEFAULT NULL COMMENT '原图地址',
  `FeaDataLen` int(11) DEFAULT '0' COMMENT '特征内存长度',
  `FeaLen` int(11) DEFAULT '0' COMMENT '特征长度',
  `Features` varchar(5000) DEFAULT '0' COMMENT '特征',
  `FrameIndex` int(11) DEFAULT '0' COMMENT '目标帧位置',
  `LocationXLeft` int(11) DEFAULT '0' COMMENT '目标坐标点',
  `LocationXRight` int(11) DEFAULT '0' COMMENT '目标坐标点',
  `LocationYLeft` int(11) DEFAULT '0' COMMENT '目标坐标点',
  `LocationYRight` int(11) DEFAULT '0' COMMENT '目标坐标点',
  `CarBrand` varchar(500) DEFAULT '0',
  `CarColor` varchar(500) DEFAULT '0',
  `CarType` varchar(500) DEFAULT '0',
  `HangerNum` varchar(500) DEFAULT '0',
  `HasLp` varchar(500) DEFAULT '0',
  `IsMainSeatBlet` varchar(500) DEFAULT '0',
  `LabelNum` varchar(500) DEFAULT '0',
  `LeftSunShield` varchar(500) DEFAULT '0',
  `LpColor` varchar(500) DEFAULT '0',
  `LpNumber` varchar(500) DEFAULT '0',
  `LpStyle` varchar(500) DEFAULT '0',
  `Orientation` varchar(500) DEFAULT '0',
  `RightSunShield` varchar(500) DEFAULT '0',
  `TissueNum` varchar(500) DEFAULT '0',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分析结果-结构化-机动车';

-- 数据导出被取消选择。


-- 导出  表 cms_base_db.camera 结构
CREATE TABLE IF NOT EXISTS `camera` (
  `Id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `DevId` int(11) NOT NULL DEFAULT '0' COMMENT '设备表主键',
  `GroupId` int(11) DEFAULT '0' COMMENT '镜头组表主键,没有组时为0',
  `PlatformId` int(11) DEFAULT '0' COMMENT '平台表主键,没有平台时为0',
  `Name` varchar(255) DEFAULT NULL COMMENT '名称',
  `ChannelNO` int(11) NOT NULL DEFAULT '0' COMMENT '通道编号',
  `Latitude` double DEFAULT '0' COMMENT '纬度',
  `Longitude` double DEFAULT '0' COMMENT '经度',
  `IsOnline` smallint(6) NOT NULL DEFAULT '0' COMMENT '状态（0下线,1上线）',
  `CreateTime` datetime DEFAULT NULL COMMENT '创建时间',
  `UpdateTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='镜头表';

-- 数据导出被取消选择。


-- 导出  表 cms_base_db.cameragroup 结构
CREATE TABLE IF NOT EXISTS `cameragroup` (
  `Id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `PlatformId` int(11) DEFAULT '0' COMMENT '平台Id,没有平台时为0',
  `ParentGroupId` int(11) DEFAULT '0' COMMENT '父组Id,没有父组时为0',
  `BizId` varchar(100) DEFAULT '0' COMMENT '平台业务Id,没有平台时为空',
  `Name` varchar(255) DEFAULT NULL COMMENT '名称',
  `CreateTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='镜头组表';

-- 数据导出被取消选择。


-- 导出  表 cms_base_db.device 结构
CREATE TABLE IF NOT EXISTS `device` (
  `Id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ServiceId` int(11) NOT NULL DEFAULT '0' COMMENT '服务表主键',
  `PlatformId` int(11) DEFAULT '0' COMMENT '平台表主键,无平台时为0',
  `DevId` varchar(255) DEFAULT NULL COMMENT '服务上报设备编号',
  `GBId` varchar(255) DEFAULT NULL COMMENT '国标20位编码',
  `Name` varchar(255) DEFAULT NULL COMMENT '设备名称',
  `Type` varchar(255) DEFAULT NULL COMMENT '设备类型',
  `SN` varchar(255) DEFAULT NULL COMMENT '设备序列号',
  `HardwareVer` varchar(255) DEFAULT NULL COMMENT '硬件版本',
  `FirmwareVer` varchar(255) DEFAULT NULL COMMENT '固件版本',
  `UserName` varchar(255) DEFAULT NULL COMMENT '用户名',
  `Password` varchar(255) DEFAULT NULL COMMENT '密码',
  `IP` varchar(255) DEFAULT NULL COMMENT '设备ip',
  `Port` int(11) DEFAULT NULL COMMENT '设备端口',
  `Mask` varchar(255) DEFAULT NULL COMMENT '掩码',
  `Gateway` varchar(255) DEFAULT NULL COMMENT '网关',
  `Mac` varchar(255) DEFAULT NULL COMMENT '设备MAC',
  `Vendor` varchar(255) DEFAULT NULL COMMENT '厂商',
  `VideoInCount` int(11) DEFAULT NULL COMMENT '视频输入通道',
  `VideoOutCount` int(11) DEFAULT NULL COMMENT '视频输出通道',
  `AudioInCount` int(11) DEFAULT NULL COMMENT '音频输入通道',
  `AudioOutCount` int(11) DEFAULT NULL COMMENT '音频输出通道',
  `AlarmInCount` int(11) DEFAULT NULL COMMENT '报警输入通道',
  `AlarmOutCount` int(11) DEFAULT NULL COMMENT '报警输出通道',
  `Serial232Count` int(11) DEFAULT NULL COMMENT '232串口',
  `Serial485Count` int(11) DEFAULT NULL COMMENT '485串口',
  `IsOnline` smallint(6) NOT NULL DEFAULT '0' COMMENT '状态（0下线,1上线）',
  `CreateTime` datetime DEFAULT NULL COMMENT '创建时间',
  `UpdateTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='设备表';

-- 数据导出被取消选择。


-- 导出  表 cms_base_db.platform 结构
CREATE TABLE IF NOT EXISTS `platform` (
  `Id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ServiceId` int(11) NOT NULL DEFAULT '0' COMMENT '服务表主键',
  `Name` varchar(255) DEFAULT NULL COMMENT '平台名称',
  `Type` varchar(255) DEFAULT NULL COMMENT '平台类型',
  `IP` varchar(255) DEFAULT NULL COMMENT '平台ip',
  `Port` int(11) DEFAULT NULL COMMENT '平台端口',
  `UserName` varchar(255) DEFAULT NULL COMMENT '用户名',
  `Password` varchar(255) DEFAULT NULL COMMENT '密码',
  `Vendor` varchar(255) DEFAULT NULL COMMENT '厂商',
  `DomainId` varchar(255) DEFAULT NULL COMMENT '平台域ID',
  `CreateTime` datetime DEFAULT NULL COMMENT '创建时间',
  `UpdateTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='平台表';

-- 数据导出被取消选择。


-- 导出  表 cms_base_db.service 结构
CREATE TABLE IF NOT EXISTS `service` (
  `Id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ServiceId` varchar(255) DEFAULT NULL COMMENT '服务上报Id',
  `Type` varchar(255) DEFAULT NULL COMMENT '服务类型',
  `IP` varchar(255) DEFAULT NULL COMMENT '服务地址',
  `Port` int(11) DEFAULT NULL COMMENT '服务端口',
  `Vendor` varchar(255) DEFAULT NULL COMMENT '接入类型',
  `Payload` double DEFAULT NULL COMMENT '负载值',
  `Ability` int(11) DEFAULT NULL COMMENT '能力级-路数',
  `IsOnline` smallint(6) NOT NULL DEFAULT '0' COMMENT '状态（0下线,1上线）',
  `CreateTime` datetime DEFAULT NULL COMMENT '创建时间',
  `UpdateTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='服务表';

-- 数据导出被取消选择。


-- 导出  表 cms_base_db.task 结构
CREATE TABLE IF NOT EXISTS `task` (
  `Id` int(4) NOT NULL AUTO_INCREMENT,
  `ServiceId` int(11) NOT NULL DEFAULT '0' COMMENT '服务表主键',
  `AlgType` varchar(255) DEFAULT NULL COMMENT '分析类型:Face:人脸,JssJIVS:捷尚结构化,JssJIV007:捷尚视侦结构化,IVS:IVU周界,SeemmoVS:深瞐结构化',
  `ControlType` varchar(255) DEFAULT NULL COMMENT '任务控制状态ON/OFF',
  `MediaSource` varchar(255) DEFAULT NULL COMMENT '资源地址(离线视频地址或rtsp地址)',
  `State` int(11) DEFAULT NULL COMMENT '任务状态(0停止,1正在获取视频流,2获取视频流失败,3算法初始化错误,4算法规则配置错误,5正常分析中,6处于暂停时间中,7性能暂用过高暂停任务,8文件解析中,9文件解析失败,10系统错误,11IVU正常停用,12分析完成(针对本地视频文件及录像),13等待,14媒体服务已打开)',
  `TaskName` varchar(255) DEFAULT NULL COMMENT '任务名称',
  `TaskType` varchar(255) DEFAULT NULL COMMENT '任务类型:Rtsp,LocalFile,Live',
  `ResourceType` int(4) DEFAULT NULL COMMENT '资源类型:平台-1,设备0,rtsp1,抓拍机 2,本地视频3',
  `ResourceId` int(11) DEFAULT NULL COMMENT '资源id',
  `ResourceName` varchar(255) DEFAULT NULL COMMENT '资源名称(镜头名或者离线视频名)',
  `AlgRule` varchar(8000) DEFAULT NULL COMMENT '分析规则参数（Json字符串）',
  `Progress` double DEFAULT NULL COMMENT '分析进度(只有离线视频才有分析进度)',
  `IsDelete` smallint(6) NOT NULL DEFAULT '0' COMMENT '是否删除（0未删除 1删除）',
  `CreateTime` datetime DEFAULT NULL COMMENT '创建时间',
  `UpdateTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分析任务表';

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
