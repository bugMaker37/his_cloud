package xt37.his.outpatient.domain;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import xt37.his.common.core.annotation.Excel;
import xt37.his.common.core.web.domain.BaseEntity;

/**
 * 患者对象 patient
 *
 * @author xt37
 * @date 2023-10-15
 */
@DS("outpatient")
public class Patient extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 名字
     */
    @Excel(name = "名字")
    private String name;

    /**
     * 联系方式
     */
    @Excel(name = "联系方式")
    private String mobile;

    /**
     * 微信open_id
     */
    @Excel(name = "微信open_id")
    private String openId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("mobile", getMobile())
                .append("openId", getOpenId())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
