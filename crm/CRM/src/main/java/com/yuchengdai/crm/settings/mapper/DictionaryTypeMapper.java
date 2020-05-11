package com.yuchengdai.crm.settings.mapper;

import com.yuchengdai.crm.settings.domain.DictionaryType;

import java.util.List;

public interface DictionaryTypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_dictionary_type
     *
     * @mbg.generated Sun Mar 08 16:31:05 CST 2017
     */
    int deleteByPrimaryKey(String code);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_dictionary_type
     *
     * @mbg.generated Sun Mar 08 16:31:05 CST 2017
     */
    int insert(DictionaryType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_dictionary_type
     *
     * @mbg.generated Sun Mar 08 16:31:05 CST 2017
     */
    int insertSelective(DictionaryType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_dictionary_type
     *
     * @mbg.generated Sun Mar 08 16:31:05 CST 2017
     */
    DictionaryType selectByPrimaryKey(String code);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_dictionary_type
     *
     * @mbg.generated Sun Mar 08 16:31:05 CST 2017
     */
    int updateByPrimaryKeySelective(DictionaryType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_dictionary_type
     *
     * @mbg.generated Sun Mar 08 16:31:05 CST 2017
     */
    int updateByPrimaryKey(DictionaryType record);

    /**
     * 获取所有数据字典类型
     *
     * @return
     */
    List<DictionaryType> selectAllDictionaryType();

    /**
     * 通过code主键查询出数据字典类型
     *
     * @param code
     * @return
     */
    DictionaryType selectDictionaryTypeByCode(String code);

    /**
     * 添加一个数据字典类型
     *
     * @param dictionaryType
     * @return
     */
    int insertDictionaryType(DictionaryType dictionaryType);

    /**
     * 根据code更新这个数据字典类型
     *
     * @param dictionaryType
     * @return
     */
    int updateDictionaryTypeByCode(DictionaryType dictionaryType);

    /**
     * 根据code删除数据字典类型
     * 多个code以数组形式存在
     *
     * @param codes
     * @return
     */
    int deleteDictionaryTypeByCode(String[] codes);

}