package com.wuwei.core.entity;

/**
 * @auther XuXin
 * @date 2019/3/14 15:30
 */
public class BaseEntity{
    //主键ID
    protected long id;
    //创建时间
    protected long createTime;
    //更新时间
    protected long updateTime;
    //数据状态:0-无效  1-有效
    protected  transient  int dataStatus;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public int getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(int dataStatus) {
        this.dataStatus = dataStatus;
    }
}