INSERT INTO "ORDERS" (`id`, `is_completed`, `user_name` ,`register_date`) VALUES
(1, false, 'user1', '2022-12-01 01:59:59'),
(2, false, 'user2', '2022-12-02 02:59:59'),
(3, false, 'user3', '2022-12-03 03:59:59'),
(4, false, 'user4', '2022-12-04 04:59:59'),
(5, false, 'user5', '2022-12-05 05:59:59');



INSERT INTO "ORDER_PRODUCTS" (`id`, `name`, `price`, `orders_id`) VALUES
(1,  '우유',   1000, 1),
(2,  '사과',   2000, 1),
(3,  '포도',   3000, 2),
(4,  '바나나',  4000, 2),
(5,  '후라이팬', 5000, 3),
(6,  '종이',   6000, 4),
(7,  '냉장고',  7000, 5),
(8,  '노트북',  8000, 5),
(9,  '화분',   9000, 5);
