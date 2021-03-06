package net.shopnc.b2b2c.dao.member;

import net.shopnc.b2b2c.domain.member.PredepositLog;
import net.shopnc.common.dao.BaseDaoHibernate4;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zxy on 2015-12-24.
 */
@Repository
@Transactional(rollbackFor = {Exception.class})
public class PredepositLogDao extends BaseDaoHibernate4<PredepositLog> {

    /**
     * 预存款日志总数
     * @param where 查询条件
     * @param params HQL参数值
     * @return 预存款日志总数
     */
    public Long findPredepositLogCount(HashMap<String,String> where, HashMap<String,Object> params)
    {
        String hql = "select count(*) from PredepositLog where 1=1 ";
        for (String key : where.keySet()) {
            hql += (" and " + where.get(key));
        }
        return super.findCount(hql, params);
    }

    /**
     * 日志列表
     * @param where 查询条件
     * @param params HQL参数值
     * @param pageNo 当前页数
     * @param pageSize 分页条数
     * @return 预存款日志列表
     */
    public List<PredepositLog> getPredepositLogListByPage(HashMap<String,String> where, HashMap<String,Object> params,int pageNo, int pageSize) {
        String hql = "from PredepositLog where 1=1 ";
        for (String key : where.keySet()) {
            hql += (" and " + where.get(key));
        }
        hql += " order by logId desc";
        return super.findByPage(hql, pageNo, pageSize, params);
    }
}