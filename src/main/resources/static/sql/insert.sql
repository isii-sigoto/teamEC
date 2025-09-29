SET foreign_key_checks=1;

USE teamdb;

INSERT INTO mst_user
(user_name, password, family_name, first_name, family_name_kana, first_name_kana, gender)
VALUES ('taro@gmail.com', '111111', '山田', '太郎', 'やまだ', 'たろう', 0);

INSERT INTO mst_category (category_name,category_description) VALUES
('犬', '愛くるしい子犬から頼もしい大型犬まで、個性豊かなワンちゃんたち。'),
('猫', '気ままな姿に癒される、個性豊かな子猫たち。'),
('爬虫類', '独特の魅力と愛らしさ、個性豊かなエキゾチックアニマル。');


INSERT INTO mst_product(product_name,product_name_kana,product_description,category_id,price,image_full_path,release_date,release_company)VALUES 
('柴犬','しばいぬ','忠実で勇敢な性格、日本の風土が生んだ賢いパートナー。',1,280000,'/img/dog1.png','2020/01/05','株式会社わんにゃんライフ'),
('サモエド','さもえど','純白の毛並みと笑顔のような表情が魅力、ロシア生まれの優しい犬。',1,550000,'/img/dog2.png','2020/01/15','株式会社わんにゃんライフ'),
('マルチーズ','まるちーず','つぶらな瞳と絹のような白い毛並みが特徴、抱きしめたくなる愛玩犬。',1,250000,'/img/dog3.png','2020/01/25','株式会社わんにゃんライフ'),
('黒猫','くろねこ','漆黒の毛並みが神秘的、幸運を運ぶと言われる心優しい家族。',2,80000,'/img/cat1.png','2020/02/05','株式会社ネコノヒミツ'),
('マンチカン','まんちかん','短い足でトコトコ歩く姿が愛らしい、好奇心旺盛な猫。',2,350000,'/img/cat2.png','2020/02/15','株式会社ネコノヒミツ'),
('スコティッシュ・フォールド','すこてぃっしゅ・ふぉーるど','丸い顔と折れた耳がチャームポイント、穏やかで人懐っこい猫。',2,320000,'/img/cat3.png','2020/02/25','株式会社ネコノヒミツ'),
('ヘビ','へび','美しい鱗模様と独特の動きが魅力的、静かに寄り添うエキゾチックな家族。',3,25000,'/img/reptile1.png','2020/03/05','エキゾチック・ジャパン株式会社'),
('とかげ','とかげ','個性豊かな色と模様が楽しめる、見ているだけで癒される小さな恐竜。',3,15000,'/img/reptile2.png','2020/03/15','エキゾチック・ジャパン株式会社');


-- user（ユーザー）テーブル データ確認
SELECT * FROM mst_user;
-- category（カテゴリ）テーブル データ確認
SELECT * FROM mst_category ORDER BY id ASC;
-- product（商品）テーブル データ確認
SELECT * FROM mst_product ORDER BY id ASC;
