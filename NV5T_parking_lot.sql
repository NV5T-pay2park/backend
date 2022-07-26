DROP DATABASE IF EXISTS NV5T_parking_lot;
CREATE DATABASE NV5T_parking_lot;
USE NV5T_parking_lot;

CREATE TABLE end_users
(
    end_user_id INT   NOT NULL
        PRIMARY KEY AUTO_INCREMENT,
    first_name  VARCHAR(50) NOT NULL,
    last_name   VARCHAR(50) NOT NULL,
    gender      TINYINT     NOT NULL,
    phone       VARCHAR(10) NOT NULL,
    email       VARCHAR(50) NULL
);

CREATE TABLE merchants
(
    merchant_id INT   NOT NULL
        PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(50) NOT NULL,
    represent   VARCHAR(50) NOT NULL,
    email       VARCHAR(50) NOT NULL,
    phone       VARCHAR(50) NOT NULL
);

CREATE TABLE parking_lots
(
    parking_lot_id        INT   NOT NULL
        PRIMARY KEY AUTO_INCREMENT,
    parking_lot_name      VARCHAR(50) NULL,
    number_slot           INT         NOT NULL,
    number_slot_remaining INT         NOT NULL,
    address               VARCHAR(100) NOT NULL UNIQUE,
    status                TINYINT     NOT NULL,
    merchant_id           INT   NOT NULL,
    lat                   FLOAT(20, 15) NOT NULL,
    ing                   FLOAT(20, 15) NOT NULL,
    time_open             TINYINT      NOT NULL,
    time_close            TINYINT      NOT NULL,
    phone_number          VARCHAR(10)  NULL,
    CONSTRAINT parking_lot_merchants_fk
        FOREIGN KEY (merchant_id) REFERENCES merchants (merchant_id)
);

CREATE TABLE parking_lot_images
(
    image_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    parking_lot_id INT NOT NULL,
    url TEXT NOT NULL,
    CONSTRAINT parking_lot_images_parking_lot_fk FOREIGN KEY (parking_lot_id) REFERENCES parking_lots(parking_lot_id)
);
CREATE TABLE permissions
(
    permission_id   TINYINT     NOT NULL
        PRIMARY KEY,
    permission_name VARCHAR(50) NOT NULL,
    description     TEXT        NOT NULL,
    allow_add       TINYINT     NOT NULL,
    allow_edit      TINYINT     NOT NULL,
    allow_delete    TINYINT     NOT NULL,
    allow_export    TINYINT     NOT NULL
);

CREATE TABLE merchant_employees
(
    ID             INT   NOT NULL
        PRIMARY KEY AUTO_INCREMENT,
    user_name      VARCHAR(50) NOT NULL,
    first_name     VARCHAR(50) NOT NULL,
    last_name      VARCHAR(50) NOT NULL,
    gender         TINYINT     NOT NULL,
    password       binary(20)  NULL,
    email          VARCHAR(50) NULL,
    phone          VARCHAR(10) NOT NULL,
    avatar         TEXT        NULL,
    permission_id  TINYINT     NOT NULL,
    status         TINYINT     NOT NULL,
    parking_lot_id INT   NOT NULL,
    CONSTRAINT merchant_employee_parking_lot_fk
        FOREIGN KEY (parking_lot_id) REFERENCES parking_lots (parking_lot_id),
    CONSTRAINT merchant_employee_permission_fk
        FOREIGN KEY (permission_id) REFERENCES permissions (permission_id)
);

CREATE TABLE vehicle_types
(
    vehicle_type_id   TINYINT     NOT NULL
        PRIMARY KEY,
    vehicle_type_name VARCHAR(50) NOT NULL
);

CREATE TABLE price_tickets
(
    parking_lot_id  INT NOT NULL,
    vehicle_type_id TINYINT   NOT NULL,
    period_time     INT       NOT NULL,
    price           INT       NOT NULL,
    unit            TINYINT   NOT NULL,
    PRIMARY KEY (parking_lot_id, vehicle_type_id, period_time),
    CONSTRAINT price_tickets_parking_lot_fk
        FOREIGN KEY (parking_lot_id) REFERENCES parking_lots (parking_lot_id),
    CONSTRAINT price_tickets_vehicle_type_fk
        FOREIGN KEY (vehicle_type_id) REFERENCES vehicle_types (vehicle_type_id)
);

CREATE TABLE tickets
(
    ticket_id      BIGINT   NOT NULL
        PRIMARY KEY AUTO_INCREMENT,
    check_in_time  datetime    NOT NULL,
    check_out_time datetime    NULL,
    license_plates VARCHAR(15) NOT NULL,
    vehicle_type_id   TINYINT     NOT NULL,
    end_user_id    INT   NOT NULL,
    parking_lot_id INT   NOT NULL,
    CONSTRAINT ticket_end_user_fk
        FOREIGN KEY (end_user_id) REFERENCES end_users (end_user_id),
    CONSTRAINT ticket_parking_lot
        FOREIGN KEY (parking_lot_id) REFERENCES parking_lots (parking_lot_id),
    CONSTRAINT ticket_vehicle_type_fk
        FOREIGN KEY (vehicle_type_id) REFERENCES vehicle_types (vehicle_type_id)
);

CREATE TABLE transactions
(
    transaction_id   BIGINT   NOT NULL
        PRIMARY KEY,
    transaction_type VARCHAR(50) NOT NULL,
    ticket_id        BIGINT   NOT NULL,
    transaction_date datetime    NOT NULL,
    transaction_log  TEXT        NOT NULL,
    CONSTRAINT transaction_ticket_fk
        FOREIGN KEY (ticket_id) REFERENCES tickets (ticket_id)
);

# TABLE URL PAYMENT

CREATE TABLE payment_url
(
	app_tran_id VARCHAR(50) NOT NULL PRIMARY KEY,
    order_url varchar(255) default null
);




INSERT INTO NV5T_parking_lot.end_users (end_user_id, first_name, last_name, gender, phone, email) VALUES (1, 'Lee4an', 'whodahman', 1, '0416177645', 'whodahman@gmail.com');
INSERT INTO NV5T_parking_lot.end_users (end_user_id, first_name, last_name, gender, phone, email) VALUES (2, 'Partypooper009', 'throwaway217217', 0, '0790529870', 'throwaway217217@gmail.com');
INSERT INTO NV5T_parking_lot.end_users (end_user_id, first_name, last_name, gender, phone, email) VALUES (3, 'Jenna1021', 'neccernpogrlinzi15', 1, '0289754850', 'neccernpogrlinzi15@gmail.com');
INSERT INTO NV5T_parking_lot.end_users (end_user_id, first_name, last_name, gender, phone, email) VALUES (4, 'ALMEHZA_02', 'Rammyjosh11', 0, '0198549128', 'Rammyjosh11@gmail.com');
INSERT INTO NV5T_parking_lot.end_users (end_user_id, first_name, last_name, gender, phone, email) VALUES (5, 'Fakehashish', 'ultrastructure', 0, '0534088327', 'ultrastructure@gmail.com');
INSERT INTO NV5T_parking_lot.end_users (end_user_id, first_name, last_name, gender, phone, email) VALUES (6, 'TheeeHman', 'Smifter', 1, '0479004829', 'Smifter@gmail.com');
INSERT INTO NV5T_parking_lot.end_users (end_user_id, first_name, last_name, gender, phone, email) VALUES (7, 'dontlookatme20', 'joea7xfan', 0, '0429083537', 'joea7xfan@gmail.com');
INSERT INTO NV5T_parking_lot.end_users (end_user_id, first_name, last_name, gender, phone, email) VALUES (8, 'dogerlove', 'Ohamingju', 0, '0529586269', 'Ohamingju@gmail.com');
INSERT INTO NV5T_parking_lot.end_users (end_user_id, first_name, last_name, gender, phone, email) VALUES (9, 'theblacktaco', 'landep', 1, '0949256098', 'landep@gmail.com');
INSERT INTO NV5T_parking_lot.end_users (end_user_id, first_name, last_name, gender, phone, email) VALUES (10, 'idkwhattodoy', 'thatoneguy1000123', 1, '0372648751', 'thatoneguy1000123@gmail.com');
INSERT INTO NV5T_parking_lot.end_users (end_user_id, first_name, last_name, gender, phone, email) VALUES (11, 'hahahahhahelpme', 'aDucknamedFoieGras', 1, '0814416522', 'aDucknamedFoieGras@gmail.com');
INSERT INTO NV5T_parking_lot.end_users (end_user_id, first_name, last_name, gender, phone, email) VALUES (12, 'The_real_Schnitzel', 'BnanVu', 1, '0535932106', 'BnanVu@gmail.com');
INSERT INTO NV5T_parking_lot.end_users (end_user_id, first_name, last_name, gender, phone, email) VALUES (13, 'vicsloan', 'chestercham', 1, '0613232956', 'chestercham@gmail.com');
INSERT INTO NV5T_parking_lot.end_users (end_user_id, first_name, last_name, gender, phone, email) VALUES (14, 'katajin31309', 'Goldcap', 0, '0448229267', 'Goldcap@gmail.com');
INSERT INTO NV5T_parking_lot.end_users (end_user_id, first_name, last_name, gender, phone, email) VALUES (15, 'Xsxcx', 'Jjs18871975i', 0, '0839757762', 'Jjs18871975i@gmail.com');
INSERT INTO NV5T_parking_lot.end_users (end_user_id, first_name, last_name, gender, phone, email) VALUES (16, 'porchcoors50', 'conce008', 0, '0699432639', 'conce008@gmail.com');
INSERT INTO NV5T_parking_lot.end_users (end_user_id, first_name, last_name, gender, phone, email) VALUES (17, 'idiociest', 'husolmoMage', 0, '0619835669', 'husolmoMage@gmail.com');
INSERT INTO NV5T_parking_lot.end_users (end_user_id, first_name, last_name, gender, phone, email) VALUES (18, 'BizzarGhostGaming', 'peterjeckub', 1, '0960366271', 'peterjeckub@gmail.com');
INSERT INTO NV5T_parking_lot.end_users (end_user_id, first_name, last_name, gender, phone, email) VALUES (19, 'AmazingDieudo', 'julianbremann', 1, '0027948327', 'julianbremann@gmail.com');
INSERT INTO NV5T_parking_lot.end_users (end_user_id, first_name, last_name, gender, phone, email) VALUES (20, 'RayShmurda6', 'rohan23', 0, '0517129255', 'rohan23@gmail.com');
INSERT INTO NV5T_parking_lot.end_users (end_user_id, first_name, last_name, gender, phone, email) VALUES (21, 'Lost-n-Confused28', 'UKWIZZZARD', 0, '0959832005', 'UKWIZZZARD@gmail.com');
INSERT INTO NV5T_parking_lot.end_users (end_user_id, first_name, last_name, gender, phone, email) VALUES (22, 'GrimmMarshal', 'mzcameron', 1, '0401205001', 'mzcameron@gmail.com');
INSERT INTO NV5T_parking_lot.end_users (end_user_id, first_name, last_name, gender, phone, email) VALUES (23, 'inception73', 'I_PLOT_YOUR_REVENGE', 0, '0544985803', 'I_PLOT_YOUR_REVENGE@gmail.com');
INSERT INTO NV5T_parking_lot.end_users (end_user_id, first_name, last_name, gender, phone, email) VALUES (24, 'Rahulkumar18', 'marriedinmay', 1, '0015797327', 'marriedinmay@gmail.com');
INSERT INTO NV5T_parking_lot.end_users (end_user_id, first_name, last_name, gender, phone, email) VALUES (25, 'MBSUPERSPAZZ', 'Prodigy_Throwaway', 0, '0225392283', 'Prodigy_Throwaway@gmail.com');
INSERT INTO NV5T_parking_lot.end_users (end_user_id, first_name, last_name, gender, phone, email) VALUES (26, 'eriktheredhead', 'ThrowawayMyOlives', 1, '0466991116', 'ThrowawayMyOlives@gmail.com');
INSERT INTO NV5T_parking_lot.end_users (end_user_id, first_name, last_name, gender, phone, email) VALUES (27, 'randomstuff063', 'Bug337', 1, '0931727434', 'Bug337@gmail.com');
INSERT INTO NV5T_parking_lot.end_users (end_user_id, first_name, last_name, gender, phone, email) VALUES (28, 'llIlIllilIlllI', 'Alasiaanne', 0, '0108915387', 'Alasiaanne@gmail.com');
INSERT INTO NV5T_parking_lot.end_users (end_user_id, first_name, last_name, gender, phone, email) VALUES (29, 'pego_tinn', '87786768768', 0, '0059968514', '87786768768@gmail.com');
INSERT INTO NV5T_parking_lot.end_users (end_user_id, first_name, last_name, gender, phone, email) VALUES (30, 'whoisthatgirl1', 'windom__earle', 0, '0201778799', 'windom__earle@gmail.com');

INSERT INTO NV5T_parking_lot.merchants (merchant_id, name, represent, email, phone) VALUES (1, 'Thành phố Thủ Đức', 'Lee4an', 'Lee4an@gmail.com', '0906094163');
INSERT INTO NV5T_parking_lot.merchants (merchant_id, name, represent, email, phone) VALUES (2, 'Quận 1', 'Partypooper009', 'Partypooper009@gmail.com', '0522503744');
INSERT INTO NV5T_parking_lot.merchants (merchant_id, name, represent, email, phone) VALUES (3, 'Quận 3', 'Jenna1021', 'Jenna1021@gmail.com', '0243360920');
INSERT INTO NV5T_parking_lot.merchants (merchant_id, name, represent, email, phone) VALUES (4, 'Quận 7', 'ALMEHZA_02', 'ALMEHZA_02@gmail.com', '0887315211');
INSERT INTO NV5T_parking_lot.merchants (merchant_id, name, represent, email, phone) VALUES (5, 'Quận 12', 'Fakehashish', 'Fakehashish@gmail.com', '0848857628');
INSERT INTO NV5T_parking_lot.merchants (merchant_id, name, represent, email, phone) VALUES (6, 'Quận Bình Tân', 'TheeeHman', 'TheeeHman@gmail.com', '0447385416');
INSERT INTO NV5T_parking_lot.merchants (merchant_id, name, represent, email, phone) VALUES (7, 'Quận Tân Phú', 'dontlookatme20', 'dontlookatme20@gmail.com', '0895290467');

INSERT INTO NV5T_parking_lot.permissions (permission_id, permission_name, description, allow_add, allow_edit, allow_delete, allow_export) VALUES (1, 'admin', 'role admin', 1, 1, 1, 1);



INSERT INTO NV5T_parking_lot.parking_lots (parking_lot_id, parking_lot_name, number_slot, number_slot_remaining, address, status, merchant_id, lat, ing, time_open, time_close, phone_number) VALUES (1, 'Hoà Thạnh', 184, 184, 'An Khánh, Thành phố Thủ Đức, TPHCM', 0, 1, 10.783889, 106.734722, 5, 22, 0982347126);
INSERT INTO NV5T_parking_lot.parking_lots (parking_lot_id, parking_lot_name, number_slot, number_slot_remaining, address, status, merchant_id, lat, ing, time_open, time_close, phone_number) VALUES (2, 'Thủ Thiêm', 80, 80, 'Hiệp Phú, Thành phố Thủ Đức, TPHCM', 0, 1, 10.846667, 106.777778, 5, 22, 0982347126);
INSERT INTO NV5T_parking_lot.parking_lots (parking_lot_id, parking_lot_name, number_slot, number_slot_remaining, address, status, merchant_id, lat, ing, time_open, time_close, phone_number) VALUES (3, 'Trường Thọ', 153, 153, 'Linh Chiểu, Thành phố Thủ Đức, TPHCM', 0, 1, 10.856389, 106.7625, 5, 22, 0982347126);
INSERT INTO NV5T_parking_lot.parking_lots (parking_lot_id, parking_lot_name, number_slot, number_slot_remaining, address, status, merchant_id, lat, ing, time_open, time_close, phone_number) VALUES (4, 'Bến Nghé', 71, 71, 'Linh Trung, Thành phố Thủ Đức, TPHCM', 0, 1, 10.863889, 106.782778, 5, 22, 0982347126);
INSERT INTO NV5T_parking_lot.parking_lots (parking_lot_id, parking_lot_name, number_slot, number_slot_remaining, address, status, merchant_id, lat, ing, time_open, time_close, phone_number) VALUES (5, 'Bình Chiểu', 101, 101, 'Linh Xuân, Thành phố Thủ Đức, TPHCM', 0, 1, 10.882222, 106.768889, 5, 22, 0982347126);
INSERT INTO NV5T_parking_lot.parking_lots (parking_lot_id, parking_lot_name, number_slot, number_slot_remaining, address, status, merchant_id, lat, ing, time_open, time_close, phone_number) VALUES (6, 'Hiệp Phú', 101, 101, 'Bình Chiểu, Thành phố Thủ Đức, TPHCM', 0, 1, 10.884167, 106.730278, 5, 22, 0982347126);
INSERT INTO NV5T_parking_lot.parking_lots (parking_lot_id, parking_lot_name, number_slot, number_slot_remaining, address, status, merchant_id, lat, ing, time_open, time_close, phone_number) VALUES (7, 'Tân Thuận Đông', 163, 163, 'Tăng Nhơn Phú A, Thành phố Thủ Đức, TPHCM', 0, 1, 10.843611, 106.791389, 5, 22, 0982347126);
INSERT INTO NV5T_parking_lot.parking_lots (parking_lot_id, parking_lot_name, number_slot, number_slot_remaining, address, status, merchant_id, lat, ing, time_open, time_close, phone_number) VALUES (8, 'Bến Thành', 119, 119, 'Thảo Điền, Thành phố Thủ Đức, TPHCM', 0, 1, 10.81, 106.733333, 5, 22, 0982347126);
INSERT INTO NV5T_parking_lot.parking_lots (parking_lot_id, parking_lot_name, number_slot, number_slot_remaining, address, status, merchant_id, lat, ing, time_open, time_close, phone_number) VALUES (9, 'Linh Xuân', 187, 187, 'Thủ Thiêm, Thành phố Thủ Đức, TPHCM', 0, 1, 10.771944, 106.715, 5, 22, 0982347126);
INSERT INTO NV5T_parking_lot.parking_lots (parking_lot_id, parking_lot_name, number_slot, number_slot_remaining, address, status, merchant_id, lat, ing, time_open, time_close, phone_number) VALUES (10, 'Tân Thuận Tây', 75, 75, 'Trường Thọ, Thành phố Thủ Đức, TPHCM', 0, 1, 10.833056, 106.755, 5, 22, 0982347126);
INSERT INTO NV5T_parking_lot.parking_lots (parking_lot_id, parking_lot_name, number_slot, number_slot_remaining, address, status, merchant_id, lat, ing, time_open, time_close, phone_number) VALUES (11, 'Linh Trung', 130, 130, 'Bến Nghé, Quận 1, TPHCM', 0, 2, 10.782222, 106.702778, 5, 22, 0982347126);
INSERT INTO NV5T_parking_lot.parking_lots (parking_lot_id, parking_lot_name, number_slot, number_slot_remaining, address, status, merchant_id, lat, ing, time_open, time_close, phone_number) VALUES (12, 'Hiệp Thành', 81, 81, 'Bến Thành, Quận 1, TPHCM', 0, 2, 10.772521, 106.698019, 5, 22, 0982347126);
INSERT INTO NV5T_parking_lot.parking_lots (parking_lot_id, parking_lot_name, number_slot, number_slot_remaining, address, status, merchant_id, lat, ing, time_open, time_close, phone_number) VALUES (13, 'Võ Thị Sáu', 103, 103, 'Đa Kao, Quận 1, TPHCM', 0, 2, 10.789167, 106.696944, 5, 22, 0982347126);
INSERT INTO NV5T_parking_lot.parking_lots (parking_lot_id, parking_lot_name, number_slot, number_slot_remaining, address, status, merchant_id, lat, ing, time_open, time_close, phone_number) VALUES (14, 'Bình Hưng Hòa', 146, 146, 'Phường Võ Thị Sáu, Quận 3, TPHCM', 0, 3, 10.783408, 106.69077, 5, 22, 0982347126);
INSERT INTO NV5T_parking_lot.parking_lots (parking_lot_id, parking_lot_name, number_slot, number_slot_remaining, address, status, merchant_id, lat, ing, time_open, time_close, phone_number) VALUES (15, 'Thảo Điền', 124, 124, 'Tân Thuận Đông, Quận 7, TPHCM', 0, 4, 10.758333, 106.735, 5, 22, 0982347126);
INSERT INTO NV5T_parking_lot.parking_lots (parking_lot_id, parking_lot_name, number_slot, number_slot_remaining, address, status, merchant_id, lat, ing, time_open, time_close, phone_number) VALUES (16, 'Linh Chiểu', 175, 175, 'Tân Thuận Tây, Quận 7, TPHCM', 0, 4, 10.751667, 106.720556, 5, 22, 0982347126);
INSERT INTO NV5T_parking_lot.parking_lots (parking_lot_id, parking_lot_name, number_slot, number_slot_remaining, address, status, merchant_id, lat, ing, time_open, time_close, phone_number) VALUES (17, 'Hiệp Tân', 148, 148, 'An Phú Đông, Quận 12, TPHCM', 0, 5, 10.851667, 106.697222 , 5, 22, 0982347126);
INSERT INTO NV5T_parking_lot.parking_lots (parking_lot_id, parking_lot_name, number_slot, number_slot_remaining, address, status, merchant_id, lat, ing, time_open, time_close, phone_number) VALUES (18, 'Tăng Nhơn Phú', 54, 54, 'Hiệp Thành, Quận 12, TPHCM', 0, 5, 10.881111, 106.635278 , 5, 22, 0982347126);
INSERT INTO NV5T_parking_lot.parking_lots (parking_lot_id, parking_lot_name, number_slot, number_slot_remaining, address, status, merchant_id, lat, ing, time_open, time_close, phone_number) VALUES (19, 'An Phú Đông', 63, 63, 'An Lạc, Quận Bình Tân, TPHCM', 0, 6, 10.722222, 106.611111, 5, 22, 0982347126);
INSERT INTO NV5T_parking_lot.parking_lots (parking_lot_id, parking_lot_name, number_slot, number_slot_remaining, address, status, merchant_id, lat, ing, time_open, time_close, phone_number) VALUES (20, 'Đa Kao', 89, 89, 'Bình Hưng Hòa, Quận Bình Tân, TPHCM', 0, 6, 10.8025, 106.6, 5, 22, 0982347126);
INSERT INTO NV5T_parking_lot.parking_lots (parking_lot_id, parking_lot_name, number_slot, number_slot_remaining, address, status, merchant_id, lat, ing, time_open, time_close, phone_number) VALUES (21, 'An Lạc', 161, 161, 'Hiệp Tân, Quận Tân Phú, TPHCM', 0, 7, 10.768889, 106.626667 , 5, 22, 0982347126);
INSERT INTO NV5T_parking_lot.parking_lots (parking_lot_id, parking_lot_name, number_slot, number_slot_remaining, address, status, merchant_id, lat, ing, time_open, time_close, phone_number) VALUES (22, 'An Khánh', 145, 145, 'Hoà Thạnh, Quận Tân Phú, TPHCM', 0, 7, 10.779167, 106.634722, 5, 22, 0982347126);

INSERT INTO NV5T_parking_lot.vehicle_types (vehicle_type_id, vehicle_type_name) VALUES (0, 'Xe đạp');
INSERT INTO NV5T_parking_lot.vehicle_types (vehicle_type_id, vehicle_type_name) VALUES (1, 'Xe máy');
INSERT INTO NV5T_parking_lot.vehicle_types (vehicle_type_id, vehicle_type_name) VALUES (2, 'Xe hơi 4 chỗ hoặc 7 chỗ');
INSERT INTO NV5T_parking_lot.vehicle_types (vehicle_type_id, vehicle_type_name) VALUES (3, 'Xe hơi 16 chỗ');

INSERT INTO NV5T_parking_lot.merchant_employees (ID, user_name, first_name, last_name, gender, password, email, phone, avatar, permission_id, status, parking_lot_id) VALUES (1, 'tienthanh', 'Thanh', 'Tien', 0, 0x3132330000000000000000000000000000000000, 'tienthanh@gmail.com', '0987654321', ':3', 1, 0, 1);
# SELECT * FROM end_users;
INSERT INTO NV5T_parking_lot.tickets (ticket_id, check_in_time, check_out_time, license_plates, vehicle_type_id, end_user_id, parking_lot_id) VALUES (1, '2022-07-18 14:26:34', null, '77C1-6180', 1, 5, 5);
INSERT INTO NV5T_parking_lot.tickets (ticket_id, check_in_time, check_out_time, license_plates, vehicle_type_id, end_user_id, parking_lot_id) VALUES (6, '2022-07-18 14:27:44', null, '77C1-85085', 1, 5, 8);
INSERT INTO NV5T_parking_lot.tickets (ticket_id, check_in_time, check_out_time, license_plates, vehicle_type_id, end_user_id, parking_lot_id) VALUES (7, '2022-07-18 14:27:45', null, '77C1-99794', 1, 3, 5);
INSERT INTO NV5T_parking_lot.tickets (ticket_id, check_in_time, check_out_time, license_plates, vehicle_type_id, end_user_id, parking_lot_id) VALUES (8, '2022-07-18 14:27:46', null, '77C1-86249', 1, 6, 5);
INSERT INTO NV5T_parking_lot.tickets (ticket_id, check_in_time, check_out_time, license_plates, vehicle_type_id, end_user_id, parking_lot_id) VALUES (9, '2022-07-18 14:27:46', null, '77C1-5505', 1, 5, 3);
INSERT INTO NV5T_parking_lot.tickets (ticket_id, check_in_time, check_out_time, license_plates, vehicle_type_id, end_user_id, parking_lot_id) VALUES (10, '2022-07-18 14:27:47', null, '77C1-11641', 1, 6, 7);
INSERT INTO NV5T_parking_lot.tickets (ticket_id, check_in_time, check_out_time, license_plates, vehicle_type_id, end_user_id, parking_lot_id) VALUES (11, '2022-07-18 14:27:47', null, '77C1-82649', 1, 9, 1);
INSERT INTO NV5T_parking_lot.tickets (ticket_id, check_in_time, check_out_time, license_plates, vehicle_type_id, end_user_id, parking_lot_id) VALUES (12, '2022-07-18 14:27:47', null, '77C1-97648', 1, 4, 2);
INSERT INTO NV5T_parking_lot.tickets (ticket_id, check_in_time, check_out_time, license_plates, vehicle_type_id, end_user_id, parking_lot_id) VALUES (13, '2022-07-18 14:27:48', null, '77C1-80268', 1, 4, 9);
INSERT INTO NV5T_parking_lot.tickets (ticket_id, check_in_time, check_out_time, license_plates, vehicle_type_id, end_user_id, parking_lot_id) VALUES (14, '2022-07-18 14:27:48', null, '77C1-84935', 1, 1, 1);
INSERT INTO NV5T_parking_lot.tickets (ticket_id, check_in_time, check_out_time, license_plates, vehicle_type_id, end_user_id, parking_lot_id) VALUES (15, '2022-07-18 14:27:48', null, '77C1-27549', 1, 6, 4);
INSERT INTO NV5T_parking_lot.tickets (ticket_id, check_in_time, check_out_time, license_plates, vehicle_type_id, end_user_id, parking_lot_id) VALUES (16, '2022-07-18 14:27:48', null, '77C1-10662', 1, 3, 2);
INSERT INTO NV5T_parking_lot.tickets (ticket_id, check_in_time, check_out_time, license_plates, vehicle_type_id, end_user_id, parking_lot_id) VALUES (18, '2022-07-18 14:27:48', null, '77C1-44094', 1, 2, 6);
INSERT INTO NV5T_parking_lot.tickets (ticket_id, check_in_time, check_out_time, license_plates, vehicle_type_id, end_user_id, parking_lot_id) VALUES (21, '2022-07-18 14:27:49', null, '77C1-37895', 1, 9, 9);
INSERT INTO NV5T_parking_lot.tickets (ticket_id, check_in_time, check_out_time, license_plates, vehicle_type_id, end_user_id, parking_lot_id) VALUES (22, '2022-07-18 14:27:50', null, '77C1-79353', 1, 1, 11);
INSERT INTO NV5T_parking_lot.tickets (ticket_id, check_in_time, check_out_time, license_plates, vehicle_type_id, end_user_id, parking_lot_id) VALUES (23, '2022-07-18 14:27:50', null, '77C1-25074', 1, 9, 8);
INSERT INTO NV5T_parking_lot.tickets (ticket_id, check_in_time, check_out_time, license_plates, vehicle_type_id, end_user_id, parking_lot_id) VALUES (24, '2022-07-18 14:27:50', null, '77C1-63352', 1, 5, 9);

INSERT INTO NV5T_parking_lot.price_tickets (parking_lot_id, vehicle_type_id, period_time, price, unit) VALUES (1, 1, 0, 5000, 4), (1, 1, 4, 3000, 4), (1, 1, 8, 2000, 4), (1, 0, 0, 3000, 4), (1, 0, 4, 2000, 4), (1, 0, 8, 1000, 4), (1, 2, 0, 20000, 4), (1, 2, 4, 10000, 4), (1, 2, 8, 5000, 4), (1, 3, 0, 50000, 4), (1, 3, 4, 25000, 4), (1, 3, 8, 10000, 4);
INSERT INTO NV5T_parking_lot.price_tickets (parking_lot_id, vehicle_type_id, period_time, price, unit) VALUES (2, 1, 0, 5000, 4), (2, 1, 4, 3000, 4), (2, 1, 8, 2000, 4), (2, 0, 0, 3000, 4), (2, 0, 4, 2000, 4), (2, 0, 8, 1000, 4), (2, 2, 0, 20000, 4), (2, 2, 4, 10000, 4), (2, 2, 8, 5000, 4), (2, 3, 0, 50000, 4), (2, 3, 4, 25000, 4), (2, 3, 8, 10000, 4);
INSERT INTO NV5T_parking_lot.price_tickets (parking_lot_id, vehicle_type_id, period_time, price, unit) VALUES (3, 1, 0, 5000, 4), (3, 1, 4, 3000, 4), (3, 1, 8, 2000, 4), (3, 0, 0, 3000, 4), (3, 0, 4, 2000, 4), (3, 0, 8, 1000, 4), (3, 2, 0, 20000, 4), (3, 2, 4, 10000, 4), (3, 2, 8, 5000, 4), (3, 3, 0, 50000, 4), (3, 3, 4, 25000, 4), (3, 3, 8, 10000, 4);
INSERT INTO NV5T_parking_lot.price_tickets (parking_lot_id, vehicle_type_id, period_time, price, unit) VALUES (4, 1, 0, 5000, 4), (4, 1, 4, 3000, 4), (4, 1, 8, 2000, 4), (4, 0, 0, 3000, 4), (4, 0, 4, 2000, 4), (4, 0, 8, 1000, 4), (4, 2, 0, 20000, 4), (4, 2, 4, 10000, 4), (4, 2, 8, 5000, 4), (4, 3, 0, 50000, 4), (4, 3, 4, 25000, 4), (4, 3, 8, 10000, 4);
INSERT INTO NV5T_parking_lot.price_tickets (parking_lot_id, vehicle_type_id, period_time, price, unit) VALUES (5, 1, 0, 5000, 4), (5, 1, 4, 3000, 4), (5, 1, 8, 2000, 4);
INSERT INTO NV5T_parking_lot.price_tickets (parking_lot_id, vehicle_type_id, period_time, price, unit) VALUES (6, 1, 0, 5000, 4), (6, 1, 4, 3000, 4), (6, 1, 8, 2000, 4);
INSERT INTO NV5T_parking_lot.price_tickets (parking_lot_id, vehicle_type_id, period_time, price, unit) VALUES (7, 1, 0, 5000, 4), (7, 1, 4, 3000, 4), (7, 1, 8, 2000, 4);
INSERT INTO NV5T_parking_lot.price_tickets (parking_lot_id, vehicle_type_id, period_time, price, unit) VALUES (8, 1, 0, 5000, 4), (8, 1, 4, 3000, 4), (8, 1, 8, 2000, 4);
INSERT INTO NV5T_parking_lot.price_tickets (parking_lot_id, vehicle_type_id, period_time, price, unit) VALUES (9, 1, 0, 5000, 4), (9, 1, 4, 3000, 4), (9, 1, 8, 2000, 4);
INSERT INTO NV5T_parking_lot.price_tickets (parking_lot_id, vehicle_type_id, period_time, price, unit) VALUES (10, 1, 0, 5000, 4), (10, 1, 4, 3000, 4), (10, 1, 8, 2000, 4), (10, 0, 0, 3000, 4), (10, 0, 4, 2000, 4), (10, 0, 8, 1000, 4), (10, 2, 0, 20000, 4), (10, 2, 4, 10000, 4), (10, 2, 8, 5000, 4);
INSERT INTO NV5T_parking_lot.price_tickets (parking_lot_id, vehicle_type_id, period_time, price, unit) VALUES (11, 1, 0, 5000, 4), (11, 1, 4, 3000, 4), (11, 1, 8, 2000, 4), (11, 0, 0, 3000, 4), (11, 0, 4, 2000, 4), (11, 0, 8, 1000, 4), (11, 2, 0, 20000, 4), (11, 2, 4, 10000, 4), (11, 2, 8, 5000, 4);
INSERT INTO NV5T_parking_lot.price_tickets (parking_lot_id, vehicle_type_id, period_time, price, unit) VALUES (12, 1, 0, 5000, 4), (12, 1, 4, 3000, 4), (12, 1, 8, 2000, 4), (12, 0, 0, 3000, 4), (12, 0, 4, 2000, 4), (12, 0, 8, 1000, 4), (12, 2, 0, 20000, 4), (12, 2, 4, 10000, 4), (12, 2, 8, 5000, 4);
INSERT INTO NV5T_parking_lot.price_tickets (parking_lot_id, vehicle_type_id, period_time, price, unit) VALUES (13, 1, 0, 5000, 4), (13, 1, 4, 3000, 4), (13, 1, 8, 2000, 4), (13, 0, 0, 3000, 4), (13, 0, 4, 2000, 4), (13, 0, 8, 1000, 4), (13, 2, 0, 20000, 4), (13, 2, 4, 10000, 4), (13, 2, 8, 5000, 4);
INSERT INTO NV5T_parking_lot.price_tickets (parking_lot_id, vehicle_type_id, period_time, price, unit) VALUES (14, 1, 0, 5000, 4), (14, 1, 4, 3000, 4), (14, 1, 8, 2000, 4), (14, 0, 0, 3000, 4), (14, 0, 4, 2000, 4), (14, 0, 8, 1000, 4), (14, 2, 0, 20000, 4), (14, 2, 4, 10000, 4), (14, 2, 8, 5000, 4);
INSERT INTO NV5T_parking_lot.price_tickets (parking_lot_id, vehicle_type_id, period_time, price, unit) VALUES (15, 1, 0, 5000, 4), (15, 1, 4, 3000, 4), (15, 1, 8, 2000, 4), (15, 0, 0, 3000, 4), (15, 0, 4, 2000, 4), (15, 0, 8, 1000, 4), (15, 2, 0, 20000, 4), (15, 2, 4, 10000, 4), (15, 2, 8, 5000, 4);
INSERT INTO NV5T_parking_lot.price_tickets (parking_lot_id, vehicle_type_id, period_time, price, unit) VALUES (16, 1, 0, 5000, 4), (16, 1, 4, 3000, 4), (16, 1, 8, 2000, 4), (16, 0, 0, 3000, 4), (16, 0, 4, 2000, 4), (16, 0, 8, 1000, 4), (16, 2, 0, 20000, 4), (16, 2, 4, 10000, 4), (16, 2, 8, 5000, 4);
INSERT INTO NV5T_parking_lot.price_tickets (parking_lot_id, vehicle_type_id, period_time, price, unit) VALUES (17, 1, 0, 5000, 4), (17, 1, 4, 3000, 4), (17, 1, 8, 2000, 4), (17, 0, 0, 3000, 4), (17, 0, 4, 2000, 4), (17, 0, 8, 1000, 4), (17, 2, 0, 20000, 4), (17, 2, 4, 10000, 4), (17, 2, 8, 5000, 4);
INSERT INTO NV5T_parking_lot.price_tickets (parking_lot_id, vehicle_type_id, period_time, price, unit) VALUES (18, 1, 0, 5000, 4), (18, 1, 4, 3000, 4), (18, 1, 8, 2000, 4), (18, 0, 0, 3000, 4), (18, 0, 4, 2000, 4), (18, 0, 8, 1000, 4);
INSERT INTO NV5T_parking_lot.price_tickets (parking_lot_id, vehicle_type_id, period_time, price, unit) VALUES (19, 1, 0, 5000, 4), (19, 1, 4, 3000, 4), (19, 1, 8, 2000, 4), (19, 0, 0, 3000, 4), (19, 0, 4, 2000, 4), (19, 0, 8, 1000, 4);
INSERT INTO NV5T_parking_lot.price_tickets (parking_lot_id, vehicle_type_id, period_time, price, unit) VALUES (20, 1, 0, 5000, 4), (20, 1, 4, 3000, 4), (20, 1, 8, 2000, 4), (20, 0, 0, 3000, 4), (20, 0, 4, 2000, 4), (20, 0, 8, 1000, 4);
INSERT INTO NV5T_parking_lot.price_tickets (parking_lot_id, vehicle_type_id, period_time, price, unit) VALUES (21, 1, 0, 5000, 4), (21, 1, 4, 3000, 4), (21, 1, 8, 2000, 4), (21, 0, 0, 3000, 4), (21, 0, 4, 2000, 4), (21, 0, 8, 1000, 4);
INSERT INTO NV5T_parking_lot.price_tickets (parking_lot_id, vehicle_type_id, period_time, price, unit) VALUES (22, 1, 0, 5000, 4), (22, 1, 4, 3000, 4), (22, 1, 8, 2000, 4), (22, 0, 0, 3000, 4), (22, 0, 4, 2000, 4), (22, 0, 8, 1000, 4);


INSERT INTO NV5T_parking_lot.payment_url(app_tran_id, order_url) VALUES ('220726_134222','https://sbgateway.zalopay.vn/openinapp?order=eyJ6cHRyYW5zdG9rZW4iOiIyMjA3MjYwMDAwMDA0MDNXMVZVOVdaIiwiYXBwaWQiOjk5OTg4OH0');


# fulltext index
ALTER TABLE NV5T_parking_lot.parking_lots ADD FULLTEXT(parking_lot_name, address);

