package cn.gaoz.example.dao.po;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "`camera`")
public class Camera {
    /**
     * 主键
     */
    @Id
    @Column(name = "`Id`")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 设备表主键
     */
    @Column(name = "`DevId`")
    private Integer devid;

    /**
     * 镜头组表主键,没有组时为0
     */
    @Column(name = "`GroupId`")
    private Integer groupid;

    /**
     * 平台表主键,没有平台时为0
     */
    @Column(name = "`PlatformId`")
    private Integer platformid;

    /**
     * 名称
     */
    @Column(name = "`Name`")
    private String name;

    /**
     * 通道编号
     */
    @Column(name = "`ChannelNO`")
    private Integer channelno;

    /**
     * 纬度
     */
    @Column(name = "`Latitude`")
    private Double latitude;

    /**
     * 经度
     */
    @Column(name = "`Longitude`")
    private Double longitude;

    /**
     * 状态（0下线,1上线）
     */
    @Column(name = "`IsOnline`")
    private Short isonline;

    /**
     * 创建时间
     */
    @Column(name = "`CreateTime`")
    private Date createtime;

    /**
     * 更新时间
     */
    @Column(name = "`UpdateTime`")
    private Date updatetime;

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
     * 获取设备表主键
     *
     * @return DevId - 设备表主键
     */
    public Integer getDevid() {
        return devid;
    }

    /**
     * 设置设备表主键
     *
     * @param devid 设备表主键
     */
    public void setDevid(Integer devid) {
        this.devid = devid;
    }

    /**
     * 获取镜头组表主键,没有组时为0
     *
     * @return GroupId - 镜头组表主键,没有组时为0
     */
    public Integer getGroupid() {
        return groupid;
    }

    /**
     * 设置镜头组表主键,没有组时为0
     *
     * @param groupid 镜头组表主键,没有组时为0
     */
    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    /**
     * 获取平台表主键,没有平台时为0
     *
     * @return PlatformId - 平台表主键,没有平台时为0
     */
    public Integer getPlatformid() {
        return platformid;
    }

    /**
     * 设置平台表主键,没有平台时为0
     *
     * @param platformid 平台表主键,没有平台时为0
     */
    public void setPlatformid(Integer platformid) {
        this.platformid = platformid;
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
     * 获取通道编号
     *
     * @return ChannelNO - 通道编号
     */
    public Integer getChannelno() {
        return channelno;
    }

    /**
     * 设置通道编号
     *
     * @param channelno 通道编号
     */
    public void setChannelno(Integer channelno) {
        this.channelno = channelno;
    }

    /**
     * 获取纬度
     *
     * @return Latitude - 纬度
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * 设置纬度
     *
     * @param latitude 纬度
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /**
     * 获取经度
     *
     * @return Longitude - 经度
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * 设置经度
     *
     * @param longitude 经度
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    /**
     * 获取状态（0下线,1上线）
     *
     * @return IsOnline - 状态（0下线,1上线）
     */
    public Short getIsonline() {
        return isonline;
    }

    /**
     * 设置状态（0下线,1上线）
     *
     * @param isonline 状态（0下线,1上线）
     */
    public void setIsonline(Short isonline) {
        this.isonline = isonline;
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

    /**
     * 获取更新时间
     *
     * @return UpdateTime - 更新时间
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * 设置更新时间
     *
     * @param updatetime 更新时间
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}