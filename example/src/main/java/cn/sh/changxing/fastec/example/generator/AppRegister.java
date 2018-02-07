package cn.sh.changxing.fastec.example.generator;

import cn.sh.changxing.latte.WeChat.templates.AppRegisterTemplate;
import cn.sh.changxing.latte_annotations.annotations.AppRegisterGenerator;

/**
 * Created by ZengChao on 2018/2/6.
 */

@AppRegisterGenerator(
        packageName = "cn.sh.changxing.fastec.example",
        registerTemplate = AppRegisterTemplate.class
)
public interface AppRegister {
}
