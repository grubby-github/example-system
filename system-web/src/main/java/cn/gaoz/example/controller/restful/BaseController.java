package cn.gaoz.example.controller.restful;

import cn.gaoz.example.model.vo.rest.MsgDatasVO;
import cn.gaoz.example.model.vo.rest.RespMsgVO;
import com.github.pagehelper.PageInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class BaseController {
    protected ResponseEntity<RespMsgVO> getRespOk() {
        return this.getRespOk(null);
    }

    protected ResponseEntity<RespMsgVO> getRespOk(Object resData) {
        RespMsgVO respMsgVO = new RespMsgVO();
        respMsgVO.setCode(0);
        respMsgVO.setMsg("请求处理成功");
        respMsgVO.setResData(resData);
        return new ResponseEntity<>(respMsgVO, HttpStatus.OK);
    }

    protected ResponseEntity<RespMsgVO> getRespOkByPage(List datas) {
        PageInfo pageInfo = new PageInfo(datas);
        MsgDatasVO msgDatasVO = new MsgDatasVO();
        msgDatasVO.setTotal(pageInfo.getTotal());
        msgDatasVO.setDatas(pageInfo.getList());
        return this.getRespOk(msgDatasVO);
    }

    protected ResponseEntity<RespMsgVO> getRespFail() {
        return this.getRespFail("请求处理失败");
    }

    protected ResponseEntity<RespMsgVO> getRespFail(String msg) {
        RespMsgVO respMsgVO = new RespMsgVO();
        respMsgVO.setCode(1);
        respMsgVO.setMsg(msg);
        return new ResponseEntity<>(respMsgVO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
