INSERT IGNORE INTO inquiry (id, name, email, content) VALUES (1, '百田', 'red@mcz.com', '百田さんのテスト用投稿です。');
INSERT IGNORE INTO inquiry (id, name, email, content) VALUES (2, '玉井', 'red@mcz.com', '玉井さんのテスト用投稿です。');
INSERT IGNORE INTO inquiry (id, name, email, content) VALUES (3, '佐々木', 'red@mcz.com', '佐々木さんのテスト用投稿です。');
INSERT IGNORE INTO inquiry (id, name, email, content) VALUES (4, '高城', 'red@mcz.com', '高城さんのテスト用投稿です。');
INSERT IGNORE INTO inquiry (id, name, email, content) VALUES (5, '有安', 'red@mcz.com', '有安さんのテスト用投稿です。');
-- INSERT IGNORE INTO inquiry (id, name, email, content) VALUES (6, '川上', 'kawakami@mcz.com', 'この投稿は消されます。');
DELETE FROM inquiry WHERE id >= 6;