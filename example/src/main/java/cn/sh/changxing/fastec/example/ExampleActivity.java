package cn.sh.changxing.fastec.example;

import cn.sh.changxing.latte.activities.ProxyActivity;
import cn.sh.changxing.latte.delegates.LatteDelegate;
import cn.sh.changxing.latte.ec.launcher.LauncherScrollDelegate;

public class ExampleActivity extends ProxyActivity {

    @Override
    public LatteDelegate setRootDelegate() {
        return new LauncherScrollDelegate();
    }
}
