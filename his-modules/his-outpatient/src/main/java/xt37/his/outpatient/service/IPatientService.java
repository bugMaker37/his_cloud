package xt37.his.outpatient.service;

import xt37.his.outpatient.domain.Patient;

import java.util.List;

/**
 * 患者Service接口
 *
 * @author xt37
 * @date 2023-10-15
 */
public interface IPatientService {
    /**
     * 查询患者
     *
     * @param id 患者主键
     * @return 患者
     */
    public Patient selectPatientById(Long id);

    /**
     * 查询患者列表
     *
     * @param patient 患者
     * @return 患者集合
     */
    public List<Patient> selectPatientList(Patient patient);

    /**
     * 新增患者
     *
     * @param patient 患者
     * @return 结果
     */
    public int insertPatient(Patient patient);

    /**
     * 修改患者
     *
     * @param patient 患者
     * @return 结果
     */
    public int updatePatient(Patient patient);

    /**
     * 批量删除患者
     *
     * @param ids 需要删除的患者主键集合
     * @return 结果
     */
    public int deletePatientByIds(Long[] ids);

    /**
     * 删除患者信息
     *
     * @param id 患者主键
     * @return 结果
     */
    public int deletePatientById(Long id);
}
