

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `mobile` varchar(32) DEFAULT NULL COMMENT '手机号',
  `nickname` varchar(128) DEFAULT NULL COMMENT '昵称',
  `avatar` varchar(128) DEFAULT NULL COMMENT '头像',
  `gmt_created` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '更新时间',
  `password` varchar(32) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `valid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='user ';

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, '15713411248', '牛供舞', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart0.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (2, '19869101785', '个名真难', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart1.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (3, '17803569170', '圳果子', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart2.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (4, '15097084830', '之囡囡', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart3.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (5, '18755278276', '手妙刀1', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart4.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (6, '18699966038', '梦百灵。', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart5.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (7, '13638582086', '客松', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart6.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (8, '15794265582', '典娜影月', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart7.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (9, '18234729244', '强就是强', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart8.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (10, '17723573275', '宫小胖', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart9.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (11, '15914081269', '葬着', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart10.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (12, '17851004685', '人小', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart11.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (13, '18908641508', '_?解之东方不败', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart12.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (14, '13151119066', '人吃地瓜', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart13.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (15, '18405615328', '黑亡神2', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart14.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (16, '18069439096', '罗尼', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart15.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (17, '19922377023', '封的酒', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart16.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (18, '13731778195', '浪_文', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart17.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (19, '18298743015', '是血王', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart18.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (20, '15715802277', '教の主', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart19.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (21, '18329162898', '吻给了烟！', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart20.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (22, '17764433850', '翔之鬼', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart21.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (23, '15598188431', '使凡心', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart22.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (24, '18685293297', '涩', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart23.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (25, '18771012553', '望之羽', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart24.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (26, '17247482885', '排是个术士', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart25.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (27, '14760982106', '游戏交出来', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart26.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (28, '13027731158', '暗疯狂', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart27.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (29, '15721574244', '哇', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart28.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (30, '17293938994', '不忍', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart29.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (31, '13406354188', '说的天才', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart30.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (32, '18128163585', '超1', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart31.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (33, '18685527195', '佛朝宗', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart32.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (34, '18259967853', '贝燕燕', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart33.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (35, '18957484372', '剑客', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart34.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (36, '14583169057', '恶的觉醒', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart35.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (37, '17368887510', '泡泡糖的狼', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart36.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (38, '14512391492', 'の魂', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart37.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (39, '17617163576', '似水之爷们', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart38.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (40, '14789518384', '心巧克力', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart39.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (41, '15927583897', '叔的gunsen', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart40.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (42, '13305104334', '会砍', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart41.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (43, '13550893167', '熙', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart42.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (44, '15688512466', '少', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart43.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (45, '18170856701', '月的婧琦', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart44.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (46, '17346833658', '衣飘飘飘', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart45.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (47, '18934866057', '月', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart46.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (48, '13973987938', '狗。', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart47.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (49, '18663547266', '想自由', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart48.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (50, '13745072827', '笑而过', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart49.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (51, '15654891113', '东辉超男', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart50.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (52, '18270243226', '星vs蝴蝶', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart51.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (53, '15635502136', '渺幻雪', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart52.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (54, '15088874150', '芒', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart53.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (55, '17314409526', '98654', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart54.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (56, '13723458275', '雪眠霜', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart55.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (57, '13426735883', '热之心', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart56.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (58, '13808555148', '夜孤魂', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart57.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (59, '15043411525', '市淘宝', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart58.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (60, '18876882392', '魂', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart59.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (61, '15053989802', '是猛龙不吓山', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart60.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (62, '13578863790', '贺', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart61.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (63, '17295388268', '冷紫月?', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart62.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (64, '18228997133', '尖代练01', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart63.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (65, '13098013698', '面vs兽心', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart64.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (66, '16654678475', '帝爱上我了', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart65.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (67, '13183023658', '芯幽燃', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart66.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (68, '15386792564', '殇漠', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart67.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (69, '14783601614', '虑海洋', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart68.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (70, '18071449089', '言?神话', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart69.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (71, '13662679268', '血凸凸', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart70.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (72, '15369246154', '留痕', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart71.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (73, '17761374951', '?', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart72.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (74, '15129664794', '魔寒冰', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart73.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (75, '13317916419', '骑士（忘记过去）', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart74.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (76, '13931113969', '臣', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart75.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (77, '15318644493', '被遗忘的角落', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart76.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (78, '13289374653', '菜华', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart77.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (79, '13922241316', '雨星空', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart78.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (80, '18333943390', '旭辉', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart79.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (81, '15765325553', '_神', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart80.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (82, '15872747030', '单de小猪', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart81.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (83, '18110726866', '?', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart82.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (84, '18959662260', '亮女儿', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart83.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (85, '18900523472', '吉', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart84.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (86, '19962611673', '配pei', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart85.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (87, '17205383860', '子??', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart86.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (88, '18483155615', '俊', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart87.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (89, '15071298801', '忘之贼', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart88.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (90, '18905982169', '数', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart89.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (91, '17502856039', '贝的奶牛', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart90.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (92, '13951249616', '子罩', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart91.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (93, '16677302354', '的爱的', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart92.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (94, '17711283913', '牌内裤', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart93.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (95, '13353807877', '乖狼', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart94.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (96, '15383046994', '色牛排', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart95.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (97, '15924271254', '江刀削面', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart96.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (98, '14738822571', '寞青衫', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart97.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (99, '15351251332', '爱丫丫~', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart98.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
INSERT INTO `user` VALUES (100, '17891775063', '致远之道', 'https://qgt-style.oss-cn-hangzhou.aliyuncs.com/newcoursep4/d3/avatar/avart99.png', '2020-06-06 17:28:34', '2020-06-06 17:28:34', NULL, NULL, 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
