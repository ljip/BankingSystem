/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : PostgreSQL
 Source Server Version : 130009 (130009)
 Source Host           : localhost:5433
 Source Catalog        : postgres
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 130009 (130009)
 File Encoding         : 65001

 Date: 03/05/2023 11:11:25
*/


-- ----------------------------
-- Table structure for klijenti
-- ----------------------------
DROP TABLE IF EXISTS "public"."klijenti";
CREATE TABLE "public"."klijenti" (
  "id" int4 NOT NULL DEFAULT nextval('klijenti_id_seq'::regclass),
  "ime" varchar(128) COLLATE "pg_catalog"."default" NOT NULL,
  "prezime" varchar(128) COLLATE "pg_catalog"."default" NOT NULL,
  "oib" numeric(8,0) NOT NULL,
  "stanjeRacuna" numeric NOT NULL,
  "pinBroj" numeric(4,0) NOT NULL
)
;

-- ----------------------------
-- Records of klijenti
-- ----------------------------
INSERT INTO "public"."klijenti" VALUES (1, 'Filip', 'Lilic', 12345676567, 100, 1234);
INSERT INTO "public"."klijenti" VALUES (2, 'Roman', 'Romić', 9847657643, 674653, 5767);
INSERT INTO "public"."klijenti" VALUES (3, 'Ana', 'Anic', 9844556743, 345, 2342);
INSERT INTO "public"."klijenti" VALUES (4, 'Marko', 'Maric', 98476567432, -100, 1235);
INSERT INTO "public"."klijenti" VALUES (5, 'Ivo', 'Ivic', 87687654324, 1020, 9233);
INSERT INTO "public"."klijenti" VALUES (0, 'Mirko', 'Miric', 12343567876, 4543, 5464);

-- ----------------------------
-- Primary Key structure for table klijenti
-- ----------------------------
ALTER TABLE "public"."klijenti" ADD CONSTRAINT "klijenti_pkey" PRIMARY KEY ("id");
