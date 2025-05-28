-- 시퀀스가 있다면 생성 (없으면)
CREATE SEQUENCE IF NOT EXISTS crop_id_seq START WITH 1 INCREMENT BY 1;

-- 테이블 비우기 (기존 데이터 제거)
DELETE FROM crop;



-- 데이터를 수동으로 삽입 (PK 충돌 방지)
INSERT INTO crop(crop_id, crop_name, crop_description, crop_category)
VALUES
    (1, 'a', '설명1', 'FOOD'),
    (2, 'aa', '설명2', 'FOOD'),
    (3, 'aaa', '설명3', 'FOOD'),
    (4, 'aaaa', '설명4', 'VEGETABLE'),
    (5, 'aaaaa', '설명5', 'VEGETABLE'),
    (6, 'aaaaaa', '설명6', 'FLOWER'),
    (7, 'aaaaaaa', '설명7', 'FLOWER'),
    (8, 'aaaaaaaa', '설명8', 'SPECIAL'),
    (9, 'aaaaaaaaa', '설명9', 'SPECIAL'),
    (10, 'aaaaaaaaaa', '설명10', 'SPECIAL');
