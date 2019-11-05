package cn.gaoz.example.model.vo.rest;

public class MsgDatasVO {
    /**
     * 符合查询条件的总记录数
     */
    private long total;
    /**
     * 符合查询条件的记录数据
     */
    private Object datas;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Object getDatas() {
        return datas;
    }

    public void setDatas(Object datas) {
        this.datas = datas;
    }
}
