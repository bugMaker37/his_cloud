package xt37.his.outpatient.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xt37.his.common.core.utils.DateUtils;
import xt37.his.outpatient.domain.Patient;
import xt37.his.outpatient.mapper.PatientMapper;
import xt37.his.outpatient.service.IPatientService;

import java.util.List;

/**
 * 患者Service业务层处理
 *
 * @author xt37
 * @date 2023-10-15
 */
@Service
@DS("outpatient")
public class PatientServiceImpl implements IPatientService {
    @Autowired
    private PatientMapper patientMapper;

    /**
     * 查询患者
     *
     * @param id 患者主键
     * @return 患者
     */
    @Override
    public Patient selectPatientById(Long id) {
        return patientMapper.selectPatientById(id);
    }

    /**
     * 查询患者列表
     *
     * @param patient 患者
     * @return 患者
     */
    @Override
    public List<Patient> selectPatientList(Patient patient) {
        return patientMapper.selectPatientList(patient);
    }

    /**
     * 新增患者
     *
     * @param patient 患者
     * @return 结果
     */
    @Override
    public int insertPatient(Patient patient) {
        patient.setCreateTime(DateUtils.getNowDate());
        return patientMapper.insertPatient(patient);
    }

    /**
     * 修改患者
     *
     * @param patient 患者
     * @return 结果
     */
    @Override
    public int updatePatient(Patient patient) {
        patient.setUpdateTime(DateUtils.getNowDate());
        return patientMapper.updatePatient(patient);
    }

    /**
     * 批量删除患者
     *
     * @param ids 需要删除的患者主键
     * @return 结果
     */
    @Override
    public int deletePatientByIds(Long[] ids) {
        return patientMapper.deletePatientByIds(ids);
    }

    /**
     * 删除患者信息
     *
     * @param id 患者主键
     * @return 结果
     */
    @Override
    public int deletePatientById(Long id) {
        return patientMapper.deletePatientById(id);
    }
}
