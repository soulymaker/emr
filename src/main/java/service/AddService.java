package service;

import Constants.Constant;
import DAO.*;
import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@SuppressWarnings("all")
public class AddService {

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

    public String addDepartment(Department department) {
        if (department == null)
            return Constant.EMPTY_PARAM;
        try {
            departmentDAO.add(department);
        } catch (Exception e) {
            return Constant.ADD_ERROR;
        }
        return Constant.ADD_SUCCESS;
    }

    public String addDisease(Disease disease) {
        if (disease == null)
            return Constant.EMPTY_PARAM;
        try {
            diseaseDAO.add(disease);
        } catch (Exception e) {
            return Constant.ADD_ERROR;
        }
        return Constant.ADD_SUCCESS;
    }

    public String addHospital(Hospital hospital) {
        if (hospital == null)
            return Constant.EMPTY_PARAM;
        try {
            hospitalDAO.add(hospital);
        } catch (Exception e) {
            return Constant.ADD_ERROR;
        }
        return Constant.ADD_SUCCESS;
    }

    public String addPatient(Patient patient) {
        if (patient == null)
            return Constant.EMPTY_PARAM;
        try {
            patientDAO.add(patient);
        } catch (Exception e) {
            return Constant.ADD_ERROR;
        }
        return Constant.ADD_SUCCESS;
    }

    public String addRecord(Record record) {
        if (record == null)
            return Constant.EMPTY_PARAM;
        try {
            recordDAO.add(record);
        } catch (Exception e) {
            return Constant.ADD_ERROR;
        }
        return Constant.ADD_SUCCESS;
    }

    public String addStaff(Staff staff) {
        if (staff == null)
            return Constant.EMPTY_PARAM;
        try {
            staffDAO.add(staff);
        } catch (Exception e) {
            return Constant.ADD_ERROR;
        }
        return Constant.ADD_SUCCESS;
    }

    public String addTest(Test test) {
        if (test == null)
            return Constant.EMPTY_PARAM;
        try {
            testDAO.add(test);
        } catch (Exception e) {
            return Constant.ADD_ERROR;
        }
        return Constant.ADD_SUCCESS;
    }

    public String addTestRecord(TestRecord testRecord) {
        if (testRecord == null)
            return Constant.EMPTY_PARAM;
        try {
            Record record = new Record();
            record.setUid(testRecord.getUid());
            List<Record> result = recordDAO.query(record);
            if (result.size() == 0)
                return Constant.RECORD_NOT_EXIST;
            record = result.get(0);
            String test = record.getTest();
            if (test == null)
                test = "";
            test = test + "||" + testRecord.getTestName() + "||";
            record.setTest(test);
            recordDAO.update(record);
            testRecordDAO.add(testRecord);

        } catch (Exception e) {
            return Constant.ADD_ERROR;
        }
        return Constant.ADD_SUCCESS;
    }

    public String addTreatment(Treatment treatment) {
        if (treatment == null)
            return Constant.EMPTY_PARAM;
        try {
            treatmentDAO.add(treatment.getTreatmentName());
        } catch (Exception e) {
            return Constant.ADD_ERROR;
        }
        return Constant.ADD_SUCCESS;
    }

    public String addTreatmentRecord(TreatmentRecord treatmentRecord) {
        if (treatmentRecord == null)
            return Constant.EMPTY_PARAM;
        try {
            Record record = new Record();
            record.setUid(treatmentRecord.getUid());
            record.setDoctorName(treatmentRecord.getDoctor());
            List<Record> result = recordDAO.query(record);
            if (result.size() == 0)
                return Constant.RECORD_NOT_EXIST;
            record = result.get(0);
            String treatment = record.getTreatment();
            if (treatment == null)
                treatment = "";
            treatment = treatment + "||" + treatmentRecord.getTreatmentName() + "||";
            record.setTreatment(treatment);
            recordDAO.update(record);
            treatmentRecordDAO.add(treatmentRecord);

        } catch (Exception e) {
            return Constant.ADD_ERROR;
        }
        return Constant.ADD_SUCCESS;
    }

    public String addUser(User user) {
        if (user == null)
            return Constant.EMPTY_PARAM;
        try {
            userDAO.add(user);
        } catch (Exception e) {
            return Constant.ADD_ERROR;
        }
        return Constant.ADD_SUCCESS;
    }
}
