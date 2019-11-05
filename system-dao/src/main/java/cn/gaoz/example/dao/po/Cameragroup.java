package cn.gaoz.example.dao.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`cameragroup`")
public class Cameragroup {
    /**
     * 主键
     */
    @Id
    @Column(name = "`Id`")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 平台Id,没有平台时为0
     */
    @Column(name = "`PlatformId`")
    private Integer platformid;

    /**
     * 父组Id,没有父组时为0
     */
    @Column(name = "`ParentGroupId`")
    private Integer parentgroupid;

    /**
     * 平台业务Id,没有平台时为空
     */
    @Column(name = "`BizId`")
    private String bizid;

    /**
     * 名称
     */
    @Column(name = "`Name`")
    private String name;

    /**
     * 创建时间
     */
    @Column(name = "`CreateTime`")
    private Date createtime;

    /**
     * 获取主键
     *
     * @return Id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取平台Id,没有平台时为0
     *
     * @return PlatformId - 平台Id,没有平台时为0
     */
    public Integer getPlatformid() {
        return platformid;
    }

    /**
     * 设置平台Id,没有平台时为0
     *
     * @param platformid 平台Id,没有平台时为0
     */
    public void setPlatformid(Integer platformid) {
        this.platformid = platformid;
    }

    /**
     * 获取父组Id,没有父组时为0
     *
     * @return ParentGroupId - 父组Id,没有父组时为0
     */
    public Integer getParentgroupid() {
        return parentgroupid;
    }

    /**
     * 设置父组Id,没有父组时为0
     *
     * @param parentgroupid 父组Id,没有父组时为0
     */
    public void setParentgroupid(Integer parentgroupid) {
        this.parentgroupid = parentgroupid;
    }

    /**
     * 获取平台业务Id,没有平台时为空
     *
     * @return BizId - 平台业务Id,没有平台时为空
     */
    public String getBizid() {
        return bizid;
    }

    /**
     * 设置平台业务Id,没有平台时为空
     *
     * @param bizid 平台业务Id,没有平台时为空
     */
    public void setBizid(String bizid) {
        this.bizid = bizid == null ? null : bizid.trim();
    }

    /**
     * 获取名称
     *
     * @return Name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取创建时间
     *
     * @return CreateTime - 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间
     *
     * @param createtime 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}