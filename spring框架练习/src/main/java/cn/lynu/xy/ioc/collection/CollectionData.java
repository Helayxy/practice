package cn.lynu.xy.ioc.collection;

import java.util.*;

public class CollectionData {
    private String[] arrayData;
    private List<String> listData;
    private Set<String> setData;
    private Map<String,String> mapData;
    private Properties proData;

    public String[] getArrayData() {
        return arrayData;
    }

    public void setArrayData(String[] arrayData) {
        this.arrayData = arrayData;
    }

    public List<String> getListData() {
        return listData;
    }

    public void setListData(List<String> listData) {
        this.listData = listData;
    }

    public Set<String> getSetData() {
        return setData;
    }

    public void setSetData(Set<String> setData) {
        this.setData = setData;
    }

    public Map<String, String> getMapData() {
        return mapData;
    }

    public void setMapData(Map<String, String> mapData) {
        this.mapData = mapData;
    }

    public Properties getProData() {
        return proData;
    }

    public void setProData(Properties proData) {
        this.proData = proData;
    }

    @Override
    public String toString() {
        return "CollectionData\n{" +
                "arrayData=" + Arrays.toString(arrayData) +
                ",\nlistData=" + listData +
                ",\nsetData=" + setData +
                ",\nmapData=" + mapData +
                ",\nproData=" + proData +
                '}';
    }
}
