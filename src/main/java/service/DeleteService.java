package service;

import Constants.Constant;
import DAO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@SuppressWarnings("all")
public class DeleteService {

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

    public String deleteDepartment(String id) {
        if (Objects.nonNull(id))
            return Constant.EMPTY_PARAM;
        try {
            departmentDAO.delete(id);
        } catch (Exception e) {
            return Constant.DELETE_ERROR;
        }
        return Constant.DELETE_SUCCESS;
    }

    public String deleteDisease(String id) {
        if (Objects.nonNull(id))
            return Constant.EMPTY_PARAM;
        try {
            diseaseDAO.delete(id);
        } catch (Exception e) {
            return Constant.DELETE_ERROR;
        }
        return Constant.DELETE_SUCCESS;
    }

    public String deleteHospital(String id) {
        if (Objects.nonNull(id))
            return Constant.EMPTY_PARAM;
        try {
            hospitalDAO.delete(id);
        } catch (Exception e) {
            return Constant.DELETE_ERROR;
        }
        return Constant.DELETE_SUCCESS;
    }

    public String deletePatient(String id) {
        if (Objects.nonNull(id))
            return Constant.EMPTY_PARAM;
        try {
            patientDAO.delete(id);
        } catch (Exception e) {
            return Constant.DELETE_ERROR;
        }
        return Constant.DELETE_SUCCESS;
    }

    public String deleteRecord(String id) {
        if (Objects.nonNull(id))
            return Constant.EMPTY_PARAM;
        try {
            recordDAO.delete(id);
        } catch (Exception e) {
            return Constant.DELETE_ERROR;
        }
        return Constant.DELETE_SUCCESS;
    }

    public String deleteStaff(String id) {
        if (Objects.nonNull(id))
            return Constant.EMPTY_PARAM;
        try {
            staffDAO.delete(id);
        } catch (Exception e) {
            return Constant.DELETE_ERROR;
        }
        return Constant.DELETE_SUCCESS;
    }

    public String deleteTest(String id) {
        if (Objects.nonNull(id))
            return Constant.EMPTY_PARAM;
        try {
            testDAO.delete(id);
        } catch (Exception e) {
            return Constant.DELETE_ERROR;
        }
        return Constant.DELETE_SUCCESS;
    }

    public String deleteTestRecord(String id) {
        if (Objects.nonNull(id))
            return Constant.EMPTY_PARAM;
        try {
            testRecordDAO.delete(id);
        } catch (Exception e) {
            return Constant.DELETE_ERROR;
        }
        return Constant.DELETE_SUCCESS;
    }

    public String deleteTreatment(String id) {
        if (Objects.nonNull(id))
            return Constant.EMPTY_PARAM;
        try {
            treatmentDAO.delete(id);
        } catch (Exception e) {
            return Constant.DELETE_ERROR;
        }
        return Constant.DELETE_SUCCESS;
    }

    public String deleteTreatmentRecord(String id) {
        if (Objects.nonNull(id))
            return Constant.EMPTY_PARAM;
        try {
            treatmentRecordDAO.delete(id);
        } catch (Exception e) {
            return Constant.DELETE_ERROR;
        }
        return Constant.DELETE_SUCCESS;
    }

    public String deleteUser(String id) {
        if (Objects.nonNull(id))
            return Constant.EMPTY_PARAM;
        try {
            userDAO.delete(id);
        } catch (Exception e) {
            return Constant.DELETE_ERROR;
        }
        return Constant.DELETE_SUCCESS;
    }

}
