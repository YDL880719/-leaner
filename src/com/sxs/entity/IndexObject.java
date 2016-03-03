package com.sxs.entity;
//对应IndexObject的数据
public class IndexObject <T> {
    
    private int indexId;
    private String indexTitle;
    private int type;
    private int dataId;
    private String indexPic;
    private int isAble;
    private String startTime;
    private String endTime;
    private T dataObject;
    public T getDataObject() {
        return dataObject;
    }
    public void setDataObject(T dataObject) {
        this.dataObject = dataObject;
    }
    public int getIndexId() {
        return indexId;
    }
    public void setIndexId(int indexId) {
        this.indexId = indexId;
    }
    public String getIndexTitle() {
        return indexTitle;
    }
    public void setIndexTitle(String indexTitle) {
        this.indexTitle = indexTitle;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public int getDataId() {
        return dataId;
    }
    public void setDataId(int dataId) {
        this.dataId = dataId;
    }
    public String getIndexPic() {
        return indexPic;
    }
    public void setIndexPic(String indexPic) {
        this.indexPic = indexPic;
    }
    public int getIsAble() {
        return isAble;
    }
    public void setIsAble(int isAble) {
        this.isAble = isAble;
    }
    public String getStartTime() {
        return startTime;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    public String getEndTime() {
        return endTime;
    }
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    
    public static void main(String []args){
	IndexObject<UserAction> o = new IndexObject<UserAction>();
	UserAction u  = new UserAction();
	u.setUactid(123131231L);
	o.setDataObject(u);
	System.out.println(o.getDataObject().getUactid());
	
    }

}
