USE
sensors;

INSERT INTO authorities (id, authority)
VALUES (1, 'Administrator'),
       (2, 'Viewer');

-- password for users is 'pass'
INSERT INTO users (id, username, password, is_enabled)
VALUES (1, 'Alex', '$2a$10$G7zDnQw22nVCP/85K5.Ku.zPWqaW9eTKlSpkigf4yy2dxClcIamq.', 1),
       (2, 'Rob', '$2a$10$G7zDnQw22nVCP/85K5.Ku.zPWqaW9eTKlSpkigf4yy2dxClcIamq.', 1);

INSERT INTO users_authorities (user_id, authority_id)
VALUES (1, 1),
       (2, 2);

INSERT INTO types (id, type)
VALUES (1, 'Pressure'),
       (2, 'Voltage'),
       (3, 'Temperature'),
       (4, 'Humidity');

INSERT INTO units (id, unit)
VALUES (1, 'bar'),
       (2, 'voltage'),
       (3, '°С'),
       (4, '%');

INSERT INTO sensors (name, model, from_val, to_val, type_id, unit_id, location, description)
VALUES ('Barometer', 'ac-23', 22, 45, 1, 2, 'kitchen', "it's a description about this sensor"),
       ('Test sensor', 'bc-34', 2, 20, 3, null, 'any', "small description"),
       ('Thermometer', '2000', 10, 90, 3, 3, null, null),
       ('Voltmeter', 'dec-2', 3, 80, 2, 2, 'any', "some description"),
       ('Humid sensor', 'b-98', 22, 45, 4, null, null, "it's a description about this sensor");

