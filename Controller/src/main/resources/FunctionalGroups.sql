INSERT INTO Users (first_name, last_name, gender, email, login, password, role)
VALUES ('admin', 'admin', 'male', 'admin@flatstock.com', 'admin', 'admin', 'administrator');

--General
INSERT INTO functional_groups (group_name, description)
VALUES ('Admin home', 'Admin general');

INSERT INTO urls (url, group_id)
VALUES ('/index.jsp', (SELECT id FROM functional_groups WHERE group_name = 'Admin home'));

--Edit Access
INSERT INTO functional_groups (group_name, description)
VALUES ('Edit access', 'Give possibility to edit access.');

INSERT INTO urls (url, group_id)
VALUES ('/accessEditor.jsp', (SELECT id FROM functional_groups WHERE group_name = 'Edit access'));

INSERT INTO urls (url, group_id)
VALUES ('/access', (SELECT id FROM functional_groups WHERE group_name = 'Edit access'));

INSERT INTO access_table (group_id, role)
VALUES ((SELECT id FROM functional_groups WHERE group_name = 'Edit access'), 'administrator'::role);


--View Users
INSERT INTO functional_groups (group_name, description)
VALUES ('View users', 'Give possibility to view users data.');

INSERT INTO urls (url, group_id)
VALUES ('/users', (SELECT id FROM functional_groups WHERE group_name = 'View users'));

INSERT INTO urls (url, group_id)
VALUES ('/users.jsp', (SELECT id FROM functional_groups WHERE group_name = 'View users'));


--Edit Users
INSERT INTO functional_groups (group_name, description)
VALUES ('Edit users', 'Give possibility to add, remove and update users data.');

INSERT INTO urls (url, group_id)
VALUES ('/addUser.jsp', (SELECT id FROM functional_groups WHERE group_name = 'Edit users'));

INSERT INTO urls (url, group_id)
VALUES ('/add_user', (SELECT id FROM functional_groups WHERE group_name = 'Edit users'));

INSERT INTO urls (url, group_id)
VALUES ('/remove_user', (SELECT id FROM functional_groups WHERE group_name = 'Edit users'));

INSERT INTO urls (url, group_id)
VALUES ('/updateUser.jsp', (SELECT id FROM functional_groups WHERE group_name = 'Edit users'));

INSERT INTO urls (url, group_id)
VALUES ('/update_user', (SELECT id FROM functional_groups WHERE group_name = 'Edit users'));

--View Apartments
INSERT INTO functional_groups (group_name, description)
VALUES ('View apartments', 'Give possibility to view apartments data.');

INSERT INTO urls (url, group_id)
VALUES ('/apartments', (SELECT id FROM functional_groups WHERE group_name = 'View apartments'));

INSERT INTO urls (url, group_id)
VALUES ('/apartments.jsp', (SELECT id FROM functional_groups WHERE group_name = 'View apartments'));


--Edit Apartments
INSERT INTO functional_groups (group_name, description)
VALUES ('Edit apartments', 'Give possibility to add, remove and update apartments data.');

INSERT INTO urls (url, group_id)
VALUES ('/addApartments.jsp', (SELECT id FROM functional_groups WHERE group_name = 'Edit apartments'));

INSERT INTO urls (url, group_id)
VALUES ('/add_apartments', (SELECT id FROM functional_groups WHERE group_name = 'Edit apartments'));

INSERT INTO urls (url, group_id)
VALUES ('/remove_apartments', (SELECT id FROM functional_groups WHERE group_name = 'Edit apartments'));

INSERT INTO urls (url, group_id)
VALUES ('/updateApartments.jsp', (SELECT id FROM functional_groups WHERE group_name = 'Edit apartments'));

INSERT INTO urls (url, group_id)
VALUES ('/update_apartments', (SELECT id FROM functional_groups WHERE group_name = 'Edit apartments'));

--View Reservations
INSERT INTO functional_groups (group_name, description)
VALUES ('View reservations', 'Give possibility to view reservations data.');

INSERT INTO urls (url, group_id)
VALUES ('/reservations', (SELECT id FROM functional_groups WHERE group_name = 'View reservations'));

INSERT INTO urls (url, group_id)
VALUES ('/reservations.jsp', (SELECT id FROM functional_groups WHERE group_name = 'View reservations'));


--Edit Reservations
INSERT INTO functional_groups (group_name, description)
VALUES ('Edit reservations', 'Give possibility to add, remove and update reservations data.');

INSERT INTO urls (url, group_id)
VALUES ('/addReservation.jsp', (SELECT id FROM functional_groups WHERE group_name = 'Edit reservations'));

INSERT INTO urls (url, group_id)
VALUES ('/add_reservation', (SELECT id FROM functional_groups WHERE group_name = 'Edit reservations'));

INSERT INTO urls (url, group_id)
VALUES ('/remove_reservation', (SELECT id FROM functional_groups WHERE group_name = 'Edit reservations'));

INSERT INTO urls (url, group_id)
VALUES ('/updateReservation.jsp', (SELECT id FROM functional_groups WHERE group_name = 'Edit reservations'));

INSERT INTO urls (url, group_id)
VALUES ('/update_reservation', (SELECT id FROM functional_groups WHERE group_name = 'Edit reservations'));

