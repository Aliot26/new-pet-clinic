#Create Databases
CREATE DATABASE clinic_dev;
CREATE DATABASE clinic_prod;

#Create database service accounts
CREATE USER 'clinic_dev_user'@'localhost' IDENTIFIED BY 'olga';
CREATE USER 'clinic_prod_user'@'localhost' IDENTIFIED BY 'olga';
CREATE USER 'clinic_dev_user'@'%' IDENTIFIED BY 'olga';
CREATE USER 'clinic_prod_user'@'%' IDENTIFIED BY 'olga';

#Database grants
GRANT SELECT ON clinic_dev.* to 'clinic_dev_user'@'localhost';
GRANT INSERT ON clinic_dev.* to 'clinic_dev_user'@'localhost';
GRANT DELETE ON clinic_dev.* to 'clinic_dev_user'@'localhost';
GRANT UPDATE ON clinic_dev.* to 'clinic_dev_user'@'localhost';
GRANT SELECT ON clinic_prod.* to 'clinic_prod_user'@'localhost';
GRANT INSERT ON clinic_prod.* to 'clinic_prod_user'@'localhost';
GRANT DELETE ON clinic_prod.* to 'clinic_prod_user'@'localhost';
GRANT UPDATE ON clinic_prod.* to 'clinic_prod_user'@'localhost';
GRANT SELECT ON clinic_dev.* to 'clinic_dev_user'@'%';
GRANT INSERT ON clinic_dev.* to 'clinic_dev_user'@'%';
GRANT DELETE ON clinic_dev.* to 'clinic_dev_user'@'%';
GRANT UPDATE ON clinic_dev.* to 'clinic_dev_user'@'%';
GRANT SELECT ON clinic_prod.* to 'clinic_prod_user'@'%';
GRANT INSERT ON clinic_prod.* to 'clinic_prod_user'@'%';
GRANT DELETE ON clinic_prod.* to 'clinic_prod_user'@'%';
GRANT UPDATE ON clinic_prod.* to 'clinic_prod_user'@'%';

