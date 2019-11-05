package cn.gaoz.example;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import cn.gaoz.example.model.vo.as.AlarmContentNonVehiVO;
import cn.gaoz.example.model.vo.as.AlarmContentPedVO;
import cn.gaoz.example.model.vo.as.AlarmContentVehiVO;
import cn.gaoz.example.model.vo.as.ReqAlarmVO;

public class Test {

    public static void main(String[] args) {
        String alarmPed = "{\"method\": \"alarm\",\"params\": {\"algClass\": 1,\"captureAdd\": \"\",\"content\": {\"BBX\": [2395, 768, 2523, 1040],\"DoubleBag\": \"无双肩包\",\"IsPickUp\": \"无手提包\",\"IsTrolleyCase\": \"无手拉箱\",\"LowerColor\": \"黑色\",\"LowerStyle\": \"长裤\",\"MessengerBag\": \"无单肩包\",\"UpperColor\": \"黄色\",\"UpperStyle\": \"长袖\",\"captureImgUrl\": \"http://192.168.1.201:8282/task102/Ped/Ped_9_2.jpg\",\"feaDataLen\": 512,\"feaLen\": 512,\"features\": \"jI+FvX7Pl7yhRee8Yw3ZPBJ20DyyW6g8q/RJPFgIQ71ym7s7MmxrPVkmWL2M1CW9NkucPXeckDyb\",\"gender\": \"女\",\"id\": 0,\"originImgUrl\": \"http://192.168.1.201:8282/task102/OrigImage/OrigImage_9_1.jpg\",\"type\": \"ped\"},\"frameIndex\": 9,\"resourceId\": \"\",\"resourceType\": \"\",\"resultType\": \"ped\",\"taskId\": \"102\",\"taskName\": \"taskName\",\"time\": 1567612800360}}";
        ReqAlarmVO reqAlarmVO = JSON.parseObject(alarmPed, new TypeReference<ReqAlarmVO<AlarmContentPedVO>>() {
        });
        boolean b1 = reqAlarmVO.getParams().getContent() instanceof AlarmContentPedVO;
        boolean b2 = reqAlarmVO.getParams().getContent() instanceof AlarmContentNonVehiVO;
        boolean b3 = reqAlarmVO.getParams().getContent() instanceof AlarmContentVehiVO;
        String alarmVehi = "{\"method\": \"alarm\",\"params\": {\"algClass\": 1,\"captureAdd\": \"\",\"content\": {\"BBX\": [467, 1525, 988, 1995],\"CarBrand\": \"Unknown-Unknown-Unknown\",\"CarColor\": \"红色\",\"CarType\": \"轿车\",\"HangerNum\": \"0\",\"HasLp\": \"无车牌\",\"IsMainSeatBlet\": \"有系安全带\",\"LabelNum\": \"0\",\"LeftSunShield\": \"无遮阳板\",\"LpColor\": \"其他\",\"LpNumber\": \"*******\",\"LpStyle\": \"双层车牌\",\"Orientation\": \"车尾\",\"RightSunShield\": \"无遮阳板\",\"TissueNum\": \"0\",\"captureImgUrl\": \"http://192.168.1.201:8282/task103/Vehi/Vehi_8_155.jpg\",\"feaDataLen\": 1288,\"feaLen\": 1288,\"features\": \"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\",\"id\": 0,\"originImgUrl\": \"http://192.168.1.201:8282/task103/OrigImage/OrigImage_155_7.jpg\",\"type\": \"vehi\"},\"frameIndex\": 155,\"resourceId\": \"\",\"resourceType\": \"\",\"resultType\": \"vehi\",\"taskId\": \"103\",\"taskName\": \"taskName\",\"time\": 1567612806200}}";
        String alarmNonVehi = "{\"method\" : \"alarm\",\"params\" : {\"algClass\" : 1,\"captureAdd\": \"\",\"content\" : {\"BBX\" : [ 749, 873, 877, 1121 ],\"Color\" : \"白色\",\"Convertible\" : \"无敞篷\",\"DriverHead\" : \"没戴\",\"IsManed\" : \"未载人\",\"IsPickUp\" : \"无背包\",\"UpperColor\" : \"黑色\",\"UpperStyle\" : \"长袖\",\"captureImgUrl\" : \"http://192.168.1.201:8282/task88/NonVehi/NonVehi_126_8.jpg\",\"feaDataLen\" : 2048,\"feaLen\" : 2048,\"features\" : \"my88P0+mKDxToKw+CT5eP9YS1T3kkNY8wI6bPlPE4j3Mr8U+NHMwPinKKz5kt0w/o96vPprRNjic\",\"gender\" : \"男\",\"id\" : 0,\"nonVehiType\" : \"二轮车\",\"originImgUrl\" : \"http://192.168.1.201:8282/task93/OrigImage/OrigImage_28_437.jpg\",\"type\" : \"nonVehi\"},\"frameIndex\" : 28,\"resourceId\": \"\",\"resourceType\": \"\",\"resultType\": \"nonVehi\",\"taskId\" : \"93\",\"taskName\" : \"taskName\",\"time\" : 1567612801120}}";
    }

}
