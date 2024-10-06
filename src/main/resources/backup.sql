-- Drop existing tables
DROP TABLE IF EXISTS mock_otp CASCADE;
DROP TABLE IF EXISTS pcc_details CASCADE;
DROP TABLE IF EXISTS personal_details CASCADE;

-- Create tables again (if they are not auto-created by Hibernate)
CREATE TABLE personal_details (
    aadhar_number VARCHAR(12) PRIMARY KEY,
    photo TEXT,
    name VARCHAR(100),
    dob DATE,
    gender VARCHAR(10),
    address TEXT
);

CREATE TABLE mock_otp (
    aadhar_number VARCHAR(12) PRIMARY KEY,
    phone_number VARCHAR(15),
    otp CHAR(6),
    FOREIGN KEY (aadhar_number) REFERENCES personal_details(aadhar_number)
);

CREATE TABLE pcc_details (
    application_id VARCHAR(15) PRIMARY KEY,
    phone_number VARCHAR(15),
    police_station_location VARCHAR(100)
);

-- PersonalDetails data
INSERT INTO personal_details (aadhar_number, photo, name, dob, gender, address)
VALUES ('123456789012', 'https://example.com/photos/sarika_deshmukh.jpg', 'Sarika Deshmukh', '1992-01-12', 'Female', 'Sadashiv Peth, Pune, Maharashtra');
INSERT INTO personal_details (aadhar_number, photo, name, dob, gender, address)
VALUES ('234567890123', 'https://example.com/photos/nisha_rao.jpg', 'Nisha Rao', '1993-02-23', 'Female', 'Kothrud, Pune, Maharashtra');
INSERT INTO personal_details (aadhar_number, photo, name, dob, gender, address)
VALUES ('345678901234', 'https://example.com/photos/sneha_ghadge.jpg', 'Sneha Ghadge', '1994-03-15', 'Female', 'Wadgaon Sheri, Pune, Maharashtra');
INSERT INTO personal_details (aadhar_number, photo, name, dob, gender, address)
VALUES ('456789012345', 'https://example.com/photos/priyanka_kulkarni.jpg', 'Priyanka Kulkarni', '1995-04-25', 'Female', 'Bibwewadi, Pune, Maharashtra');
INSERT INTO personal_details (aadhar_number, photo, name, dob, gender, address)
VALUES ('567890123456', 'https://example.com/photos/anjali_khandare.jpg', 'Anjali Khandare', '1996-05-18', 'Female', 'Aundh, Pune, Maharashtra');

-- MockOtp data
INSERT INTO mock_otp (aadhar_number, phone_number, otp) VALUES ('123456789012', '9876543210', '678912');
INSERT INTO mock_otp (aadhar_number, phone_number, otp) VALUES ('234567890123', '8765432109', '123456');
INSERT INTO mock_otp (aadhar_number, phone_number, otp) VALUES ('345678901234', '7654321098', '432198');
INSERT INTO mock_otp (aadhar_number, phone_number, otp) VALUES ('456789012345', '6543210987', '876543');
INSERT INTO mock_otp (aadhar_number, phone_number, otp) VALUES ('567890123456', '5432109876', '987654');

-- PccDetails data
INSERT INTO pcc_details (application_id, phone_number, police_station_location)
VALUES ('APP001234567890', '9876543210', 'Pune City Police Station');
INSERT INTO pcc_details (application_id, phone_number, police_station_location)
VALUES ('APP002345678901', '8765432109', 'Kothrud Police Station');
INSERT INTO pcc_details (application_id, phone_number, police_station_location)
VALUES ('APP003456789012', '7654321098', 'Wadgaon Sheri Police Station');
INSERT INTO pcc_details (application_id, phone_number, police_station_location)
VALUES ('APP004567890123', '6543210987', 'Bibwewadi Police Station');
INSERT INTO pcc_details (application_id, phone_number, police_station_location)
VALUES ('APP005678901234', '5432109876', 'Aundh Police Station');
