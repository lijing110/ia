package com.njfu.wa.sys.mapper;

import com.njfu.wa.sys.domain.DataRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DataRecordMapper {

    /**
     * 查询数据记录
     * @param map map
     * @return data
     */
    List<DataRecord> selectDataRecords(Map<String, Object> map);
}
