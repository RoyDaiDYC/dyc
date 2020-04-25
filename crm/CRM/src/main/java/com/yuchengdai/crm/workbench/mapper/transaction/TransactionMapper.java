package com.yuchengdai.crm.workbench.mapper.transaction;

import com.yuchengdai.crm.workbench.domain.Transaction;
import com.yuchengdai.crm.workbench.domain.TransactionFunnelVO;

import java.util.List;
import java.util.Map;

public interface TransactionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_transaction
     *
     * @mbg.generated Sat Mar 28 21:29:26 CST 2020
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_transaction
     *
     * @mbg.generated Sat Mar 28 21:29:26 CST 2020
     */
    int insert(Transaction record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_transaction
     *
     * @mbg.generated Sat Mar 28 21:29:26 CST 2020
     */
    int insertSelective(Transaction record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_transaction
     *
     * @mbg.generated Sat Mar 28 21:29:26 CST 2020
     */
    Transaction selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_transaction
     *
     * @mbg.generated Sat Mar 28 21:29:26 CST 2020
     */
    int updateByPrimaryKeySelective(Transaction record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_transaction
     *
     * @mbg.generated Sat Mar 28 21:29:26 CST 2020
     */
    int updateByPrimaryKey(Transaction record);

    /**
     * 添加一个交易内容
     *
     * @param transaction
     * @return
     */
    int insertTransaction(Transaction transaction);

    /**
     * 通过客户id获取对应的交易信息
     *
     * @param customerId
     * @return
     */
    List<Transaction> selectTransactionForDetailByCustomerId(String customerId);

    /**
     * 通过客户id删除对应的交易内容
     *
     * @param customerIds
     * @return
     */
    int deleteTransactionFromCustomerByCustomerIdArray(String[] customerIds);

    /**
     * 通过多个客户id，获取所有相关的交易详细内容
     *
     * @param customerIds
     * @return
     */
    List<Transaction> selectTransactionForDetailByCustomerIdArray(String[] customerIds);

    /**
     * 通过联系人id获取对应的交易信息
     *
     * @param contactsId
     * @return
     */
    List<Transaction> selectTransactionForDetailByContactsId(String contactsId);

    /**
     * 通过联系人id删除对应的交易内容
     *
     * @param contactsIds
     * @return
     */
    int deleteTransactionFromContactsByContactsIdArray(String[] contactsIds);

    /**
     * 通过多个联系人id，获取相关的交易详细内容
     *
     * @param contactsIds
     * @return
     */
    List<Transaction> selectTransactionFromContactsByContactsIdArray(String[] contactsIds);

    /**
     * 通过条件查询，获取所有的交易内容
     * 关联查询
     * 分页查询
     *
     * @param map
     * @return
     */
    List<Transaction> selectAllTransactionForDetailByCondition(Map<String, Object> map);

    /**
     * 通过条件，获取所有交易的总条数
     *
     * @param map
     * @return
     */
    int selectAllCountTransaction(Map<String, Object> map);

    /**
     * 通过id更新一个交易
     *
     * @param transaction
     * @return
     */
    int updateTransaction(Transaction transaction);

    /**
     * 根据id获取交易内容
     *
     * @param id
     * @return
     */
    Transaction selectTransactionById(String id);

    /**
     * 根据id批量删除对应的交易内容
     *
     * @param ids
     * @return
     */
    int deleteTransactionById(String[] ids);

    /**
     * 通过id获取详细交易内容
     *
     * @param id
     * @return
     */
    Transaction selectTransactionForDetailById(String id);

    /**
     * 通过id更新交易的stage
     *
     * @return
     */
    int updateTransactionForStage(Map<String, Object> map);

    /**
     * 获取交易漏斗内容
     * 交易名对应多少条数据
     *
     * @return
     */
    List<TransactionFunnelVO> selectTransactionFunnel();
}