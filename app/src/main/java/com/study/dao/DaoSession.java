package com.study.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.study.db.CollectVo;

import com.study.dao.CollectVoDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig collectVoDaoConfig;

    private final CollectVoDao collectVoDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        collectVoDaoConfig = daoConfigMap.get(CollectVoDao.class).clone();
        collectVoDaoConfig.initIdentityScope(type);

        collectVoDao = new CollectVoDao(collectVoDaoConfig, this);

        registerDao(CollectVo.class, collectVoDao);
    }
    
    public void clear() {
        collectVoDaoConfig.clearIdentityScope();
    }

    public CollectVoDao getCollectVoDao() {
        return collectVoDao;
    }

}