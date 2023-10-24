package seminar4;

import java.util.HashMap;
import java.util.Map;

public class Main3 {
    /*

*/
    public static void main(String[] args) {
        Map<String, String> phoneBook = new HashMap<>();
        phoneBook.put("123", "РљРѕРЅСЃС‚Р°РЅС‚РёРЅ");
        phoneBook.put("123123", "РњР°СЂРёСЏ");
        phoneBook.put("12311", "Р’СЏС‡РµСЃР»Р°РІ");
        phoneBook.put("12", "РљРёСЂРёР»Р»");
        phoneBook.put("911", "Р®Р»РёСЏ");

        for (Map.Entry<String, String> entry: phoneBook.entrySet()){
            String key = entry.getKey();
            String val = entry.getValue();
        }

        System.out.println(phoneBook.entrySet()
                .stream().min((e1, e2) -> e1.getKey().compareTo(e2.getKey())).get().getValue());

        System.out.println(phoneBook.entrySet()
                .stream().max((e1, e2) -> e1.getValue().compareTo(e2.getValue())).get().getKey());
    }
}

