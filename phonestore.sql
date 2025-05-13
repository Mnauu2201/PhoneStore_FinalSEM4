SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";



CREATE TABLE `authority` (
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- --------------------------------------------------------



CREATE TABLE `banner` (
  `id` bigint NOT NULL,
  `id_product` bigint DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `link_web` varchar(255) DEFAULT NULL,
  `page_name` varchar(255) DEFAULT NULL,
  `banner_type` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `blog`
--

CREATE TABLE `blog` (
  `id` bigint NOT NULL,
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `created_date` date DEFAULT NULL,
  `description` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `image_banner` varchar(255) DEFAULT NULL,
  `primary_blog` bit(1) DEFAULT NULL,
  `title` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `user_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cart`
--

CREATE TABLE `cart` (
  `id` bigint NOT NULL,
  `quantity` int DEFAULT NULL,
  `product_color_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `category`
--

CREATE TABLE `category` (
  `id` bigint NOT NULL,
  `category_type` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chatting`
--

CREATE TABLE `chatting` (
  `id` bigint NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `receiver` bigint DEFAULT NULL,
  `sender` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



--
-- Cấu trúc bảng cho bảng `districts`
--

CREATE TABLE `districts` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `province_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `history_pay`
--

CREATE TABLE `history_pay` (
  `id` bigint NOT NULL,
  `created_date` date DEFAULT NULL,
  `created_time` time DEFAULT NULL,
  `order_id` varchar(255) DEFAULT NULL,
  `request_id` varchar(255) DEFAULT NULL,
  `total_amount` double DEFAULT NULL,
  `invoice_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `invoice`
--

CREATE TABLE `invoice` (
  `id` bigint NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `created_time` time DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `pay_type` int DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `receiver_name` varchar(255) DEFAULT NULL,
  `status_invoice` int DEFAULT NULL,
  `status_update_date` datetime DEFAULT NULL,
  `total_amount` double DEFAULT NULL,
  `user_address_id` bigint DEFAULT NULL,
  `voucher_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `invoice_detail`
--

CREATE TABLE `invoice_detail` (
  `id` bigint NOT NULL,
  `price` double DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `invoice_id` bigint DEFAULT NULL,
  `product_color_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product`
--

CREATE TABLE `product` (
  `id` bigint NOT NULL,
  `accessory` varchar(255) DEFAULT NULL,
  `back_camera` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `cpu` varchar(255) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `created_time` time DEFAULT NULL,
  `description` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `front_camera` varchar(255) DEFAULT NULL,
  `image_banner` varchar(255) DEFAULT NULL,
  `material` varchar(255) DEFAULT NULL,
  `mobile_network` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `old_price` double DEFAULT NULL,
  `opera_system` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `quantity_sold` int DEFAULT NULL,
  `screen` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `security_infor` varchar(255) DEFAULT NULL,
  `sim` varchar(255) DEFAULT NULL,
  `special_feature` varchar(255) DEFAULT NULL,
  `category_id` bigint DEFAULT NULL,
  `trademark_id` bigint DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product_color`
--

CREATE TABLE `product_color` (
  `id` bigint NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `product_storage_id` bigint DEFAULT NULL,
  `quantity` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product_comment`
--

CREATE TABLE `product_comment` (
  `id` bigint NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `created_time` time DEFAULT NULL,
  `star` float DEFAULT NULL,
  `product_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product_comment_image`
--

CREATE TABLE `product_comment_image` (
  `id` bigint NOT NULL,
  `link_image` varchar(255) DEFAULT NULL,
  `product_comment_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product_image`
--

CREATE TABLE `product_image` (
  `id` bigint NOT NULL,
  `link_image` varchar(255) DEFAULT NULL,
  `product_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product_storage`
--

CREATE TABLE `product_storage` (
  `id` bigint NOT NULL,
  `ram` varchar(255) DEFAULT NULL,
  `rom` varchar(255) DEFAULT NULL,
  `product_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `province`
--

CREATE TABLE `province` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `trade_mark`
--

CREATE TABLE `trade_mark` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `id` bigint NOT NULL,
  `activation_key` varchar(255) DEFAULT NULL,
  `actived` bit(1) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `token_fcm` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `authority_name` varchar(255) DEFAULT NULL,
  `remember_key` varchar(255) DEFAULT NULL,
  `user_type` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user_address`
--

CREATE TABLE `user_address` (
  `id` bigint NOT NULL,
  `created_date` date DEFAULT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `primary_addres` bit(1) DEFAULT NULL,
  `street_name` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `ward_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `voucher`
--

CREATE TABLE `voucher` (
  `id` bigint NOT NULL,
  `block` bit(1) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `min_amount` double DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `quantity` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `voucherupdate`
--

CREATE TABLE `voucherupdate` (
  `id` bigint NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `wards`
--

CREATE TABLE `wards` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `districts_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- ràng buộc cho các bảng
--

--
-- ràng buộc cho bảng `blog`
--
ALTER TABLE `blog`
  ADD CONSTRAINT `FKkr2fy24puc3x3sdnla4r1iok1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- ràng buộc cho bảng `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `FK4krba5ediaj0flkjp76isgcxv` FOREIGN KEY (`product_color_id`) REFERENCES `product_color` (`id`),
  ADD CONSTRAINT `FKg5uhi8vpsuy0lgloxk2h4w5o6` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- ràng buộc cho bảng `chatting`
--
ALTER TABLE `chatting`
  ADD CONSTRAINT `FKfaewt5773gq00mr4rlgkvb3hi` FOREIGN KEY (`receiver`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKmiq947q3icuu8tlfjknw8uwih` FOREIGN KEY (`sender`) REFERENCES `users` (`id`);

--
-- ràng buộc cho bảng `districts`
--
ALTER TABLE `districts`
  ADD CONSTRAINT `FKlxgu5dule1pse26iowlchxbnx` FOREIGN KEY (`province_id`) REFERENCES `province` (`id`);

--
-- ràng buộc cho bảng `history_pay`
--
ALTER TABLE `history_pay`
  ADD CONSTRAINT `FK3uqapx8urdm829chr0p30d0y2` FOREIGN KEY (`invoice_id`) REFERENCES `invoice` (`id`);

--
-- ràng buộc cho bảng `invoice`
--
ALTER TABLE `invoice`
  ADD CONSTRAINT `FKh8mc37lrohbk7stgatwwn5doq` FOREIGN KEY (`voucher_id`) REFERENCES `voucher` (`id`),
  ADD CONSTRAINT `FKm2237u7qq7ro3l5i5bwpxk3m1` FOREIGN KEY (`user_address_id`) REFERENCES `user_address` (`id`);

--
-- ràng buộc cho bảng `invoice_detail`
--
ALTER TABLE `invoice_detail`
  ADD CONSTRAINT `FKfmwmd1q9dcbk65r4pd1ybrgob` FOREIGN KEY (`product_color_id`) REFERENCES `product_color` (`id`),
  ADD CONSTRAINT `FKit1rbx4thcr6gx6bm3gxub3y4` FOREIGN KEY (`invoice_id`) REFERENCES `invoice` (`id`);

--
-- ràng buộc cho bảng `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `FK1mtsbur82frn64de7balymq9s` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  ADD CONSTRAINT `FKkvo9x5wjqpf8i48bksqoqujue` FOREIGN KEY (`trademark_id`) REFERENCES `trade_mark` (`id`);

--
-- ràng buộc cho bảng `product_color`
--
ALTER TABLE `product_color`
  ADD CONSTRAINT `FK9f1ipimr238tsmcgshnma63k` FOREIGN KEY (`product_storage_id`) REFERENCES `product_storage` (`id`);

--
-- ràng buộc cho bảng `product_comment`
--
ALTER TABLE `product_comment`
  ADD CONSTRAINT `FKf0dvop3xf5orf5j8icdwnq5ak` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  ADD CONSTRAINT `FKkg61diec02rh2o3xt4hjiy5u0` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- ràng buộc cho bảng `product_comment_image`
--
ALTER TABLE `product_comment_image`
  ADD CONSTRAINT `FK9jkf3unia7o8ylu9ar3sgd5py` FOREIGN KEY (`product_comment_id`) REFERENCES `product_comment` (`id`);

--
-- ràng buộc cho bảng `product_image`
--
ALTER TABLE `product_image`
  ADD CONSTRAINT `FK6oo0cvcdtb6qmwsga468uuukk` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`);

--
-- ràng buộc cho bảng `product_storage`
--
ALTER TABLE `product_storage`
  ADD CONSTRAINT `FKosydpas33gbw7icl0gyh0l6jr` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`);

--
-- ràng buộc cho bảng `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `FKq6r7e19l5xjmty0j0w6i2inlv` FOREIGN KEY (`authority_name`) REFERENCES `authority` (`name`);

--
-- ràng buộc cho bảng `user_address`
--
ALTER TABLE `user_address`
  ADD CONSTRAINT `FKrmincuqpi8m660j1c57xj7twr` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKrqr7o5wetvsyk4qbprim0p1ki` FOREIGN KEY (`ward_id`) REFERENCES `wards` (`id`);

--
-- ràng buộc cho bảng `wards`
--
ALTER TABLE `wards`
  ADD CONSTRAINT `FK44fn44vepk1iu1es803kydx3g` FOREIGN KEY (`districts_id`) REFERENCES `districts` (`id`);
COMMIT;

