package web;

import BO.Result;
import Constants.Constant;
import DTO.LoginDTO;
import DTO.QueryDTO;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.AddService;
import service.DeleteService;
import service.QueryService;
import service.UpdateService;
import utils.encrypt.Md5;

import java.util.ArrayList;
import java.util.Map;

@RestController
public class EmrController {

    @Autowired
    private AddService addService;

    @Autowired
    private QueryService queryService;

    @Autowired
    private UpdateService updateService;

    @Autowired
    private DeleteService deleteService;

    @RequestMapping(value = {"/web/login"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject login(@RequestBody LoginDTO l) {
        User user = new User();
        user.setUserId(l.getUserId());
        user.setPassword(Md5.MD5(l.getPassword()));
        LoginDTO result = queryService.queryUser(user);
        if (result == null) {
            return Result.returnData("登录失败", "登录失败");
        } else {
            Map<String, String> map = Maps.newHashMap();
            map.put("userId", l.getUserId());
            map.put("userType", l.getUserType());
            return Result.returnData(null, "success", map);
        }
    }

    @RequestMapping(value = {"/web/queryUser"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject queryUser(@RequestBody User user) {
        QueryDTO queryDTO = queryService.queryUser2(user);
        if(!queryDTO.getFlag().equals(Constant.QUERY_SUCCESS)) {
            return Result.returnData(queryDTO.getResult());
        } else {
            return Result.returnData(queryDTO.getFlag());
        }
    }

    @RequestMapping(value = {"/web/queryDepartment"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject queryDepartment(@RequestBody Department department) {
        QueryDTO queryDTO = queryService.queryDepartment(department);
        if(!queryDTO.getFlag().equals(Constant.QUERY_SUCCESS)) {
            return Result.returnData(queryDTO.getResult());
        } else {
            return Result.returnData(queryDTO.getFlag());
        }
    }

    @RequestMapping(value = {"/web/queryDisease"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject queryDisease(@RequestBody Disease disease) {
        QueryDTO queryDTO = queryService.queryDisease(disease);
        if(!queryDTO.getFlag().equals(Constant.QUERY_SUCCESS)) {
            return Result.returnData(queryDTO.getResult());
        } else {
            return Result.returnData(queryDTO.getFlag());
        }
    }

    @RequestMapping(value = {"/web/queryHospital"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject queryHospital(@RequestBody Hospital hospital) {
        QueryDTO queryDTO = queryService.queryHospital(hospital);
        if(!queryDTO.getFlag().equals(Constant.QUERY_SUCCESS)) {
            return Result.returnData(queryDTO.getResult());
        } else {
            return Result.returnData(queryDTO.getFlag());
        }
    }

    @RequestMapping(value = {"/web/queryPatient"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject queryPatient(@RequestBody Patient patient) {
        QueryDTO queryDTO = queryService.queryPatient(patient);
        if(!queryDTO.getFlag().equals(Constant.QUERY_SUCCESS)) {
            return Result.returnData(queryDTO.getResult());
        } else {
            return Result.returnData(queryDTO.getFlag());
        }
    }

    @RequestMapping(value = {"/web/queryRecord"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject queryRecord(@RequestBody Record record) {
        QueryDTO queryDTO = queryService.queryRecord(record);
        if(!queryDTO.getFlag().equals(Constant.QUERY_SUCCESS)) {
            return Result.returnData(queryDTO.getResult());
        } else {
            return Result.returnData(queryDTO.getFlag());
        }
    }

    @RequestMapping(value = {"/web/queryStaff"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject queryStaff(@RequestBody Staff staff) {
        QueryDTO queryDTO = queryService.queryStaff(staff);
        if(!queryDTO.getFlag().equals(Constant.QUERY_SUCCESS)) {
            return Result.returnData(queryDTO.getResult());
        } else {
            return Result.returnData(queryDTO.getFlag());
        }
    }

    @RequestMapping(value = {"/web/queryTest"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject queryTest(@RequestBody Test test) {
        QueryDTO queryDTO = queryService.queryTest(test);
        if(!queryDTO.getFlag().equals(Constant.QUERY_SUCCESS)) {
            return Result.returnData(queryDTO.getResult());
        } else {
            return Result.returnData(queryDTO.getFlag());
        }
    }


    @RequestMapping(value = {"/web/queryTestRecord"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject queryTestRecord(@RequestBody TestRecord testRecord) {
        QueryDTO queryDTO = queryService.queryTestRecord(testRecord);
        if(!queryDTO.getFlag().equals(Constant.QUERY_SUCCESS)) {
            return Result.returnData(queryDTO.getResult());
        } else {
            return Result.returnData(queryDTO.getFlag());
        }
    }

    @RequestMapping(value = {"/web/queryTreatment"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject queryTreatment(@RequestBody Treatment treatment) {
        QueryDTO queryDTO = queryService.queryTreatment(treatment);
        if(!queryDTO.getFlag().equals(Constant.QUERY_SUCCESS)) {
            return Result.returnData(queryDTO.getResult());
        } else {
            return Result.returnData(queryDTO.getFlag());
        }
    }

    @RequestMapping(value = {"/web/queryTreatmentRecord"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject queryTreatmentRecord(@RequestBody TreatmentRecord treatmentRecord) {
        QueryDTO queryDTO = queryService.queryTreatmentRecord(treatmentRecord);
        if(!queryDTO.getFlag().equals(Constant.QUERY_SUCCESS)) {
            return Result.returnData(queryDTO.getResult());
        } else {
            return Result.returnData(queryDTO.getFlag());
        }
    }

    @RequestMapping(value = {"/web/addUser"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addUser(@RequestBody User user) {
        String result = addService.addUser(user);
        if(result.equals(Constant.ADD_SUCCESS))
            return Result.returnData(null,result);
        else
            return Result.returnData(result,null);
    }

    @RequestMapping(value = {"/web/addDepartment"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addDepartemnt(@RequestBody Department department) {
        String result = addService.addDepartment(department);
        if(result.equals(Constant.ADD_SUCCESS))
            return Result.returnData(null,result);
        else
            return Result.returnData(result,null);
    }

    @RequestMapping(value = {"/web/addDisease"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addDisease(@RequestBody Disease disease) {
        String result = addService.addDisease(disease);
        if(result.equals(Constant.ADD_SUCCESS))
            return Result.returnData(null,result);
        else
            return Result.returnData(result,null);
    }

    @RequestMapping(value = {"/web/addHospital"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addHospital(@RequestBody Hospital hospital) {
        String result = addService.addHospital(hospital);
        if(result.equals(Constant.ADD_SUCCESS))
            return Result.returnData(null,result);
        else
            return Result.returnData(result,null);
    }

    @RequestMapping(value = {"/web/addPatient"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addPatient(@RequestBody Patient patient) {
        String result = addService.addPatient(patient);
        if(result.equals(Constant.ADD_SUCCESS))
            return Result.returnData(null,result);
        else
            return Result.returnData(result,null);
    }

    @RequestMapping(value = {"/web/addRecord"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addRecord(@RequestBody Record record) {
        String result = addService.addRecord(record);
        if(result.equals(Constant.ADD_SUCCESS))
            return Result.returnData(null,result);
        else
            return Result.returnData(result,null);
    }

    @RequestMapping(value = {"/web/addStaff"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addStaff(@RequestBody Staff staff) {
        String result = addService.addStaff(staff);
        if(result.equals(Constant.ADD_SUCCESS))
            return Result.returnData(null,result);
        else
            return Result.returnData(result,null);
    }

    @RequestMapping(value = {"/web/addTest"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addTest(@RequestBody Test test) {
        String result = addService.addTest(test);
        if(result.equals(Constant.ADD_SUCCESS))
            return Result.returnData(null,result);
        else
            return Result.returnData(result,null);
    }

    @RequestMapping(value = {"/web/addTestRecord"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addTestRecord(@RequestBody TestRecord testRecord) {
        String result = addService.addTestRecord(testRecord);
        if(result.equals(Constant.ADD_SUCCESS))
            return Result.returnData(null,result);
        else
            return Result.returnData(result,null);
    }

    @RequestMapping(value = {"/web/addTreatment"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addTreatment(@RequestBody Treatment treatment) {
        String result = addService.addTreatment(treatment);
        if(result.equals(Constant.ADD_SUCCESS))
            return Result.returnData(null,result);
        else
            return Result.returnData(result,null);
    }

    @RequestMapping(value = {"/web/addTreatmentRecord"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addTreatmentRecord(@RequestBody TreatmentRecord treatmentRecord) {
        String result = addService.addTreatmentRecord(treatmentRecord);
        if(result.equals(Constant.ADD_SUCCESS))
            return Result.returnData(null,result);
        else
            return Result.returnData(result,null);
    }

    @RequestMapping(value = {"/web/deleteUser"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject deleteUser(@RequestBody User user) {
        String result = deleteService.deleteUser(user.getId().toString());
        if(result.equals(Constant.DELETE_SUCCESS))
            return Result.returnData(null,result);
        else
            return Result.returnData(result,null);
    }

    @RequestMapping(value = {"/web/deleteDepartment"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject deleteDepartemnt(@RequestBody Department department) {
        String result = deleteService.deleteDepartment(department.getId().toString());
        if(result.equals(Constant.DELETE_SUCCESS))
            return Result.returnData(null,result);
        else
            return Result.returnData(result,null);
    }

    @RequestMapping(value = {"/web/deleteDisease"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject deleteDisease(@RequestBody Disease disease) {
        String result = deleteService.deleteDisease(disease.getId().toString());
        if(result.equals(Constant.DELETE_SUCCESS))
            return Result.returnData(null,result);
        else
            return Result.returnData(result,null);
    }

    @RequestMapping(value = {"/web/deleteHospital"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject deleteHospital(@RequestBody Hospital hospital) {
        String result = deleteService.deleteHospital(hospital.getId().toString());
        if(result.equals(Constant.DELETE_SUCCESS))
            return Result.returnData(null,result);
        else
            return Result.returnData(result,null);
    }

    @RequestMapping(value = {"/web/deletePatient"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject deletePatient(@RequestBody Patient patient) {
        String result = deleteService.deletePatient(patient.getId().toString());
        if(result.equals(Constant.DELETE_SUCCESS))
            return Result.returnData(null,result);
        else
            return Result.returnData(result,null);
    }

    @RequestMapping(value = {"/web/deleteRecord"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject deleteRecord(@RequestBody Record record) {
        String result = deleteService.deleteRecord(record.getId().toString());
        if(result.equals(Constant.DELETE_SUCCESS))
            return Result.returnData(null,result);
        else
            return Result.returnData(result,null);
    }

    @RequestMapping(value = {"/web/deleteStaff"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject deleteStaff(@RequestBody Staff staff) {
        String result = deleteService.deleteStaff(staff.getId().toString());
        if(result.equals(Constant.DELETE_SUCCESS))
            return Result.returnData(null,result);
        else
            return Result.returnData(result,null);
    }

    @RequestMapping(value = {"/web/deleteTest"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject deleteTest(@RequestBody Test test) {
        String result = deleteService.deleteTest(test.getId().toString());
        if(result.equals(Constant.DELETE_SUCCESS))
            return Result.returnData(null,result);
        else
            return Result.returnData(result,null);
    }

    @RequestMapping(value = {"/web/deleteTestRecord"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject deleteTestRecord(@RequestBody TestRecord testRecord) {
        String result = deleteService.deleteTestRecord(testRecord.getId().toString());
        if(result.equals(Constant.DELETE_SUCCESS))
            return Result.returnData(null,result);
        else
            return Result.returnData(result,null);
    }

    @RequestMapping(value = {"/web/deleteTreatment"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject deleteTreatment(@RequestBody Treatment treatment) {
        String result = deleteService.deleteTreatment(treatment.getId().toString());
        if(result.equals(Constant.DELETE_SUCCESS))
            return Result.returnData(null,result);
        else
            return Result.returnData(result,null);
    }

    @RequestMapping(value = {"/web/deleteTreatmentRecord"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject deleteTreatmentRecord(@RequestBody TreatmentRecord treatmentRecord) {
        String result = deleteService.deleteTreatmentRecord(treatmentRecord.getId().toString());
        if(result.equals(Constant.DELETE_SUCCESS))
            return Result.returnData(null,result);
        else
            return Result.returnData(result,null);
    }

    @RequestMapping(value = {"/web/updateUser"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject updateUser(@RequestBody User user) {
        String result = updateService.updateUser(user);
        if(result.equals(Constant.UPDATE_SUCCESS))
            return Result.returnData(null,result);
        else
            return Result.returnData(result,null);
    }

    @RequestMapping(value = {"/web/updateDepartment"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject updateDepartemnt(@RequestBody Department department) {
        String result = updateService.updateDepartment(department);
        if(result.equals(Constant.UPDATE_SUCCESS))
            return Result.returnData(null,result);
        else
            return Result.returnData(result,null);
    }

    @RequestMapping(value = {"/web/updateDisease"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject updateDisease(@RequestBody Disease disease) {
        String result = updateService.updateDisease(disease);
        if(result.equals(Constant.UPDATE_SUCCESS))
            return Result.returnData(null,result);
        else
            return Result.returnData(result,null);
    }

    @RequestMapping(value = {"/web/updateHospital"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject updateHospital(@RequestBody Hospital hospital) {
        String result = updateService.updateHospital(hospital);
        if(result.equals(Constant.UPDATE_SUCCESS))
            return Result.returnData(null,result);
        else
            return Result.returnData(result,null);
    }

    @RequestMapping(value = {"/web/updatePatient"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject updatePatient(@RequestBody Patient patient) {
        String result = updateService.updatePatient(patient);
        if(result.equals(Constant.UPDATE_SUCCESS))
            return Result.returnData(null,result);
        else
            return Result.returnData(result,null);
    }

    @RequestMapping(value = {"/web/updateRecord"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject updateRecord(@RequestBody Record record) {
        String result = updateService.updateRecord(record);
        if(result.equals(Constant.UPDATE_SUCCESS))
            return Result.returnData(null,result);
        else
            return Result.returnData(result,null);
    }

    @RequestMapping(value = {"/web/updateStaff"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject updateStaff(@RequestBody Staff staff) {
        String result = updateService.updateStaff(staff);
        if(result.equals(Constant.UPDATE_SUCCESS))
            return Result.returnData(null,result);
        else
            return Result.returnData(result,null);
    }

    @RequestMapping(value = {"/web/updateTest"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject updateTest(@RequestBody Test test) {
        String result = updateService.updateTest(test);
        if(result.equals(Constant.UPDATE_SUCCESS))
            return Result.returnData(null,result);
        else
            return Result.returnData(result,null);
    }

    @RequestMapping(value = {"/web/updateTestRecord"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject updateTestRecord(@RequestBody TestRecord testRecord) {
        String result = updateService.updateTestRecord(testRecord);
        if(result.equals(Constant.UPDATE_SUCCESS))
            return Result.returnData(null,result);
        else
            return Result.returnData(result,null);
    }

    @RequestMapping(value = {"/web/updateTreatment"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject updateTreatment(@RequestBody Treatment treatment) {
        String result = updateService.updateTreatment(treatment);
        if(result.equals(Constant.UPDATE_SUCCESS))
            return Result.returnData(null,result);
        else
            return Result.returnData(result,null);
    }

    @RequestMapping(value = {"/web/updateTreatmentRecord"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject updateTreatmentRecord(@RequestBody TreatmentRecord treatmentRecord) {
        String result = updateService.updateTreatmentRecord(treatmentRecord);
        if(result.equals(Constant.UPDATE_SUCCESS))
            return Result.returnData(null,result);
        else
            return Result.returnData(result,null);
    }

}
