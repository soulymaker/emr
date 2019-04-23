package service;

import Constants.Constant;
import DAO.*;
import DTO.LoginDTO;
import DTO.QueryDTO;
import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yjy
 */
@Service
@SuppressWarnings("all")
public class QueryService {

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

    public QueryDTO queryDepartment(Department department) {
        QueryDTO dto = new QueryDTO();
        if (department == null) {
            dto.setFlag(Constant.EMPTY_PARAM);
            return dto;
        }
        try {
            List<Department> result = departmentDAO.query(department);
            dto.setResult(result);
        } catch (Exception e) {
            dto.setFlag(Constant.QUERY_ERROR);
            return dto;
        }
        dto.setFlag(Constant.QUERY_SUCCESS);
        return dto;

    }

    public QueryDTO queryDisease(Disease disease) {
        QueryDTO dto = new QueryDTO();
        if (disease == null) {
            dto.setFlag(Constant.EMPTY_PARAM);
            return dto;
        }
        try {
            List<Disease> result = diseaseDAO.query(disease);
            dto.setResult(result);
        } catch (Exception e) {
            dto.setFlag(Constant.QUERY_ERROR);
            return dto;
        }
        dto.setFlag(Constant.QUERY_SUCCESS);
        return dto;

    }

    public QueryDTO queryHospital(Hospital hospital) {
        QueryDTO dto = new QueryDTO();
        if (hospital == null) {
            dto.setFlag(Constant.EMPTY_PARAM);
            return dto;
        }
        try {
            List<Hospital> result = hospitalDAO.query(hospital);
            dto.setResult(result);
        } catch (Exception e) {
            dto.setFlag(Constant.QUERY_ERROR);
            return dto;
        }
        dto.setFlag(Constant.QUERY_SUCCESS);
        return dto;

    }

    public QueryDTO queryPatient(Patient patient) {
        QueryDTO dto = new QueryDTO();
        if (patient == null) {
            dto.setFlag(Constant.EMPTY_PARAM);
            return dto;
        }
        try {
            List<Patient> result = patientDAO.query(patient);
            dto.setResult(result);
        } catch (Exception e) {
            dto.setFlag(Constant.QUERY_ERROR);
            return dto;
        }
        dto.setFlag(Constant.QUERY_SUCCESS);
        return dto;

    }

    public QueryDTO queryRecord(Record record) {
        QueryDTO dto = new QueryDTO();
        if (record == null) {
            dto.setFlag(Constant.EMPTY_PARAM);
            return dto;
        }
        try {
            List<Record> result = recordDAO.query(record);
            dto.setResult(result);
        } catch (Exception e) {
            dto.setFlag(Constant.QUERY_ERROR);
            return dto;
        }
        dto.setFlag(Constant.QUERY_SUCCESS);
        return dto;

    }

    public QueryDTO queryStaff(Staff staff) {
        QueryDTO dto = new QueryDTO();
        if (staff == null) {
            dto.setFlag(Constant.EMPTY_PARAM);
            return dto;
        }
        try {
            List<Staff> result = staffDAO.query(staff);
            dto.setResult(result);
        } catch (Exception e) {
            dto.setFlag(Constant.QUERY_ERROR);
            return dto;
        }
        dto.setFlag(Constant.QUERY_SUCCESS);
        return dto;
    }

    public QueryDTO queryTest(Test test) {
        QueryDTO dto = new QueryDTO();
        if (test == null) {
            dto.setFlag(Constant.EMPTY_PARAM);
            return dto;
        }
        try {
            List<Test> result = testDAO.query(test);
            dto.setResult(result);
        } catch (Exception e) {
            dto.setFlag(Constant.QUERY_ERROR);
            return dto;
        }
        dto.setFlag(Constant.QUERY_SUCCESS);
        return dto;

    }

    public QueryDTO queryTestRecord(TestRecord testRecord) {
        QueryDTO dto = new QueryDTO();
        if (testRecord == null) {
            dto.setFlag(Constant.EMPTY_PARAM);
            return dto;
        }
        try {
            List<TestRecord> result = testRecordDAO.query(testRecord);
            dto.setResult(result);
        } catch (Exception e) {
            dto.setFlag(Constant.QUERY_ERROR);
            return dto;
        }
        dto.setFlag(Constant.QUERY_SUCCESS);
        return dto;

    }

    public QueryDTO queryTreatment(Treatment treatment) {
        QueryDTO dto = new QueryDTO();
        if (treatment == null) {
            dto.setFlag(Constant.EMPTY_PARAM);
            return dto;
        }
        try {
            List<Treatment> result = treatmentDAO.query(treatment);
            dto.setResult(result);
        } catch (Exception e) {
            dto.setFlag(Constant.QUERY_ERROR);
            return dto;
        }
        dto.setFlag(Constant.QUERY_SUCCESS);
        return dto;
    }

    public QueryDTO queryTreatmentRecord(TreatmentRecord treatmentRecord) {
        QueryDTO dto = new QueryDTO();
        if (treatmentRecord == null) {
            dto.setFlag(Constant.EMPTY_PARAM);
            return dto;
        }
        try {
            List<TreatmentRecord> result = treatmentRecordDAO.query(treatmentRecord);
            dto.setResult(result);
        } catch (Exception e) {
            dto.setFlag(Constant.QUERY_ERROR);
            return dto;
        }
        dto.setFlag(Constant.QUERY_SUCCESS);
        return dto;
    }

    //权限无感知登录
    public LoginDTO queryUser(User user) {
        LoginDTO l=new LoginDTO();
        if (user == null) {
            return null;
        }
        try {
            User result = userDAO.login(user);
            if(result!=null){
                l.setUserId(result.getUserId());
                l.setUserType(result.getUserType());
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    public QueryDTO queryUser2(User user) {
        QueryDTO dto = new QueryDTO();
        if (user == null) {
            dto.setFlag(Constant.EMPTY_PARAM);
            return dto;
        }
        try {
            List<User> result = userDAO.query(user);
            dto.setResult(result);
        } catch (Exception e) {
            dto.setFlag(Constant.QUERY_ERROR);
            return dto;
        }
        dto.setFlag(Constant.QUERY_SUCCESS);
        return dto;

    }
}
