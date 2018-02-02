package cn.sh.changxing.latte.ec.database;

import android.content.Context;

import org.greenrobot.greendao.database.Database;

/**
 * Created by ZengChao on 2018/2/1.
 */

public class DatabaseManager {
    private DaoSession mDaoSession = null;
    private UserProfileDao mDao = null;

    private DatabaseManager() {

    }

    public DatabaseManager init(Context context) {
        initDao(context);
        return this;
    }

    private static final class Holder {
        private static final DatabaseManager INSTANCE = new DatabaseManager();
    }

    public static DatabaseManager getInstance() {
        return Holder.INSTANCE;
    }

    private void initDao(Context context) {
        final ReleaseOpenHelper helper = new ReleaseOpenHelper(context, "fast_ec.db");
        final Database database = helper.getWritableDb();
        mDaoSession = new DaoMaster(database).newSession();
        mDao = mDaoSession.getUserProfileDao();
    }

    public final UserProfileDao getDao() {
        return mDao;
    }
}
