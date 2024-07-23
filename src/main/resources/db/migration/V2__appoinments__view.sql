CREATE VIEW appointments_view AS
SELECT
    a.id AS appointment_id,
    p.fullname AS patient_name,
    d.fullname AS doctor_name,
    a.created_at AS appointment_date,
    a.reason AS appointment_reason
FROM
    appoinments a
        JOIN
    patients p ON a.patients_id = p.id
        JOIN
    doctor d ON a.doctor_id = d.id;
