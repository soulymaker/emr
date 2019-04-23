package service;

import Constants.Constant;
import DAO.*;
import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("all")
public class UpdateService {

    @Autowired
    private TreatmentDAO treatmentDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private TreatmentRecordDAO treatmentRecordDAO;

    @Autowired
    private DepartmentDAO departmentDAO;

    @Autowired
    private DiseaseDAO diseaseDAO;

    @Autowired
    private HospitalDAO hospitalDAO;

    @Autowired
    private TestDAO testDAO;

    @Autowired
    private TestRecordDAO testRecordDAO;

    @Autowired
    private PatientDAO patientDAO;

    @Autowired
    private StaffDAO staffDAO;

    @Autowired
    private RecordDAO recordDAO;

    public String updateDepartment(Department department) {
        if (department == null)
            return Constant.EMPTY_PARAM;
        try {
            departmentDAO.update(department);
        } catch (Exception e) {
            return Constant.UPDATE_ERROR;
        }
        return Constant.UPDATE_SUCCESS;
    }

    public String updateDisease(Disease disease) {
        if (disease == null)
            return Constant.EMPTY_PARAM;
        try {
            diseaseDAO.update(disease);
        } catch (Exception e) {
            return Constant.UPDATE_ERROR;
        }
        return Constant.UPDATE_SUCCESS;
    }

    public String updateHospital(Hospital hospital) {
        if (hospital == null)
            return Constant.EMPTY_PARAM;
        try {
            hospitalDAO.update(hospital);
        } catch (Exception e) {
            return Constant.UPDATE_ERROR;
        }
        return Constant.UPDATE_SUCCESS;
    }

    public String updatePatient(Patient patient) {
        if (patient == null)
            return Constant.EMPTY_PARAM;
        try {
            patientDAO.update(patient);
        } catch (Exception e) {
            return Constant.UPDATE_ERROR;
        }
        return Constant.UPDATE_SUCCESS;
    }

    public String updateRecord(Record record) {
        if (record == null)
            return Constant.EMPTY_PARAM;
        try {
            recordDAO.update(record);
        } catch (Exception e) {
            return Constant.UPDATE_ERROR;
        }
        return Constant.UPDATE_SUCCESS;
    }

    public String updateStaff(Staff staff) {
        if (staff == null)
            return Constant.EMPTY_PARAM;
        try {
            staffDAO.update(staff);
        } catch (Exception e) {
            return Constant.UPDATE_ERROR;
        }
        return Constant.UPDATE_SUCCESS;
    }

    public String updateTest(Test test) {
        if (test == null)
            return Constant.EMPTY_PARAM;
        try {
            testDAO.update(test);
        } catch (Exception e) {
            return Constant.UPDATE_ERROR;
        }
        return Constant.UPDATE_SUCCESS;
    }

    public String updateTestRecord(TestRecord testRecord) {
        if (testRecord == null)
            return Constant.EMPTY_PARAM;
        try {

            testRecordDAO.update(testRecord);

        } catch (Exception e) {
            return Constant.UPDATE_ERROR;
        }
        return Constant.UPDATE_SUCCESS;
    }

    public String updateTreatment(Treatment treatment) {
        if (treatment == null)
            return Constant.EMPTY_PARAM;
        try {
            treatmentDAO.update(treatment);
        } catch (Exception e) {
            return Constant.UPDATE_ERROR;
        }
        return Constant.UPDATE_SUCCESS;
    }

    public String updateTreatmentRecord(TreatmentRecord treatmentRecord) {
        if (treatmentRecord == null)
            return Constant.EMPTY_PARAM;
        try {

            treatmentRecordDAO.update(treatmentRecord);

        } catch (Exception e) {
            return Constant.UPDATE_ERROR;
        }
        return Constant.UPDATE_SUCCESS;
    }

    public String updateUser(User user) {
        if (user == null)
            return Constant.EMPTY_PARAM;
        try {
            userDAO.update(user);
        } catch (Exception e) {
            return Constant.UPDATE_ERROR;
        }
        return Constant.UPDATE_SUCCESS;
    }
}
