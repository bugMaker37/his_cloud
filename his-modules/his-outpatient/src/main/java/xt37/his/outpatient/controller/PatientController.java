package xt37.his.outpatient.controller;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xt37.his.common.core.utils.poi.ExcelUtil;
import xt37.his.common.core.web.controller.BaseController;
import xt37.his.common.core.web.domain.AjaxResult;
import xt37.his.common.core.web.page.TableDataInfo;
import xt37.his.common.log.annotation.Log;
import xt37.his.common.log.enums.BusinessType;
import xt37.his.common.security.annotation.RequiresPermissions;
import xt37.his.outpatient.domain.Patient;
import xt37.his.outpatient.service.IPatientService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 患者Controller
 *
 * @author xt37
 * @date 2023-10-15
 */
@RestController
@RequestMapping("/patient")
@DS("outpatient")
public class PatientController extends BaseController {
    @Autowired
    private IPatientService patientService;

    /**
     * 查询患者列表
     */
    @RequiresPermissions("outpatient:patient:list")
    @GetMapping("/list")
    public TableDataInfo list(Patient patient) {
        startPage();
        List<Patient> list = patientService.selectPatientList(patient);
        return getDataTable(list);
    }

    /**
     * 导出患者列表
     */
    @RequiresPermissions("outpatient:patient:export")
    @Log(title = "患者", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Patient patient) {
        List<Patient> list = patientService.selectPatientList(patient);
        ExcelUtil<Patient> util = new ExcelUtil<Patient>(Patient.class);
        util.exportExcel(response, list, "患者数据");
    }

    /**
     * 获取患者详细信息
     */
    @RequiresPermissions("outpatient:patient:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(patientService.selectPatientById(id));
    }

    /**
     * 新增患者
     */
    @RequiresPermissions("outpatient:patient:add")
    @Log(title = "患者", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Patient patient) {
        return toAjax(patientService.insertPatient(patient));
    }

    /**
     * 修改患者
     */
    @RequiresPermissions("outpatient:patient:edit")
    @Log(title = "患者", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Patient patient) {
        return toAjax(patientService.updatePatient(patient));
    }

    /**
     * 删除患者
     */
    @RequiresPermissions("outpatient:patient:remove")
    @Log(title = "患者", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(patientService.deletePatientByIds(ids));
    }
}
