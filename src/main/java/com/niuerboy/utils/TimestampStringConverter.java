package com.niuerboy.utils;



import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.alibaba.excel.util.DateUtils;

import java.sql.Timestamp;


/**
 * @AUTHOR : liuwei
 * @DATE : 2022/11/3 22:41
 * @DESCRIPTION :
 */
public class TimestampStringConverter implements Converter<Timestamp> {

    @Override
    public Class<?> supportJavaTypeKey() {
        return Timestamp.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }


    @Override
    public WriteCellData<?> convertToExcelData(Timestamp value, ExcelContentProperty contentProperty,
                                               GlobalConfiguration globalConfiguration) {
        WriteCellData cellData = new WriteCellData();
        String cellValue;
        if (contentProperty == null || contentProperty.getDateTimeFormatProperty() == null) {
            cellValue = DateUtils.format(value.toLocalDateTime(), "yyyy年MM月dd日", globalConfiguration.getLocale());
        } else {
            cellValue = DateUtils.format(value.toLocalDateTime(), contentProperty.getDateTimeFormatProperty().getFormat(),
                    globalConfiguration.getLocale());
        }
        cellData.setType(CellDataTypeEnum.STRING);
        cellData.setStringValue(cellValue);
        cellData.setData(cellValue);
        return cellData;
    }
}