package cn.sh.changxing.latte.delegates;

/**
 * Created by ZengChao on 2018/1/22.
 */

public abstract class LatteDelegate extends PermissionCheckerDelegate{

    public <T extends LatteDelegate> T getParentDelegate(){
        return (T) getParentFragment();
    }
}
