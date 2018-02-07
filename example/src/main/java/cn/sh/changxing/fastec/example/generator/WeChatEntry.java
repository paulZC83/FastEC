package cn.sh.changxing.fastec.example.generator;

import cn.sh.changxing.latte.WeChat.templates.WXEntryTemplate;
import cn.sh.changxing.latte_annotations.annotations.EntryGenerator;

/**
 * Created by ZengChao on 2018/2/6.
 */

@EntryGenerator(
        packageName = "cn.sh.changxing.fastec.example",
        entryTemplete = WXEntryTemplate.class
)
public interface WeChatEntry {
}
