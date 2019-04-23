import DAO.*;
import entity.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring.xml"})
public class DAOTest {

    @Autowired
    private TreatmentDAO dao;

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

    @Test
    public void testUpdate() {

    }

    @Test
    public void testInsert() {
        dao.add("拔牙");
    }

    @Test
    public void deleteTest() {
        dao.delete("1");
    }

    @Test
    public void query() {
        Treatment treatment = new Treatment();
        treatment.setId(3);
        treatment.setTreatmentName("手术");
        List result = dao.query(treatment);
        System.out.println(result);
    }

    @Test
    public void tsetUpdateUser() {
        User user = new User();
        user.setUserId("S000001");
        user.setPassword("123456");
        userDAO.update(user);
    }

    @Test
    public void testQueryUser() {
        User user = new User();
        user.setUserId("S000001");
        user.setUserType("管理员");
        List<User> result = userDAO.query(user);
        System.out.println(result);
    }

    @Test
    public void testDeletUser() {
        User user = new User();
        user.setUserId("1");
        userDAO.delete("1");

    }

    @Test
    public void testAddUser() {
        User user = new User();
        user.setUserId("S000002");
        user.setPassword("123456");
        user.setUserType("管理员");
        userDAO.add(user);
    }

    @Test
    public void testUpdateTreatmentRecord() {
        TreatmentRecord treatmentRecord = new TreatmentRecord();
        treatmentRecord.setId(5);
//        treatmentRecord.setUid("2");
//        treatmentRecord.setTreatmentName("666");
//        treatmentRecord.setDoctor("888");
        treatmentRecord.setStatus("已完成");
        treatmentRecordDAO.update(treatmentRecord);
    }

    @Test
    public void testDeleteTreatmentRecord() {
        treatmentRecordDAO.delete("3");

    }

    @Test
    public void testQueryTreatmentRecord() {
        TreatmentRecord record = new TreatmentRecord();
        record.setDoctor("4");
        record.setTreatmentName("4");
        record.setUid("4");
        System.out.println(treatmentRecordDAO.query(record));
    }

    @Test
    public void testAddTreatmentRecord() {
        TreatmentRecord record = new TreatmentRecord();
        record.setUid("0");
        record.setTreatmentName("0");
        record.setDoctor("0");
        treatmentRecordDAO.add(record);
    }

    @Test
    public void testDeleteDepartment() {
        departmentDAO.delete("6");

    }

    @Test
    public void testQueryDepartment() {
        Department department = new Department();
        department.setCode("001");
        department.setHospitalName("安徽医科大学第二附属医院");
        department.setDepartmentName("儿科");
        List<Department> result = departmentDAO.query(department);
        System.out.println(result);
    }

    @Test
    public void testAddDepartment() {
        Department department = new Department();
        department.setDepartmentName("急诊科");
        department.setCode("011");
        department.setHospitalName("安徽医科大学第二附属医院");
        department.setAddress("急诊大楼");
        departmentDAO.add(department);
    }

    @Test
    public void testUpdateDepartment() {
        Department department = new Department();
        department.setId(7);
        department.setCode("0001");
        department.setDepartmentName("急诊部");
        departmentDAO.update(department);
    }

    @Test
    public void testDeleteDisease() {
        diseaseDAO.delete("3");
    }

    @Test
    public void testQueryDisease() {
        Disease disease = new Disease();
        disease.setDieaseName("霍乱");
        List<Disease> result = diseaseDAO.query(disease);
        System.out.println(result);
    }

    @Test
    public void testAddDisease() {
        Disease disease = new Disease();
        disease.setIcdCode("1");
        disease.setDieaseName("1");
        disease.setCode("1");
        diseaseDAO.add(disease);
    }

    @Test
    public void testUpdateDisease() {
        Disease disease = new Disease();
        disease.setId(10);
        disease.setCode("1");
        disease.setDieaseName("1");
        disease.setIcdCode("1");
        diseaseDAO.update(disease);

    }

    @Test
    public void testDeleteHospital() {
        hospitalDAO.delete("5");
    }

    @Test
    public void testQueryHospital() {
        Hospital hospital = new Hospital();
        hospital.setCode("AYDEFY");
        hospital.setHospitalName("安徽医科大学第二附属医院");
        hospital.setLevel("三级甲等");
        List<Hospital> result = hospitalDAO.query(hospital);
        System.out.println(result);
    }

    @Test
    public void testAddHospital() {
        Hospital hospital = new Hospital();
        hospital.setLevel("1");
        hospital.setCode("1");
        hospital.setHospitalName("1");
        hospital.setAddress("1");
        hospital.setTelephone("1");
        hospitalDAO.add(hospital);
    }

    @Test
    public void testUpdateHospital() {
        Hospital hospital = new Hospital();
        hospital.setId(7);
        hospital.setTelephone("2");
        hospital.setAddress("2");
        hospital.setHospitalName("2");
        hospital.setCode("2");
        hospital.setLevel("2");
        hospitalDAO.update(hospital);
    }

    @Test
    public void testDeleteTest() {
        testDAO.delete("3");
    }

    @Test
    public void testAddTest() {
        entity.Test test = new entity.Test();
        test.setDepartment("1");
        test.setTestName("1");
        testDAO.add(test);
    }

    @Test
    public void testQueryTest() {
        entity.Test test = new entity.Test();
        test.setTestName("血常规");
        test.setDepartment("检验科");
        List<entity.Test> result = testDAO.query(test);
        System.out.println(result);
    }

    @Test
    public void testUpdateTest() {
        entity.Test test = new entity.Test();
        test.setId(2);
        test.setDepartment("000");
        testDAO.update(test);
    }

    @Test
    public void testQueryTestRecordTest() {
        TestRecord testRecord = new TestRecord();
        testRecord.setTestName("血常规");
        System.out.println(testRecordDAO.query(testRecord));
    }

    @Test
    public void testAddTestRecordTest() {
        TestRecord record = new TestRecord();
        record.setTestName("1");
        record.setDepartment("1");
        record.setUid("1");
        testRecordDAO.add(record);
    }

    @Test
    public void testUpdateTestRecordTest() {
        TestRecord record = new TestRecord();
        record.setId(2);
        record.setUid("00000");
        record.setStatus("已完成");
        testRecordDAO.update(record);

    }

    @Test
    public void testDeleteTestRecordTest() {
        testRecordDAO.delete("2");
    }

    @Test
    public void testQueryPatient() {
        Patient patient = new Patient();
        patient.setUid("330512199702162546");
        patient.setPatientName("马龙");
        List<Patient> result = patientDAO.query(patient);
        System.out.println(result);
    }

    @Test
    public void testAddPatient() {
        Patient patient = new Patient();
        patient.setPatientName("1");
        patient.setUid("1");
        patient.setAddress("1");
        patient.setSex("男");
        patient.setBirthYear("1");
        patient.setNativePlace("1");
        patient.setPhone("1");
        patientDAO.add(patient);
    }

    @Test
    public void testUpdatePatient() {
        Patient patient = new Patient();
        patient.setId(2);
        patient.setAddress("000");
        patient.setPhone("1425");
        patientDAO.update(patient);
    }

    @Test
    public void testDeletePatient() {
        patientDAO.delete("2");
    }

    @Test
    public void testQueryStaff() {
        Staff staff = new Staff();
        staff.setType("医生");
        System.out.println(staffDAO.query(staff));
    }

    @Test
    public void testAddStaff() {
        Staff staff = new Staff();
        staff.setJobNumber("0");
        staff.setStaffName("0");
        staff.setGrade("0");
        staff.setHospital("0");
        staff.setDepartmentName("0");
        staffDAO.add(staff);
    }

    @Test
    public void testUpdateStaff() {
        Staff staff = new Staff();
        staff.setId(5);
        staff.setType("医生");
        staffDAO.update(staff);
    }

    @Test
    public void testDeleteStaff() {
        staffDAO.delete("5");
    }

    @Test
    public void testQueryRecord() {
        Record record = new Record();
        record.setUid("330512199702162546");
        record.setPatientName("马龙");
        record.setDoctorName("李安");
        record.setConsultationDate("2019-04-16");
        record.setVisitType("门诊");
        record.setDiseaseType("1");
        System.out.println(recordDAO.query(record));
    }

    @Test
    public void testAddRecord() {
        Record record = new Record();
        record.setUid("1");
        record.setPatientName("1");
        record.setDoctorName("1");
        record.setConsultationDate("2019-4-18");
        record.setVisitType("门诊");
        record.setDiseaseType("1");
        recordDAO.add(record);
    }

    @Test
    public void testUpdateRecord() {
        Record record = new Record();
        record.setId(3);
        record.setUid("111");
        record.setDoctorName("142");
        recordDAO.update(record);
    }

    @Test
    public void testDeleteRecord() {
        recordDAO.delete("3");
    }
}
