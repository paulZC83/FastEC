package cn.sh.changxing.fastec.example.generator;

import cn.sh.changxing.latte.WeChat.templates.WXPayEntryTemplate;
import cn.sh.changxing.latte_annotations.annotations.PayEntryGenerator;

/**
 * Created by ZengChao on 2018/2/6.
 */

@PayEntryGenerator(
        packageName = "cn.sh.changxing.fastec.example",
        payEntryTemplete = WXPayEntryTemplate.class
)
public interface WeChatPayEntry {
}
